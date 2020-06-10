package com.fakecompany.grader.clientservice;

import com.fakecompany.grader.common.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ClientController
{
	@Autowired
	private ItemClient itemClient;
	
	@GetMapping(path = "/items")
	public List<Item> getItems()
	{
		return itemClient.getItems();
	}
	
	@GetMapping(path = "/item/{id}")
	public Item getItem(@PathVariable("id") String id)
	{
		return itemClient.getItem(id);
	}
	
	@DeleteMapping(path = "/item/{id}")
	public void deleteItem(@PathVariable("id") String id)
	{
		itemClient.deleteItem(id);
	}
}
