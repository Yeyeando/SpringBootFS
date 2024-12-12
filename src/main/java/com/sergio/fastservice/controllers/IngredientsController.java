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

import com.sergio.fastservice.entity.models.Ingredients;
import com.sergio.fastservice.entity.services.IIngredientsService;

@RestController
@CrossOrigin(origins ="*")
public class IngredientsController {
 @Autowired
 IIngredientsService ingredientsService;
 
 @GetMapping("/ingredients")
 public List<Ingredients> getAllIngredients(){
	 return ingredientsService.getAll();
 }
 
 @GetMapping("/ingredients/{id}")
 public Ingredients getOne(@PathVariable(value="id")long id) {
	 return ingredientsService.get(id);
 }
 
 @PostMapping("/ingredients")
 public void post(Ingredients ingredient) {
	 ingredientsService.post(ingredient);
 }
 
 @PutMapping("/ingredients/{id}")
 public void put(Ingredients ingredients, @PathVariable(value = "id") long id) {
	 ingredientsService.put(ingredients, id);
 }
 
 @DeleteMapping("/ingredients/{id}")
 public void delete(@PathVariable(value = "id") long id) {
	 ingredientsService.delete(id);
 }
}
