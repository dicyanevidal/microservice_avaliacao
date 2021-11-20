package vidal.dicyane.conta.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vidal.dicyane.conta.utils.CartaoPersist;

@FeignClient(url = "http://localhost:8082/cartoes/", name = "cartoes")
public interface CartaoFeign {

    @PostMapping("/cadastrar")
    public void cadastrarCartao(@RequestBody CartaoPersist cartaoPersist);

    @GetMapping( "/buscarCartao/{idConta}")
    public CartaoPersist buscarCartao(@PathVariable Long idConta);
}
