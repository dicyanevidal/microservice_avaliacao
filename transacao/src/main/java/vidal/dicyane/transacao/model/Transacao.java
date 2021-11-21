package vidal.dicyane.transacao.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TRANSACAO")
@Getter @Setter
@EnableSwagger2
public class Transacao implements Serializable {
    private static final long serialVersionUID = -5243120123104366629L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dataHoraMovimento;

    @Column
    @NotNull
    private String operacao;

    @Column(precision = 17, scale = 2)
    private Double valor;

    @Column(name = "id_Conta")
    private Long contaId;
}
