package com.bcaisse.bcaisse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaisse.bcaisse.dao.CategorieRepository;
import com.bcaisse.bcaisse.entity.Categorie;
import com.bcaisse.bcaisse.exception.ResourceNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CategorieController {

	@Autowired
	private CategorieRepository categorieRepository;
	
	@GetMapping("/categories")
	public List<Categorie> getAllCategories(){
		System.out.println("Get all Categories...");
		
		List<Categorie> categories = new ArrayList<>();
		categorieRepository.findAll().forEach(categories :: add);
		return categories;
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable(value = "id") Long categorieId) throws ResourceNotFoundException{
		Categorie categorie = categorieRepository.findById(categorieId)
				.orElseThrow(()-> new ResourceNotFoundException("Categorie not found for this id ::" + categorieId));
		return ResponseEntity.ok().body(categorie);
	}
	
	@PostMapping("/categories")
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return categorieRepository.save(categorie);
	}
	
	@DeleteMapping("/categories/{id}")
	public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") Long categorieId) throws ResourceNotFoundException{
		Categorie categorie = categorieRepository.findById(categorieId)
				.orElseThrow(() -> new ResourceNotFoundException("Categorie not found id: " + categorieId));
		
		categorieRepository.delete(categorie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/categories/delete")
	public ResponseEntity<String> deleteAllCategories(){
		System.out.println("Delete All Categories...");
		categorieRepository.deleteAll();
		return new ResponseEntity<>("All Categories have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") Long id, @RequestBody Categorie categorie){
		System.out.println("Update Categorie with ID = " + id + "...");
		
		Optional<Categorie> categorieInfo = categorieRepository.findById(id);
		
		if(categorieInfo.isPresent()) {
			Categorie categorie2 = categorieInfo.get();
			categorie2.setLibelle(categorie.getLibelle());
			
			return new ResponseEntity<>(categorieRepository.save(categorie), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
