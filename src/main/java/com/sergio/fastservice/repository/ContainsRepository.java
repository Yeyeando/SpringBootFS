package com.sergio.fastservice.repository;

import com.sergio.fastservice.entity.ContainsEntity;
import com.sergio.fastservice.entity.DishesEntity;
import com.sergio.fastservice.entity.IngredientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainsRepository extends JpaRepository<ContainsEntity, Long> {
    List<ContainsEntity> findByDishes(DishesEntity dish);
    List<ContainsEntity> findByIngredients(IngredientsEntity ingredients);
}