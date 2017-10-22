package dcc196.trabalho_dcc.model;

/**
 * Created by Vitor on 22/10/2017.
 */

public class Reserva {
    private Participante participante;
    private Livro livro;

    public Reserva() {

    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
