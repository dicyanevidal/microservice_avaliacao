package vidal.dicyane.conta.model;

import vidal.dicyane.conta.exceptions.SaldoInsuficienteException;
import vidal.dicyane.conta.interfaces.OperacaoSaldo;

public class Saque implements OperacaoSaldo {

    @Override
    public Double executarOperacao(Double saldo, Double quantia) {
        if(saldo > quantia){
            return saldo - quantia;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente, liso.");
        }

    }
}
