package br.edu.flf.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.flf.dao.DaoCd;
import br.edu.flf.entidades.Cd;
import br.edu.flf.negocio.NegocioCd;

@WebServlet("/ServletCd")
public class ServletCd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCd() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cd cd = new Cd();
		DaoCd daoCd = (DaoCd) request.getServletContext().getAttribute(
				"daoCd");
		NegocioCd negocioCd = new NegocioCd(daoCd);
		request.setAttribute("cds", negocioCd.listarTodos());
		
		String paramLink = request.getParameter("paramLink");
		if (paramLink != null) {
			switch (paramLink) {
			case "add_Cd.jsp":
				request.getRequestDispatcher("add_Cd.jsp").forward(request,
						response);
			case "listar_Cds.jsp":
				request.getRequestDispatcher("listar_Cds.jsp").forward(request,
						response);
			}
		} else {
			String operacao = request.getParameter("operacao");
			if (operacao != null) {
				
				
				if ("Editar".equals(operacao)) {
					cd.setTitulo(request.getParameter("nomeProduto"));
					cd = negocioCd.buscar(cd);
					request.setAttribute("cd", cd);
					request.getRequestDispatcher("editar_Cd.jsp").forward(
							request, response);
				} 
				
				
				else if ("Alterar".equals(operacao)) {
					cd.setTitulo(request.getParameter("nomeProduto"));
					cd = negocioCd.buscar(cd);
					Cd cdAlterado = new Cd();
					cdAlterado.setTitulo(request.getParameter("titulo"));
					cdAlterado.setPreco(Double.parseDouble(request.getParameter("preco")));
					cdAlterado.setData_de_publicacao(request.getParameter("dataLancamento"));
					cdAlterado.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
					cdAlterado.setQuantidade_faixas(Integer.parseInt(request.getParameter("faixas")));
					if (request.getParameter("duplo") != null) {
						cdAlterado.setDuplo(true);
					} else {
						cdAlterado.setDuplo(false);
					}
					negocioCd.alterar(cd, cdAlterado);
					request.getRequestDispatcher("listar_Cds.jsp").forward(
							request, response);
				} 
				
				
				
				else if ("Apagar".equals(operacao)) {
					cd.setTitulo(request.getParameter("nomeProduto"));
					cd = negocioCd.buscar(cd);
					negocioCd.apagar(cd);
					request.getRequestDispatcher("listar_Cds.jsp").forward(
							request, response);
				} 
				
				
				else if ("Adicionar".equals(operacao)) {
					cd.setTitulo(request.getParameter("titulo"));
					cd.setPreco(Double.parseDouble(request
							.getParameter("preco")));
					cd.setData_de_publicacao(request
							.getParameter("dataLancamento"));
					cd.setQuantidade(Integer.parseInt(request
							.getParameter("quantidade")));
					cd.setQuantidade_faixas(Integer.parseInt(request
							.getParameter("faixas")));
					if (request.getParameter("duplo") != null) {
						cd.setDuplo(true);
					} else {
						cd.setDuplo(false);
					}
					negocioCd.salvar(cd);
					request.getServletContext().setAttribute("daoCd", daoCd);
					negocioCd = null;
					request.getRequestDispatcher("add_Cd.jsp").forward(request,
							response);
				}
			}
		}
	}
}
