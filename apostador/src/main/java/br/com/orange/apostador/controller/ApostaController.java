package br.com.orange.apostador.controller;

import br.com.orange.apostador.entity.Aposta;
import br.com.orange.apostador.service.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class ApostaController {

    @Autowired
    private ApostaService service;

    @PostMapping("/apostas")
    public Aposta createAposta(@RequestParam Map<String, String> requestParams)
    {
        String email = requestParams.get("email");
        return service.saveEmailAposta(email);
    }

    @GetMapping("/apostas/{email}")
    public List<Aposta> getApostasByEmail(@PathVariable String email){
        return service.getApostasByEmail(email);
    }

    @GetMapping("/apostas")
    public List<Aposta> findAllApostas(){
        return service.getApostas();
    }

}
