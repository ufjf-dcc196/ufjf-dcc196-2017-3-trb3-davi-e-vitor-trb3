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

/**
 * Created by Vitor on 03/12/2017.
 */

public class EtiquetaAdapter extends CursorAdapter {
    private DBHelper dbHelper;

    public EtiquetaAdapter(Context context, Cursor c) {
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
        String titulo = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.Etiqueta.COLUMN_NAME_NOME));
        tv_titulo.setText(titulo);
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String[] visao = {
                    DatabaseContract.Etiqueta._ID,
                    DatabaseContract.Etiqueta.COLUMN_NAME_NOME
            };
            Cursor c = db.query(DatabaseContract.Etiqueta.TABLE_NAME, visao, null, null, null, null, null);
            this.changeCursor(c);

        } catch (Exception e) {
            Log.e("ETIQUETA", e.getLocalizedMessage());
            Log.e("ETIQUETA", e.getStackTrace().toString());
        }
    }

    public void inserir(Etiqueta etiqueta){
        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(DatabaseContract.Etiqueta.COLUMN_NAME_NOME, etiqueta.getNome());

            long id = db.insert(DatabaseContract.Etiqueta.TABLE_NAME, null, values);
            atualizar();
        } catch (Exception e) {
            Log.e("ETIQUETA", e.getLocalizedMessage());
            Log.e("ETIQUETA", e.getStackTrace().toString());
        }
    }
}
