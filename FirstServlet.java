import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<title>My first servlet!</title>"
				+ "<style>.bold_cls{font-weight:bold;}</style>"
				+ "</head>"
				+ "<body>");
		
		List<User> users = new ArrayList<User>();
		users.add(new User("Иванов Иван", "ivanov@gmail.com"));
		users.add(new User("Петров Иван", "petrov@gmail.com"));
		users.add(new User("Сидоров Иван", "sidorov@gmail.com"));
		users.add(new User("Лукашенко Иван", "luka@gmail.com"));
		users.add(new User("Путин Иван", "put-in@gmail.com"));
		users.add(new User("Медведев Иван", "medved@gmail.com"));
		users.add(new User("Обама Иван", "monkey@gmail.com"));
		
		String cls = "";
		String curStringDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date()); 

		out.println("<h1>Список пользователей на "+curStringDate+": </h1>");
		out.println("<ol>");
		
		for (int i = 0; i < users.size(); i++) 
		{
			if (i>=4) cls = "bold_cls";
			out.println("<li class='"+cls+"'>");
			if (i>=2) 
			{
				out.println("<a href=\"mailto:"+users.get(i).email+"\"> "+users.get(i).email+"</a>"+"("+users.get(i).username+")");
				if (i==3) out.println("<br/>Половина!");
			}
			else
				out.println(users.get(i).username+" (<a href=\"mailto:"+users.get(i).email+"\">"+users.get(i).email+"</a>)");

			out.println("</li>");
		}
		out.println("</ol>");
        out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}


class User
{
	String username, email = "";
	public User(String username, String email)
	{
		this.username = username;
		this.email = email;
	}
}