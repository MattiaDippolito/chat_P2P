/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Timer extends Thread{
    private int milliSec;
    private boolean terminato;
    private boolean isRunning;
    private boolean visto;

    public Timer(int milliSec) {
        this.milliSec = milliSec;
        terminato = false;
        isRunning = false;
        visto = false;
    }

    @Override
    public void run() {
        if(visto){
            visto = false;
            terminato = false;
            isRunning = true;
            while(isRunning){
                try {
                    sleep(milliSec);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                }
                terminato = true;
                isRunning = false;
            }
        }        
    }

    public boolean isTerminato() {
        visto = true;
        return terminato;
    }
}
