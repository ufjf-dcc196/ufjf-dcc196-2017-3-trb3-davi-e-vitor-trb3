package dcc196.trabalho_dcc;

import java.util.List;

/**
 * Created by Vitor on 03/12/2017.
 */

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private Integer dificuldade;
    private Integer estado;
    private List<Etiqueta> listEtiquetas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Integer getEstado() { return estado; }

    public void setEstado(Integer estado) {this.estado = estado; }

    public List<Etiqueta> getListEtiquetas() {
        return listEtiquetas;
    }

    public void setListEtiquetas (List<Etiqueta> listEtiquetas) {
        this.listEtiquetas = listEtiquetas;
    }
}
