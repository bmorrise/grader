package com.fakecompany.grader.clientservice;

import com.fakecompany.grader.common.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("item-service")
interface ItemClient {
	
	@GetMapping("/item-service/items")
	List<Item> getItems();
	
	@GetMapping("/item-service/item/{id}")
	Item getItem(@PathVariable("id") String id);
	
	@DeleteMapping("/item-service/item/{id}")
	void deleteItem(@PathVariable("id") String id);
}