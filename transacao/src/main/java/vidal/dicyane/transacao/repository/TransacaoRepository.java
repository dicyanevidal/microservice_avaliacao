package vidal.dicyane.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vidal.dicyane.transacao.model.Transacao;

import java.util.List;

@Repository
@Transactional
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findAllByContaId(Long id);
}
