package www.person.manager.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class DeleteInfo
 */
@WebServlet("/delete")
public class DeleteInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String numParam = request.getParameter("num");
		int num = Integer.parseInt(numParam);
		
		DButil dbUtil = new DButil();
		int result = dbUtil.deleteByNum(num);
		JSONObject json = new JSONObject();
		json.put("result", result);
		response.getWriter().append(json.toJSONString());
	}

}
