package dcc196.trabalho_dcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.List;

import dcc196.trabalho_dcc.model.Livro;
import dcc196.trabalho_dcc.model.Participante;
import dcc196.trabalho_dcc.model.Reserva;


public class CadastroReserva extends AppCompatActivity {

    private Button btnReservarLivro;
    private AutoCompleteTextView autoCompleteParticipantes;
    private AutoCompleteTextView autoCompleteLivros;
    private ParticipanteHelper ph;
    private LivroHelper lh;
    private List<Participante> participantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_reserva);

        ph = ParticipanteHelper.getInstance();
        lh = LivroHelper.getInstance();

        btnReservarLivro = (Button) findViewById(R.id.btnReservarLivro);
        autoCompleteParticipantes = (AutoCompleteTextView) findViewById(R.id.autoCompleteParticipantes);
        autoCompleteLivros = (AutoCompleteTextView) findViewById(R.id.autoCompleteLivros);

        participantes = ParticipanteHelper.getInstance().listarParticipantes();
        final ArrayAdapter<Participante> adpParticipante = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, participantes);
        autoCompleteParticipantes.setAdapter(adpParticipante);

        List<Livro> livros = lh.listarLivros();
        final ArrayAdapter<Livro> adpLivro = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, livros);
        autoCompleteLivros.setAdapter(adpLivro);

        btnReservarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
