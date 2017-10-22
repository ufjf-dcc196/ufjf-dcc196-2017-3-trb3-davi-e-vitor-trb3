package dcc196.trabalho_dcc;

import java.util.ArrayList;
import java.util.List;

import dcc196.trabalho_dcc.model.Reserva;

/**
 * Created by Davi on 22/10/2017.
 */

public class ReservaHelper {

    private List<Reserva> reservas = new ArrayList<>();

    public void criar(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }
}
