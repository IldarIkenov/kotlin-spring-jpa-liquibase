package com.kotlin.spring.jpa.liquibase.entity

import org.springframework.validation.annotation.Validated

@Validated
data class EntityCreateRequest(
    val documentDate: String? = null,
    val dictionaryValueName: String? = null,
    val sortOrder: String? =null
)
