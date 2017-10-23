package dcc196.trabalho_dcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalheParticipante extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtEmail;
    private TextView horaEntrada;
    private TextView horaSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_participante);

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        horaEntrada = (TextView) findViewById(R.id.txtHoraEntrada);
        horaSaida = (TextView) findViewById(R.id.txtHoraSaida);


    }
}
