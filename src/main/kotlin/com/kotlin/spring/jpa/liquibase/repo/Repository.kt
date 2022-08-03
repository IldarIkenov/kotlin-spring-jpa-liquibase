package com.kotlin.spring.jpa.liquibase.repo

import com.kotlin.spring.jpa.liquibase.entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface Repository: JpaRepository<TestEntity, UUID>