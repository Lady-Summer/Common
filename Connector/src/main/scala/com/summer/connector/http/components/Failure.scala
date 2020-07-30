package com.summer.connector.http.components

import com.summer.connector.http.HttpCode

case class Failure(errorCode: HttpCode, msg: String) extends Throwable

class Internal_Failure extends Failure(HttpCode.INTERNAL_ERROR, "Internal Error")

class Server_Failure extends Failure(HttpCode.SERVER_ERROR, "Server Error")
