package dcc196.trabalho_dcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora;  // Ou qualquer outra forma que tem
        //String dataFormatada = sdf.format(hora);

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

        final List<Participante> participantes = ph.listarParticipantes();

        ArrayAdapter<Participante> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, participantes);

        lvParticipantes.setAdapter(adapter);

        btnCadastrarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroReserva.class);
                startActivity(intent);
            }


        });

        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroLivro.class);
                startActivity(intent);
            }
        });

        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroParticipante.class);
                startActivity(intent);
            }
        });

        lvParticipantes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                Participante p = participantes.get(position);

                if (p.getHoraEntrada().equals(null)) {
                    p.setHoraEntrada(Calendar.getInstance().getTime());
                    Toast.makeText(getApplicationContext(), "HoraEntrada atualizada", Toast.LENGTH_SHORT).show();
                } else if (p.getHoraSaída().equals(null)) {
                    p.setHoraSaída(Calendar.getInstance().getTime());
                    Toast.makeText(getApplicationContext(), "HoraSaida atualizada", Toast.LENGTH_SHORT).show();
                } else {
                    p.setHoraEntrada(null);
                    p.setHoraSaída(null);
                    Toast.makeText(getApplicationContext(), "Horas de entrada e saidas resetadas", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        lvParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalheParticipante.class);
                startActivity(intent);
            }
        });
    }
}
