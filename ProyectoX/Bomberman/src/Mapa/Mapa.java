package Mapa;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Juego;
import Objetos.*;
import Personajes.*;

/**
 * 
 * Clase logica de Mapa
 *
 */
public class Mapa {
	
	protected Juego juego;
    protected int cantEnemigos;
    protected Celda grilla[][];  
    protected Bomberman miBomberman;  
    protected ArrayList<Celda> noDestruibles;
    protected ArrayList<Celda> destruibles;
  
    /**
     *  Constructor de Mapa, sin parametros
     *  @param jgo Juego
     */
    public  Mapa(Juego jgo) {
    	juego=jgo;
     	
    	cantEnemigos=6;
    	
    	grilla= new Celda[31][13];
    	
    	for(int i = 0; i < 31; i++){
			for(int j = 0; j < 13; j++){
				grilla[i][j] = new Celda(this,i,j);
				
			}
		}   	

    	miBomberman= new Bomberman(this,new Celda(this,1,1));
    	
    	noDestruibles= new ArrayList<Celda>();
    	destruibles= new ArrayList<Celda>();
    	
    	inicializarPDestruibles();
    	inicializarPNDestruibles();   	
    }
    
    /**
     * Inicializa las paredes destruibles
     */
    
    private void inicializarPDestruibles() {
    	int i=0;
    	
        Random nR = new Random();
        int fila;
 		int columna;
    	
    	while(i<125){
    		fila= nR.nextInt(30);
         	columna= nR.nextInt(12);
    		if(EsValida(fila,columna) && grilla[fila][columna].getPared()==null ){
	    		grilla[fila][columna].setPared(new Destruible(grilla[fila][columna]));
	    		destruibles.add(grilla[fila][columna]);
	    		i++;
	    	
	    
    	switch (i){
		case 1: 
			grilla[fila][columna].setPowerUp(new Masacrallity(this, grilla[fila][columna]));
			break;
		case 2:
		case 4:
		case 6:
			grilla[fila][columna].setPowerUp(new Bombality(this, grilla[fila][columna]));
			break;
		case 3:
		case 5:
		case 7:
		case 9:
			grilla[fila][columna].setPowerUp(new SpeedUp(this, grilla[fila][columna]));
			break;
		case 8:
		case 10:
		case 11:
			grilla[fila][columna].setPowerUp(new Fatallity(this,grilla[fila][columna]));
			break;
	}
    		}
    	}
    	
    }
    
