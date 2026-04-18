package com.parcial.composicion;
import com.parcial.criaturas.Criatura;

public class Arma {
    
    private String nombre;
    private int dañoAdicional;

    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = dañoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }

    public void setDañoAdicional(int dañoAdicional) {
        this.dañoAdicional = dañoAdicional;
    }

    public void atacarConArma(Criatura objetivo) {
        System.out.println("Ataque con arma '" +nombre+ "' causando " +dañoAdicional+ " de daño adicional.");
        objetivo.defender(dañoAdicional);
    }

    public int getDañoAdicional(int base) {
        return base + dañoAdicional;
    }
}