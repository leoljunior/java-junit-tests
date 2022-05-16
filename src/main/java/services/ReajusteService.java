package services;

import java.math.BigDecimal;

import models.Funcionario;

public class ReajusteService {

	public void aplicarReajuste(Funcionario funcionario, Desempenho desempenho) {
		
//		APLICANDO DESIGN PATTERN STRATEGY PARA REFATORAR O CÓDIGO. Dessa forma sempre que se adicionar um novo reajuste ou a regra de negocio mudar
//		temos que adicionar um no if aqui, e uma nova constante no enum
		if (desempenho == Desempenho.A_DESEJAR) {
			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
			funcionario.reajustarSalario(reajuste);
		} else if (desempenho == Desempenho.BOM) {
			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
			funcionario.reajustarSalario(reajuste);
		} else if (desempenho == Desempenho.OTIMO) {
			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.2"));
			funcionario.reajustarSalario(reajuste);
		}
		
//		funcionario.reajustarSalario(funcionario.getSalario().multiply(desempenho.percentualReajuste()));
		
	}

}
