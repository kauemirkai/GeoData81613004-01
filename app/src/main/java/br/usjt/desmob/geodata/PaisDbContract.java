package br.usjt.desmob.geodata;

import android.provider.BaseColumns;

/**
 * Created by kauemirkai on 15/04/2018.
 */
public final class PaisDbContract {

    public PaisDbContract(){


    }


public static abstract class PaisContract implements BaseColumns {
    public static final String TABLE_NAME = "Pais";
    public static final String nome = "nome";
    public static final String codigo3 = "codigo3";
    public static final String capital = "capital";
    public static final String regiao = "regiao";
    public static final String subRegiao = "subRegiao";
    public static final String demonimo = "demonimo";
    public static final String area = "area";
    public static final String bandeira = "bandeira";
    public static final String figura = "figura";
    public static final String gini = "gini";
    public static final String idiomas = "idiomas";
    public static final String moedas = "moedas";
    public static final String dominios = "dominios";
    public static final String fusos = "fusos";
    public static final String fronteiras = "fronteiras";
    public static final String latitude = "latitude";
    public static final String longitude = "longitude";


}
}