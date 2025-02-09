package com.sergio.fastservice.repository;

import com.sergio.fastservice.entity.TablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepository extends JpaRepository<TablesEntity, Long> {
}
