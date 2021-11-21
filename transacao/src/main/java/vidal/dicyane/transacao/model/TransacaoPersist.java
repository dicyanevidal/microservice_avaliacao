package vidal.dicyane.transacao.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class TransacaoPersist implements Serializable {
    private static final long serialVersionUID = 7702565579248180393L;

    private Long contaId;

    private String operacao;

    private Double valor;
}
