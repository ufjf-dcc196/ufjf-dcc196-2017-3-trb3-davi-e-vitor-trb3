package dcc196.trabalho_dcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroTarefa extends AppCompatActivity {

    private EditText txt_titulo;
    private EditText txt_descricao;
    private EditText txt_dificuldade;

    private Button btnCadastroTarefa;

    private TarefaAdapter tarefaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tarefa);

        txt_titulo = (EditText) findViewById(R.id.txt_titulo);
        txt_descricao = (EditText) findViewById(R.id.txt_descricao);
        txt_dificuldade = (EditText) findViewById(R.id.txt_dificuldade);
        btnCadastroTarefa = (Button) findViewById(R.id.btn_cadastro_tarefa);

        tarefaAdapter = new TarefaAdapter(getApplicationContext(), null);

        btnCadastroTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer dificuldade;

                try {
                    dificuldade = Integer.valueOf(txt_dificuldade.getText().toString());
                } catch (NumberFormatException e) {
                    dificuldade = null;
                }

                Tarefa tarefa = new Tarefa();
                tarefa.setTitulo(txt_titulo.getText().toString());
                tarefa.setDescricao(txt_descricao.getText().toString());
                tarefa.setDificuldade(dificuldade);
                tarefa.setEstado(Estado.A_FAZER);
                tarefaAdapter.inserir(tarefa);
                Toast.makeText(getApplicationContext(), "Tarefa cadastrada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
