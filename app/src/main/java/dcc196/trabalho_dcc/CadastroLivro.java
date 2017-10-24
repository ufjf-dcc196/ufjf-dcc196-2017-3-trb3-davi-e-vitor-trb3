package dcc196.trabalho_dcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dcc196.trabalho_dcc.model.Livro;

public class CadastroLivro extends AppCompatActivity {

    private Button btnCadastrarLivro;
    private EditText campoTitulo;
    private EditText campoEditora;
    private EditText campoAnoPubliicacao;
    private LivroHelper lh = LivroHelper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        btnCadastrarLivro = (Button) findViewById(R.id.btnSalvarLivro);
        campoTitulo = (EditText) findViewById(R.id.txtCampoTitulo);
        campoEditora = (EditText) findViewById(R.id.txtCampoEditora);
        campoAnoPubliicacao = (EditText) findViewById(R.id.txtCampoAnoPublicacao);

        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Livro livro = new Livro();
                livro.setTitulo(campoTitulo.getText().toString());
                livro.setEditora(campoEditora.getText().toString());
                livro.setAnoPlubicacao(campoAnoPubliicacao.getText().toString());
                lh.criar(livro);
            }
        });
    }
}
