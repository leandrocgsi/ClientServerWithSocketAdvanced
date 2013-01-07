package br.com.semeru.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws Exception{
        System.out.println("Starting Client!");
        
        System.out.println("Starting connection with server!");
        
        Socket socket = new Socket("localhost", 2525);
        
        System.out.println("Connection established!");
        
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        PrintStream out = new PrintStream(output);
        
        
        Scanner scanner = new Scanner(System.in);
        while (true) {            
            System.out.println("Write one message: ");
            String mensagem = scanner.nextLine();
            
            out.println(mensagem);
            
            if ("FIM".equals(mensagem)) {
                break;
            }
            
            mensagem = in.readLine();
            System.out.println("Message received of the server: " +
                    mensagem);
            
        }
        
                System.out.println("Finishing Connection");
        
        in.close();
        
        out.close();
        
        socket.close();
        
    }
}