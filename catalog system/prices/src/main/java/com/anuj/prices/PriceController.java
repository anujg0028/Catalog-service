package com.anuj.prices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PriceController {
	
	@Autowired
	PriceRepo repo;
	
	
	
	@GetMapping("/prices")
	public List<Prices> getPrices()
	{
		
		return repo.findAll();
	}
	
	@GetMapping("/prices/{pid}")
	public Optional<Prices> getAsset(@PathVariable("pid") int pid)
	{
		return repo.findById(pid);
	}
		
	@PostMapping("/prices")
	public String savePrices(@RequestBody Prices price)
	{
		repo.save(price);
		return "save successful";
	}
	
	

}