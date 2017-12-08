package dcc196.trabalho_dcc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class DetalheEtiqueta extends AppCompatActivity {

    private TextView txt_nome_etiqueta;
    private ListView listview_tarefas;

    private DBHelper dbHelper;
    private TarefaAdapter tarefaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_etiqueta);

        txt_nome_etiqueta = (TextView) findViewById(R.id.txt_d_etiqueta_nome);
        listview_tarefas = (ListView) findViewById(R.id.lv_detalhe_etiqueta);

        Intent i = getIntent();
        long id = i.getLongExtra("ID_ETIQUETA",0);
        txt_nome_etiqueta.setText(nomeEtiqueta(id));

        String rawQuery = "SELECT * FROM " + DatabaseContract.TarefaEtiqueta.TABLE_NAME + " tr" +
                " INNER JOIN " + DatabaseContract.Etiqueta.TABLE_NAME + " tl ON tr." + DatabaseContract.TarefaEtiqueta.COLUMN_NAME_ID_ETIQUETA + " = tl." +
                DatabaseContract.Etiqueta._ID + " INNER JOIN " + DatabaseContract.Tarefa.TABLE_NAME + " tp ON tr." +
                DatabaseContract.TarefaEtiqueta.COLUMN_NAME_ID_TAREFA + " = tp." + DatabaseContract.Tarefa._ID;

        tarefaAdapter = new TarefaAdapter(getApplicationContext(), null);
        tarefaAdapter.atualizar(rawQuery);


        listview_tarefas.setAdapter(tarefaAdapter);
        tarefaAdapter.atualizar(rawQuery);


    }

    public String nomeEtiqueta(long id) {
        dbHelper = DBHelper.getInstance(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] visao = {
                DatabaseContract.Etiqueta._ID,
                DatabaseContract.Etiqueta.COLUMN_NAME_NOME,
        };

        String selecao = DatabaseContract.Etiqueta._ID + " = ?";
        String[] args = {Long.toString(id)};
        Cursor c = db.query(DatabaseContract.Etiqueta.TABLE_NAME, visao, selecao, args, null, null, null);
        c.moveToFirst();

        return c.getString(c.getColumnIndexOrThrow(DatabaseContract.Etiqueta.COLUMN_NAME_NOME));
    }
}
