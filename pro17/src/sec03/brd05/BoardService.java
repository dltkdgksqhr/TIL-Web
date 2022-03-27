package sec03.brd05;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();  // 생성자 호출 시 BoardDAO 객체를 생성합니다.
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}

	public int addArticle(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
		
	}

	public ArticleVO viewArticle(int articleNO) throws UnsupportedEncodingException {
		ArticleVO article = null;
		article = boardDAO.selectArticles(articleNO);
		return article;
	}
	
	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}
}
