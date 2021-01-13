package br.com.orange.apostador.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="aposta_tbl")
public class Aposta {

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private java.util.Date dataAposta;
    private String numerosApostados;
}
