package br.edu.flf.listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.flf.dao.DaoBluRay;
import br.edu.flf.dao.DaoCd;
import br.edu.flf.dao.DaoCliente;
import br.edu.flf.dao.DaoLivro;
import br.edu.flf.dao.DaoPedido;
import br.edu.flf.entidades.BluRay;
import br.edu.flf.entidades.Cd;
import br.edu.flf.entidades.Cliente;
import br.edu.flf.entidades.Livro;
import br.edu.flf.entidades.Produto;
import br.edu.flf.entidades.Tema;
import br.edu.flf.negocio.NegocioBluRay;
import br.edu.flf.negocio.NegocioCd;
import br.edu.flf.negocio.NegocioCliente;
import br.edu.flf.negocio.NegocioLivro;

@WebListener
public class Listener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent context) {
		
		BluRay bluRay = new BluRay();
		BluRay bluRay2 = new BluRay();
		BluRay bluRay3 = new BluRay();
		
		Livro livro = new Livro();
		Livro livro2 = new Livro();
		Livro livro3 = new Livro();
		
		Cliente cliente = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		Cd cd = new Cd();
		Cd cd2 = new Cd();
		Cd cd3 = new Cd();
		
		
		
		DaoBluRay daoBluRay = new DaoBluRay();
		DaoCd daoCd = new DaoCd();
		DaoCliente daoCliente = new DaoCliente();
		DaoLivro daoLivro = new DaoLivro();
		DaoPedido daoPedido = new DaoPedido();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		
		NegocioBluRay negocioBluRay = new NegocioBluRay(daoBluRay);
		NegocioLivro negocioLivro = new NegocioLivro(daoLivro);
		NegocioCd negocioCd = new NegocioCd(daoCd);
		NegocioCliente negocioCliente = new NegocioCliente(daoCliente);
		
		
		
		
		
		
		
		
		
		//esses são criados no inicio apenas para a listagem de blu-rays não aparecer vazia
		bluRay.setTitulo("bluray 1");
		bluRay.setPreco(12.90);
		bluRay.setData_de_publicacao("2015-02-12");
		bluRay.setQuantidade(4);
		bluRay.setTema(Tema.Acao);
		bluRay.setDuplo(true);
		negocioBluRay.salvar(bluRay);
		
		bluRay2.setTitulo("bluray 2");
		bluRay2.setPreco(12.70);
		bluRay2.setData_de_publicacao("2015-02-12");
		bluRay2.setQuantidade(0);
		bluRay2.setTema(Tema.Aventura);
		bluRay2.setDuplo(false);
		negocioBluRay.salvar(bluRay2);
		
		bluRay3.setTitulo("bluray 3");
		bluRay3.setPreco(30.90);
		bluRay3.setData_de_publicacao("2015-02-12");
		bluRay3.setQuantidade(2);
		bluRay3.setTema(Tema.Ficcao);
		bluRay3.setDuplo(true);
		negocioBluRay.salvar(bluRay3);
		//fim da criação de blu-rays de exemplo
		
		//criaçõa de livros de exemplo para aparecerem na hora que o projeto for iniciado
		livro.setTitulo("livro1");
		livro.setPreco(30.90);
		livro.setData_de_publicacao("2015-02-12");
		livro.setQuantidade(0);
		livro.setTema(Tema.Acao);
		livro.setEdicao("1");
		livro.setISBN(1234);
		negocioLivro.salvar(livro);
		
		
		livro2.setTitulo("livro2");
		livro2.setPreco(30.90);
		livro2.setData_de_publicacao("2015-02-12");
		livro2.setQuantidade(15);
		livro2.setTema(Tema.Aventura);
		livro2.setEdicao("3");
		livro2.setISBN(12346);
		negocioLivro.salvar(livro2);
		
		livro3.setTitulo("livro3");
		livro3.setPreco(30.90);
		livro3.setData_de_publicacao("2015-02-12");
		livro3.setQuantidade(5);
		livro3.setTema(Tema.Ficcao);
		livro3.setEdicao("2");
		livro3.setISBN(1234);
		negocioLivro.salvar(livro3);
		//fim da criação de livros pra teste
		
		//criaçõa de clientes de exemplo para aparecerem na hora que o projeto for iniciado
		cliente.setNome("cliente1");
		cliente.setCpf("123");
		cliente.setEndereco("Rua 1");
		negocioCliente.salvar(cliente);
		
		cliente2.setNome("cliente2");
		cliente2.setCpf("456");
		cliente2.setEndereco("Rua 2");
		negocioCliente.salvar(cliente2);
		
		cliente3.setNome("cliente3");
		cliente3.setCpf("789");
		cliente3.setEndereco("Rua 3");
		negocioCliente.salvar(cliente3);
		//fim da criação de clientes pra teste
		
		//criaçõa de cds de exemplo para aparecerem na hora que o projeto for iniciado
		cd.setTitulo("cd1");
		cd.setQuantidade_faixas(12);
		cd.setQuantidade(4);
		cd.setData_de_publicacao("2015-02-12");
		cd.setDuplo(false);
		cd.setPreco(22.90);
		negocioCd.salvar(cd);
		
		cd2.setTitulo("cd2");
		cd2.setQuantidade_faixas(12);
		cd2.setQuantidade(4);
		cd2.setData_de_publicacao("2015-02-12");
		cd2.setDuplo(false);
		cd2.setPreco(22.90);
		negocioCd.salvar(cd2);
		
		cd3.setTitulo("cd3");
		cd3.setQuantidade_faixas(12);
		cd3.setQuantidade(0);
		cd3.setData_de_publicacao("2015-02-12");
		cd3.setDuplo(true);
		cd3.setPreco(59.90);
		negocioCd.salvar(cd3);
		//fim da criação de cds pra teste
		
		
		
		context.getServletContext().setAttribute("daoBluRay", daoBluRay);
		context.getServletContext().setAttribute("daoCd", daoCd);
		context.getServletContext().setAttribute("daoCliente", daoCliente);
		context.getServletContext().setAttribute("daoLivro", daoLivro);
		context.getServletContext().setAttribute("daoPedido", daoPedido);
		context.getServletContext().setAttribute("produtos", produtos);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}
	
}
