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
public class Thread_ricezione extends Thread{
    private Gestore_messaggio gm;
    private Condivisa cond;
    private boolean collegato;
    private boolean in_attesa;
    private Timer timer;

    public Thread_ricezione(Condivisa c) {
         gm = new Gestore_messaggio();
         collegato = false;
         in_attesa = false;
         cond = c;
         timer = new Timer(30000);
    }

    @Override
    public void run() {
        while(true){
            Messaggio messaggio = gm.ricevi();
            if(!collegato && !in_attesa && messaggio.getOperazione().equals("a")){
                gm.invia("y", "Dippolito");
                in_attesa = true;
                timer.start();
            }else if(collegato || in_attesa){
                gm.invia("n", "");
            }
            
            if(!timer.isTerminato()){
                if(in_attesa && messaggio.getOperazione().equals("y")){
                in_attesa = false;
                collegato = true;
                }
                if(in_attesa && messaggio.getOperazione().equals("n")){
                in_attesa = false;
                collegato = false;
                }
            }else{
                collegato = false;
                in_attesa = false;
            }
            
            if(collegato && messaggio.getOperazione().equals("m")){
                cond.buffer_messaggio.setData(messaggio.getData());
            }
            
            if(collegato && messaggio.getOperazione().equals("c")){
                collegato = false;
            }
            
            if(!collegato && messaggio.getOperazione().equals("m")){
                gm.invia("c", "");
            }
            
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_ricezione.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}