package com.summer.connector.http.components

import com.summer.com.connector.http.HttpCode

case class Failure(errorCode: HttpCode, msg: String) extends Throwable

case class Internal_Failure() extends Failure(HttpCode.INTERNAL_ERROR, "Internal Error")

case class Server_Failure() extends Failure(HttpCode.SERVER_ERROR, "Server Error")
