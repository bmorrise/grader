package com.fakecompany.grader.itemservice.controller;

import com.fakecompany.grader.common.model.Item;
import com.fakecompany.grader.itemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ItemController implements CommandLineRunner
{
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping(path = "/items")
	public List<Item> getItems() {
		return itemRepository.findAll();
	}
	
	@GetMapping(path = "/item/{id}")
	public Item getItem(@PathVariable("id") String id) {
		return itemRepository.findById(id).orElse(null);
	}
	
	@PostMapping(path = "/item")
	public Item createItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@DeleteMapping(path = "/item/{id}")
	public void deleteItem(@PathVariable("id") String id) {
		itemRepository.deleteById(id);
	}
	
	@Override
	public void run(String... args) throws Exception
	{
		itemRepository.deleteAll();
		
		Item item1 = new Item();
		item1.setName("Super Mario 3 NES Cartridge");
		item1.setStatus(Item.Status.COMPLETE);
		item1.setCompleted(new Date());
		item1.setGrade(8.2);
		item1.setNotes("The package is sealed with no visible tears. The plastic is somewhat rough. The bottom right edge has very minor crumpling, but the other corners are sharp.");
		
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setName("Super Spike V-Ball");
		item2.setStatus(Item.Status.COMPLETE);
		item2.setCompleted(new Date());
		item2.setGrade(6.4);
		item2.setNotes("The package has no visible tears, but does have the price written on the plastic with marker. There are no visible crumpling on any of the edges");
		
		itemRepository.save(item2);
	}
}
