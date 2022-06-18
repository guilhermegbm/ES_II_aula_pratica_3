package com.esii.aulapratica3.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.esii.aulapratica3.entity.Empresa;
import com.esii.aulapratica3.repository.EmpresaRepository;
import com.esii.aulapratica3.service.EmpresaService;

@SpringBootTest
public class EmpresaServiceTest {

	@Autowired
	private EmpresaService empresaService;

	@MockBean
	private EmpresaRepository empresaRepository;

	/*@BeforeEach
	public void setUp() {
	
	}*/

	@Test
	void testBuscarPorCNPJExistente() {
		Empresa e1 = new Empresa();
		e1.setId(1l);
		e1.setDataAbertura(new Date());
		e1.setCnpj("11928567000133");
		List<Empresa> lComE1 = new ArrayList<Empresa>();
		lComE1.add(e1);

		Mockito.when(this.empresaRepository.findByCNPJ(anyString())).thenReturn(new ArrayList<Empresa>());
		Mockito.when(this.empresaRepository.findByCNPJ("11928567000133")).thenReturn(lComE1);

		Empresa eTest = this.empresaService.buscarEmpresaPorCNPJ("11928567000133");

		assertNotNull(eTest);
		assertEquals("11928567000133", eTest.getCnpj());
		assertEquals(1l, eTest.getId());

		verify(this.empresaRepository, times(1)).findByCNPJ(anyString());
	}

	@Test
	void testBuscarPorCNPJInexistente() {
		Empresa e1 = new Empresa();
		e1.setId(1l);
		e1.setDataAbertura(new Date());
		e1.setCnpj("11928567000133");
		List<Empresa> lComE1 = new ArrayList<Empresa>();
		lComE1.add(e1);

		Mockito.when(this.empresaRepository.findByCNPJ(anyString())).thenReturn(new ArrayList<Empresa>());
		Mockito.when(this.empresaRepository.findByCNPJ("11928567000133")).thenReturn(lComE1);

		Empresa eTest = this.empresaService.buscarEmpresaPorCNPJ("12345678901234");

		assertNull(eTest);

		verify(this.empresaRepository, times(1)).findByCNPJ(anyString());
	}

	@Test
	void testBuscarPorCNPJNulo() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			this.empresaService.buscarEmpresaPorCNPJ(null);
		});

		assertEquals("O CNPJ é obrigatório", e.getMessage());
	}

	@Test
	void testBuscarPorCNPJVazio() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			this.empresaService.buscarEmpresaPorCNPJ("");
		});

		assertEquals("O CNPJ é obrigatório", e.getMessage());
	}
}
