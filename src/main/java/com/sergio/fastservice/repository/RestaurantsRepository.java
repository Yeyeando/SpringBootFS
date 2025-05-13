package com.sergio.fastservice.repository;

import com.sergio.fastservice.entity.RestaurantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository<RestaurantsEntity, Long> {
}
