package controller;

import java.io.IOException;
import java.sql.SQLException;


import dao.TiendaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modelo.Tienda;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/TiendaServlet")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TiendaDao tiendaDao;
    public TiendaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.tiendaDao = new TiendaDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch(action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarTienda(request, response);
				break;
			default:
			
			
				break;
		}	
	} catch (SQLException e) {
		throw new ServletException(e);
	}
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("tienda.jsp");
		dispatcher.forward(request, response);
	}
	
	public void insertarTienda(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		
		String nombre= request.getParameter("nombre");
		String email= request.getParameter("lema");
		String telefono= request.getParameter("telefono");
		
		Tienda tienda= new Tienda(nombre, email, telefono);
		
		tiendaDao.insert(tienda);
		response.sendRedirect("index.jsp");
		
	}
}
