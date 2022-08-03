package com.kotlin.spring.jpa.liquibase.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.CONFLICT)
class DuplicateException(override val message: String?): RuntimeException(message)