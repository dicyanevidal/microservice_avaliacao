package vidal.dicyane.conta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vidal.dicyane.conta.interfaces.OperacaoSaldo;
import vidal.dicyane.conta.model.Conta;
import vidal.dicyane.conta.model.Deposito;
import vidal.dicyane.conta.model.Saque;
import vidal.dicyane.conta.model.Valor;
import vidal.dicyane.conta.service.ContaService;

import javax.transaction.Transactional;
import java.util.List;

import static vidal.dicyane.conta.service.ContaService.controleOperacao;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping(path = "/listar")
    public ResponseEntity<?> listar(){
        List<Conta> contas = contaService.listarContas();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Conta conta){
        Conta contaCadastrada = this.contaService.cadastrarConta(conta);
        return new ResponseEntity<>(contaCadastrada, HttpStatus.OK);
    }

    @PutMapping(path = "/operacao/id/{id}/operacao/{tipoOperacao}")
    public ResponseEntity<?> realizarOperacao(@PathVariable Long id, @PathVariable Integer tipoOperacao, @RequestBody Valor valor) {
        contaService.movimentarSaldo(id, controleOperacao(tipoOperacao), valor.getQuantia());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
