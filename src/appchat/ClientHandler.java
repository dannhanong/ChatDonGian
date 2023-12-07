/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appchat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ClientHandler implements Runnable{
    private Socket mySocket;
    Server sv;
    private String userName;
    private InputStream input;
    private OutputStream output;
    
    public ClientHandler(Socket mySocket, String userName, Server sv){
        this.mySocket = mySocket;
        this.userName = userName;
        this.sv = sv;
        try {
            this.input = mySocket.getInputStream();
            this.output = mySocket.getOutputStream();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = input.read(buffer)) != -1){
                String mess = new String(buffer, 0, bytesRead);
                sv.broadcastMessage(this.userName, mess);
            }
        } catch (Exception e) {
        }
    }
    
    void sendMess(String mess){
        try {
            output.write(mess.getBytes());
        } catch (Exception e) {
        }
    }

    public String getUserName() {
        return userName;
    }
    
}
