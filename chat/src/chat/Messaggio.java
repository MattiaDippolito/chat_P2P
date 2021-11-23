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
public class Messaggio {
    private InetAddress mittente;
    private String operazione;
    private String data;
    
    public Messaggio(String operazione, String data) {
        this.operazione = operazione;
        this.data = data;
        this.mittente = null;
    }

    public String getOperazione() {
        return operazione;
    }

    public void setOperazione(String operazione) {
        this.operazione = operazione;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public InetAddress getMittente() {
        return mittente;
    }

    public void setMittente(InetAddress mittente) {
        this.mittente = mittente;
    }
}
