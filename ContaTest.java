package excecoes.exercicio2;
import excecoes.exercicio2.Conta;
import excecoes.exercicio2.SaldoInsuficienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {
    @Test
    public void testDeposito() {
        Conta conta = new Conta();
        conta.deposita(100);
        Assertions.assertEquals(100, conta.getSaldo());
    }

    @Test
    public void testSaqueSemLimite() throws SaldoInsuficienteException {
        Conta conta = new Conta(1, 12345, 100, 0);
        conta.saca(50);
        Assertions.assertEquals(50, conta.getSaldo());
    }

    @Test
    public void testSaqueComLimite() throws SaldoInsuficienteException {
        Conta conta = new Conta(1, 12345, 50, 100);
        conta.saca(150);
        Assertions.assertEquals(0, conta.getSaldo());
    }

    @Test
    public void testSaqueExcedendoLimiteTotal() throws SaldoInsuficienteException {
        Conta conta = new Conta(1, 12345, 50, 100);
        try {
            conta.saca(200);
        } catch (SaldoInsuficienteException e) {
            Assertions.assertEquals("Limite total disponível para saque: 150", e.getMessage());
        }
    }
}

