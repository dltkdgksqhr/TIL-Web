package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	
	MemberDAO memberDAO;
	
	public void init() {
		memberDAO = new MemberDAO(); // memberDAO 객체 생성
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
	String nextPage =null;	
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String action = request.getPathInfo(); //URL에서 요청명을 가져옵니다.
	System.out.println("action: " + action);
	
	if(action== null || action.equals("/listMembers.do")) {
		List<MemberVO> membersList = memberDAO.listMembers(); //요청에 대해 회원정보를 조회합니다.
		request.setAttribute("membersList", membersList); //조회한 회원 정보를 request에 바인딩합니다.
		nextPage = "/test02/listMembers.jsp"; //test02 폴더의 listMembers.jsp로 포워딩합니다.
	} else if (action.equals("/addMember.do")) { // action 값이 /addMember.do면 전송된 회원 정보를 가져와서 테이블에 추가합니다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberVO memberVO = new MemberVO(id, pwd, name, email);
		memberDAO.addMember(memberVO);
		nextPage = "/member/listMembers.do"; //회원 등록 후 다시 회원 목록을 출력합니다.
	} else if(action.equals("/memberForm.do")) {
	  nextPage ="/test02/memberForm.jsp";
	} else {
	  List<MemberVO> membersList = memberDAO.listMembers(); 
	  request.setAttribute("membersList", membersList);
	  nextPage = "/test02/listMembers.jsp";
	}
	
	RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); // nextPage에 지정한 요청명으로 다시 서블릿에 요청합니다.
	dispatch.forward(request, response); // 컨트롤러에서 표시하고자 하는 JSP로 포워딩합니다.
	 
		
	}

}
