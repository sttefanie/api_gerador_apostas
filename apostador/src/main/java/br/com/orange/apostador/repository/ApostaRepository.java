package br.com.orange.apostador.repository;

import br.com.orange.apostador.entity.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApostaRepository extends JpaRepository<Aposta, Integer> {

    List<Aposta> findAllByEmailOrderByDataAposta(String email);
}
