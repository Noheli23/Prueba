package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ClienteDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteDao clienteDao;
	
    public ClienteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.clienteDao = new ClienteDao();
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
					insertarCliente(request, response);
					break;
				default:
					listCliente(request, response);
				
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente.jsp");
		dispatcher.forward(request, response);
	}
	public void insertarCliente(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		
		String nombre= request.getParameter("nombre");
		String email= request.getParameter("email");
		String clave= request.getParameter("clave");
		
		Cliente cliente= new Cliente(nombre, email, clave);
		
		clienteDao.insert(cliente);
		response.sendRedirect("index.jsp");
		
	}
	public void listCliente(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
				
		List <Cliente> listCliente = clienteDao.selectAll();
		request.setAttribute("listCliente", listCliente);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
