package co.com.curso.springboot.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.com.curso.springboot.app.item.models.Item;
import co.com.curso.springboot.app.item.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceRestTemplate implements ItemService{

	public static String urlProductos="http://servicio-productos/producto/";
	
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject(urlProductos+"listarProductos", Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject(urlProductos+"/verProducto/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
