package com.wyre;

import java.net.Socket;

/**
 * This is a basic port scanner built on a 7 hour plane ride to see if we can find a open port to connect to a vps to get free INFLIGHT internet
 */
public class Main {
    /**
     * @param args The first arguement should be the gateway ip address to try to connect to
     */
    public static void main(String[] args) {
//iterate through all ports starting from zero
        //we gotta multi thread this due to the incredible amount of time this process is taking
        for (int i = 0; i < 99999; i++) {
            System.out.println("Trying port number" + i);
            //switch this to the ip address of the router gateway on the plane
            ScannerThread thread = new ScannerThread("172.19.248.1", i);

            try {
                //depending on the network timeout rate, set the sleep time to prevent to many threads from being created.
                //For a ivy bridge mac i5, i set it to 250
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished Setting Up Threads, now must wait for all responses");
    }
}
