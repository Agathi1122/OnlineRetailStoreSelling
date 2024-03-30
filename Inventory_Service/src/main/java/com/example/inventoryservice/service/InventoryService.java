package com.example.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.exception.Exception_class;
import com.example.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
    InventoryRepository repo;

	public List<Inventory> getInventorys() {

	List<Inventory> inventorys = (List<Inventory>) repo.findAll(); //System.out.println("customer 11111--->"+customers);

	return inventorys;

	}

	public ResponseEntity<Inventory> createInventory (Inventory inventory) {

	Inventory createInventory =repo.save(inventory);

	return new ResponseEntity<Inventory>(createInventory, HttpStatus.CREATED);

	}

	public Inventory getInventory(int inventoryid) {

	Optional<Inventory> inventorys= repo.findById(inventoryid);

	if (inventorys.isEmpty()) {

	throw new Exception_class("Inventory Product doesn't exists--> "+inventoryid); }

	Inventory inventory = inventorys.get();

	if (inventory == null) {

	throw new Exception_class("Inventory Product doesn't exists--># "+ inventoryid);

	} 
	return inventory;
}

	public Inventory updateInventory(int inventoryid, Inventory inven) {

	Optional<Inventory> inventorys =  repo.findById(inventoryid);

	if (inventorys.isEmpty()) {

	throw new Exception_class("Inventory Product doesn't exists-->#" + inventoryid);

	}

	Inventory inventory = inventorys.get();

	if (inventory == null) {

		throw new Exception_class("Inventory Product doesn't exists-->#" + inventoryid);
	}
    inventory.setProductId(inven.getProductId());
    inventory.setQuantity(inven.getQuantity());
    
    return repo.save(inventory);
	}
	
	public Inventory deleteInventory(int inventory_id)
	{
		Optional<Inventory> inventorys =  repo.findById(inventory_id);

		if (inventorys.isEmpty()) {

		throw new Exception_class("Inventory Product doesn't exists-->#" + inventory_id);

		}

		Inventory deleteinventory = inventorys.get();
		if (deleteinventory == null) {

			throw new Exception_class("Inventory Product doesn't exists-->#" + inventory_id);
		}
		repo.deleteById(inventory_id);
		return deleteinventory;
		
	}
	

}
