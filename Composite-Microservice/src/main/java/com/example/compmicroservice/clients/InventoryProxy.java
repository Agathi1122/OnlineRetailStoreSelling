package com.example.compmicroservice.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.compmicroservice.Entity.Inventory;

@FeignClient(name="Inventory-Service",fallback=InventoryServiceFallBack.class)
public interface InventoryProxy {
	
	@GetMapping("/api/inventorys")
	public List<Inventory> getInventorys();
	
	@PostMapping("/api/inventorys")
	public Inventory createInventory (@RequestBody Inventory inventory);

	@GetMapping(value="/api/inventorys/{inventory_id}")
	public Inventory getInventory(@PathVariable int inventory_id);

	@PutMapping("/api/inventorys/{inventory_id}")
	public Inventory updateInventory (@PathVariable int inventory_id,
	@RequestBody Inventory inventory);
}

@Component
class InventoryServiceFallBack implements InventoryProxy
{

	@Override
	public List<Inventory> getInventorys() {
		// TODO Auto-generated method stub
		return new ArrayList<Inventory>();
	}

	@Override
	public Inventory createInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return new Inventory(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Inventory getInventory(int inventory_id) {
		// TODO Auto-generated method stub
		return new Inventory();
	}

	@Override
	public Inventory updateInventory(int inventory_id, Inventory inventory) {
		// TODO Auto-generated method stub
		return new Inventory(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
