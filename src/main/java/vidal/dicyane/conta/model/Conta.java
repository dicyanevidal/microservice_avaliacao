package vidal.dicyane.conta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Conta")
public class Conta implements Serializable {
    private static final long serialVersionUID = 3867851376759979506L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double saldo;

    @Column
    private String tipo;

    @Column
    private Boolean flagAtivo;
}
