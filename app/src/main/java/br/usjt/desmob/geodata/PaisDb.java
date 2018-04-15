package br.usjt.desmob.geodata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by kauemirkai on 15/04/2018.
 */

public class PaisDb {
    private PaisDbHelper dbHelper;

    public PaisDb(Context context) {
        dbHelper = new PaisDbHelper(context);

    }

    public void inserirPais(ArrayList<Pais> paises){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        for(Pais pais:paises){
            values.put(PaisDbContract.PaisContract.nome, pais.getNome());
            values.put(PaisDbContract.PaisContract.codigo3, pais.getCodigo3());
            values.put(PaisDbContract.PaisContract.capital, pais.getCapital());
            values.put(PaisDbContract.PaisContract.regiao, pais.getRegiao());
            values.put(PaisDbContract.PaisContract.subRegiao, pais.getSubRegiao());
            values.put(PaisDbContract.PaisContract.demonimo, pais.getDemonimo());
            values.put(PaisDbContract.PaisContract.figura, pais.getFigura());
            values.put(PaisDbContract.PaisContract.gini, pais.getGini());
            //values.put(PaisDbContract.PaisContract.idiomas, pais.getIdiomas());
            //values.put(PaisDbContract.PaisContract.moedas, pais.getMoedas());
            //values.put(PaisDbContract.PaisContract.dominios, pais.getDominios());
            //values.put(PaisDbContract.PaisContract.fusos, pais.getFusos());
            //values.put(PaisDbContract.PaisContract.fronteiras, pais.getFronteiras());
            values.put(PaisDbContract.PaisContract.latitude, pais.getLatitude());
            values.put(PaisDbContract.PaisContract.longitude, pais.getLongitude());



            //values.put(PaisDbContract.PaisContract.bandeira, pais.getBandeira());

            db.insert(PaisDbContract.PaisContract.TABLE_NAME,null,values);

        }
        db.close();


    }

    public ArrayList<Pais> listarPais(){
        ArrayList<Pais> paises  = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = {PaisDbContract.PaisContract.nome, PaisDbContract.PaisContract.codigo3, PaisDbContract.PaisContract.capital,PaisDbContract.PaisContract.regiao
        ,PaisDbContract.PaisContract.subRegiao,PaisDbContract.PaisContract.demonimo,PaisDbContract.PaisContract.area,PaisDbContract.PaisContract.bandeira,PaisDbContract.PaisContract.figura
                ,PaisDbContract.PaisContract.gini,PaisDbContract.PaisContract.idiomas
        ,PaisDbContract.PaisContract.moedas,PaisDbContract.PaisContract.fusos,PaisDbContract.PaisContract.fronteiras,PaisDbContract.PaisContract.latitude,PaisDbContract.PaisContract.longitude
        };

        String orderBy = PaisDbContract.PaisContract.nome;

        Cursor c ;
        c = db.query(PaisDbContract.PaisContract.TABLE_NAME, colunas, null, null, null, null,orderBy,null);

        while (c.moveToNext()){
            Pais pais = new Pais();
            pais.setNome(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.nome)));
            pais.setCodigo3(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.codigo3)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.capital)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.regiao)));
            pais.setSubRegiao(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.subRegiao)));
            pais.setDemonimo(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.demonimo)));
            pais.setArea(c.getInt(c.getColumnIndex(PaisDbContract.PaisContract.area)));

            pais.setFigura(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.figura)));
            pais.setGini(c.getDouble(c.getColumnIndex(PaisDbContract.PaisContract.gini)));
            //pais.setIdiomas(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.idiomas)));
            //pais.setNome(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.moedas)));
            //pais.setNome(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.dominios)));
            //pais.setNome(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.fusos)));
            //pais.setNome(c.getString(c.getColumnIndex(PaisDbContract.PaisContract.fronteiras)));
            pais.setLatitude(c.getDouble(c.getColumnIndex(PaisDbContract.PaisContract.latitude)));
            pais.setLongitude(c.getDouble(c.getColumnIndex(PaisDbContract.PaisContract.longitude)));

            paises.add(pais);

        }

        c.close();
        db.close();

        return paises;




    }

}
