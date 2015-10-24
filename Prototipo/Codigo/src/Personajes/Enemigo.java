package Personajes;

import Mapa.*;
import java.util.*;
import java.util.Random.*;


public abstract class Enemigo extends Personaje {

    protected int puntosAOtorgar;

    protected Enemigo(Mapa m, Celda c) {
        super(m,c);    	
    }

    public int getPuntosAOtorgar() {
        return puntosAOtorgar;
    }

    public abstract void mover();
   

}