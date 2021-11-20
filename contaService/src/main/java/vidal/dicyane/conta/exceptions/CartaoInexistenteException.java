package vidal.dicyane.conta.exceptions;

public class CartaoInexistenteException extends RuntimeException {

    public CartaoInexistenteException(String message) {
        super(message);
    }
}
