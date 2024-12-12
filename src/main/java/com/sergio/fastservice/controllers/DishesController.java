package com.sergio.fastservice.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.fastservice.entity.models.Dishes;
import com.sergio.fastservice.entity.services.DishServicelmpl;


@RestController
@CrossOrigin(origins ="*")
public class DishesController {
 @Autowired
 DishServicelmpl dishesService;
 
 @GetMapping("/dishes")
 public List<Dishes> getAllIngredients(){
	 return dishesService.getAll();
 }
 
 @GetMapping("/dishes/{id}")
 public Dishes getOne(@PathVariable(value="id")long id) {
	 return dishesService.get(id);
 }
 

 
 @PostMapping("/dishes")
 public void post(Dishes dish) {
	 dishesService.post(dish);
 }
 
 @PutMapping("/dishes/{id}")
 public void put(Dishes dishes, @PathVariable(value = "id") long id) {
	 dishesService.put(dishes, id);
 }
 
 @DeleteMapping("/dishes/{id}")
 public void delete(@PathVariable(value = "id") long id) {
	 dishesService.delete(id);
 }
}
