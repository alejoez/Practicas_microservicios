package co.com.curso.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.com.curso.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos", url = "localhost:8001/producto")
public interface ProductoClienteRestFeign {

	@GetMapping("/listarProductos")
	public List<Producto> listarProductos();
	
	@GetMapping("/verProducto/{id}")
	public Producto listarProducto(@PathVariable("id") long id);
}
