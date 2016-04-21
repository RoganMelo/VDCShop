package br.edu.flf.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.edu.flf.dao.DaoBluRay;
import br.edu.flf.dao.DaoCd;
import br.edu.flf.dao.DaoLivro;
import br.edu.flf.dao.DaoPedido;
import br.edu.flf.entidades.BluRay;
import br.edu.flf.entidades.Cd;
import br.edu.flf.entidades.Cliente;
import br.edu.flf.entidades.Livro;
import br.edu.flf.entidades.Pedido;
import br.edu.flf.entidades.Produto;
import br.edu.flf.negocio.NegocioBluRay;
import br.edu.flf.negocio.NegocioCd;
import br.edu.flf.negocio.NegocioLivro;
import br.edu.flf.negocio.NegocioPedido;

@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletPedido() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		
		ArrayList<Produto> produtos = (ArrayList<Produto>) request.getServletContext().getAttribute("produtos");
		ArrayList<Produto> produtosTemp = new ArrayList<Produto>();
		
		DaoPedido daoPedido = (DaoPedido) request.getServletContext()
				.getAttribute("daoPedido");
		
		NegocioPedido negocioPedido = new NegocioPedido(daoPedido);
		request.setAttribute("pedidos", negocioPedido.listarTodos());
		
		
		//criando instancias dos produtos
		Livro livro = new Livro();
		DaoLivro daoLivro = (DaoLivro) request.getServletContext()
				.getAttribute("daoLivro");
		NegocioLivro negocioLivro = new NegocioLivro(daoLivro);
		request.setAttribute("livros", negocioLivro.listarTodos());
		
		BluRay bluRay = new BluRay();
		DaoBluRay daoBluRay = (DaoBluRay) request.getServletContext()
				.getAttribute("daoBluRay");
		NegocioBluRay negocioBluRay = new NegocioBluRay(daoBluRay);
		request.setAttribute("bluRays", negocioBluRay.listarTodos());
		
		Cd cd = new Cd();
		DaoCd daoCd = (DaoCd) request.getServletContext().getAttribute("daoCd");
		NegocioCd negocioCd = new NegocioCd(daoCd);
		request.setAttribute("cds", negocioCd.listarTodos());
		//fim das instanciação dos produtos
		
		
		
		String paramLink = request.getParameter("paramLink");
		System.out.println(paramLink);
		if (paramLink != null) {
			switch (paramLink) {
			case"index":
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
				
			case"listar_Pedidos.jsp":
				request.getRequestDispatcher("listar_Pedidos.jsp").forward(
						request, response);
				
			case"AddCarrinho":
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			case "Sair":
				HttpSession session = request.getSession();
				session.invalidate();
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
		} 
		
		
		
		else {
			String operacao = request.getParameter("operacao");
			String operacao2 = (String) request.getAttribute("operacao2");
			if ("CarrinhoLivro".equals(operacao)) {
				livro.setTitulo(request.getParameter("nomeProduto"));
				livro = negocioLivro.buscar(livro);
				
				//criando um livro temporário e mandando ele receber os atributos pra não dar erro
				Livro livro2 = new Livro();
				livro2.setData_de_publicacao(livro.getData_de_publicacao());
				livro2.setEdicao(livro.getEdicao());
				livro2.setISBN(livro.getISBN());
				livro2.setPreco(livro.getPreco());
				livro2.setQuantidade(livro.getQuantidade());
				livro2.setTitulo(livro.getTitulo());
				livro2.setTema(livro.getTema());
				System.out.println(livro2.getTitulo());
				//fim da cópia do livro temporário
				
				produtos = negocioPedido.adcCarrinho(produtos, livro2);
				request.getServletContext().setAttribute("produtos", produtos);
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
			
			
			
			else if ("CarrinhoCd".equals(operacao)) {
					cd.setTitulo(request.getParameter("nomeProduto"));
					cd = negocioCd.buscar(cd);
					
					Cd cd2 = new Cd();
					cd2.setData_de_publicacao(cd.getData_de_publicacao());
					cd2.setDuplo(cd.isDuplo());
					cd2.setPreco(cd.getPreco());
					cd2.setQuantidade(cd.getQuantidade());
					cd2.setQuantidade_faixas(cd.getQuantidade_faixas());
					cd2.setTitulo(cd.getTitulo());
					System.out.println(cd2.getTitulo());
					
					
					
					produtos = negocioPedido.adcCarrinho(produtos, cd2);
					request.getServletContext().setAttribute("produtos", produtos);
					request.getRequestDispatcher("index.jsp").forward(request,
							response);
			}
			
			
			
			else if ("CarrinhoBluRay".equals(operacao)) {
				bluRay.setTitulo(request.getParameter("nomeProduto"));
				bluRay = negocioBluRay.buscar(bluRay);
				
				BluRay bluRay2 = new BluRay();
				bluRay2.setData_de_publicacao(bluRay.getData_de_publicacao());
				bluRay2.setDuplo(bluRay.isDuplo());
				bluRay2.setPreco(bluRay.getPreco());
				bluRay2.setQuantidade(bluRay.getQuantidade());
				bluRay2.setTema(bluRay.getTema());
				bluRay2.setTitulo(bluRay.getTitulo());
				System.out.println(bluRay2.getTitulo());
				
				produtos = negocioPedido.adcCarrinho(produtos, bluRay2);
				request.getServletContext().setAttribute("produtos", produtos);
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
			
			
			
			
			else if ("Apagar".equals(operacao)) {
				pedido.setId(Integer.parseInt(request.getParameter("nomeProduto")));
				System.out.println("id = " + pedido.getId());
				pedido = negocioPedido.buscar(pedido);
				System.out.println("nome do cliente = " + pedido.getCliente().getNome());
				negocioPedido.devolveAoEstoque(pedido.getProdutos(), daoBluRay, daoCd, daoLivro);
				request.getServletContext().setAttribute("daoLivro",daoLivro);
				request.getServletContext().setAttribute("daoCd",daoCd);
				request.getServletContext().setAttribute("daoBluRay",daoBluRay);
				negocioPedido.apagar(pedido);
				request.getServletContext().setAttribute("daoPedido",daoPedido);
				request.getRequestDispatcher("listar_Pedidos.jsp").forward(
						request, response);
			}
			
			
			
			
			
			
			else if ("ConcluirPedido".equals(operacao) || "ConcluirPedido".equals(operacao2)) {
				pedido.setProdutos(produtos);
				request.setAttribute("produtos", pedido.getProdutos());
				request.setAttribute("pedido", pedido);
				request.getRequestDispatcher("realizar_Compra.jsp").forward(
						request, response);
			}
			
			
			else if ("Cancelar".equals(operacao)) {
				produtos.clear();
				//produtosTemp.clear();
				pedido.setProdutos(produtos);
				request.getServletContext().setAttribute("produtos", produtos);
				request.setAttribute("pedido", pedido);
				request.getRequestDispatcher("index.jsp").forward(
						request, response);
			}
			
			
			
			else if ("Concluir".equals(operacao)){
				pedido.setCliente((Cliente) request.getSession().getAttribute("usuariologado"));
				
				if(produtos != null){
					for (int i = 0; i < produtos.size(); i++) {
						produtosTemp.add(produtos.get(i));
					}
				}
				
				pedido.setProdutos(produtosTemp);
				
				request.setAttribute("produtos", pedido.getProdutos());
				request.setAttribute("pedido", pedido);
				
				
				negocioPedido.tiraDoEstoque(pedido.getProdutos(), daoBluRay, daoCd, daoLivro);
				request.getServletContext().setAttribute("daoLivro",daoLivro);
				request.getServletContext().setAttribute("daoCd",daoCd);
				request.getServletContext().setAttribute("daoBluRay",daoBluRay);
				negocioPedido.salvar(pedido);
				request.getServletContext().setAttribute("daoPedido",daoPedido);
								
				produtos.clear();
				request.getServletContext().setAttribute("produtos", produtos);
				
				request.getRequestDispatcher("nota_Fiscal.jsp").forward(
						request, response);
				
			}
			
			else if (paramLink == null && operacao == null && operacao2 == null){
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
			
		}
	}



	
	
	//////////
}
