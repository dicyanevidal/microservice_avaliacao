package vidal.dicyane.transacao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
public class Conta implements Serializable {
    private static final long serialVersionUID = 3867851376759979506L;

    private Long id;

    private Double saldo;

    private String tipo;

    private Boolean flagAtivo;
}
