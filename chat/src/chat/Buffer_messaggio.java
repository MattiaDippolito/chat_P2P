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
    private LinkedList<String> data;

    public Buffer_messaggio() {
        data = new LinkedList<String>();
    }

    public String getData() {
        if(data.size()!=0)
            return data.remove(0);
        return null;
    }

    public void setData(String d) {
        data.add(d);
    }
}
