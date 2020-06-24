package com.summer.connector.http.components

import com.summer.com.connector.http.BaseRequest

case class Request(header: Header, body: String, query: Option[Map[String, String]]) extends BaseRequest
