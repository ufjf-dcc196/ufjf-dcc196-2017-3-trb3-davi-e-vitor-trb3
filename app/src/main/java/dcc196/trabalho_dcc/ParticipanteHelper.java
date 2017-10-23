package dcc196.trabalho_dcc;

import java.util.ArrayList;
import java.util.List;

import dcc196.trabalho_dcc.model.Participante;

/**
 * Created by Davi on 22/10/2017.
 */

public class ParticipanteHelper {

    private static ParticipanteHelper phs = null;
    private List<Participante> participantes = new ArrayList<>();

    private ParticipanteHelper () {

    }

    public List<Participante> listarParticipantes() {
        return participantes;
    }

    public void criar(Participante participante) {
        participantes.add(participante);
    }

    public static ParticipanteHelper getInstance() {
        if (phs == null) {
            phs = new ParticipanteHelper();
        }
        return phs;
    }

}
