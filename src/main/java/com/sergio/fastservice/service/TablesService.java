package com.sergio.fastservice.service;

import com.sergio.fastservice.entity.TablesEntity;
import com.sergio.fastservice.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesService {

    private final TablesRepository tablesRepository;

    @Autowired
    public TablesService(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
    }

    public List<TablesEntity> getAllTables() {
        return tablesRepository.findAll();
    }

    public Optional<TablesEntity> getTableById(Long id) {
        return tablesRepository.findById(id);
    }

    public TablesEntity saveOrUpdateTable(TablesEntity table) {
        return tablesRepository.save(table);
    }

    public void deleteTableById(Long id) {
        if (tablesRepository.existsById(id)) {
            tablesRepository.deleteById(id);
        } else {
            throw new RuntimeException("La mesa con ID " + id + " no existe.");
        }
    }
}