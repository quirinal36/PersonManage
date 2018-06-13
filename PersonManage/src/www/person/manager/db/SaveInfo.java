package www.person.manager.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.person.manager.Person;

/**
 * Servlet implementation class SaveInfo
 */
@WebServlet("/save")
public class SaveInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name 	= request.getParameter("name");
		String birth 	= request.getParameter("birth");
		String num		= request.getParameter("num");
		Person person = new Person();
		person.setName(name);
		person.setBirth(birth);
		person.setNo(Integer.parseInt(num));
		
		DButil util = new DButil();
		int result = util.insertPerson(person);
		
		if(result > 0) {
			response.sendRedirect("./index.jsp");
		}else {
			response.getWriter().append("입력에 실패했습니다.");
		}
	}

}
