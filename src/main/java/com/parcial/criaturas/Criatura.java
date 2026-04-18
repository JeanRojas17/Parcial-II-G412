package com.parcial.criaturas;

public abstract class Criatura {

    protected String nombre;
    protected int salud;
    protected int fuerza;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }
    
    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public abstract void atacar(Criatura objetivo);

    public abstract void defender(int daño);

    public boolean estaViva() {
        return salud > 0;
    }

    @Override
    public String toString() {
        return nombre+ " | Salud: " +salud+ " | Fuerza: " +fuerza;
    }
}