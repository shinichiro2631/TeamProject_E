package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Book;

public class BookDAO {
	// DBへのConnectionを取得（本番環境/テスト環境 切り替え用）
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
		
		//商品を全権取得するためのメソッド
		public static List<Book>selectListBook(){
			String sql = "SELECT * FROM libbook";
			List<Book> list = new ArrayList<>();
			
			try(
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				try(ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						 int id = rs.getInt("id");
			                String title = rs.getString("title");
			                String author = rs.getString("author");
			                int isbn = rs.getInt("isbn");
			                String new_old = rs.getString("new_old");
			                String publisher = rs.getString("publisher");
						
			                Book book = new Book(id,title,author,isbn,new_old,publisher);
							list.add(book);
						}
				} 
				
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return list;
		}
	}

			

