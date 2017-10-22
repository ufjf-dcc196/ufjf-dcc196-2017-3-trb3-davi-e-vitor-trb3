package dcc196.trabalho_dcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import dcc196.trabalho_dcc.model.Livro;
import dcc196.trabalho_dcc.model.Participante;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarParticipante;
    private Button btnCadastrarReserva;
    private Button btnCadastrarLivro;
    private ListView lvParticipantes;
    private ParticipanteHelper ph;
    private LivroHelper lh;
    private ReservaHelper rh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrarParticipante = (Button) findViewById(R.id.btnCadastrarParticipante);
        btnCadastrarReserva = (Button) findViewById(R.id.btnCadastrarReserva);
        btnCadastrarLivro = (Button) findViewById(R.id.btnCadastrarLivro);
        lvParticipantes = (ListView) findViewById(R.id.lvParticipantes);
        ph = new ParticipanteHelper();
        lh = new LivroHelper();
        rh = new ReservaHelper();

        //Carregamento de dados
        Participante p1 = new Participante();
        p1.setNomeCompleto("Davi de Almeida");
        p1.setEmail("davi.c@gmail.com");
        ph.criar(p1);
        Participante p2 = new Participante();
        p2.setNomeCompleto("Ricardo Tuboly");
        p2.setEmail("ricardo.c@gmail.com");
        ph.criar(p2);

        Livro l1 = new Livro();
        l1.setTitulo("Senhor dos Anéis");
        l1.setEditora("Almenara");
        l1.setAnoPlubicacao("2000");
        lh.criar(l1);

        Livro l2 = new Livro();
        l2.setTitulo("Senhor dos Anéis");
        l2.setEditora("Almenara");
        l2.setAnoPlubicacao("2000");
        lh.criar(l2);

        List<Participante> participantes = ph.listarParticipantes();

        ArrayAdapter<Participante> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, participantes);

        lvParticipantes.setAdapter(adapter);



    }
}
