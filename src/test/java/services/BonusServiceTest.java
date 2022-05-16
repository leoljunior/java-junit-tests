package services;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import models.Funcionario;

class BonusServiceTest {

	@Test //Testando se o bonus é 0 para funcionarios com salario alto(bonus maior que 1000 reais)
	void bonusDeveSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService bonusService = new BonusService(); //classe que queremos testar
		BigDecimal valorBonus = bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("25000"))); //Calculando valor bonus, base 25000
		
		assertEquals(new BigDecimal("00.00"), valorBonus);
	}
	
	@Test //Testando se calculo de bonus de 10% está correto
	void bonusDeveSerDezPorCentoDoSalario() {
		BonusService bonusService = new BonusService(); //classe que queremos testar
		BigDecimal valorBonus = bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("1000"))); //Calculando valor bonus 10%
		
		assertEquals(new BigDecimal("100.00"), valorBonus);
	}
	
	@Test //Testando se o bonus é aplicado se o bonus é exatamente 1000 reais
	void bonusDeveSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
		BonusService bonusService = new BonusService(); //classe que queremos testar
		BigDecimal valorBonus = bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), valorBonus);
	}
	
}
