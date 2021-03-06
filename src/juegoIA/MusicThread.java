/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoIA;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Arkgath
 */
public class MusicThread extends Thread{
    public Clip song;
    public String ruta;
    public int repeticiones;
    
    public MusicThread(String ruta, int repeticiones){
        this.ruta=ruta;
        this.repeticiones=repeticiones;
    }
    
    @Override
    public void run(){
        try{
            URL url = new URL(ruta);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            song = AudioSystem.getClip();
            song.open(audioIn);
            song.loop(repeticiones);
            
        }catch(MalformedURLException murle){
            System.out.println(murle.toString());
            
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e.toString());
        }
    }
}
