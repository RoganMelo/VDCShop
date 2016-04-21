package br.edu.flf.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*", dispatcherTypes = { DispatcherType.FORWARD,
		DispatcherType.REQUEST })
public class LoginFilter implements Filter {
	public LoginFilter() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hresp = (HttpServletResponse) response;
		HttpSession session = hreq.getSession();

		String paginaAtual = new String(hreq.getRequestURL());

		if (paginaAtual != null
				&& (!paginaAtual.endsWith("tela_login.jsp") && !paginaAtual
						.endsWith("logout.jsp"))
				&& !paginaAtual.endsWith("add_BluRay.jsp")
				&& !paginaAtual.endsWith("add_Cd.jsp")
				&& !paginaAtual.endsWith("add_Cliente.jsp")
				&& !paginaAtual.endsWith("add_Livro.jsp")
				&& !paginaAtual.endsWith("editar_BluRay.jsp")
				&& !paginaAtual.endsWith("editar_Cd.jsp")
				&& !paginaAtual.endsWith("editar_Cliente.jsp")
				&& !paginaAtual.endsWith("editar_Livro.jsp")
				&& !paginaAtual.endsWith("index.jsp")
				&& !paginaAtual.endsWith("listar_BluRays.jsp")
				&& !paginaAtual.endsWith("listar_Cds.jsp")
				&& !paginaAtual.endsWith("listar_Clientes.jsp")
				&& !paginaAtual.endsWith("listar_Livros.jsp")
				&& !paginaAtual.endsWith("listar_Pedidos.jsp")
				&& !paginaAtual.endsWith("ServletBluRay")
				&& !paginaAtual.endsWith("ServletCd")
				&& !paginaAtual.endsWith("ServletCliente")
				&& !paginaAtual.endsWith("ServletLivro")
				&& !paginaAtual.endsWith("ServletPedido")
				&& !paginaAtual.endsWith("ServletLogin")
				&& (paginaAtual.endsWith(".jsp"))) {

			if (session.getAttribute("usuariologado") == null) {

				hresp.sendRedirect("tela_login.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}

}
