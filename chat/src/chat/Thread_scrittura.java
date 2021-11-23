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
public class Thread_scrittura extends Thread{
    Condivisa cond;

    public Thread_scrittura(Condivisa cond) {
        this.cond = cond;
    }

    @Override
    public void run() {
        while(true){
            cond.buffer_messaggio.getData();
            try {
                sleep(1000/33);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_scrittura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
