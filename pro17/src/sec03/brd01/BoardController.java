package sec03.brd01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	BoardService boardService;
	ArticleVO articleVO;
	
	public void init() {
		boardService = new BoardService(); // BoardService 객체 생성
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String nextPage ="";	
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String action = request.getPathInfo(); //URL에서 요청명을 가져옵니다.
	System.out.println("action: " + action);
	
	List<ArticleVO> articlesList = new ArrayList<>();
	if(action==null) {
		articlesList = boardService.listArticles();
		request.setAttribute("articlesList", articlesList);
		nextPage = "/board01/listArticles.jsp";
	} else if(action.equals("/listArticles.do")) {  // action 값이 /listArticles.do면 전체 글을 조회합니다.
        articlesList = boardService.listArticles();  // 전체 글을 조회합니다.
        request.setAttribute("articlesList", articlesList);  //조회된 글 목록을 articlesList로 바인딩 한 후 listArticles.jsp로 포워딩합니다.
        nextPage = "/board01/listArticles.jsp";
	}
	RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
	dispatch.forward(request, response);
		
	}

}
