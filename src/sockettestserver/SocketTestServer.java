/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sockettestserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Joseph
 */
public class SocketTestServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int portNum = Integer.parseInt(args[0]);
        
        try (
            ServerSocket serverSocket = new ServerSocket(portNum);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            )
        {
            String inputLine, outputLine;
            
            System.out.println("Client Connected");
            out.println("Welcome to the server");
            
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client -- " + inputLine);
                outputLine = inputLine;
                System.out.println("Server -- " + outputLine);
                out.println(outputLine);
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
