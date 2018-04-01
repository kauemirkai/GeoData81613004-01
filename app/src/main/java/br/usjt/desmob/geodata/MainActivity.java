package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;




/**
 * Nome: Kauê Victor Paz Garcia Mirkai.
 * Ra:81613004.
 * Turma:CCP3AN-MCA
 * Professor:Bonato.
 * Documentação: MainActivity
 */

public class MainActivity extends Activity {
    Spinner spinnerContinente;
    public static final String CHAVE = "br.usjt.desmob.geodata.txtContinente";
    public static final String PAISES = "br.usjt.desmob.geodata.paises";
    String continente = "Todos";

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
        spinnerContinente = (Spinner)findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new PaisSelecionado());
    }

    /**
     * Nome: Kauê Victor Paz Garcia Mirkai.
     * Ra:81613004.
     * Turma:CCP3AN-MCA
     * Professor:Bonato.
     * Documentação: Este metodo é chamado ao clickar no botão listar. Ele starta a proxima activity e passa a chave do continente
     * sendo todos, ou um continente especifico
     */

    public void listarPaises(View view){
        Intent intent = new Intent(this, ListaPaisesActivity.class);

        intent.putExtra(CHAVE, continente);
        startActivity(intent);
    }

    /**
     * Nome: Kauê Victor Paz Garcia Mirkai.
     * Ra:81613004.
     * Turma:CCP3AN-MCA
     * Professor:Bonato.
     * Documentação:
     */

    private class PaisSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continente = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
