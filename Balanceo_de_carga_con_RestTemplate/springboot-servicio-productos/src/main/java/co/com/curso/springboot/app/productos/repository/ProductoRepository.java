package co.com.curso.springboot.app.productos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.curso.springboot.app.productos.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
