package com.sergio.fastservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.entity.TablesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishesRepository extends JpaRepository<DishesEntity, Long> {
    List<DishesEntity> findByTable(TablesEntity table);
}

