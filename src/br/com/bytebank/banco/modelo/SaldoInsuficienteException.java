package br.com.bytebank.banco.modelo;

// unchecked
// n�o s�o checadas pelo compilador

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
