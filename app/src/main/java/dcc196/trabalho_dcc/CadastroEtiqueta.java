package dcc196.trabalho_dcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroEtiqueta extends AppCompatActivity {

    private EditText txt_nome_etiqueta;
    private Button btn_cadastro_etiqueta;

    private EtiquetaAdapter etiquetaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_etiqueta);

        txt_nome_etiqueta = (EditText) findViewById(R.id.txt_nome_etiqueta);
        btn_cadastro_etiqueta = (Button) findViewById(R.id.btn_cadastro_etiqueta);

        etiquetaAdapter = new EtiquetaAdapter(getApplicationContext(), null);

        btn_cadastro_etiqueta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Etiqueta etiqueta = new Etiqueta();
                etiqueta.setNome(txt_nome_etiqueta.getText().toString());
                etiquetaAdapter.inserir(etiqueta);
                Toast.makeText(getApplicationContext(), "Etiqueta cadastrada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
