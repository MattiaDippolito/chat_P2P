/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.InetAddress;

/**
 *
 * @author dippolito_mattia
 */
public class Destinatario {
    private InetAddress indirizzo;
    private String nome;

    public Destinatario() {
        this.indirizzo = null;
    }

    public InetAddress getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(InetAddress indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
