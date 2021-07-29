package edu.fiuba.algo3.modelo.excepciones;

public class CanjeConTarjetaAjenaException extends RuntimeException {
    public CanjeConTarjetaAjenaException(String msg) {
        super((msg));
    }
}
