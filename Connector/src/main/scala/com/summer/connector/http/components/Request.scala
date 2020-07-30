package com.summer.connector.http.components

import com.summer.connector.http.BaseRequest

case class Request(header: Header, body: String, query: Option[Map[String, String]]) extends BaseRequest
