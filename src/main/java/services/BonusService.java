package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import models.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) { //se bonus for maior que 1000 reais o funcionario não recebe bonus
			valor = BigDecimal.ZERO;
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
//		return valor;
	}
	
}
