package dcc196.trabalho_dcc;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarEtiquetas;
    private Button btnCadastrarTarefas;
    private Button btnVisualizarEtiquetas;
    private Button btnVisualizarTarefas;
    private ListView listview_main;

    private TarefaAdapter tarefaAdapter;
    private EtiquetaAdapter etiquetaAdapter;
    private DBHelper dbHelper;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVisualizarEtiquetas = (Button) findViewById(R.id.btnVisualizarEtiquetas);
        btnCadastrarEtiquetas = (Button) findViewById(R.id.btnCadastrarEtiquetas);
        btnCadastrarTarefas = (Button) findViewById(R.id.btnCadastrarTarefas);
        btnVisualizarTarefas = (Button) findViewById(R.id.btnVisualizarTarefas);
        listview_main = (ListView) findViewById(R.id.listview_main);

        dbHelper = DBHelper.getInstance(getApplicationContext());

        tarefaAdapter = new TarefaAdapter(getApplicationContext(), null);
        tarefaAdapter.atualizar();

        etiquetaAdapter = new EtiquetaAdapter(getApplicationContext(), null);
        etiquetaAdapter.atualizar();


        btnCadastrarTarefas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroTarefa.class);
                startActivity(intent);
            }

        });

        btnCadastrarEtiquetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroEtiqueta.class);
                startActivity(intent);
            }
        });

        btnVisualizarTarefas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listview_main.setAdapter(tarefaAdapter);
                tarefaAdapter.atualizar();
            }
        });

        btnVisualizarEtiquetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listview_main.setAdapter(etiquetaAdapter);
                etiquetaAdapter.atualizar();
            }
        });


        listview_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listview_main.getAdapter().equals(etiquetaAdapter)) {
                    Intent intent = new Intent(MainActivity.this, DetalheEtiqueta.class);
                    intent.putExtra("ID_ETIQUETA", id);
                    startActivity(intent);
                } else if (listview_main.getAdapter().equals(tarefaAdapter)) {
                    Intent intent = new Intent(MainActivity.this, EditarTarefa.class);
                    intent.putExtra("ID_TAREFA", id);
                    startActivity(intent);
                }
            }
        });

        listview_main.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String whereClause = "_id=?";
                String[] whereArgs = {String.valueOf(id)};

                db.delete(DatabaseContract.Tarefa.TABLE_NAME, whereClause, whereArgs);
                tarefaAdapter.atualizar();
                return true;
            }
        });

    }
}
