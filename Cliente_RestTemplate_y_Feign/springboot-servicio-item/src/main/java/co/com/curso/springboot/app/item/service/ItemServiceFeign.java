package co.com.curso.springboot.app.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.com.curso.springboot.app.item.clientes.ProductoClienteRestFeign;
import co.com.curso.springboot.app.item.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService{

	@Autowired
	private ProductoClienteRestFeign clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listarProductos().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.listarProducto(id), cantidad);
	}

}
