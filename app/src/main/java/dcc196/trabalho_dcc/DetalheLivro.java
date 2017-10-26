package dcc196.trabalho_dcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dcc196.trabalho_dcc.model.Livro;
import dcc196.trabalho_dcc.model.Participante;
import dcc196.trabalho_dcc.model.Reserva;

public class DetalheLivro extends AppCompatActivity {

    private ListView lvLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_livro);

        lvLivros = (ListView) findViewById(R.id.lvLivros);

        ArrayAdapter<Livro> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, LivroHelper.getInstance().listarLivros());

        lvLivros.setAdapter(adapter);

        lvLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Livro livro = LivroHelper.getInstance().listarLivros().get(position);
                ArrayList<Participante> participantes = (ArrayList<Participante>) ReservaHelper.getInstance().reservaramLivro(livro);
                Toast.makeText(getApplicationContext(), Integer.toString(participantes.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
