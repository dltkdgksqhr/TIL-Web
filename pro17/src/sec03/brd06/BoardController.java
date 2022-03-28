package sec03.brd06;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image"; // 글에 첨부한 이미지 저장 위치를 상수로 선언합니다.
	BoardService boardService;
	ArticleVO articleVO;
	
	public void init() {
		boardService = new BoardService(); // BoardService 객체 생성
		articleVO = new ArticleVO();
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
	
	
	try {
		List<ArticleVO> articlesList = new ArrayList<>();
		if(action==null) {
			articlesList = boardService.listArticles();
			request.setAttribute("articlesList", articlesList);
			nextPage = "/board05/listArticles.jsp";
		} else if(action.equals("/listArticles.do")) {  // action 값이 /listArticles.do면 전체 글을 조회합니다.
	        articlesList = boardService.listArticles();  // 전체 글을 조회합니다.
	        request.setAttribute("articlesList", articlesList);  //조회된 글 목록을 articlesList로 바인딩 한 후 listArticles.jsp로 포워딩합니다.
	        nextPage = "/board05/listArticles.jsp";
		} else if (action.equals("/articleForm.do")) { // action 값 /articleForm.do로 요청 시 글쓰기창이 나타납니다.
			nextPage = "/board05/articleForm.jsp";
		} else if (action.equals("/addArticle.do")) { // /addAticle.do로 요청 시 새글 추가 작업을 수행합니다.
		  int articleNO=0;
		  Map<String, String> articleMap;
		  articleMap = upload(request, response); // 파일 업로드 기능을 사용하기 위해 upload()로 요청을 전달합니다.
		  String title = articleMap.get("title");
		  String content = articleMap.get("content");
		  String imageFileName = articleMap.get("imageFileName"); // articleMap에 저장된 글 정보를 다시 가져옵니다.
		  
		  articleVO.setParentNO(0);  // 새 글의 부모 글 번호를 0으로 설정합니다.
		  articleVO.setId("hong"); // 새 글 작성자 ID를 hong으로 설정합니다.
		  articleVO.setTitle(title);
		  articleVO.setContent(content);
		  articleVO.setImageFileName(imageFileName);
		  articleNO = boardService.addArticle(articleVO); // 테이블에 새 글을 추가한 후 새글에 대한 글 번호를 가져옵니다.
		  
		  PrintWriter pw =response.getWriter();
		  pw.print("<script>"
				  +" alert('새글을 추가했습니다.');"
		          +" location.href='"+request.getContextPath()+"/board/listArticles.do';"
		          +"</script>"); // 새 글 등록 메시지를 나타낸 후 자바스크립트 location 객체의 href속성을 이용해 글 목록을 요청합니다.
		  boardService.addArticle(articleVO); // 글쓰기창에서 입력된 정보를 article VO 객체에 설정한 후 addArticle()로 전달합니다.
		  nextPage = "/board05/listArticles.do";
		} else if (action.equals("/viewArticle.do")) {
		  String articleNO = request.getParameter("articleNO"); // 글 상세창을 요청할 경우 articleNO값을 가져옵니다.
		  articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
		  request.setAttribute("article",articleVO); //articleNO에 대한 글 정보를 조회하고 article 속성으로 바인딩합니다.
		  nextPage = "/board05/viewArticle.jsp";
		} else if (action.equals("/modArticle.do")) {
		Map<String, String> articleMap = upload(request, response);
		int articleNO = Integer.parseInt(articleMap.get("articleNO"));
		articleVO.setArticleNO(articleNO);
		String title = articleMap.get("title");
		String content = articleMap.get("content");
		String imageFileName = articleMap.get("imageFileName");
		articleVO.setParentNO(0);
		articleVO.setId("hong");
		articleVO.setTitle(title);
		articleVO.setContent(content);
		articleVO.setImageFileName(imageFileName);
		boardService.modArticle(articleVO); //전송된 글 정보를 이용해 글을 수정합니다.
		
		if (imageFileName != null && imageFileName.length() !=0) {
		  String originalFileName = articleMap.get("originalFileName");
		  Path srcFile = Paths.get(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
		  Path destDir = Paths.get(ARTICLE_IMAGE_REPO + "\\" + articleNO);
		  File destDir2 = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
		  destDir2.mkdirs();
		  Files.move(srcFile, destDir, StandardCopyOption.REPLACE_EXISTING); // 수정된 이미지 파일을 폴더로 이동합니다.
		  File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + originalFileName);
		  oldFile.delete(); // 전송된 originalmageFileName을 이용해 기존의 파일을 삭제합니다.
		}
		PrintWriter pw =response.getWriter();
		pw.print("<script>" + " alert('글을 수정했습니다.');" + " location.href='" + request.getContextPath() +
				"/board/viewArticle.do?articleNO=" + articleNO + "';" + "</script>"); // 글 수정 후 location 객체의 href속성을 이용해 글 상세 화면을 나타냅니다.
		return;
			} else if (action.equals("/removeArticle.do")) {
			int articleNO = Integer.parseInt(request.getParameter("articleNO"));
			List<Integer> articleNOList = boardService.removeArticle(articleNO); // articleNO 값에 대한 글을 삭제한 후 삭제된 부모 글과 자식 글의 articleNO 목록을 가져옵니다.
			for (int _articleNO : articleNOList) {
			  File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _articleNO);
			  if (imgDir.exists()) {
				  FileUtils.deleteDirectory(imgDir);
			  }
			}  // 삭제된 글들의 이미지 저장 폴더들을 삭제합니다.
			PrintWriter pw = response.getWriter();
			pw.print("<script>" + " alert('글을 삭제했습니다.');" + " location.href='"
			        + request.getContextPath() + "/board/listArticles.do';"
			        + "</script>");
			return;
				}else {		
		  nextPage = "/board05/listArticles.jsp";
	   }
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	} catch (Exception e) {
		
		e.printStackTrace();
	} 	
}


