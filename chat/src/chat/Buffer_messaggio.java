/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author HP
 */
public class Buffer_messaggio {
    private String data;
    private boolean aggiornato;

    public Buffer_messaggio() {
        data = "";
        aggiornato = false;
    }

    synchronized public String getData() {
        return data;
    }

    synchronized public void setData(String data) {
        this.data = data;
        aggiornato = true;
    }

    public boolean isAggiornato() {
        return aggiornato;
    }
}
