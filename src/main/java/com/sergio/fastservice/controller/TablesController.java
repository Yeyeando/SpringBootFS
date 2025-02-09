package com.sergio.fastservice.controller;

import com.sergio.fastservice.entity.TablesEntity;
import com.sergio.fastservice.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tables")
public class TablesController {

    private final TablesService tablesService;

    @Autowired
    public TablesController(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @GetMapping
    public List<TablesEntity> getAllTables() {
        return tablesService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablesEntity> getTableById(@PathVariable Long id) {
        Optional<TablesEntity> table = tablesService.getTableById(id);
        return table.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TablesEntity> saveOrUpdateTable(@RequestBody TablesEntity table) {
        TablesEntity savedTable = tablesService.saveOrUpdateTable(table);
        return ResponseEntity.ok(savedTable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTableById(@PathVariable Long id) {
        try {
            tablesService.deleteTableById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
