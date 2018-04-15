package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Nome: Kauê Victor Paz Garcia Mirkai.
 * Ra:81613004.
 * Turma:CCP3AN-MCA
 * Professor:Bonato.
 * Documentação: MainActivity
 */

public class MainActivity extends Activity {
    public static final String CHAVE = "br.usjt.desmob.geodata.txtContinente";
    public static final String PAISES = "br.usjt.desmob.geodata.paises";
    String continente = "Todos";
    private EditText txtNome;
    Context contexto;

    /**
     * Nome: Kauê Victor Paz Garcia Mirkai.
     * Ra:81613004.
     * Turma:CCP3AN-MCA
     * Professor:Bonato.
     * Documentação: Chamada do Spinner em strings.xml, onde estamos pegando os textos que aparecem no dropbox.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_paises);
        contexto = this;
        new DownloadJsonPaises().execute("https://restcountries.eu/rest/v2/all");

    }


    private class  DownloadJsonPaises extends AsyncTask<String, Void,ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> pais = new ArrayList<>();
            try {
                pais = PaisNetworking.buscarPaises("https://restcountries.eu/rest/v2/all");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return pais;

        }


        protected  void onPostExecute(ArrayList<Pais> paises){
            Intent intent = new Intent(contexto, ListaPaisesActivity.class);
            intent.putExtra(PAISES, paises);
            startActivity(intent);

        }



}
}
