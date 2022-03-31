package sec03.brd07;

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

	public List<Integer> removeArticle(int articleNO) {
    List<Integer> articleNOList = boardDAO.selectRemovedArticles(articleNO); // 글을 삭제하기 전 글번호들을 ArrayList객체에 저장합니다.
    boardDAO.deleteArticle(articleNO);
		return articleNOList; // 삭제한 글 번호 목록을 컨트롤러로 반환합니다.
	}

	public int addReply(ArticleVO article) {
		return boardDAO.insertNewArticle(article); // 새 글 추가시 사용한 insertNewArticle()메서드를 이용해 답글을 추가합니다.
	}

}
