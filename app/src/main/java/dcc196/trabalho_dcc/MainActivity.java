package dcc196.trabalho_dcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarEtiquetas;
    private Button btnCadastrarTarefas;
    private Button btnVisualizarEtiquetas;
    private Button btnVisualizarTarefas;
    private ListView listview_main;


    @Override
    protected void onResume() {
        super.onResume();
        //BaseAdapter adapter = (BaseAdapter) listview_main.getAdapter();
        //adapter.notifyDataSetChanged();
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


        btnCadastrarTarefas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

        btnCadastrarEtiquetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnVisualizarTarefas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnVisualizarEtiquetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
