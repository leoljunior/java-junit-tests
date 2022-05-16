package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import models.Funcionario;

public class ReajusteTestService {

	@Test
	public void reajusteDeveSerDeTresPorCentoQuandoRendimentoForADesejar() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Julia", LocalDate.now(), new BigDecimal("1000.00"));
		reajusteService.aplicarReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveSerDeQuinzePorCentoQuandoRendimentoForBom() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Julia", LocalDate.now(), new BigDecimal("1000.00"));
		reajusteService.aplicarReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveSerDeVintePorCentoQuandoRendimentoForBom() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Julia", LocalDate.now(), new BigDecimal("1000.00"));
		reajusteService.aplicarReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
