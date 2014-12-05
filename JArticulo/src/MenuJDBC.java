
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MenuJDBC {
	
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba?user=root&password=sistemas");

        int opcion=0;
		do{
			System.out.println("*****************");
			System.out.println("Elige una opción:");
			System.out.println("*****************");
			System.out.println("0--Salir");//OK
			System.out.println("1--Nuevo");//OK
			System.out.println("2--Editar");
			System.out.println("3--Eliminar");//OK
			System.out.println("4--Visualizar");//OK+-
			opcion = scanner.nextInt();
			
			
			switch(opcion){
			case 0:
				System.exit(0);  
				break;
		    case 1:
		    	System.out.println("Introduce el nombre a insertar");
				String nombreInsertar = scanner.nextLine();
				nombreInsertar = scanner.nextLine();
				System.out.println("Introduce el numero de la categoria a insertar");
				int categoriaInsertar = scanner.nextInt();
				
			    System.out.println("Introduce el precio a insertar");
				float precioInsertar = scanner.nextFloat();
				
				PreparedStatement preparedStatementInsert =connection.prepareStatement("insert into articulo (nombre,categoria,precio) VALUES (?,?,?)");
	    		
	    		preparedStatementInsert.setString(1,nombreInsertar);
	    		preparedStatementInsert.setInt(2,categoriaInsertar);
	    		preparedStatementInsert.setFloat(3,precioInsertar);
	    		int resultSet = preparedStatementInsert.executeUpdate();

		        
	
		        break;
		    case 2:

		    	
		        break;    
	        case 3:
	        	System.out.println("Elige el id del articulo a borrar");
				int idBorrar = scanner.nextInt();
				
				PreparedStatement preparedStatementDelete =connection.prepareStatement("delete from articulo where id = ?");
	    		
	    		preparedStatementDelete.setInt(1,idBorrar);
	    		int resultSetDelete = preparedStatementDelete.executeUpdate();
	    		
     
		        break;
	        case 4:
	        	PreparedStatement preparedStatement =connection.prepareStatement("select * from articulo where id < ?");
	    		
	    		preparedStatement.setLong(1,100);
	    		ResultSet resultSetSelect = preparedStatement.executeQuery();
	    		
	    		while(resultSetSelect.next()){
	    			System.out.printf("id=%s nombre=%s categotia=%s precio=%s\n", resultSetSelect.getObject("id"),
	    					resultSetSelect.getObject("nombre"),resultSetSelect.getObject("categoria"),resultSetSelect.getObject("precio"));
	    		}
				

	    		resultSetSelect.close();
	        	
	        	         
		        break;
	        	
			}

			
		 }while(opcion!=5);

		
		scanner.close();
		connection.close();
	}
	

}
