/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appchat;

import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientListener implements Runnable{
    private Socket socket;
    private InputStream input;
    
    public ClientListener(Socket socket){
        this.socket = socket;
        try {
            this.input = socket.getInputStream();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
//        try {
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while((bytesRead = input.read(buffer)) != -1){
//                String mess = new String(buffer, 0, bytesRead);
//                System.out.println(mess);
//            }
//        } catch (Exception e) {
//        }
    }
    
}
