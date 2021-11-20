package vidal.dicyane.conta.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import vidal.dicyane.conta.interfaces.OperacaoSaldo;
import vidal.dicyane.conta.model.Conta;
import vidal.dicyane.conta.model.Deposito;
import vidal.dicyane.conta.model.Saque;
import vidal.dicyane.conta.repository.ContaRepository;
import java.util.List;


@AllArgsConstructor
@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    public Conta cadastrarConta(Conta conta){
        return contaRepository.save(conta);
    }


    public void movimentarSaldo(Long id, OperacaoSaldo operacao, Double quantia){
        Conta conta = contaRepository.findById(id).get();
        conta.setSaldo(operacao.executarOperacao(conta.getSaldo(), quantia));
        contaRepository.save(conta);
    }

    public static OperacaoSaldo controleOperacao(Integer tipoOperacao) {
        switch (tipoOperacao){
            case 1:
                return new Saque();
            case 2:
                return new Deposito();
            default:
                throw new RuntimeException("Não foi possível realizar a operação.");
        }
    }

    public static String nomeOperacao(Integer tipoOperacao) {
        switch (tipoOperacao){
            case 1:
                return "SAQUE";
            case 2:
                return "DEPOSITO";
            default:
                throw new RuntimeException("Não foi possível encontrar a operação.");
        }
    }
}
