package co.com.curso.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.curso.springboot.app.item.models.Item;
import co.com.curso.springboot.app.item.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;

	@GetMapping("/listarItems")
	public List<Item> listar(){
		return itemService.findAll();
	}

	@GetMapping("/verDetalleItem/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
}
