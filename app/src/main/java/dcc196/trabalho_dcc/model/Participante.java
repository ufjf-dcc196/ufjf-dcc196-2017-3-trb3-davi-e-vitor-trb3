package dcc196.trabalho_dcc.model;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vitor on 22/10/2017.
 */

public class Participante implements Serializable {
    private String nomeCompleto;
    private String email;
    private Date horaEntrada;
    private Date horaSaída;

    @Override
    public String toString() {
        return nomeCompleto;
    }

    public Participante () {

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSaída() {
        return horaSaída;
    }

    public void setHoraSaída(Date horaSaída) {
        this.horaSaída = horaSaída;
    }
}
