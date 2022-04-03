package br.com.bytebank.banco.modelo;

// unchecked
// não são checadas pelo compilador

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
