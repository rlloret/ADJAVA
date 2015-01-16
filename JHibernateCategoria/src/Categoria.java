import java.io.Serializable;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")*/
public class Categoria implements Serializable  {
 
    //@Id
    //@Column(name="Id")
    private int id;
 
     //@Column(name="nombre")
     private String nombre;



     public Categoria(){
     }

     public Categoria(int id, String nombre) {
         this.id = id;
         this.nombre = nombre;

     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

 }
