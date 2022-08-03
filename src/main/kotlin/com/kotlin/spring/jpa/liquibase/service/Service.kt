package com.kotlin.spring.jpa.liquibase.service

import com.kotlin.spring.jpa.liquibase.dto.TestEntityDto
import com.kotlin.spring.jpa.liquibase.entity.EntityCreateRequest
import com.kotlin.spring.jpa.liquibase.entity.TestEntity
import com.kotlin.spring.jpa.liquibase.exception.DuplicateException
import com.kotlin.spring.jpa.liquibase.exception.ResourceNotFoundException
import com.kotlin.spring.jpa.liquibase.repo.Repository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class Service internal constructor(val repo: Repository) {

    fun getEntity(id: UUID): Optional<TestEntityDto> {
        return repo.findById(id).map { x -> x.toDto() }
    }

    fun getAllEntity(pageable: Pageable): Page<TestEntityDto> {
        return repo.findAll(pageable).map { x -> x.toDto() }
    }

    fun saveEntity(entityReq: EntityCreateRequest): TestEntityDto {
        try {
            return repo.save(TestEntity.fromDto(entityReq)).toDto()
        } catch (e: DataIntegrityViolationException) {
            throw DuplicateException("entity exists already")
        }
    }

    fun update(id: UUID, entityReq: EntityCreateRequest): TestEntityDto {
        val existingRec = repo.findById(id)
        existingRec.orElseThrow {
            ResourceNotFoundException("user "+ id + "not found")
        }

        try {
            return repo.save(TestEntity.fromDto(entityReq)).toDto()
        } catch (e: DataIntegrityViolationException){
            throw DuplicateException("Data integrity exception")
        }
    }

    fun deleteEntity(id: UUID) {
        if (repo.existsById(id)) {
            repo.deleteById(id)
        } else {
            throw ResourceNotFoundException("entity doesn't exists")
        }
    }
}