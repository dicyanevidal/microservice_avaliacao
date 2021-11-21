package vidal.dicyane.transacao.service;

import com.netflix.discovery.EurekaClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vidal.dicyane.transacao.model.Transacao;
import vidal.dicyane.transacao.repository.TransacaoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public void cadastrarTransacao(Transacao transacao){
        transacao.setDataHoraMovimento(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTransacoes(Long id){
        return transacaoRepository.findAllByContaId(id);
    }

}
