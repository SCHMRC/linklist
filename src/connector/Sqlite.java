package connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite {
	
	private static Connection connection;
	
	public static Connection getConnection() {
		if(Sqlite.connection == null) {
			try{
				Sqlite.connection = DriverManager.getConnection("jdbc:sqlite:graphic.db");
				System.out.println("Connection success!!");
			}catch(SQLException error){
				System.out.println(error.getMessage());
				
			}	
		}
		return Sqlite.connection;
	}

}
