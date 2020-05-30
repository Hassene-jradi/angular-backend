package com.example.catservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.catservice.dao.ProduitRepository;
import com.example.catservice.entites.Produit;

@RestController
public class ProduitRestService {
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping(value = "/listProduits")
	public List<Produit> listProduits() {
		return produitRepository.findAll();
	}
	
	@GetMapping(value = "/listProduits/{id}")
	public Produit listProduits(@PathVariable(name="id") Long id) {
		return produitRepository.findById(id).get();
	}
	
	@PutMapping(value = "/listProduits/{id}")
	public Produit update(@PathVariable(name="id") Long id, @RequestBody Produit p) {
		p.setId(id);
		return produitRepository.save(p);
	}
	
	@PostMapping(value = "/listProduits")
	public Produit save(@RequestBody Produit p) {
		return produitRepository.save(p);
	}
	
	@DeleteMapping(value = "/listProduits/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		produitRepository.deleteById(id);
	}
}
