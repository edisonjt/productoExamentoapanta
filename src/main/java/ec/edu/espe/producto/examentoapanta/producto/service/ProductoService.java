package ec.edu.espe.producto.examentoapanta.producto.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

  public Producto obtenerPorCodigo(String codigoUnico) {
        log.info("Se va a obtener el producto por codigoUnico: {}", codigoUnico);
        Producto producto = this.obtenerPorCodigo(codigoUnico);
        if (producto.getExistencia()) {
            log.debug("producto obtenido: {}", producto);
            return producto;
        } else {
            throw new RuntimeException("producto con codigo unico: " + codigoUnico + " no posee existencia");
        }
    }

}
