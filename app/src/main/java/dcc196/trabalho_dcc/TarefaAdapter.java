package dcc196.trabalho_dcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import static dcc196.trabalho_dcc.DatabaseContract.Tarefa.COLUMN_NAME_DESCRICAO;
import static dcc196.trabalho_dcc.DatabaseContract.Tarefa.COLUMN_NAME_DIFICULDADE;
import static dcc196.trabalho_dcc.DatabaseContract.Tarefa.COLUMN_NAME_ESTADO;
import static dcc196.trabalho_dcc.DatabaseContract.Tarefa.COLUMN_NAME_TITULO;

/**
 * Created by Vitor on 03/12/2017.
 */

public class TarefaAdapter extends CursorAdapter{
    private DBHelper dbHelper;

    public TarefaAdapter(Context context, Cursor c) {
        super(context, c, 0);
        dbHelper = DBHelper.getInstance(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.listview_layout,viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv_titulo = (TextView) view.findViewById(R.id.textview_titulo);
        String titulo = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.Tarefa.COLUMN_NAME_TITULO)) + " - " +
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_ESTADO));
        tv_titulo.setText(titulo);
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String[] visao = {
                    DatabaseContract.Tarefa._ID,
                    COLUMN_NAME_TITULO,
                    COLUMN_NAME_ESTADO
            };
            String sort = DatabaseContract.Tarefa.COLUMN_NAME_ESTADO + " ASC";
            Cursor c = db.query(DatabaseContract.Tarefa.TABLE_NAME, visao, null, null, null, null, sort);
            this.changeCursor(c);

        } catch (Exception e) {
            Log.e("TAREFA", e.getLocalizedMessage());
            Log.e("TAREFA", e.getStackTrace().toString());
        }
    }

    public void atualizar(String rawQuery) {
        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor c = db.rawQuery(rawQuery, null);
            Log.e("SQL", rawQuery);
            this.changeCursor(c);

        } catch (Exception e) {
            Log.e("Tarefa - rawquery", e.getLocalizedMessage());
            Log.e("Tarefa - rawquery", e.getStackTrace().toString());
        }
    }

    public void inserir(Tarefa tarefa){
        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COLUMN_NAME_TITULO, tarefa.getTitulo());
            values.put(COLUMN_NAME_DESCRICAO, tarefa.getDescricao());
            values.put(COLUMN_NAME_DIFICULDADE, tarefa.getDificuldade());
            values.put(COLUMN_NAME_ESTADO, tarefa.getEstado());

            long id = db.insert(DatabaseContract.Tarefa.TABLE_NAME, null, values);
        } catch (Exception e) {
            Log.e("TAREFA", e.getLocalizedMessage());
            Log.e("TAREFA", e.getStackTrace().toString());
        }
    }

    public void update(Tarefa tarefa) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        if (tarefa.getTitulo() != null)
            values.put("titulo", tarefa.getTitulo());
        if(tarefa.getDescricao() != null)
            values.put("descricao", tarefa.getDescricao());
        if(tarefa.getDificuldade() != null)
            values.put("dificuldade", tarefa.getDificuldade());
        if(tarefa.getEstado() != null)
            values.put("estado", tarefa.getEstado());

        db.update(DatabaseContract.Tarefa.TABLE_NAME, values, "_id="+tarefa.getId(), null);
    }

    public void insertEtiqueta(Long idTarefa, Long idEtiqueta) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valuesEtiqueta = new ContentValues();

        valuesEtiqueta.put("idTarefa", idTarefa);
        valuesEtiqueta.put("idEtiqueta", idEtiqueta);

        db.insert(DatabaseContract.TarefaEtiqueta.TABLE_NAME, null, valuesEtiqueta);
    }
}
