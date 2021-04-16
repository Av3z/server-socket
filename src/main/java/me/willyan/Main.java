package me.willyan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        final int PORT = 3309;
            try {
                ServerSocket server = new ServerSocket(PORT);
                Socket client;
                if(server.isClosed() == false){
                    System.out.println("Servidor iniciado: " + server.getInetAddress().getHostName() + ":" + PORT );

                    while (true){
                        client = server.accept();
                        if(client.isConnected()){
                            System.out.println("Cliente conectado: " + client.getRemoteSocketAddress());
                            client.close();
                        }
                        if(client.isClosed()){
                            System.out.println("Cliente desconectou");
                        }
                    }
                } else {
                    System.out.println("Servidor não foi iniciado!");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
