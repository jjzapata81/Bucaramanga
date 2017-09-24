package co.com.bucaramanga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.bucaramanga.entities.Producto;

public interface IProductoRep extends JpaRepository<Producto, String>{

}
