package br.usjt.desmob.geodata;


import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Nome: Kauê Victor Paz Garcia Mirkai.
 * Ra:81613004.
 * Turma:CCP3AN-MCA
 * Professor:Bonato.
 * Documentação:Esta classe modela o conceito de Pais na aplicação, temos também o metodo ToString
 */
public class Pais implements Serializable{
    private String nome;
    private String codigo3;
    private String capital;
    private String regiao;
    private String subRegiao;
    private String demonimo;
    private int populacao;
    private int area;
    private Bitmap bandeira;
    private String figura;
    private double gini;
    private ArrayList<String> idiomas;
    private ArrayList<String> moedas;
    private ArrayList<String> dominios;
    private ArrayList<String> fusos;
    private ArrayList<String> fronteiras;
    private double latitude;


    private double longitude;


    public Bitmap getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bitmap bandeira) {
        this.bandeira = bandeira;
    }


    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    /**
     * Nome: Kauê Victor Paz Garcia Mirkai.
     * Ra:81613004.
     * Turma:CCP3AN-MCA
     * Professor:Bonato.
     * Documentação:Gets and setters
     */

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getDemonimo() {
        return demonimo;
    }

    public void setDemonimo(String demonimo) {
        this.demonimo = demonimo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }


    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<String> moedas) {
        this.moedas = moedas;
    }

    public ArrayList<String> getDominios() {
        return dominios;
    }

    public void setDominios(ArrayList<String> dominios) {
        this.dominios = dominios;
    }

    public ArrayList<String> getFusos() {
        return fusos;
    }

    public void setFusos(ArrayList<String> fusos) {
        this.fusos = fusos;
    }

    public ArrayList<String> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(ArrayList<String> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Nome: Kauê Victor Paz Garcia Mirkai.
     * Ra:81613004.
     * Turma:CCP3AN-MCA
     * Professor:Bonato.
     * Documentação:ToString
     */

    @Override
    public String toString() {
        return "Pais{" +
                "\nnome='" + nome + '\'' +
                "\ncodigo3='" + codigo3 + '\'' +
                "\ncapital='" + capital + '\'' +
                "\nregiao='" + regiao + '\'' +
                "\nsubRegiao='" + subRegiao + '\'' +
                "\ndemonimo='" + demonimo + '\'' +
                "\npopulacao=" + populacao +
                "\narea=" + area +
                "\nbandeira='" + bandeira + '\'' +
                "\ngini=" + gini +
                "\nidiomas=" + idiomas +
                "\nmoedas=" + moedas +
                "\ndominios=" + dominios +
                "\nfusos=" + fusos +
                "\nfronteiras=" + fronteiras +
                "\nlatitude=" + latitude +
                "\nlongitude=" + longitude +
                "\n}";
    }

}

