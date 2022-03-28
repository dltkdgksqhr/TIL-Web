package sec03.brd06;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
   
   private int getNewArticleNO() {
	try {
		conn = dataFactory.getConnection();
		String query = "select max(articleNO) from t_board "; // 기본 글 번호 중 가장 큰 번호를 조회합니다.
		System.out.println(query);
		pstmt = conn.prepareStatement(query);
		ResultSet rs =pstmt.executeQuery();
		if (rs.next()) 
		  return (rs.getInt(1) + 1); // 가장 큰 번호에 1을 더한 번호를 반환합니다.
	    rs.close();
	    pstmt.close();
	    conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return 0;
   }
  
   public int insertNewArticle(ArticleVO article) {
	  
	   int articleNO = getNewArticleNO(); // 새 글을 추가하기 전에 새 글에 대한 글 번호를 가져옵니다.
	 try {
		conn = dataFactory.getConnection();
		 int parentNO = article.getParentNO();
		 String title = article.getTitle();
		 String content = article.getContent();
		 String id = article.getId();
		 String imageFileName = article.getImageFileName();
		 String query = "insert into t_board (articleNO, parentNO, title, content, imageFileName, id)" +
		                " values (?, ?, ?,? ,?,?)";
		 System.out.println(query);
		 pstmt = conn.prepareStatement(query);
		 pstmt.setInt(1, articleNO);
		 pstmt.setInt(2, parentNO);
		 pstmt.setString(3, title);
		 pstmt.setString(4, content);
		 pstmt.setString(5, imageFileName);
		 pstmt.setString(6, id);
		 pstmt.executeUpdate();
		 pstmt.close();
		 conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return articleNO; // SQL문으로 새 글을 추가하고 새 글 번호를 반환합니다.
	 
   }

public ArticleVO selectArticles(int articleNO) throws UnsupportedEncodingException {
  ArticleVO article = new ArticleVO();
  try {
	conn = dataFactory.getConnection();
	String query = "select articleNO, parentNO, title, content, imageFileName, id, writeDate"
		        +" from t_board"
		        +" where articleNO=?";
	System.out.println(query);
	pstmt = conn.prepareStatement(query);
	pstmt.setInt(1, articleNO);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int _articleNO =rs.getInt("articleNO");
	int parentNO=rs.getInt("parentNO");
	String title = rs.getString("title");
	String content =rs.getString("content");
	String imageFileName = URLEncoder.encode(rs.getString("imageFileName"), "UTF-8");

	if(imageFileName.equals("null")) {
	  imageFileName = null;
	}
	String id =rs.getString("id");
	Date writeDate = rs.getDate("writeDate");

	article.setArticleNO(_articleNO);
	article.setParentNO (parentNO);
	article.setTitle(title);
	article.setContent(content);
	article.setImageFileName(imageFileName);
	article.setId(id);
	article.setWriteDate(writeDate);
	rs.close();
	pstmt.close();
	conn.close();
      } catch (SQLException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
    }
 
  return article;
  }
public void updateArticle(ArticleVO article) {
  int articleNO = article.getArticleNO();
  String title = article.getTitle();
  String content = article.getContent();
  String imageFileName = article.getImageFileName();
  
  try {
	conn = dataFactory.getConnection();
	String qeury = "update t_board set title=?, content=?";
	  if(imageFileName != null && imageFileName.length() != 0) {
		 qeury += ",imageFileName=?";
	  } // 수정된 이미지 파일이 있을 때만 imageFileName을 SQL문에 추가합니다.
	  qeury += " where articleNO=?";
	  
	  System.out.println(qeury);
	  pstmt=conn.prepareStatement(qeury);
	  pstmt.setString(1, title);
	  pstmt.setString(2, content);
	  
	  if(imageFileName != null && imageFileName.length() != 0) {
		pstmt.setString(3, imageFileName);
		pstmt.setInt(4, articleNO);
	  } else {
		  pstmt.setInt(3, articleNO);
	  }  // 이미지 파일을 수정하는 경우와 그렇지 않은 경우를 구분해서 설정합니다.
	  pstmt.executeUpdate();
	  pstmt.close();
	  conn.close();
} catch (SQLException e) {
	
	e.printStackTrace();
    	}
    
    }
public List<Integer> selectRemovedArticles(int articleNO) {
  List<Integer> articleNOList = new ArrayList<Integer>();
  
  try {
	conn = dataFactory.getConnection();
	String query ="select articleNO from t_board ";
    query += " start with articleNO =?";
    query += " connect by prior articleNO = parentNO"; //삭제한 글들의 articleNO를 조회합니다.
    System.out.println(query);
    pstmt= conn.prepareStatement(query);
    pstmt.setInt(1, articleNO);
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
     articleNO = rs.getInt("articleNO");
     articleNOList.add(articleNO);
    }
    pstmt.close();
    conn.close();
} catch (SQLException e) {
	
	e.printStackTrace();
}
  
	return articleNOList;
  }
public void deleteArticle(int articleNO) {
    try {
		conn = dataFactory.getConnection();
		String query = "delete from t_board ";
	    query += " where articleNO in (";
	    query += " select articleNO from t_board ";
	    query += " start with articleNO =?";
	    query += " connect by prior articleNO = parentNO)"; // 오라클의 계층형 SQL문을 이용해 삭제글과 관련된 자식 글까지 모두 삭제합니다.
	    System.out.println(query);
	    pstmt = conn.prepareStatement(query);
	    pstmt.setInt(1, articleNO);
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
    
	
	}
}
