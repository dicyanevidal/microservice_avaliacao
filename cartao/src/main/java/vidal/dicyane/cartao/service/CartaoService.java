package vidal.dicyane.cartao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import vidal.dicyane.cartao.model.Cartao;
import vidal.dicyane.cartao.repository.CartaoRepository;

import java.io.Serializable;
import java.util.List;

@Service
public class CartaoService implements Serializable {
    private static final long serialVersionUID = 4553529206975062216L;

    @Autowired
    CartaoRepository cartaoRepository;

    public Cartao cadastrarCartao(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> listarCartoes(){
        return cartaoRepository.findAll();
    }

    public Cartao buscarCartao(Long id){
        return cartaoRepository.findAllByIdConta(id);
    }
}
