package com.sergio.fastservice.repository;

import com.sergio.fastservice.entity.TablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablesRepository extends JpaRepository<TablesEntity, Long> {
    List<TablesEntity> findByRestaurantId(Long restaurantId);
}
