package vidal.dicyane.conta.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
public class TransacaoPersist implements Serializable {
    private static final long serialVersionUID = -5243120123104366629L;

    private Long contaId;

    private String operacao;

    private Double valor;

}
