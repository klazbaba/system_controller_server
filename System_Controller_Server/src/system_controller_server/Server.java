/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_controller_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author macbookpro
 */
public class Server implements Runnable {
    ServerSocket server = null;
    int port = 0;
    PrintWriter out;
    
    public Server(int port) throws IOException {
        this.port = port;
        server = new ServerSocket(this.port);
        Thread connectionThread = new Thread(this);
        connectionThread.start();
    }
    
    public Server() {
        
    }
    
    public void closeConnection() {
        try {
            server.close();
        } catch (IOException error) {
            System.out.println(error);
        }
    }

    @Override
    public void run() {
        try (Socket client = server.accept()) {
            System.out.println("Connection established");
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(input.readLine());
        }
        catch (IOException ex) {
           System.out.println(ex);
        }    
    }
}
