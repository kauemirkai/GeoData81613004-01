package br.usjt.desmob.geodata;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kauemirkai on 15/04/2018.
 */

public class PaisNetworking {
    public static ArrayList<Pais> _paises =null ;

    public static ArrayList<Pais> getPaises(String urlRest, String urlImg) throws IOException {
        if( _paises == null){
            _paises = buscarPaises(urlRest);

        }
        for (Pais pais:_paises){
            pais.setBandeira(getFigura(urlImg));


        }
        return _paises;

    }

    public static ArrayList<Pais> buscarPaises(String url) throws IOException {
        ArrayList<Pais> paises = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        try {
            JSONArray lista = new JSONArray(json);
            for (int i = 0; i < lista.length(); i++) {
                JSONObject item = (JSONObject) lista.get(i);
                Pais pais = new Pais();
                pais.setNome(item.getString("name"));
                pais.setCodigo3(item.getString("alpha3Code"));
                pais.setCapital(item.getString("capital"));
                pais.setRegiao(item.getString("region"));
                pais.setSubRegiao(item.getString("subregion"));
                pais.setDemonimo(item.getString("demonym"));
                pais.setPopulacao(item.getInt("populacao"));
                pais.setArea(item.getInt("area"));
                pais.setGini(item.getDouble("gini"));
                pais.setLatitude(item.getDouble("latlng"));
                pais.setLongitude(item.getDouble("latlng"));


                ArrayList<String> idiomas = new ArrayList<>();
                JSONArray jArray = item.getJSONArray("languages");
                if (jArray != null) {
                    for (int k =0;k<jArray.length();k++){
                        idiomas.add(jArray.getString(k));
                    }
                }

                pais.setIdiomas(idiomas);




                ArrayList<String> moedas = new ArrayList<>();
                jArray = item.getJSONArray("currencies");
                if (jArray != null) {
                    for (int p=0 ; p <jArray.length();p++){
                        moedas.add(jArray.getString(p));
                    }
                }

                pais.setMoedas(moedas);

                ArrayList<String> dominios = new ArrayList<>();
                jArray = item.getJSONArray("regionalBlocs");
                if (jArray != null) {
                    for (int c =0;c <jArray.length();c++){
                        dominios.add(jArray.getString(c));
                    }
                }

                pais.setDominios(dominios);



                ArrayList<String> fusos = new ArrayList<>();
                jArray = item.getJSONArray("timezones");
                if (jArray != null) {
                    for (int e=0;e<jArray.length();e++){
                        fusos.add(jArray.getString(e));
                    }
                }

                pais.setDominios(fusos);

                ArrayList<String> fronteiras = new ArrayList<>();
                jArray = item.getJSONArray("borders");
                if (jArray != null) {
                    for (int l=0;l<jArray.length();l++){
                        fronteiras.add(jArray.getString(l));
                    }
                }

                pais.setDominios(fronteiras);


                paises.add(pais);


            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }


        return paises;
    }
    public static Bitmap getFigura(String url) throws IOException{
        Bitmap img = null;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        InputStream is = response.body().byteStream();

        img = BitmapFactory.decodeStream(is);
        is.close();

        return img;
    }


}
