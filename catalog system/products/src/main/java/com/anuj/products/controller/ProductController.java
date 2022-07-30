package com.anuj.products.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anuj.prices.Prices;


@RestController
public class ProductController {
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	
	@GetMapping("/products")
	public List<Products> getProducts()
	{
		return repo.findAll();
	}
	
	
	//whenever admin add new product then its price will get fetch from price table
	@PostMapping("/products")
	public String saveAsset(@RequestBody Products product)
	{
		//get primary key of product table
		int pid=product.getPid();
		
		//get prices from price table using primary key 
		Prices obj=restTemplate.getForObject("http://PRICE/prices/"+pid,Prices.class);
		
		 //set map column of product to newly create hash map
		product.setPrice(obj);

	    //save in database
		repo.save(product);
		
		return "save successful";
	}
	
	@GetMapping("/products/{pid}")
	public Optional<Products> getAsset(@PathVariable("pid") int pid)
	{
		return repo.findById(pid);
	}
	
	@PutMapping("/products")
	public String updateAsset(@RequestBody Products product)
	{
		repo.save(product);
		return "save successful";
	}
	
	@DeleteMapping("/products/{pid}")
	public String deleteAsset(@PathVariable("pid") int pid)
	{
		@SuppressWarnings("deprecation")
		Products obj=repo.getOne(pid);
		repo.delete(obj);
		return "successful";
	}
	
	

}


