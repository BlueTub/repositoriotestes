package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	static EmpresaDAO empresaDAO = new EmpresaDAO();
	static Empresa empresa = new Empresa();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Empresa 1");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("Empr 1");
		empresa.setEndereco("Rua da Empresa 1, SP");
		empresa.setTelefone("2722-4595");
		
	}
	
	@Test
	public void CT01UC02ConsultaEmpresa_com_Sucesso(){
		empresaDAO.adiciona(empresa);
		assertTrue(empresa.equals(empresaDAO.consultaEmpresas("89424232000180")));
	}
	
	@Test
	public void test(){
		//empresaDAO.adiciona(empresa);
		//assertTrue(empresa.equals(empresaDAO.consultaEmpresas("89424232000180")));
		//empresaDAO.exclui("89424232000180");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
		
	}

	

}
