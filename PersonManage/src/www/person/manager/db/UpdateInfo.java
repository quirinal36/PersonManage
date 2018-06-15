package www.person.manager.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import www.person.manager.Person;

/**
 * Servlet implementation class UpdateInfo
 */
@WebServlet("/update")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String numParam = request.getParameter("num");
		String nameParam = request.getParameter("name");
		String birthParam = request.getParameter("birth");
		String addressParam = request.getParameter("address");
		String postParam = request.getParameter("postcode");
		String phoneParam = request.getParameter("phone");
		
		Person person = new Person();
		person.setNo(Integer.parseInt(numParam));
		person.setName(nameParam);
		person.setBirth(birthParam);
		person.setAddress(addressParam);
		person.setPostCode(postParam);
		person.setPhone(phoneParam);
		
		DButil dbUtil = new DButil();
		int result = dbUtil.updatePerson(person);
		
		if(result > 0) {
			response.sendRedirect("./index.jsp");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("수정에 실패했습니다.");
		}
	}

}
