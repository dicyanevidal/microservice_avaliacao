package vidal.dicyane.conta.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class Transacao implements Serializable {
    private static final long serialVersionUID = -5243120123104366629L;

    private Long idConta;

    private String operacao;

    private Double valor;

}
