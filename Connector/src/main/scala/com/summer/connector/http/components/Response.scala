package com.summer.connector.http.components

import com.summer.connector.http.BaseResponse

case class Response[+A](data: A) extends BaseResponse
