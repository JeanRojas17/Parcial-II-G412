package com.parcial;

import com.parcial.composicion.Arma;
import com.parcial.criaturas.Criatura;
import com.parcial.criaturas.Dragon;
import com.parcial.criaturas.Guerrero;
import com.parcial.criaturas.Mago;
import com.parcial.interfaces.*;

public class Main {

    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║           INICIO DE BATALLA              ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println(criatura1.toString());
        System.out.println("  VS");
        System.out.println(criatura2.toString());

        int turno = 1;
        while(criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Turno " +turno+ " ---");

            if(criatura1 instanceof IVolador) {
                ((IVolador) criatura1).volar();
            }
            if(criatura1 instanceof IMagico) {
                ((IMagico) criatura1).lanzarHechizo();
            }

            criatura1.atacar(criatura2);

            if(criatura2.estaViva()) {
                if(criatura2 instanceof IVolador) {
                    ((IVolador) criatura2).volar();
                }
                if(criatura2 instanceof IMagico) {
                    ((IMagico) criatura2).lanzarHechizo();
                }
                criatura2.atacar(criatura1);
            }

            turno++;
        }

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║             FIN DE BATALLA               ║");
        System.out.println("╚══════════════════════════════════════════╝");
        
        if(criatura1.estaViva()) {
            System.out.println("Ganador: " +criatura1.getNombre());
        } else {
            System.out.println("Ganador: " +criatura2.getNombre());
        }
    }

    public static void main(String[] args) {
        
        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║             PREPARACIÓN PARA LA BATALLA               ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");

        Arma espada = new Arma("Espada Legendaria", 15);
        Arma baston = new Arma("Bastón Mágico", 10);
        Arma garras = new Arma("Garras de Fuego", 20);

        Dragon dragon = new Dragon("Copperfield", 150, 40, "Escamas de Hierro");
        Guerrero guerrero = new Guerrero("Geralt", 120, 35, "Aerondight");

        dragon.equiparArma(garras);
        guerrero.equiparArma(espada);

        simularBatalla(dragon, guerrero);

        System.out.println("\n╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║             PREPARACIÓN PARA LA SIGUIENTE BATALLA               ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");

        Mago mago2 = new Mago("Gandalf", 100, 30, "Rayo Oscuro");
        Guerrero guerrero2 = new Guerrero("Guts", 120, 35, "Matadragones");
        mago2.equiparArma(baston);
        guerrero2.equiparArma(espada);

        simularBatalla(mago2, guerrero2);
    }
}