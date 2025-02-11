package com.sergio.fastservice.repository;

import com.sergio.fastservice.entity.ContainsEntity;
import com.sergio.fastservice.entity.ContainsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainsRepository extends JpaRepository<ContainsEntity, ContainsId> {

    @Query("SELECT c FROM ContainsEntity c WHERE c.ingredients.id = :ingredientId")
    List<ContainsEntity> findByIngredientsId(@Param("ingredientId") Long ingredientId);

    @Query("SELECT c FROM ContainsEntity c WHERE c.dishes.id_dish = :dishId")
    List<ContainsEntity> findByDishesId(@Param("dishId") Long dishId);
}