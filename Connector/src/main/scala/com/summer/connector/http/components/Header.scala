package com.summer.connector.http.components

import com.summer.connector.http.Operation

case class Header(operation: Operation, keep_alive: Boolean, others: Map[String, String])
