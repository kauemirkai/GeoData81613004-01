package br.usjt.desmob.geodata;

/**
 * Created by kauemirkai on 15/04/2018.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.desmob.geodata.PaisDbContract.PaisContract;

public class PaisDbHelper extends SQLiteOpenHelper {
    public static final PaisDbContract CONTRACT = new PaisDbContract();
    public static final String SQL_CREATE_FILA =
            "CREATE TABLE " + PaisContract.TABLE_NAME + "(" +
                    PaisContract._ID +" INTEGER PRIMARY KEY,"
                    + PaisContract.nome +" INTEGER, "
                    + PaisContract.codigo3 + " TEXT, "
                    + PaisContract.capital + " TEXT,"
                    + PaisContract.regiao +" TEXT, "
                    + PaisContract.subRegiao +" TEXT, "
                    + PaisContract.demonimo +" TEXT, "
                    + PaisContract.area +" INT, "
                    + PaisContract.bandeira +"BLOB, "
                    + PaisContract.figura +"TEXT, "
                    + PaisContract.gini +" DOUBLE, "
                    + PaisContract.idiomas +" TEXT, "
                    + PaisContract.moedas +" TEXT, "
                    + PaisContract.dominios +" TEXT, "
                    + PaisContract.fusos +" TEXT, "
                    + PaisContract.fronteiras +" TEXT, "
                    + PaisContract.latitude +" DOUBLE, "
                    + PaisContract.longitude +" DOUBLE) "



            ;



    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Fila.db";

    public static final String SQL_DROP_FILA = "DROP TABLE IF EXISTS " + PaisContract.TABLE_NAME;

    public PaisDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_FILA);
        db.execSQL(SQL_CREATE_FILA);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FILA);
    }
}





