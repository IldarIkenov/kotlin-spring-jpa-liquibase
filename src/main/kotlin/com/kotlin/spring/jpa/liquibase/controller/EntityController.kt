package com.kotlin.spring.jpa.liquibase.controller

import com.kotlin.spring.jpa.liquibase.dto.TestEntityDto
import com.kotlin.spring.jpa.liquibase.entity.EntityCreateRequest
import com.kotlin.spring.jpa.liquibase.service.Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/test_entity")
class EntityController(private  val service: Service) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllEntity(@PageableDefault(value = 50)  pageable: Pageable): Page<TestEntityDto> =
        service.getAllEntity(pageable)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getEntity(@PathVariable("id") id: UUID): Optional<TestEntityDto> =
        service.getEntity(id)

    @PostMapping("/entity")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEntity(@RequestBody entityReq: EntityCreateRequest): TestEntityDto =
        service.saveEntity(entityReq)

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateUser(@PathVariable("id") id: UUID,
                   @RequestBody entityReq: EntityCreateRequest): TestEntityDto =
        service.update(id, entityReq)

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable("id") id: UUID) =
        service.deleteEntity(id)
}