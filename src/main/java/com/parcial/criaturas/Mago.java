package com.parcial.criaturas;
import com.parcial.composicion.Arma;
import com.parcial.interfaces.IMagico;

public class Mago extends Criatura implements IMagico {
    
    private String hechizos;
    private Arma arma;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    public String getHechizos() {
        return hechizos;
    }

    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre+ " ha equipado el arma: " +arma.getNombre());
    }

    public void desequiparArma() {
        System.out.println(nombre+ " ha desequipado el arma: " +arma.getNombre());
        this.arma = null;
    }

    @Override
    public void atacar(Criatura objetivo) {
        System.out.println(nombre+ " lanza un hechizo a " +objetivo.getNombre()+ " causando " +fuerza+ " de daño.");
        objetivo.defender(fuerza);

        if(arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    @Override
    public void defender(int daño) {
        salud -= daño;

        if(salud < 0) {
            salud = 0;
        }

        System.out.println(nombre+ " recibe " +daño+ " de daño mágico. Salud restante: " +salud);
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre+ " lanza el hechizo: " +hechizos);
    }

    @Override
    public void aprenderHechizo() {
        System.out.println(nombre+ " aprende un nuevo hechizo y lo agrega a: " + hechizos);
    }

    @Override
    public String toString() {
        return super.toString() + " | Hechizos: " +hechizos;
    }
}