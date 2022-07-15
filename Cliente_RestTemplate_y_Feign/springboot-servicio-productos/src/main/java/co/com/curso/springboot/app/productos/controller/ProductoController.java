package co.com.curso.springboot.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.curso.springboot.app.productos.models.Producto;
import co.com.curso.springboot.app.productos.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/listarProductos")
	public List<Producto> listarProductos(){
		return iProductoService.findAll();
	}
	
	@GetMapping("/verProducto/{id}")
	public Producto listarProducto(@PathVariable("id") long id) {
		return iProductoService.findById(id);
	}
}
