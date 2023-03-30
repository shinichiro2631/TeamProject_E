package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.Arrears;
import dto.History;

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
		String sql = "INSERT INTO History VALUES(default,?,?,current_date,null, current_date + cast( '" + due_date +  " days'as INTERVAL))";
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

	 public static List<History> selectListHistory() {
			String sql = "SELECT * FROM History";
			List<History> list = new ArrayList<>();

			try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						int book_id = rs.getInt("boook_id");
						int account_id = rs.getInt("account_id");
						String loan_date = rs.getString("loan_date");
						String return_date = rs.getString("return_date");
						String due_date = rs.getString("due_date");

						History history = new History(book_id,account_id,loan_date,return_date,due_date);
						list.add(history);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return list;
		}
	//延滞者一覧
	public static List<Arrears> arrearsList(){
			 String sql = "SELECT * FROM history h JOIN libaccount a ON h.account_id = a.id JOIN libbook b ON h.book_id = b.id WHERE h.return_date IS NULL AND h.due_date < current_date";
			 List<Arrears> result = new ArrayList<>();
			 Date date = new Date();
			 try (
					 Connection con = getConnection();
					 PreparedStatement pstmt = con.prepareStatement(sql);
					 ){
				 try (ResultSet rs = pstmt.executeQuery()){
					 while(rs.next()) {
						 String name = rs.getString("name");
						 int account_id = rs.getInt("account_id");
						 int book_id = rs.getInt("book_id");
						 String title = rs.getString("title");
						 String loan_date = rs.getString("loan_date");
						 String due_date = rs.getString("due_date");
						 				            
						 Arrears arrears = new Arrears(name, account_id, book_id, title, loan_date, due_date);
						 
						 result.add(arrears);
					 }
				 }
			 } catch (SQLException e) {
				 e.printStackTrace();
			 } catch (URISyntaxException e) {
			   	 e.printStackTrace();
			 }
			 return result; 
	 }
}
