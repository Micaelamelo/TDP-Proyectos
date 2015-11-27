package GUI;

import java.io.BufferedInputStream;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SonidoPrincipal {
		protected Clip sonido;
		
		public SonidoPrincipal(){
		}
		
		public void empezar(){
	
			try {
				BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("/Musica/TemaPrincipal.wav"));
				AudioInputStream ais= AudioSystem.getAudioInputStream(bis);
				sonido = AudioSystem.getClip();
				sonido.open(ais);
				sonido.start();
				sonido.loop(29);
		
			} catch (Exception tipoerror) {}
		}
		
		public void bomba(){
			try {
				BufferedInputStream bis2= new BufferedInputStream(getClass().getResourceAsStream("/Musica/Bomba.wav"));
				AudioInputStream ais2= AudioSystem.getAudioInputStream(bis2);
				Clip sonido2 = AudioSystem.getClip();
				sonido2.open(ais2);
				sonido2.start();	
				
				} catch (Exception tipoerror) {}
		}
		
		public void parar(){
			sonido.stop();
		}
	
	
	
}

