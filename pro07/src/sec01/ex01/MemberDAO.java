package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "whdytpq4";
	private static final String pwd = "1234";
	
	private Statement stmt;
	private Connection con;

	public List<MemberVO> listMembers() throws ClassNotFoundException, SQLException {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		connDB();
		String query = "select * from t_member ";
		System.out.println(query);
		ResultSet rs =stmt.executeQuery(query);
		
		while (rs.next()) {
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate =rs.getDate("joinDate");
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			vo.setJoinDate(joinDate);
			list.add(vo);
		}
		rs.close();
		stmt.close();
		con.close();
		
		return list;
	}

	private void connDB() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		System.out.println("Oracle 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, pwd);
		System.out.println("Connection 생성 성공");
		stmt = con.createStatement();
		System.out.println("Statement 생성 성공");
		
	}
}
