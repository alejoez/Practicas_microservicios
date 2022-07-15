package co.com.curso.springboot.app.productos.service;

import java.util.List;

import co.com.curso.springboot.app.productos.models.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
}
