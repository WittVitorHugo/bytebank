package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta.
 * 
 * @author witt_
 *
 */

public abstract class Conta {

    private static int total = 0;
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;

    public Conta() {
    }

    /**
     * Construtor para inicializar o objeto Conta a partir da agência e número.
     * 
     * @param agencia
     * @param numero
     */
    
    public Conta(int agencia, int numero) {
        Conta.total++;
        System.out.println("O total de contas Ã© " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
        System.out.println("Estou criando uma conta " + this.numero);
    }

    public static int getTotal() {
        return Conta.total;
    }

    public abstract void deposita(double valor);

    /**
     * Valor precisa ser maior que o saldo.
     * 
     * @param valor
     * @throws SaldoInsuficienteException
     */
    public void saca(double valor) throws SaldoInsuficienteException {

        if (this.saldo < valor) {
            //problema
            throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
        }
        this.saldo -= valor;

    }

    public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
        this.saca(valor);
        destino.deposita(valor);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        if (agencia <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.agencia = agencia;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "Numero: " + this.numero;
    }
}