package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Seller;
import com.revature.services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Seller addSeller(@Valid @RequestBody Seller newSeller) {
		Seller seller = sellerService.addSeller(newSeller);
		seller.getAccount().setPassword("");
		return seller;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Seller> getAllSellers() {
		List<Seller> sellers = sellerService.findAllSellers();
		for (Seller seller : sellers) {
			seller.getAccount().setPassword("");
		}
		return sellers;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Seller findSellerById(@PathVariable("id") int id) {
		Seller seller = sellerService.findSellerById(id);
		seller.getAccount().setPassword("");
		return seller;
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Seller updateSeller(@RequestBody Seller updatedSeller) {
		Seller seller = sellerService.updateSellerById(updatedSeller);
		seller.getAccount().setPassword("");
		return seller;
	}

}
