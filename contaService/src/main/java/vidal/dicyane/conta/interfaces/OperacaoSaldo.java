package vidal.dicyane.conta.interfaces;

import vidal.dicyane.conta.model.Conta;

public interface OperacaoSaldo {

    Double executarOperacao(Double saldo, Double quantia);
}
