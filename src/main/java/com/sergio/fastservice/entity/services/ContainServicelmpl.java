package com.sergio.fastservice.entity.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergio.fastservice.entity.dao.IContainsDao;
import com.sergio.fastservice.entity.models.Contains;
import com.sergio.fastservice.entity.models.ContainsId;

@Service
public class ContainServicelmpl implements IConteinService {
    @Autowired
    private IContainsDao containsDao;

    @Override
    public List<Contains> getIngredientsByDish(long dishId) {
        return containsDao.findByIdDish(dishId);
    }

    @Override
    public Contains get(ContainsId id) {
        return containsDao.findById(id).orElse(null);
    }

    @Override
    public List<Contains> getAll() {
        return containsDao.findAll();
    }

    @Override
    public void post(Contains contain) {
        containsDao.save(contain);
    }

    @Override
    public void put(Contains contain, ContainsId id) {
        containsDao.findById(id).ifPresent(existing -> {
            contain.setIdDish(id.getIdDish());
            contain.setIdIngredient(id.getIdIngredient());
            containsDao.save(contain);
        });
    }

    @Override
    public void delete(ContainsId id) {
        containsDao.deleteById(id);
    }
}