    /**Metodo privado utilizado para inicializar las paredes destruibles donde indica que lugares son validos para 
     * insertar una de estas
     * @param x Posicion X
     * @param y Posicion Y
     * @return true si es valido, false caso contrario
     */
	private boolean EsValida(int x, int y){
		boolean valida=true;
		
		if (x%2==0){
			if ( y%2==0 )
				valida=false;
		}
		
		if(x==0 || x==12)
			valida=false;
		
		if(y==0 || y==30)
			valida=false;
			
		if (x==1 || x==2 || x==28 || x==29 ){ 
			if (y==1 || y==2 || y==10 || y==11)
				valida=false;
		}
							
		return valida;
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
     * Detiene el hilo del bomberman
     * Envia mensaje a gui para mostrar la imagen del bomberman muerto
     * Detiene el hilo del tiempo
     * Suma puntos al bomberman
     * @param d Celda hacia donde se encuentra el Bomberman
     */
    public void destruirJugador(Celda d) {
    	juego.bombermanMuerto();
    	juego.getGUI().getBombermanThread().detener();
    	d.setBomberman(null);
    	miBomberman=null;
    	juego.getGUI().getTiempoThread().interrupt();
    	
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
     * Detiene el hilo del enemigo que se encuentra en la celda d
     * Remueve el enemigo de la celda
     * Suma puntos al bomberman
     * @param d Celda donde se encuentran los enemigos a la hora de morir
     */
    public void destruirEnemigos(Celda d) { //Este metodo se utiliza cuando una explosion de la bomba afecta a varios enemigos
    
    	for(Enemigo e: d.getEnemigos()){
    		miBomberman.aumentarPuntaje(e.getPuntosAOtorgar());
    		juego.eliminarEnemigo(e);
    		juego.getEnemigoThread(e).detener();
    		d.getEnemigos().remove(e);
        	e.setCelda(null);
    		cantEnemigos--;
    	}
    			
    	if(cantEnemigos==0)
    		ganoJuego();
    }
    
    /**
     * Setea en nulo al enemigo que se enceuntra en la celda d
     * Detiene el hilo del enemigo pasado por parametro
     * Suma puntos al bomberman
     * @param e Enemigo a eliminar
     */
    public void destruirEnemigo(Enemigo e){
    	miBomberman.aumentarPuntaje(e.getPuntosAOtorgar());
    	juego.eliminarEnemigo(e);
    	juego.getEnemigoThread(e).detener();
    	e.getCelda().eliminarEnemigo(e);
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
    	juego.eliminarPowerUp(d.getPowerUp());
    	d.setPowerUp(null);
    }
    
    /**
     * Detiene el hilo del bomberman
     * Envia mensaje a GUI para que muestre la imagen final
     */
    public void ganoJuego() {
    	juego.getGUI().getBombermanThread().detener();
    	juego.getGUI().win();
    }
    
    /**
     * 
     * @return Bomberman
     */
    public Bomberman getBomberman(){
    	return miBomberman;
    }
    
    /**Acciones que realiza y controla la bomba al momento de explotar
     * 
     * @param d Celda donde se creo la bomba
     * @param alcance Alcance de la bomba 
     * @return arraylist de Jlabels 
     */
    public ArrayList<JLabel> generarExplosion(Celda d, int alcance) {
    	int x= d.getX();
    	int y= d.getY();
    	boolean salida=false;
    	ArrayList<Celda> celdas= new ArrayList<Celda>();
    	
    	for(int i=1; i<=alcance && !salida; i++){
    		Celda aux=grilla[x+i][y];
    		if(aux.getPared()!=null)
    			salida=true;
    		celdas.add(aux);
    	}
    	
    	salida=false;
    	for(int i=1; i<=alcance && !salida; i++){
    		Celda aux=grilla[x-i][y];
    		if(aux.getPared()!=null)
    			salida=true;
    		celdas.add(aux);
    	}
    	
    	salida=false;
    	for(int i=1; i<=alcance && !salida; i++){
        	Celda aux=grilla[x][y+i];
        	if(aux.getPared()!=null)
        		salida=true;
        	celdas.add(aux);
    	}
        
    	salida=false;
        for(int i=1; i<=alcance && !salida; i++){
            Celda aux=grilla[x][y-i];
            	if(aux.getPared()!=null)
            		salida=true;
            	celdas.add(aux);
         }
       
        for(Celda aux: celdas){
        	if(aux.getPared()!=null){
        		aux.getPared().destruirPared();
        		if(aux.tienePowerUp()){
        			juego.añadirPowerUp(aux.getPowerUp());
        		}
        	}
        	else {
        		if(aux.getBomberman()!=null)
        			destruirJugador(aux);
        		if(!aux.getEnemigos().isEmpty()){
        			if(aux.getEnemigos().size()==1){
        				destruirEnemigo(aux.getPrimerEnemigo());
        			}
        			else
        				destruirEnemigos(aux);
        		}
        	}
    	}
        
        if(miBomberman!=null)
        	miBomberman.aumentarBombas();
        
        ArrayList<JLabel> labels= juego.explosionBomba(d,celdas);    
        d.setBomba(null);
        
        return labels;
        
        
    }
        
    /**
     * 
     * @return Cantidad de enemigos vivos que hay en el juego
     */
    public int getCantEnemigos() {
        return cantEnemigos;
    }
    
    /**
     * 
     * @return Juego
     */
    public Juego getJuego(){
    	return juego;
    }
    
}