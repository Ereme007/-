package default_p;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LibWeb.my_base_class;

/**
 * Servlet implementation class My_servlet
 */
@WebServlet("/My_servlet")
public class My_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 my_base_class MBC = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public My_servlet() {
        super();
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("ok1");
		} catch (ClassNotFoundException e1) {
			System.out.println("Bad1");
			System.out.println(e1);
		}
        MBC = new my_base_class();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//ResultSet RS_one =  null;
		//ResultSet User_next = null;
		ResultSet Book_next = null;
	//	ResultSet Book_aut = null;
		
		
		
		
		String act = request.getParameter("act");
		
		if (act == null) {
			System.out.println("act_bad");
		}else if( act.equals("Reader_BD")) {		
				getServletContext().getRequestDispatcher("/BD_Reader.jsp").forward(request, response);
				return;
			
		}else if(act.equals("Book_BD")) {		
				
				getServletContext().getRequestDispatcher("/BD_Book.jsp").forward(request, response);
				return; 

		}else if( act.equals("Return")) {		
			getServletContext().getRequestDispatcher("/1.jsp").forward(request, response);
			return; 
		}else if( act.equals("Add")) {		
			getServletContext().getRequestDispatcher("/Reader_Add.html").forward(request, response);
			return;
		}else if( act.equals("Book_Add")) {	
			
				getServletContext().getRequestDispatcher("/Book_Add.html").forward(request, response);
			return;
		}else if( act.equals("Order_Add")) {		
			
			
			getServletContext().getRequestDispatcher("/Order_Add.html").forward(request, response);
			return; 
		}else{
			System.out.println("Nope");
			}

	
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
