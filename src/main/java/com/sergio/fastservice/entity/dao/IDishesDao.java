package com.sergio.fastservice.entity.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.sergio.fastservice.entity.models.Dishes;

public interface IDishesDao extends CrudRepository<Dishes, Long> {
}
