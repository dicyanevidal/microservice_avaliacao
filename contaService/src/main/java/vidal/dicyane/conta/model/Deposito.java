package vidal.dicyane.conta.model;

import vidal.dicyane.conta.interfaces.OperacaoSaldo;

public class Deposito implements OperacaoSaldo {

    @Override
    public Double executarOperacao(Double saldo, Double quantia) {
        return saldo + quantia;
    }
}
