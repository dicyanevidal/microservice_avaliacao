package vidal.dicyane.conta.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CartaoPersist implements Serializable {
    private static final long serialVersionUID = 6026412647325927959L;

    private String titular;

    private Long numeroCartao;

    private Boolean flagAtivo;

    private Long idConta;
}
