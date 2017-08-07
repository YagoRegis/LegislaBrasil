package com.cursoandroid.examplerecyclerview.legislabrasil.models;

/**
 * Created by -Yago- on 06/08/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deputado {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("siglaPartido")
    @Expose
    private String siglaPartido;
    @SerializedName("uriPartido")
    @Expose
    private String uriPartido;
    @SerializedName("siglaUf")
    @Expose
    private String siglaUf;
    @SerializedName("idLegislatura")
    @Expose
    private Integer idLegislatura;
    @SerializedName("urlFoto")
    @Expose
    private String urlFoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getUriPartido() {
        return uriPartido;
    }

    public void setUriPartido(String uriPartido) {
        this.uriPartido = uriPartido;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public Integer getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(Integer idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
