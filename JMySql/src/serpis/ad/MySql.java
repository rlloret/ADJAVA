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
	      
	        	
	        	PreparedStatement preparedStatement =connection.prepareStatement("select * from categoria where id < ?");
	    		
	    		preparedStatement.setLong(1,100);
	    		ResultSet resultSet = preparedStatement.executeQuery();
	    		
	    		while(resultSet.next()){
	    			System.out.printf("id=%4s nombre=%s\n", resultSet.getObject("id"),
	    					resultSet.getObject("nombre"));
	    		}
				

	        
	     


		
		resultSet.close();
		scanner.close();
		preparedStatement.close();
		connection.close();
	}

}
