package com.sergio.fastservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.sergio.fastservice.entity.models.Tables;
import com.sergio.fastservice.entity.services.ITableService;

@RestController
	@CrossOrigin(origins ="*")
public class TablesController {
	@Autowired
	ITableService tableService;
	
	@GetMapping("/tables")
	public List<Tables> getAllTables(){
		return tableService.getAll();
	}
	
	@GetMapping("/tables/{id}")
	public Tables getOne(@PathVariable(value="id")long id){
		return tableService.get(id);
	}
	
	@PostMapping("/tables")
	public void post(Tables table) {
		tableService.post(table);
	}
	
	@PutMapping("/tables/{id}")
	public void put(Tables table, @PathVariable(value="id") long id) {
		tableService.put(table, id);
	}
	
	@PutMapping("/tables/{id}/availability")
	public void updateAvailability(@PathVariable(value = "id_table") long id, @RequestBody boolean availability) {
	    Tables table = tableService.get(id);
	    if (table != null) {
	        table.setAvailability(availability);
	        tableService.post(table);
	    }
	}

}
