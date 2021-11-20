package vidal.dicyane.conta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vidal.dicyane.conta.utils.CartaoPersist;
import vidal.dicyane.conta.utils.ContaCartaoPersist;
import vidal.dicyane.conta.utils.TransacaoPersist;
import vidal.dicyane.conta.utils.Valor;
import vidal.dicyane.conta.exceptions.CartaoInexistenteException;
import vidal.dicyane.conta.interfaces.CartaoFeign;
import vidal.dicyane.conta.interfaces.TransacaoFeign;
import vidal.dicyane.conta.model.*;
import vidal.dicyane.conta.service.ContaService;
import java.util.List;
import java.util.Objects;

import static vidal.dicyane.conta.service.ContaService.controleOperacao;
import static vidal.dicyane.conta.service.ContaService.nomeOperacao;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    ContaService contaService;

    @Autowired
    TransacaoFeign transacaoFeign;

    @Autowired
    CartaoFeign cartaoFeign;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        List<Conta> contas = contaService.listarContas();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ContaCartaoPersist contaCartaoPersist){
        Conta contaCadastrada = contaService.cadastrarConta(contaCartaoPersist.getConta());
        CartaoPersist cartaoPersist = contaCartaoPersist.getCartao();
        cartaoPersist.setIdConta(contaCadastrada.getId());
        cartaoFeign.cadastrarCartao(cartaoPersist);
        return new ResponseEntity<>(contaCadastrada, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/operacao/{id}/tipoOperacao/{tipoOperacao}")
    public ResponseEntity<?> realizarOperacao(@PathVariable Long id, @PathVariable Integer tipoOperacao, @RequestBody Valor valor) {
        if(Objects.isNull(cartaoFeign.buscarCartao(id))){
            throw new CartaoInexistenteException("Cartão inexistente.");
        } else {
            contaService.movimentarSaldo(id, controleOperacao(tipoOperacao), valor.getQuantia());
            transacaoFeign.salvarTransacao(new TransacaoPersist(id, nomeOperacao(tipoOperacao),valor.getQuantia()));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
