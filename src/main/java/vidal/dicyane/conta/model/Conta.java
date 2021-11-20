package vidal.dicyane.conta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import vidal.dicyane.conta.interfaces.CartaoFeign;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@EnableSwagger2
@Table(name = "CONTA")
@NoArgsConstructor @AllArgsConstructor
public class Conta implements Serializable {
    private static final long serialVersionUID = 3867851376759979506L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double saldo;

    @Column
    private String tipo;

    @Column
    private Boolean contaAtiva;

    @Column
    private String conta;


}
