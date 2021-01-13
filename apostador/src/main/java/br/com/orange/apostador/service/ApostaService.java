package br.com.orange.apostador.service;

import br.com.orange.apostador.entity.Aposta;
import br.com.orange.apostador.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository repository;

    public Aposta saveAposta(Aposta aposta){
        return repository.save(aposta);
    }

    public List<Aposta> getApostas(){
        return repository.findAll();
    }

    public List<Aposta> getApostasByEmail(String email)
    {
        return repository.findAllByEmailOrderByDataAposta(email);
    }

}
