package br.edu.flf.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.flf.entidades.Cliente;
import br.edu.flf.dao.DaoCliente;
import br.edu.flf.negocio.NegocioCliente;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public Cliente pegaDoForm(Cliente cli, HttpServletRequest request) {
		cli.setNome(request.getParameter("nome"));
		cli.setCpf(request.getParameter("CPF"));
		cli.setEndereco(request.getParameter("endereco"));
		return cli;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		DaoCliente daoCliente = (DaoCliente) request.getServletContext()
				.getAttribute("daoCliente");
		NegocioCliente negocioCliente = new NegocioCliente(daoCliente);
		request.setAttribute("clientes", negocioCliente.listarTodos());
		String paramLink = request.getParameter("paramLink");
		if (paramLink != null) {
			switch (paramLink) {
			case "add_Cliente.jsp":
				request.getRequestDispatcher("add_Cliente.jsp").forward(
						request, response);
			case "listar_Clientes.jsp":
				request.getRequestDispatcher("listar_Clientes.jsp").forward(
						request, response);
			}
		} else {
			String operacao = request.getParameter("operacao");
			HttpSession sessao = request.getSession();
			if (operacao != null) {
				if ("Editar".equals(operacao)) {
					cliente.setNome(request.getParameter("nomeProduto"));
					cliente = negocioCliente.buscar(cliente);
					request.setAttribute("cliente", cliente);
					request.getRequestDispatcher("editar_Cliente.jsp").forward(
							request, response);
				} 
				
				else if ("Alterar".equals(operacao)) {
					cliente.setNome(request.getParameter("nomeProduto"));
					cliente = negocioCliente.buscar(cliente);
					Cliente clienteAlterado = new Cliente();
					clienteAlterado = pegaDoForm(clienteAlterado, request);
					negocioCliente.alterar(cliente, clienteAlterado);
					request.getRequestDispatcher("listar_Clientes.jsp").forward(request, response);
				} 
				
				
				else if ("Apagar".equals(operacao)) {
					cliente.setNome(request.getParameter("nomeProduto"));
					cliente = negocioCliente.buscar(cliente);
					negocioCliente.apagar(cliente);
					request.getRequestDispatcher("listar_Clientes.jsp")
							.forward(request, response);
				} else if ("logar".equals(operacao)) {
					cliente.setNome(request.getParameter("nome"));
					if (negocioCliente.logar(cliente) != null) {
						sessao.setAttribute("clientelogado", cliente);
						request.setAttribute("cliente", cliente);
						request.getRequestDispatcher("realizar_Compra.jsp")
								.forward(request, response);
					}
				} else if ("Adicionar".equals(operacao)) {
					cliente = pegaDoForm(cliente, request);
					negocioCliente.salvar(cliente);
					request.getServletContext().setAttribute("daoCliente",
							daoCliente);
					negocioCliente = null;
					request.getRequestDispatcher("add_Cliente.jsp").forward(
							request, response);
				}
			}
		}
	}
}
