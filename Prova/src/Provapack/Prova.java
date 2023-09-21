package Provapack;
import java.sql.*;

public class Prova {

	
	public static void main(String[] args) {
		Prova.es4(3);
	}
	
	public static void es4(int X) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/";
			String username = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url,username, password);
			
			String query = "SELECT s.matricola, s.nome, s.cognome FROM studente AS s"
					+ "INNER JOIN accesso AS a ON s.matricola = a.studente"
					+ "GROUP BY (s.matricola)"
					+ "HAVING COUNT(DISTINCT a.esameP) >= ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, X);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String matricola = rs.getString("matricola");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				System.out.println( matricola + "|" + nome + "|" + cognome);
			}
		}
		catch(Exception e){System.out.println("Errore!");}
	}

}
