package sec03.brd01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
  private DataSource dataFactory;
  Connection conn;
  PreparedStatement pstmt;
  
  public BoardDAO() {
	  Context ctx;
	try {
		ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		  dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
	} catch (NamingException e) {
		e.printStackTrace();
	}
	  
 }
   public List selectAllArticles() {
	   List articlesList = new ArrayList();
	   try {
		conn = dataFactory.getConnection();
		  String query ="select level,articleNO,parentNO,title,content,id,writeDate"
			        + " from t_board"
			        + " start with parentNO=0" + " connect by prior articleNO=parentNO"
			        + " order siblings by articleNO desc"; // 오라클의 계층형 SQL문을 실행합니다.
	   System.out.println(query);
	   pstmt = conn.prepareStatement(query);
	   ResultSet rs = pstmt.executeQuery();
	   while (rs.next()) {
		int level = rs.getInt("level"); // 각 글의 깊이(계층)를 level 속성에 저장합니다.
		int articleNO = rs.getInt("articleNO"); // 글 번호는 숫자형이므로 getInt()로 값을 가져옵니다.
		int parentNO = rs.getInt("parentNO");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");
		Date writeDate = rs.getDate("writeDate");
		
		ArticleVO article = new ArticleVO();  // 글 정보를 ArticleVO 객체 속성에 설정합니다.
		article.setLevel(level);
		article.setArticleNO(articleNO);
		article.setParentNO(parentNO);
		article.setTitle(title);
		article.setContent(content);
		article.setId(id);
		article.setWriteDate(writeDate);
		articlesList.add(article);
	   }
	   rs.close();
	   pstmt.close();
	   conn.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return articlesList;
	 
   }
  
}
