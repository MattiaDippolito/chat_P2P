/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.InetAddress;

/**
 *
 * @author HP
 */
public class Destinatario {
    private InetAddress indirizzo;
    private int porta;

    public Destinatario() {
        this.indirizzo = null;
        this.porta = -1;
    }

    public Destinatario(InetAddress indirizzo, int porta) {
        this.indirizzo = indirizzo;
        this.porta = porta;
    }

    public InetAddress getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(InetAddress indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
}
