package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import models.Funcionario;

public class BonusServiceException {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) { //se bonus for maior que 1000 reais o funcionario não recebe bonus
			throw new IllegalArgumentException("Funcionário com salário acima de R$ 10.000,00 não pode receber bônus");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
//		return valor;
	}
	
}
