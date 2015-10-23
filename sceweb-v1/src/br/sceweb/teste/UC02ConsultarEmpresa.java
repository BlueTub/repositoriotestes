package br.sceweb.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	static EmpresaDAO empresaDAO = new EmpresaDAO();
	static Empresa empresa = new Empresa();
	private static Empresa  empresa2;
	public List<Empresa> lista;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Empresa 1");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("Empr 1");
		empresa.setEndereco("Rua da Empresa 1, SP");
		empresa.setTelefone("2722-4595");
		
	    empresa2 = new Empresa();
		empresa2.setNomeDaEmpresa("Empresa 2");
		empresa2.setCnpj("66132972000148");
		empresa2.setNomeFantasia("Empr 2");
		empresa2.setEndereco("Rua da Empresa 2, SP");
		empresa2.setTelefone("2722-4522");
		
	}
	
	@Test
	public void CT01UC02CT1ConsultaEmpresa_com_Sucesso(){
		empresaDAO.adiciona(empresa);
		assertTrue(empresa.equals(empresaDAO.consultaEmpresas("89424232000180")));
		empresaDAO.exclui("89424232000180");
	}
	
	@Test
	public void CT01UC02CT1ConsultaEmpresa_sem_Sucesso(){
		empresaDAO.adiciona(empresa);
		assertFalse(empresa.equals(empresaDAO.consultaEmpresas()));
		empresaDAO.exclui("89424232000180");
	}
	
	@Test
	public void CT01UC02CT2ConsultaEmpresa_com_Sucesso(){
		empresaDAO.adiciona(empresa);
		empresaDAO.adiciona(empresa2);
		assertEquals(2,empresaDAO.consultaEmpresas().size());
		empresaDAO.exclui("89424232000180");
		empresaDAO.exclui("66132972000148");
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
		empresaDAO.exclui("66132972000148");
		
	}

	

}
