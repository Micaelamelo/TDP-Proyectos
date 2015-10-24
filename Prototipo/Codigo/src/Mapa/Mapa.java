package Mapa;

import java.util.*;

import javax.swing.ImageIcon;

import Objetos.*;
import Personajes.*;

/**
 * 
 * Clase logica de Mapa
 *
 */
public class Mapa {
	
    protected int cantEnemigos;
    protected Celda grilla[][];  
    protected Tiempo miTiempo;
    protected Bomberman miBomberman;  
    protected ArrayList<Celda> noDestruibles;
    protected ArrayList<Celda> destruibles;
    
    /**
     *  Constructor de Mapa, sin parametros
     */
    public  Mapa() {
    	cantEnemigos=6;
    	
    	grilla= new Celda[31][13];
    	
    	for(int i = 0; i < 31; i++){
			for(int j = 0; j < 13; j++){
				grilla[i][j] = new Celda(this,i,j);
				
			}
		}
    	
    	noDestruibles= new ArrayList<Celda>();
    	destruibles= new ArrayList<Celda>();
    	
    	inicializarPDestruibles();
    	inicializarPNDestruibles();   	
    }
    
    /**
     * Inicializa las paredes destruibles en el mapa y crea los power up en alguna de ellas
     */
    private void inicializarPDestruibles(){
    	Random rnd= new Random();
    	int i=0;
    	int x;
    	int y;
    	while(i<=124){
    		x=rnd.nextInt(28)+2;
    		y=rnd.nextInt(10)+2;
    		if((y%2!=0 && x%2!=0) || (x!=2 && y!=1) || (x!=1 && y!=2) || (x!=1 && y!=1)){
    			if(grilla[x][y].getPared()==null){
    				grilla[x][y].setPared(new Destruible(grilla[x][y]));
    				destruibles.add(grilla[x][y]);
    				i++; 
    			} 			
    		}
    		switch (i){
    			case 1: 
    				grilla[x][y].setPowerUp(new Masacrallity(this, grilla[x][y]));
    				break;
    			case 2:
    			case 4:
    			case 6:
    				grilla[x][y].setPowerUp(new Bombality(this, grilla[x][y]));
    				break;
    			case 3:
    			case 5:
    			case 7:
    			case 9:
    				grilla[x][y].setPowerUp(new SpeedUp(this, grilla[x][y]));
    				break;
    			case 8:
    			case 10:
    			case 11:
    				grilla[x][y].setPowerUp(new Fatallity(this,grilla[x][y]));
    				break;
    		}		
    	}
    }
    
    /**
     * Crea las paredes no destruibles en el mapa
     */
    private void inicializarPNDestruibles(){
    	for(int i=0; i<31; i++){
    		for(int j=0; j<13; j++){
    			if((j==0 || j==12 || i==0 || i==30) || (j%2==0 && i%2==0)){
    				grilla[i][j].setPared(new NoDestruible(grilla[i][j]));   
    				noDestruibles.add(grilla[i][j]);
    			}
    			}
    	}
    }
    
    /**
     * 
     * @return Arreglo de celdas que contienen a las paredes no destruibles del mapa
     */
    
    public ArrayList<Celda> getNDestruibles(){
    	return noDestruibles;
    }
    
    /**
     * 
     * @return Arreglo de celdas que contienen a las paredes destruibles del mapa
     */
    public ArrayList<Celda> getDestruibles(){
    	return destruibles;
    }
    
    /**
     * Setea al Bomberman en null en la celda donde se encuentra a la hora de morir
     * @param d Celda hacia donde se encuentra el Bomberman
     */
    public void destruirJugador(Celda d) {
    	d.setBomberman(null);
    	miBomberman=null;
    }
    
    /**
     * 
     * @param x columna donde se encuentra la celda
     * @param y fila donde se encuentra la celda
     * @return Celda que se encuentra en la fila y y en la columna x
     */
    
    public Celda getCelda(int x, int y){
    if((x>0 && x<31) && (y>0 && y<13))
    	return grilla[x][y];
    return null;
    }
   
