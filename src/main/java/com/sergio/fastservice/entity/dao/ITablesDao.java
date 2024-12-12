package com.sergio.fastservice.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.sergio.fastservice.entity.models.Tables;

public interface ITablesDao extends CrudRepository<Tables, Long> {
	
}
