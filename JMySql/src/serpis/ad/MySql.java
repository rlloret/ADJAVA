package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MySql {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//Class.forName("com.mysql.jdbc.Driver");//Necesario en driver 3 o anterior
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba?user=root&password=sistemas");

		

        int opcion=0;
		do{
			System.out.println("*****************");
			System.out.println("Elige una opción:");
			System.out.println("*****************");
			System.out.println("1--Borrar");
			System.out.println("2--Insertar");
			System.out.println("3--Listar");
			System.out.println("4--Salir");
			opcion = scanner.nextInt();
			
			
			switch(opcion){
		    case 1:
		    	System.out.println("Elige el id de la categoría a borrar");
				int idBorrar = scanner.nextInt();
				
				PreparedStatement preparedStatementDelete =connection.prepareStatement("delete from categoria where id = ?");
	    		
	    		preparedStatementDelete.setLong(1,idBorrar);
	    		ResultSet resultSetDelete = preparedStatementDelete.executeQuery();
	    		
	    		resultSetDelete.close();
	
		        break;
		    case 2:
				System.out.println("Introduce el nombre a insertar");
				String nombreInsertar = scanner.nextLine();
				
				PreparedStatement preparedStatementInsert =connection.prepareStatement("insert into categoria (nombre) VALUES (?)");
	    		
	    		preparedStatementInsert.setString(1,nombreInsertar);
	    		ResultSet resultSet = preparedStatementDelete.executeQuery();

		        
		        break;    
	        case 3:
	        	
	        	PreparedStatement preparedStatement =connection.prepareStatement("select * from categoria where id < ?");
	    		
	    		preparedStatement.setLong(1,100);
	    		ResultSet resultSet = preparedStatement.executeQuery();
	    		
	    		while(resultSet.next()){
	    			System.out.printf("id=%4s nombre=%s\n", resultSet.getObject("id"),
	    					resultSet.getObject("nombre"));
	    		}
				

		        
		        break;
	        case 4:
	        	
	        	System.exit(0);         
		        break;
	        	
			}
			
			
			
			
			
		 }while(opcion!=5);

		
		resultSet.close();
		scanner.close();
		preparedStatement.close();
		connection.close();
	}

}
