package dcc196.trabalho_dcc.model;

import java.io.Serializable;

/**
 * Created by Vitor on 22/10/2017.
 */

public class Livro implements Serializable{
    private String titulo;
    private String editora;
    private String anoPlubicacao;

    public Livro () {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoPlubicacao() {
        return anoPlubicacao;
    }

    public void setAnoPlubicacao(String anoPlubicacao) {
        this.anoPlubicacao = anoPlubicacao;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
