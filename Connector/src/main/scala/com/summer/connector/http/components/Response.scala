package com.summer.connector.http.components

case class Response[+A](data: A) extends Serializable
