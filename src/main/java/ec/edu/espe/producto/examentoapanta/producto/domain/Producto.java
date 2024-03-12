package ec.edu.espe.producto.examentoapanta.producto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Naturales")

public class Producto {

  @Id
  @Field("codigoUnico")
  private String codigoUnico;

  @Field("nombre")
  private String nombre;

  @Field("descripcion")
  private String descripcion;

  @Field("precio")
  private BigDecimal precio;

  @Field("existencia")
  private String existencia;

  @Override
  public String toString() {
    return "Producto [codigoUnico=" + codigoUnico + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
        + precio + ", existencia=" + existencia + "]";
  }

  public Producto(String codigoUnico) {
    this.codigoUnico = codigoUnico;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codigoUnico == null) ? 0 : codigoUnico.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Producto other = (Producto) obj;
    if (codigoUnico == null) {
      if (other.codigoUnico != null)
        return false;
    } else if (!codigoUnico.equals(other.codigoUnico))
      return false;
    return true;
  }
}
