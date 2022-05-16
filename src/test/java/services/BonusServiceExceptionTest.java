package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import models.Funcionario;

class BonusServiceExceptionTest {

	@Test //Testando se o bonus é 0 para funcionarios com salario alto(bonus maior que 1000 reais) com exception
	void bonusDeveSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusServiceException bonusService = new BonusServiceException(); //classe que queremos testar
//		MANEIRA 1
//		assertThrows(IllegalArgumentException.class,
//				() -> bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("25000"))));
		
		
//		MANEIRA 2 - metodo utilizado para quando é preciso capturar a mensagem da exception
		try {
			bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("25000")));
			fail("Não lançou exception!!"); //força junit lançar erro dizendo que nao foi lançada a exception
		} catch (Exception e) {
			assertEquals("Funcionário com salário acima de R$ 10.000,00 não pode receber bônus", e.getMessage());
		}
		
	}
	
	@Test //Testando se calculo de bonus de 10% está correto
	void bonusDeveSerDezPorCentoDoSalario() {
		BonusServiceException bonusService = new BonusServiceException(); //classe que queremos testar
		BigDecimal valorBonus = bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("1000"))); //Calculando valor bonus 10%
		
		assertEquals(new BigDecimal("100.00"), valorBonus);
	}
	
	@Test //Testando se o bonus é aplicado se o bonus é exatamente 1000 reais
	void bonusDeveSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
		BonusServiceException bonusService = new BonusServiceException(); //classe que queremos testar
		BigDecimal valorBonus = bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), valorBonus);
	}
	
}
