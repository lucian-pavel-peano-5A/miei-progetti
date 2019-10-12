/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eli
 */
public class PrimoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            // Istanzio un server che si mette in ascolto su una specifica porta
            // Accetto la connessione sulla porta specificata
            // Leggo i dati che arrivano dal client
            // Il server si rimette in ascolto

            ServerSocket ss = new ServerSocket(6666);
            for (;;) {
                Socket s;
                s = ss.accept();

                InputStreamReader isr= new InputStreamReader(s.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Il server ha ricevuto: " + br.readLine() );
                s.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(PrimoServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
