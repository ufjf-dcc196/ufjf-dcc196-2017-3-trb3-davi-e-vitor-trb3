package dcc196.trabalho_dcc;

import java.util.ArrayList;
import java.util.List;

import dcc196.trabalho_dcc.model.Participante;

/**
 * Created by Davi on 22/10/2017.
 */

public class ParticipanteHelper {

    private List<Participante> participantes = new ArrayList<>();


    List<Participante> listarParticipantes() {

        return participantes;
    }

    public void criar(Participante participante) {
        participantes.add(participante);
    }
}
