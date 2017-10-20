package com.wyre;

import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by yaakov on 10/2/17.
 */
public class ScannerThread implements Runnable {
    private String address;
    private int port;
    private Thread thread = new Thread(this);
    public ScannerThread(String address,int port){
        this.address = address;
        this.port = port;
thread.start();
    }
    public void interruptThread(){
    }
    @Override
    public void run() {
        try {
            Socket sc = new Socket(address, port);
            //if we got here that means that the port is open so print the port
            System.out.println("The following port is open: " + port);
        }
        catch(Exception ex){
             //dont print the errors since we want to be able to find the open ports
             //  System.out.println("Error when trying port number " + i + " :"+ex.toString());
        }
    }
}
