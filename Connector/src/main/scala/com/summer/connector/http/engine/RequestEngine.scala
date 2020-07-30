package com.summer.connector.http.engine

import java.io.IOException
import java.lang.{String => jstring}
import java.util.{HashMap => jmap}

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.summer.connector.http.components._
import com.summer.connector.http._
import org.slf4j.LoggerFactory

import scala.concurrent.{ExecutionContext, Future}

sealed trait RequestEngine {

  def send[T](req: Request)(implicit ec: ExecutionContext): Future[Either[Failure, Response[T]]]

}

class RequestEngineImpl extends RequestEngine {

  private val LOGGER = LoggerFactory.getLogger(classOf[RequestEngineImpl])

  private val httpEngine: HttpEngine = new HttpEngineImpl

  private val operationMap
  = Map(
    Operation.GET -> Constants.GET,
    Operation.PATCH -> Constants.PATCH,
    Operation.DELETE -> Constants.DELETE,
    Operation.POST -> Constants.POST
  )

  def transformRequest(req: Request) = {
    val httpReq = new HttpRequest
    httpReq.setAsync(true)
    httpReq.setOperation(operationMap(req.header.operation))
    val queryParam = new jmap[jstring, jstring]()
    req.query.getOrElse(Map()).foreach(entry => queryParam.put(entry._1, entry._2))
    httpReq.setQueryParams(queryParam)
    httpReq.setRetry(req.getRetry)
    httpReq.setTimeout(req.getTimeout)
    httpReq
  }

  def transformResponse[T](data: jstring): Response[T] = {
    val gson = new GsonBuilder().create()
    Response(gson.fromJson(data, new TypeToken[T](){}.getType))
  }

  override def send[T](req: Request)(implicit ec: ExecutionContext): Future[Either[Failure, Response[T]]] = {

    // Asynchronous send to HttpEngine
    val futureResponse : Future[Either[Failure, Response[T]]]= Future {

      val httpReq = transformRequest(req)

      try {
        val response = httpEngine.send(httpReq)
        Right(transformResponse(response))
      } catch {
        case exception: IOException=>
          LOGGER.error("Error occurs when send request. The message is: {}", exception.getMessage)
          Left(new Internal_Failure)
        case _: Throwable =>
          LOGGER.error("Error occurs when send request")
          Left(new Server_Failure)
      }

    }
    futureResponse
  }
}
