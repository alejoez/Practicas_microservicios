package co.com.curso.springboot.app.item.service;

import java.util.List;

import co.com.curso.springboot.app.item.models.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
}
