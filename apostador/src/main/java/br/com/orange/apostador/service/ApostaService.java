package br.com.orange.apostador.service;

import br.com.orange.apostador.entity.Aposta;
import br.com.orange.apostador.repository.ApostaRepository;
import br.com.orange.apostador.util.GeradorAposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository repository;

    public Aposta saveEmailAposta(String email){
        String dezenasApostadas = GeradorAposta.obterNumerosString();
        Aposta aposta = new Aposta();
        aposta.setEmail(email);
        aposta.setDataAposta(new Date());
        aposta.setNumerosApostados(dezenasApostadas);
        return saveAposta(aposta);
    }

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
