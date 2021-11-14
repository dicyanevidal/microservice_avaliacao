package vidal.dicyane.conta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vidal.dicyane.conta.model.Conta;

import java.util.List;

@Repository
@Transactional
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Override
    List<Conta> findAll();
}
