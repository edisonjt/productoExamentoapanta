package ec.edu.espe.producto.examentoapanta.producto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.producto.examentoapanta.producto.domain.Producto;
import ec.edu.espe.producto.examentoapanta.producto.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

  private final ProductoService productoService;

  public ProductoController(ProductoService productoService) {
      this.productoService = productoService;
  }

  @GetMapping("/{codigoUnico}")
    public ResponseEntity<Producto> buscarPorCodigounico(@PathVariable(name = "codigoUnico") String codigoUnico) {
        log.info("Obteniendo producto con codigo unico : {}", codigoUnico);
        try {
            return ResponseEntity.ok(this.productoService.obtenerPorCodigo(codigoUnico));
        } catch(RuntimeException rte) {
            log.error("Error al obtener cliente por ID", rte);
            return ResponseEntity.notFound().build();
        }
    }

  @PostMapping
    public ResponseEntity<Void> crear(@RequestBody Producto producto) {
        log.info("Se va a crear el producto: {}", producto);
        try {
            this.productoService.crear(producto);
            return ResponseEntity.noContent().build();
        } catch(RuntimeException rte) {
            log.error("Error al crear el producto", rte);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@RequestBody Producto producto) {
        log.info("Se va a actualizar el producto: {}", producto);
        try {
            this.productoService.modificar(producto);
            return ResponseEntity.noContent().build();
        } catch(RuntimeException rte) {
            log.error("Error al actualizar el producto", rte);
            return ResponseEntity.badRequest().build();
        }
    }
  


}
