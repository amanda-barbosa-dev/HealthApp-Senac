package com.example.demo.model.bularioapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public  class Content {
    @JsonProperty("idProduto")
    int idProduto;
    @JsonProperty("numeroRegistro")
    String numeroRegistro;
    @JsonProperty("nomeProduto")
    String nomeProduto;
    @JsonProperty("expediente")
    String expediente;
    @JsonProperty("razaoSocial")
    String razaoSocial;
    @JsonProperty("cnpj")
    String cnpj;
    @JsonProperty("numeroTransacao")
    String numeroTransacao;
    @JsonProperty("data")
    Date data;
    @JsonProperty("numProcesso")
    String numProcesso;
    @JsonProperty("idBulaPacienteProtegido")
    String idBulaPacienteProtegido;
    @JsonProperty("idBulaProfissionalProtegido")
    String idBulaProfissionalProtegido;
    @JsonProperty("dataAtualizacao")
    Date dataAtualizacao;
    public Content() {
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getIdBulaPacienteProtegido() {
        return idBulaPacienteProtegido;
    }
    public void setIdBulaPacienteProtegido(String idBulaPacienteProtegido) {
        this.idBulaPacienteProtegido = idBulaPacienteProtegido;
    }

    @Override
    public String toString() {
        return "Content{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", idBulaPacienteProtegido='" + idBulaPacienteProtegido + '\'' +
                '}';
    }
}

