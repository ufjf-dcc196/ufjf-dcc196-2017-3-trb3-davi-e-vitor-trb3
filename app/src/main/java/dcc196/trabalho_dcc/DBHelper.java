package dcc196.trabalho_dcc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vitor on 03/12/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    private static DBHelper sInstance;
    private static final String DATABASE_NAME = "trbtres";
    private static final int DATABASE_VERSION = 3;

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.SQL_CREATE_TAREFA);
        db.execSQL(DatabaseContract.SQL_CREATE_ETIQUETA);
        db.execSQL(DatabaseContract.SQL_CREATE_TAREFA_ETIQUETA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseContract.SQL_DROP_TAREFA);
        db.execSQL(DatabaseContract.SQL_DROP_ETIQUETA);
        db.execSQL(DatabaseContract.SQL_DROP_TAREFA_ETIQUETA);
        onCreate(db);
    }
}
