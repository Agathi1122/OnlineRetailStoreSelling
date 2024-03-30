package com.example.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	InventoryService service;

	@GetMapping("/api/inventorys")
	public List<Inventory> getInventorys() {

	return service.getInventorys();
	}

	@PostMapping("/api/inventorys")

	public ResponseEntity<Inventory> createInventory (@RequestBody Inventory inventory) {

	return service.createInventory(inventory);
	}

	@GetMapping(value="/api/inventorys/{inventory_id}")
	public Inventory getInventory(@PathVariable int inventory_id) {

	Inventory inventory =service.getInventory(inventory_id);
	return inventory;
	}

	@PutMapping("/api/inventorys/{inventory_id}")
	public Inventory updateInventory (@PathVariable int inventory_id,
	@RequestBody Inventory inventory) {

	Inventory InventoryUpdate = service.updateInventory(inventory_id, inventory);

	return InventoryUpdate;

	}

	@DeleteMapping("/api/inventorys/{inventory_id}") 
	public Inventory deleteInventory (@PathVariable int inventory_id) {
		Inventory InventoryDelete =service.deleteInventory(inventory_id);
		return InventoryDelete;
	}
	

	
}
