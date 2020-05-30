package com.example.catservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.catservice.dao.ProduitRepository;
import com.example.catservice.entites.Produit;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner{

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private RepositoryRestConfiguration configuration;
	
	public static void main(String[] args) {
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null, "Ordinateur LX 45", 6700, 3));
		produitRepository.save(new Produit(null, "Imprimante HP", 1700, 3));
		produitRepository.save(new Produit(null, "Smartphone samsung S9", 8000, 13));
		
		produitRepository.findAll().forEach(p ->
			System.out.println(p.toString())
				);
	}

}
