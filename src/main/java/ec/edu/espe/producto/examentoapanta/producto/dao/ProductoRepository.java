package ec.edu.espe.producto.examentoapanta.producto.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.producto.examentoapanta.producto.domain.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String>{

  Producto findByCodigo(String codigoUnico);
  
}
