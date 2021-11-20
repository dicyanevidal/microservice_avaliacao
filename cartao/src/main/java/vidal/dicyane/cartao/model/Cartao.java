package vidal.dicyane.cartao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@Table(name = "CARTAO")
@Entity
public class Cartao implements Serializable {
    private static final long serialVersionUID = 6026412647325927959L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titular;

    @Column
    private Long numeroCartao;

    @Column
    private Boolean flagAtivo;

    @Column
    private Long idConta;
}
