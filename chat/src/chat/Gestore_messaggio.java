/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Gestore_messaggio {
    private DatagramSocket server;
    private byte[] buffer;
    private Condivisa cond;

    public Gestore_messaggio(Condivisa cond){
        try {
            server = new DatagramSocket(12345);
        } catch (SocketException ex) {
            Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        buffer = new byte[1500];
        this.cond = cond;
    }
    
    public Messaggio ricevi(){
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            server.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        byte[] dataReceived = packet.getData();
        String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
        String[] campi = messaggioRicevuto.split(";");
        Messaggio messaggio = new Messaggio(campi[0],campi[1]);
        
        messaggio.setMittente(packet.getAddress());
        
        return messaggio;
    }
    
    public boolean invia(String operazione, String data){
        String risposta = operazione + ";" + data;
        byte[] responseBuffer = risposta.getBytes();
        if(cond.destinatario.getIndirizzo()!=null){
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(cond.destinatario.getIndirizzo());
            responsePacket.setPort(12345);
            try {
                server.send(responsePacket);
            } catch (IOException ex) {
                Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
    
    public void connetti(String data, String indirizzo) throws UnknownHostException{
        //System.out.println("avvio connessione");
        String risposta = "a;" + data;
        byte[] responseBuffer = risposta.getBytes();
        if(cond.destinatario.getIndirizzo()==null && !indirizzo.equals("")){
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            responsePacket.setAddress(InetAddress.getByName(indirizzo));
            responsePacket.setPort(12345);
            try {
                server.send(responsePacket);
            } catch (IOException ex) {
                Logger.getLogger(Gestore_messaggio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
