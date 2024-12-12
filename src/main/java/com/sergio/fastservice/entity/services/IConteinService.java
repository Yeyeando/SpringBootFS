package com.sergio.fastservice.entity.services;

import java.util.List;

import com.sergio.fastservice.entity.models.Contains;
import com.sergio.fastservice.entity.models.ContainsId;

public interface IConteinService {
    Contains get(ContainsId id); // Ajustado para clave compuesta
    List<Contains> getAll();
    List<Contains> getIngredientsByDish(long dishId);
    void post(Contains contain);
    void put(Contains contain, ContainsId id);
    void delete(ContainsId id); // Clave compuesta aquí
}

