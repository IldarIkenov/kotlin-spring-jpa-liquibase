package com.kotlin.spring.jpa.liquibase.entity

import com.kotlin.spring.jpa.liquibase.dto.TestEntityDto
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class TestEntity(
    @Id
    val id: UUID? = null,
    val documentID: UUID? = null,
    val documentDate: String? = null,
    val dictionaryValueId: UUID? = null,
    val dictionaryValueName: String? = null,
    val sortOrder: String? =null
) {
    var testId: UUID? = null
    var testName: String = "Test"

    fun toDto(): TestEntityDto = TestEntityDto(
        id = this.id,
        documentID = this.documentID,
        documentDate = this.documentDate,
        dictionaryValueId = this.dictionaryValueId,
        dictionaryValueName = this.dictionaryValueName,
        sortOrder = this.sortOrder
    )

    companion object {
        fun fromDto(entityReg: EntityCreateRequest) = TestEntity(
            documentDate = entityReg.documentDate,
            dictionaryValueName = entityReg.dictionaryValueName,
            sortOrder = entityReg.sortOrder
        )
    }

}
