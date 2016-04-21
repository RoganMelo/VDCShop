package br.edu.flf.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.flf.dao.DaoLivro;
import br.edu.flf.entidades.Livro;
import br.edu.flf.entidades.Tema;
import br.edu.flf.negocio.NegocioLivro;

@WebServlet("/ServletLivro")
public class ServletLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLivro() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Livro livro = new Livro();
		DaoLivro daoLivro = (DaoLivro) request.getServletContext()
				.getAttribute("daoLivro");
		NegocioLivro negocioLivro = new NegocioLivro(daoLivro);
		request.setAttribute("livros", negocioLivro.listarTodos());
		String paramLink = request.getParameter("paramLink");
		if (paramLink != null) {
			switch (paramLink) {
			case "add_Livro.jsp":
				request.getRequestDispatcher("add_Livro.jsp").forward(request,
						response);
			case "listar_Livros.jsp":
				request.getRequestDispatcher("listar_Livros.jsp").forward(
						request, response);
			}
		} else {
			String operacao = request.getParameter("operacao");
			if (operacao != null) {
				if ("Editar".equals(operacao)) {
					livro.setTitulo(request.getParameter("nomeProduto"));
					livro = negocioLivro.buscar(livro);
					request.setAttribute("livro", livro);
					request.getRequestDispatcher("editar_Livro.jsp").forward(
							request, response);
				} else if ("Alterar".equals(operacao)) {
					livro.setTitulo(request.getParameter("nomeProduto"));
					livro = negocioLivro.buscar(livro);
					Livro livroAlterado = new Livro();
					livroAlterado.setTitulo(request.getParameter("titulo"));
					livroAlterado.setPreco(Double.parseDouble(request
							.getParameter("preco")));
					livroAlterado.setData_de_publicacao(request
							.getParameter("dataLancamento"));
					livroAlterado.setEdicao(request.getParameter("edicao"));
					livroAlterado.setTema(Tema.valueOf(request.getParameter("tema")));
					livroAlterado.setISBN(Integer.parseInt(request.getParameter("ISBN")));
					livroAlterado.setQuantidade(Integer.parseInt(request
							.getParameter("quantidade")));
					negocioLivro.alterar(livro, livroAlterado);
					request.getRequestDispatcher("listar_Livros.jsp").forward(
							request, response);
				} else if ("Apagar".equals(operacao)) {
					livro.setTitulo(request.getParameter("nomeProduto"));
					livro = negocioLivro.buscar(livro);
					negocioLivro.apagar(livro);
					request.getRequestDispatcher("listar_Livros.jsp").forward(
							request, response);
				} 
				
				else if ("Adicionar".equals(operacao)) {
					livro.setTitulo(request.getParameter("titulo"));
					livro.setPreco(Double.parseDouble(request
							.getParameter("preco")));
					livro.setData_de_publicacao(request
							.getParameter("dataLancamento"));
					livro.setEdicao(request.getParameter("edicao"));
					livro.setTema(Tema.valueOf(request.getParameter("tema")));
					livro.setISBN(Integer.parseInt(request.getParameter("ISBN")));
					livro.setQuantidade(Integer.parseInt(request
							.getParameter("quantidade")));
					negocioLivro.salvar(livro);
					request.getServletContext().setAttribute("daoLivro",
							daoLivro);
					negocioLivro = null;
					request.getRequestDispatcher("add_Livro.jsp").forward(
							request, response);
				}
			}
		}
	}
}