private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map<String, String> articleMap = new HashMap<String, String>();
    String encoding = "utf-8";
    File currentDirPath = new File(ARTICLE_IMAGE_REPO);  // 글 이미지 저장 폴더에 대해 파일 객체를 생성합니다.
    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setRepository(currentDirPath);  
    factory.setSizeThreshold(1024 * 1024);  //메모리에 저장할 수 있는 최대 크기
    ServletFileUpload upload = new ServletFileUpload(factory);
    
    List items;
	try {
		items = upload.parseRequest(new ServletRequestContext(request));
		for(int i=0; i < items.size(); i++) {
	    	  FileItem fileItem = (FileItem) items.get(i);
	    	  if(fileItem.isFormField()) {
	    		System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
	    		articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding)); // 파일 업로드로 같이 전송된 새 글 관련 매개변수를 Map에 (key, value)로 저장한 후 반환하고, 새글과 관련된 title, content를 Map에 저장합니다.
	    	  } else {
	    		System.out.println("파라미터명 : " + fileItem.getFieldName());
	    		System.out.println("파일크기:" + fileItem.getSize() + "bytes");
	    		if(fileItem.getSize() > 0) {
	    		  int idx = fileItem.getName().lastIndexOf("\\");
	    		    if(idx == -1) {
	    		    	idx = fileItem.getName().lastIndexOf("/");
	    		    }
	    		  
	    		  String fileName = fileItem.getName().substring(idx + 1);
	    		  System.out.println("파일명 : " + fileName);
	    		  articleMap.put(fileItem.getFieldName(), fileName);  // 업로드된 파일의 이름을 Map에 ("imageFileName","업로드 파일이름")로 저장합니다.
	    		  File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
	    		  fileItem.write(uploadFile);
	    		} //end if
	    	  }// end if
	      } // end for
	} catch (FileUploadException e) {
		
		e.printStackTrace();
	}
      
	return articleMap;
    }
}