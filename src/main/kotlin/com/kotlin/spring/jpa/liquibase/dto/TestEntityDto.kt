package com.kotlin.spring.jpa.liquibase.dto

import java.util.*

data class TestEntityDto(
    val id: UUID? = null,
    val documentID: UUID? = null,
    val documentDate: String? = null,
    val dictionaryValueId: UUID? = null,
    val dictionaryValueName: String? = null,
    val sortOrder: String? =null
) {
    var testId: UUID? = null
    var testName: String = "Test"
}