    /**
     * Setea en nulo a los enemigos que se enceuntran en la celda d
     * @param d Celda donde se encuentran los enemigos a la hora de morir
     */
    public void destruirEnemigos(Celda d) { //Este metodo se utiliza cuando una explosion de la bomba afecta a varios enemigos
    	for(Enemigo e: d.getEnemigos()){
    		d.getEnemigos().remove(e);
    		cantEnemigos--;
    	}
    			
    	if(cantEnemigos==0)
    		ganoJuego();
    }
    
    /**
     * Setea en nulo al enemigo que se enceuntra en la celda d
     * @param d Celda donde se encuentra el enemigo a la hora de morir
     */
    public void destruirEnemigo(Enemigo e){
    	e.getCelda().getEnemigos().remove(e);
    	e.setCelda(null);
    	cantEnemigos--;
    	if(cantEnemigos==0)
    		ganoJuego();
    }
    
    /**
     * Setea en nulo al power up que se encuentra en la celda pasada por parametro
     * @param d Celda donde se encuentra el power up
     */ 
    
    public void destruirPowerUp(Celda d){
    	d.setPowerUp(null);
    }
    
    /**
     * Imprime un mensaje por consola si el usuario gano el juego
     */
    public void ganoJuego() {
    	System.out.println("Ha ganado!");
    }
    
    /**Acciones que realiza y controla la bomba al momento de explotar
     * 
     * @param d Celda donde se creo la bomba
     * @param alcance Alcance de la bomba 
     */
    public void generarExplosion(Celda d, int alcance) {
    	int x= d.getX();
    	int y= d.getY();
    	boolean salida=false;
    	
    	for(int i=1; i<=alcance && !salida; i++){
    		Celda aux=grilla[x+i][y];
    		if(aux.getPared()!=null){
    			destruirPared(aux.getPared());
    			salida=true;
    		}
    		else{
    			if(aux.getBomberman()!=null)
    				destruirJugador(aux);
    			if(!aux.getEnemigos().isEmpty())
    				destruirEnemigos(aux);
    			if(aux.getPowerUp()!=null)
    				destruirPowerUp(aux);
    		}
    	}
    	
    	for(int i=1; i<=alcance && !salida; i++){
    		Celda aux=grilla[x-i][y];
    		if(aux.getPared()!=null){
    			destruirPared(aux.getPared());
    			salida=true;
    		}
    		else{
    			if(aux.getBomberman()!=null)
    				destruirJugador(aux);
    			if(!aux.getEnemigos().isEmpty())
    				destruirEnemigos(aux);
    			if(aux.getPowerUp()!=null)
    				destruirPowerUp(aux);
    		}
    	}
    		
    		for(int i=1; i<=alcance && !salida; i++){
        		Celda aux=grilla[x][y+i];
        		if(aux.getPared()!=null){
        			destruirPared(aux.getPared());
        			salida=true;
        		}
        		else{
        			if(aux.getBomberman()!=null)
        				destruirJugador(aux);
        			if(!aux.getEnemigos().isEmpty())
        				destruirEnemigos(aux);
        			if(aux.getPowerUp()!=null)
        				destruirPowerUp(aux);
        		}
    		}
        		
        		for(int i=1; i<=alcance && !salida; i++){
            		Celda aux=grilla[x][y-i];
            		if(aux.getPared()!=null){
            			destruirPared(aux.getPared());
            			salida=true;
            		}
            		else{
            			if(aux.getBomberman()!=null)
            				destruirJugador(aux);
            			if(!aux.getEnemigos().isEmpty())
            				destruirEnemigos(aux);
            			if(aux.getPowerUp()!=null)
            				destruirPowerUp(aux);
            		}
        		}
    }
    
    /**
     * 
     * @return Tiempo que lleva transcurrido el juego
     */
    public Tiempo getTiempo() {
        return miTiempo;
    }
    
    /**
     * Setea en nulo a la celda que contiene la pared y setea en nulo a la pared que contiene la celda
     * @param d Pared que se destruye por la explosion de una bomba
     */
    public void destruirPared(Pared d) {
        d.getCelda().setPared(null);
        d.setCelda(null);
    }
    
    /**
     * 
     * @return Cantidad de enemigos vivos que hay en el juego
     */
    public int getCantEnemigos() {
        return cantEnemigos;
    }

}