package dcc196.trabalho_dcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class EditarTarefa extends AppCompatActivity {

    private EditText txt_titulo;
    private EditText txt_descricao;
    private EditText txt_dificuldade;
    private EditText txt_estado;
    private ListView listView_adicionar_etiquetas;

    private Button btnEditarTarefa;
    private TarefaAdapter tarefaAdapter;
    private EtiquetaAdapter etiquetaAdapter;

    private Long idTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tarefa);

        txt_titulo = (EditText) findViewById(R.id.txt_editar_titulo);
        txt_descricao = (EditText) findViewById(R.id.txt_editar_descricao);
        txt_dificuldade = (EditText) findViewById(R.id.txt_editar_dificuldade);
        txt_estado = (EditText) findViewById(R.id.txt_editar_estado);
        listView_adicionar_etiquetas = (ListView) findViewById(R.id.lv_adicionar_etiquetas);
        btnEditarTarefa = (Button) findViewById(R.id.btn_ed_tarefa);

        Intent i = getIntent();
        idTarefa = i.getLongExtra("ID_TAREFA", 0);

        tarefaAdapter = new TarefaAdapter(getApplicationContext(), null);
        etiquetaAdapter = new EtiquetaAdapter(getApplicationContext(), null);

        listView_adicionar_etiquetas.setAdapter(etiquetaAdapter);
        etiquetaAdapter.atualizar();

        listView_adicionar_etiquetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent i = new Intent();
                //long id = i.getLongExtra("TAREFA_ID", 0);

                tarefaAdapter.insertEtiqueta(idTarefa, id);
                Log.e("idTarefa", idTarefa.toString());
                //Log.e("idTarefaIntent", String.valueOf(i.getLongExtra("TAREFA_ID", 0)));
                Log.e("idEtiqueta", String.valueOf(id));
                Toast.makeText(getApplicationContext(), "Etiqueta adicionada", Toast.LENGTH_SHORT).show();
            }
        });



        btnEditarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tarefa tarefa = new Tarefa();
                Integer dificuldade, estado;

                try {
                    dificuldade = Integer.valueOf(txt_dificuldade.getText().toString());
                } catch (NumberFormatException e) {
                    dificuldade = null;
                }

                try {
                    estado = Integer.valueOf(txt_estado.getText().toString());
                } catch (NumberFormatException e) {
                    estado = null;
                }

                tarefa.setId(idTarefa);
                if (!txt_titulo.getText().toString().isEmpty())
                    tarefa.setTitulo(txt_titulo.getText().toString());
                if (!txt_descricao.getText().toString().isEmpty())
                    tarefa.setDescricao(txt_descricao.getText().toString());
                tarefa.setDificuldade(dificuldade);
                tarefa.setEstado(estado);

                tarefaAdapter.update(tarefa);
                Toast.makeText(getApplicationContext(), "Tarefa editada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
