package vidal.dicyane.conta.utils;

import lombok.Getter;
import lombok.Setter;
import vidal.dicyane.conta.model.Conta;

import java.io.Serializable;

@Getter @Setter
public class ContaCartaoPersist implements Serializable {
    private static final long serialVersionUID = 6026412647325927959L;

    private String titular;

    private Long numeroCartao;

    private Boolean flagAtivo;

    private Double saldo;

    private String tipo;

    private Boolean contaAtiva;

    private String conta;

    public Conta getConta(){
        Conta conta = new Conta();
        conta.setSaldo(this.saldo);
        conta.setTipo(this.tipo);
        conta.setContaAtiva(this.contaAtiva);
        conta.setConta(this.conta);
        return conta;
    }

    public CartaoPersist getCartao(){
        CartaoPersist cartao = new CartaoPersist();
        cartao.setTitular(this.titular);
        cartao.setNumeroCartao(this.numeroCartao);
        cartao.setFlagAtivo(this.flagAtivo);
        return cartao;
    }
}
