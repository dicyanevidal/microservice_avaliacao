package vidal.dicyane.conta.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import vidal.dicyane.conta.interfaces.OperacaoSaldo;
import vidal.dicyane.conta.model.*;
import vidal.dicyane.conta.service.ContaService;
import javax.transaction.Transactional;
import java.util.List;

import static vidal.dicyane.conta.service.ContaService.controleOperacao;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    ContaService contaService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${spring.application.transacao}")
    private String transacaoServiceName;

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

    @PutMapping(path = "/operacao/{id}/operacao/{tipoOperacao}")
    public ResponseEntity<?> realizarOperacao(@PathVariable Long id, @PathVariable Integer tipoOperacao, @RequestBody Valor valor) {
        contaService.movimentarSaldo(id, controleOperacao(tipoOperacao), valor.getQuantia());
        salvarTransacao(new Transacao(id, tipoOperacao.toString(), valor.getQuantia()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void salvarTransacao(Transacao transacao) {
        Application application = eurekaClient.getApplication(transacaoServiceName);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/transacoes";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JSONObject personJsonObject = new JSONObject();
            personJsonObject.put("idConta", transacao.getIdConta());
            personJsonObject.put("operacao", transacao.getOperacao());
            personJsonObject.put("valor", transacao.getValor());

            HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);

            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
