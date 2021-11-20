package vidal.dicyane.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vidal.dicyane.cartao.model.Cartao;

@Transactional
@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Cartao findAllByIdConta(Long id);
}
