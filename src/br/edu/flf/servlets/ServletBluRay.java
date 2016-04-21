package br.edu.flf.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.flf.dao.DaoBluRay;
import br.edu.flf.entidades.BluRay;
import br.edu.flf.entidades.Tema;
import br.edu.flf.negocio.NegocioBluRay;

@WebServlet("/ServletBluRay")
public class ServletBluRay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletBluRay() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BluRay bluRay = new BluRay();
		DaoBluRay daoBluRay = (DaoBluRay) request.getServletContext()
				.getAttribute("daoBluRay");
		NegocioBluRay negocioBluRay = new NegocioBluRay(daoBluRay);
		request.setAttribute("bluRays", negocioBluRay.listarTodos());
		String paramLink = request.getParameter("paramLink");
		if (paramLink != null) {
			switch (paramLink) {
			case "add_BluRay.jsp":
				request.getRequestDispatcher("add_BluRay.jsp").forward(request,
						response);
			case "listar_BluRays.jsp":
				request.getRequestDispatcher("listar_BluRays.jsp").forward(
						request, response);
			}
		} else {
			String operacao = request.getParameter("operacao");
			if (operacao != null) {
				if ("Editar".equals(operacao)) {
					bluRay.setTitulo(request.getParameter("nomeProduto"));
					bluRay = negocioBluRay.buscar(bluRay);
					request.setAttribute("bluRay", bluRay);
					request.getRequestDispatcher("editar_BluRay.jsp").forward(
							request, response);
				} 
				
				
				else if ("Alterar".equals(operacao)) {
					bluRay.setTitulo(request.getParameter("nomeProduto"));
					bluRay = negocioBluRay.buscar(bluRay);
					BluRay bluRayAlterado = new BluRay();
					bluRayAlterado.setTitulo(request.getParameter("titulo"));
					bluRayAlterado.setPreco(Double.parseDouble(request.getParameter("preco")));
					bluRayAlterado.setData_de_publicacao(request.getParameter("dataLancamento"));
					bluRayAlterado.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
					bluRayAlterado.setTema(Tema.valueOf(request.getParameter("tema")));
					
					if (request.getParameter("duplo") != null) {
						bluRayAlterado.setDuplo(true);
					} else {
						bluRayAlterado.setDuplo(false);
					}
					
					negocioBluRay.alterar(bluRay, bluRayAlterado);
					request.getRequestDispatcher("listar_BluRays.jsp").forward(request, response);
				} 
				
				
				
				
				else if ("Apagar".equals(operacao)) {
					bluRay.setTitulo(request.getParameter("nomeProduto"));
					bluRay = negocioBluRay.buscar(bluRay);
					negocioBluRay.apagar(bluRay);
					request.getRequestDispatcher("listar_BluRays.jsp").forward(
							request, response);

				} else if ("Adicionar".equals(operacao)) {
					bluRay.setTitulo(request.getParameter("titulo"));
					bluRay.setPreco(Double.parseDouble(request
							.getParameter("preco")));
					bluRay.setData_de_publicacao(request
							.getParameter("dataLancamento"));
					bluRay.setQuantidade(Integer.parseInt(request
							.getParameter("quantidade")));
					bluRay.setTema(Tema.valueOf(request.getParameter("tema")));
					if (request.getParameter("duplo") != null) {
						bluRay.setDuplo(true);
					} else {
						bluRay.setDuplo(false);
					}
					negocioBluRay.salvar(bluRay);
					request.getServletContext().setAttribute("daoBluRay",
							daoBluRay);
					negocioBluRay = null;
					request.getRequestDispatcher("add_BluRay.jsp").forward(
							request, response);
				}
			}
		}
	}
}
