/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Buffer_messaggio {
    private LinkedList<String> dataRecived;
    private int num_dataRecived = 0;
    private LinkedList<String> dataSended;
    private int num_dataSended = 0;

    public Buffer_messaggio() {
        dataRecived = new LinkedList<String>();
        dataSended = new LinkedList<String>();
    }

    /*synchronized public String getData() {
        if(dataRecived.size()>0 && dataSended.size()==0){
            dataRecived.remove(0);
        }
        else if(dataSended.size()>0){
            getDataSended();
        }
        return null;
    }*/
    
    synchronized public void getData() {
        if(dataRecived.size()>0 && dataSended.size()==0){
            System.out.println("Risposta: " + dataRecived.remove(0));
        }
        else if(dataSended.size()>0){
            getDataSended();
        }
    }

    synchronized public void setDataRecived(String d) {
        dataRecived.add(d);
    }
    
    /*synchronized private String getDataSended() {
        return dataSended.remove(0);
    }*/
    
    synchronized private void getDataSended() {
        System.out.println("Tu: " + dataSended.remove(0));
    }
    
    synchronized public void setDataSended(String d) {
        dataSended.add(d);
    }
}
