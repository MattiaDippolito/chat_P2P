/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Gestore_messaggio {
    private DatagramSocket server;
    private byte[] buffer;
    private Destinatario destinatario;

    public Gestore_messaggio(){
        try {
            server = new DatagramSocket(12345);
        } catch (SocketException ex) {
            Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        buffer = new byte[1500];
        destinatario = new Destinatario();
    }
    
    public Messaggio ricevi(){
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            server.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        destinatario.setIndirizzo(packet.getAddress());
        destinatario.setPorta(packet.getPort());
        
        byte[] dataReceived = packet.getData();
        String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
        String[] campi = messaggioRicevuto.split(";");
        Messaggio messaggio = new Messaggio(campi[0],campi[1]);
        return messaggio;
    }
    
    public boolean invia(String operazione, String data){
        String risposta = operazione + ";" + data;
        byte[] responseBuffer = risposta.getBytes();
        if(destinatario.getIndirizzo() != null && destinatario.getPorta() != -1){
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(destinatario.getIndirizzo());
            responsePacket.setPort(destinatario.getPorta());
            try {
                server.send(responsePacket);
            } catch (IOException ex) {
                Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
}
