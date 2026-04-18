package com.parcial.criaturas;
import com.parcial.composicion.Arma;
import com.parcial.interfaces.IVolador;

public class Dragon extends Criatura implements IVolador {

    private String escamas;
    private Arma arma;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
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
        int daño = fuerza * 2;
        System.out.println(nombre+ " ataca con fuego a " +objetivo.getNombre()+ " causando " +daño+ " de daño.");
        objetivo.defender(daño);

        if(arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    @Override
    public void defender(int daño) {
        int dañoRecibido = daño / 2;
        salud -= dañoRecibido;

        if(salud < 0) {
            salud = 0;
        }

        System.out.println(nombre+ " se defiende con sus escamas de " +escamas+ ". Daño recibido: " +dañoRecibido+ ". Salud restante: " +salud);
    }

    @Override
    public void volar() {
        System.out.println(nombre+ " despliega sus alas y comienza a volar.");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre+ " aterriza con fuerza en el suelo.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Escamas: " +escamas;
    }
}