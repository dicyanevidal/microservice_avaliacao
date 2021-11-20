package vidal.dicyane.conta.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vidal.dicyane.conta.utils.TransacaoPersist;

@FeignClient(url = "http://localhost:8084/transacoes/", name = "transacoes")
public interface TransacaoFeign {

    @PostMapping
    public TransacaoPersist salvarTransacao(@RequestBody TransacaoPersist transacaoPersist);
}
