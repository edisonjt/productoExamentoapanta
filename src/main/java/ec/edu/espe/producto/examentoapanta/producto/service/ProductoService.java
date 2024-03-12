package ec.edu.espe.producto.examentoapanta.producto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import ec.edu.espe.producto.examentoapanta.producto.dao.ProductoRepository;
import ec.edu.espe.producto.examentoapanta.producto.domain.Producto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoService {

  private final ProductoRepository productoRepository;

  public ProductoService(ProductoRepository productoRepository) {
    this.productoRepository = productoRepository;
  }

  @Transactional
  public void crear (Producto producto) {
    try {
     log.debug("Producto generado: {} ", producto.getCodigoUnico() );
     this.productoRepository.save(producto);
     log.info("Se creo el produco: {}", producto);
    } catch (Exception e) {
      throw new RuntimeException("Error al crear el producto", e);
    }
  }

  @Transactional
  public void modificar (Producto producto) {
    try{
      Producto productoAux = this.productoRepository.findByCodigo(producto.getCodigoUnico());
      if(productoAux.getCodigoUnico() != null){
        this.productoRepository.save(producto);

      }else{
        log.error("No se puede actualizar, el producto {}, no existe", producto);
      }

    }catch(Exception e){
      throw new RuntimeException("Error al actualizar el producto", e);
    }
  }


  public Producto obtenerPorCodigo(String codigoUnico) {
        log.info("Se va a obtener el producto por codigoUnico: {}", codigoUnico);
        Producto producto = this.obtenerPorCodigo(codigoUnico);
        if ( producto.getExistencia()) {
            log.debug("producto obtenido: {}", producto);
            return producto;
        } else {
            throw new RuntimeException("producto con codigo unico: " + codigoUnico + " no posee existencia");
        }
    }

}
