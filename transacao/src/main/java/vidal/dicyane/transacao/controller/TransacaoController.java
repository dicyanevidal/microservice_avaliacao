package vidal.dicyane.transacao.controller;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vidal.dicyane.transacao.model.Transacao;
import vidal.dicyane.transacao.model.TransacaoPersist;
import vidal.dicyane.transacao.service.TransacaoService;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
@Log4j2
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    void salvarTransacao(@RequestBody TransacaoPersist transacaoPersist) {
        Transacao transacao = modelMapper.map(transacaoPersist, Transacao.class);
        transacao.setId(null);
        transacaoService.cadastrarTransacao(transacao);
        log.info("Transação salva");
    }

    @GetMapping( "/conta/{id}")
    public ResponseEntity<?> listarTransacoes(@PathVariable Long id){
        List<Transacao> transacoes = transacaoService.listarTransacoes(id);
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }
}
