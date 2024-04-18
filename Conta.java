package excecoes.exercicio2;

public class Conta {
    private int agencia;
    private int codigo;
    private int saldo;
    private float limite;

    public Conta() {
        // Construtor default
    }

    public Conta(int agencia, int codigo, int saldo, float limite) {
        this.agencia = agencia;
        this.codigo = codigo;
        this.saldo = saldo;
        this.limite = limite;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public void deposita(float valor) {
        this.saldo += valor;
    }

    public void saca(float valor) throws SaldoInsuficienteException {
        if (valor > saldo + limite) {
            throw new SaldoInsuficienteException("Limite total disponível para saque: " + (saldo + limite));
        }
        this.saldo -= valor;
    }
}
