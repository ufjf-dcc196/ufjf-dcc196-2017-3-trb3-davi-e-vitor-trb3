package dcc196.trabalho_dcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dcc196.trabalho_dcc.model.Livro;
import dcc196.trabalho_dcc.model.Participante;

public class DadosLivro extends AppCompatActivity {

    private TextView tvTitulo;
    private TextView tvEditora;
    private TextView tvAnoPublicacao;
    private ListView lvParticipantesReservaram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_livro);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvEditora = (TextView) findViewById(R.id.tvEditora);
        tvAnoPublicacao = (TextView) findViewById(R.id.tvAnoPublicacao);
        lvParticipantesReservaram = (ListView) findViewById(R.id.lvParticipantesReservaram);

        Livro livro = (Livro) getIntent().getSerializableExtra("Livro");
        ArrayList<Participante> participantes = (ArrayList<Participante>) getIntent().getSerializableExtra("Participantes");

        tvTitulo.setText(livro.getTitulo());
        tvEditora.setText(livro.getEditora());
        tvAnoPublicacao.setText(livro.getAnoPlubicacao());

        ArrayAdapter<Participante> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, participantes);

        lvParticipantesReservaram.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), Integer.toString(participantes.size()), Toast.LENGTH_SHORT).show();
    }
}
