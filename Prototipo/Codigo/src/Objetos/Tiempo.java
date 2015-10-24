package Objetos;


import java.util.*;

/** La clase tiempo controla cuanto lleva de tiempo el juego
 * 
 */
public class Tiempo {

    /** cantidad de horas
     * 
     */
    protected int horas;

    /** cantidad de minutos
     * 
     */
    protected int minutos;

    /** cantidad de segundos
     * 
     */
    protected int segundos;

    /**
     * @param int h 
     * @param int m 
     * @param int s
     */
    public Tiempo(int h, int m, int s) {
     	h=horas;
     	m=minutos;
     	s=segundos;
    }

    /** 
     * @return el tiempo con los atributos de hora, minutos y segundos 
     */
    public Tiempo getHora() {
        // TODO implement here
        Tiempo t= new Tiempo(horas,minutos,segundos);
        return t;
    }

    /**
     * @return cantidad de horas
     */
    public int getHoras() {
        // TODO implement here
        return horas;
    }

    /**
     * @return cantidad de segundos
     */
    public int getSegundos() {
        // TODO implement here
        return segundos;
    }

    /**
     * @return cantidad de minutos
     */
    public int getMinutos() {
        // TODO implement here
        return minutos;
    }

}