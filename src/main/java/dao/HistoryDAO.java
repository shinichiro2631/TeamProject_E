package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoryDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	public static int registerHistory(int book_id,int account_id,int due_date){
		String sql = "INSERT INTO History VALUES (?,?,current_date,null, currentdate + cast( '" + due_date +  " days'as INTERVAL)";
		int result=0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book_id);
			pstmt.setInt(2, account_id);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "貸出しました。");
		}
		return result;
	}
	 public void returnBook(int accountId, int bookId) throws SQLException {
	        String sql = "UPDATE History SET return_date = ? WHERE account_id = ? AND book_id = ? AND return_date IS NULL;";
	        int result = 0;
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
	        pstmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
	        pstmt.setInt(2, accountId);
	        pstmt.setInt(3, bookId);
	        
	        result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "返却しました。");
			}
			return;
	 }
}
