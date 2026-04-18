package com.parcial.criaturas;
import com.parcial.composicion.Arma;

public class Guerrero extends Criatura {

    private String armaEspada;
    private Arma arma;

    public Guerrero(String nombre, int salud, int fuerza, String armaEspada) {
        super(nombre, salud, fuerza);
        this.armaEspada = armaEspada;
    }

    public String getArmaEspada() {
        return armaEspada;
    }

    public void setArmaEspada(String armaEspada) {
        this.armaEspada = armaEspada;
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
        System.out.println(nombre+ " ataca con su espada '" +armaEspada+ "' a " +objetivo.getNombre()+ " causando " +fuerza+ " de daño.");
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
        
        System.out.println(nombre+ " recibe " +daño+ " de daño. Salud restante: " +salud);
    }

    @Override
    public String toString() {
        return super.toString() + " | Arma: " +armaEspada;
    }
}
