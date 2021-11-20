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
public class Condivisa {
    public Buffer_messaggio buffer_messaggio;
    public Destinatario destinatario;

    public Condivisa() {
        this.buffer_messaggio = new Buffer_messaggio();
        this.destinatario = new Destinatario();
    }
}
