package vidal.dicyane.cartao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vidal.dicyane.cartao.model.Cartao;
import vidal.dicyane.cartao.service.CartaoService;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController implements Serializable {
    private static final long serialVersionUID = -6119129487735953894L;

    @Autowired
    CartaoService cartaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarCartao(@RequestBody Cartao cartao){
        Cartao cartaGerado = cartaoService.cadastrarCartao(cartao);
        return new ResponseEntity<>(cartaGerado, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Cartao> cartoes = cartaoService.listarCartoes();
        return new ResponseEntity<>(cartoes, HttpStatus.OK);
    }

    @GetMapping( "/buscarCartao/{idConta}")
    public ResponseEntity<?> buscarCartao(@PathVariable Long idConta){
        Cartao cartao = cartaoService.buscarCartao(idConta);
        return new ResponseEntity<>(cartao, HttpStatus.OK);
    }
}
