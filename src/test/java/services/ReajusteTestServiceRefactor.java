package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Funcionario;

public class ReajusteTestServiceRefactor {
	
	private ReajusteService reajusteService;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Instanciando service e funcionario.");
		this.reajusteService = new ReajusteService();
		this.funcionario = new Funcionario("Julia", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Fim do teste.");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Executa antes de todos os testes");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Executa depois de todos os testes");
	}
	

	@Test
	public void reajusteDeveSerDeTresPorCentoQuandoRendimentoForADesejar() {
		System.out.println("Executando teste");
		reajusteService.aplicarReajuste(funcionario, Desempenho.A_DESEJAR);		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveSerDeQuinzePorCentoQuandoRendimentoForBom() {
		System.out.println("Executando teste");
		reajusteService.aplicarReajuste(funcionario, Desempenho.BOM);		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveSerDeVintePorCentoQuandoRendimentoForBom() {
		System.out.println("Executando teste");
		reajusteService.aplicarReajuste(funcionario, Desempenho.OTIMO);		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
