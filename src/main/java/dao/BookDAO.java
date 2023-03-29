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
			String sql = "SELECT * FROM libBook";
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
			                String isbn = rs.getString("isbn");
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

		public static Book searchIDBook(int book_id) {
			String sql = "SELECT * FROM libbook WHERE id = ?";
			
			try(
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setInt(1,book_id);
			
				try(ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						 int id = rs.getInt("id");
			                String title = rs.getString("title");
			                String author = rs.getString("author");
			                String isbn = rs.getString("isbn");
			                String new_old = rs.getString("new_old");
			                String publisher = rs.getString("publisher");
			                
			                return new Book(id,title,author,isbn,new_old,publisher);
						}
				}
		}
			catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return null;

	}

		//ISBNで本の検索
		public static Book searchisbnBook(String book_isbn) {
			String sql = "SELECT * FROM libbook WHERE isbn = ?";
		
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setString(1, book_isbn);
				
				try (ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						int id = rs.getInt("id");
						String title = rs.getString("title");
						String author = rs.getString("author");
						String isbn = rs.getString("isbn");
		                String new_old = rs.getString("new_old");
		                String publisher = rs.getString("publisher");
						
						return new Book(id, title, author, isbn, new_old, publisher);
						
						
					}
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		}
		//図書の新規登録
		public static int registerBook(Book book) {
			String sql = "INSERT INTO libbook VALUES(default, ?, ?, ?, ?, ?)";
			
			int result = 0;
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setString(1, book.getTitle());
				pstmt.setString(2, book.getAuthor());
				pstmt.setString(3, book.getIsbn());
				pstmt.setString(4, book.getNew_old());
				pstmt.setString(5, book.getPublisher());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件更新しました。");
			}
			return result;
		}
		
		public static int DeleteBook(int id) {
			String sql = "delete from libbook where id = ?";
			int result = 0;
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setInt(1, id);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件更新しました。");
			}
			return result;
		}

	}
			

