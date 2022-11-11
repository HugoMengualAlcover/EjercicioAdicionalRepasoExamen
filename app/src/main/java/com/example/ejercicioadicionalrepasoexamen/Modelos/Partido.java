package com.example.ejercicioadicionalrepasoexamen.Modelos;

public class Partido {
    String result;
    String equipo1;
    String equipo2;

    public Partido(String result, String equipo1, String equipo2) {
        this.result = result;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
}
