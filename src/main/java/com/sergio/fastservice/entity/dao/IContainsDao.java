package com.sergio.fastservice.entity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergio.fastservice.entity.models.Contains;
import com.sergio.fastservice.entity.models.ContainsId;

public interface IContainsDao extends JpaRepository<Contains, ContainsId> {
    List<Contains> findByIdDish(Long idDish);
}

