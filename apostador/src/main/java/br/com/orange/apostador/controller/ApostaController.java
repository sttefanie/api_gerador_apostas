package br.com.orange.apostador.controller;

import br.com.orange.apostador.entity.Aposta;
import br.com.orange.apostador.service.ApostaService;
import br.com.orange.apostador.util.GeradorAposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ApostaController {

    @Autowired
    private ApostaService service;

    @PostMapping("/apostar")
    public Aposta createAposta(@RequestParam Map<String, String> requestParams)
    {
        GeradorAposta geradorNumeros = new GeradorAposta();
        String email = requestParams.get("email");
        String dezenasApostadas = geradorNumeros.obterNumerosString();
        Aposta aposta = new Aposta();
        aposta.setEmail(email);
        aposta.setDataAposta(new Date());
        aposta.setNumerosApostados(dezenasApostadas);
        return service.saveAposta(aposta);
    }

    @GetMapping("/obterApostas")
    public List<Aposta> getApostasByEmail(@RequestParam("email") String email){
        return service.getApostasByEmail(email);
    }

    @PostMapping("/inserir")
    public Aposta addAposta(@RequestBody Aposta aposta){
        return service.saveAposta(aposta);
    }

    @GetMapping("/all")
    public List<Aposta> findAllApostas(){
        return service.getApostas();
    }

}
