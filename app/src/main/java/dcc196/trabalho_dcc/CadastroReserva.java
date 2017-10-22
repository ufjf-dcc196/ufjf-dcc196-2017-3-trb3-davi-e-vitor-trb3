package dcc196.trabalho_dcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import dcc196.trabalho_dcc.model.Livro;
import dcc196.trabalho_dcc.model.Participante;
import dcc196.trabalho_dcc.model.Reserva;

import static android.widget.Toast.LENGTH_SHORT;

public class CadastroReserva extends AppCompatActivity {

    private Button btnReservarLivro;
    private AutoCompleteTextView autoCompleteParticipantes;
    private AutoCompleteTextView autoCompleteLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_reserva);

        btnReservarLivro = (Button) findViewById(R.id.btnReservarLivro);
        autoCompleteParticipantes = (AutoCompleteTextView) findViewById(R.id.autoCompleteParticipantes);
        autoCompleteLivros = (AutoCompleteTextView) findViewById(R.id.autoCompleteLivros);

        final ArrayAdapter<Participante> adpParticipante = new ArrayAdapter<Participante>(this, R.layout.support_simple_spinner_dropdown_item);
        autoCompleteParticipantes.setAdapter(adpParticipante);

        final ArrayAdapter<Livro> adpLivro = new ArrayAdapter<Livro>(this, R.layout.support_simple_spinner_dropdown_item);
        autoCompleteLivros.setAdapter(adpLivro);

        btnReservarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reserva reserva = new Reserva();
                reserva.setLivro(adpLivro.getItem(autoCompleteLivros.getListSelection()));
                reserva.setParticipante(adpParticipante.getItem(autoCompleteParticipantes.getListSelection()));

                Toast.makeText(getApplicationContext(), reserva.getLivro().getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
