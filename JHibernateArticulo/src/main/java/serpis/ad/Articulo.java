package serpis.ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Articulo{
	
	private Long id;
    private String nombre;
    private String categoria;
    private int precio;
    
    
   public Articulo() {

	}

	public Articulo(long id, String nombre, String categoria, int precio) {

		this.id =id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}
    

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
		return id;
    }

    private void setId(Long id) {
		this.id = id;
    }

    public String getNombre() {
		return nombre;
    }

    public void setNombre(String nombre) {
		this.nombre = nombre;
    }
    
    public String getCategoria() {
		return nombre;
    }

    public void setCategoria(String nombre) {
		this.nombre = nombre;
    }

    public int getPrecio() {
		return precio;
    }

    public void setPrecio(int precio) {
		this.precio = precio;
    }

}
