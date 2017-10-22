package dcc196.trabalho_dcc.model;

/**
 * Created by Vitor on 22/10/2017.
 */

public class Livro {
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
}
