package dcc196.trabalho_dcc;

import android.provider.BaseColumns;

/**
 * Created by Vitor on 03/12/2017.
 */

public class DatabaseContract {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String SEP = ",";

    public static final String SQL_CREATE_TAREFA = "CREATE TABLE " + Tarefa.TABLE_NAME + " (" +
            Tarefa._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Tarefa.COLUMN_NAME_TITULO + TEXT_TYPE + SEP +
            Tarefa.COLUMN_NAME_DESCRICAO + TEXT_TYPE + SEP +
            Tarefa.COLUMN_NAME_DIFICULDADE + INT_TYPE + SEP +
            Tarefa.COLUMN_NAME_ESTADO + INT_TYPE + ")";
    public static final String SQL_DROP_TAREFA = "DROP TABLE IF EXISTS " + Tarefa.TABLE_NAME;


    public static final String SQL_CREATE_ETIQUETA = "CREATE TABLE " + Etiqueta.TABLE_NAME + " (" +
            Etiqueta._ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + SEP +
            Etiqueta.COLUMN_NAME_NOME + TEXT_TYPE + ")";
    public static final String SQL_DROP_ETIQUETA = "DROP TABLE IF EXISTS " + Etiqueta.TABLE_NAME;


    public static final String SQL_CREATE_TAREFA_ETIQUETA = "CREATE TABLE " + TarefaEtiqueta.TABLE_NAME + " (" +
            TarefaEtiqueta._ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + SEP +
            TarefaEtiqueta.COLUMN_NAME_ID_TAREFA + INT_TYPE + SEP +
            TarefaEtiqueta.COLUMN_NAME_ID_ETIQUETA + INT_TYPE + ")";
    public static final String SQL_DROP_TAREFA_ETIQUETA = "DROP TABLE IF EXISTS " + TarefaEtiqueta.TABLE_NAME;


    private DatabaseContract() {
    }

    public static final class Tarefa implements BaseColumns {
        public static final String TABLE_NAME = "tarefa";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_DIFICULDADE = "dificuldade";
        public static final String COLUMN_NAME_ESTADO = "estado";
    }

    public static final class Etiqueta implements BaseColumns {
        public static final String TABLE_NAME = "etiqueta";
        public static final String COLUMN_NAME_NOME = "nome";
    }

    public static final class TarefaEtiqueta implements BaseColumns {
        public static final String TABLE_NAME = "tarefa_etiqueta";
        public static final String COLUMN_NAME_ID_TAREFA = "idTarefa";
        public static final String COLUMN_NAME_ID_ETIQUETA = "idEtiqueta";
    }

}
