package br.edu.flf.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.flf.dao.DaoCliente;
import br.edu.flf.entidades.Cliente;
import br.edu.flf.entidades.Produto;
import br.edu.flf.negocio.NegocioCliente;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logout = request.getParameter("logout");
		Cliente cliente = new Cliente();
		DaoCliente daoCliente = (DaoCliente) request.getServletContext()
				.getAttribute("daoCliente");
		
		ArrayList<Produto> produtos = (ArrayList<Produto>) request.getServletContext().getAttribute("produtos");
		
		NegocioCliente negocioCliente = new NegocioCliente(daoCliente);
		HttpSession session =  request.getSession();
		if (logout != null) {
			session.invalidate();
			produtos.clear();
			request.getServletContext().setAttribute("produtos", produtos);
		} else {
			cliente.setNome(request.getParameter("nome"));
			cliente = negocioCliente.buscar(cliente);
			if(cliente != null){
				session.setAttribute("usuariologado", cliente);
			}else{
				request.getRequestDispatcher("tela_login.jsp").forward(request, response);
			}
		}
		request.setAttribute("operacao2", "ConcluirPedido");
		request.getRequestDispatcher("ServletPedido").forward(request, response);
	}
}
