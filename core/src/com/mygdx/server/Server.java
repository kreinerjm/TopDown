package com.mygdx.server;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.SocketHints;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.mygdx.game.Entities.Games.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by jacob on 3/27/17.
 */
public class Server {
    Cluster cluster;
    Session session;
    ArrayList<Socket> clientSockets;
    ServerSocket serverSocket;

    public Server(Game g)
    {
        clientSockets = new ArrayList<>();
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("top_down");
        List<String> addresses = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            for(NetworkInterface ni : Collections.list(interfaces)){
                for(InetAddress address : Collections.list(ni.getInetAddresses()))
                {
                    if(address instanceof Inet4Address){
                        addresses.add(address.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // Print the contents of our array to a string.  Yeah, should have used StringBuilder
        String ipAddress = new String("");
        for(String str:addresses)
        {
            ipAddress = ipAddress + str + "\n";
            //System.out.println(ipAddress);
        }

        new Thread(new Runnable()
        {

            @Override
            public void run() {
                ServerSocketHints serverSocketHint = new ServerSocketHints();
                // 0 means no timeout.  Probably not the greatest idea in production!
                serverSocketHint.acceptTimeout = 0;
                List<String> addresses = new ArrayList<String>();
                try {
                    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                    for(NetworkInterface ni : Collections.list(interfaces)){
                        for(InetAddress address : Collections.list(ni.getInetAddresses()))
                        {
                            if(address instanceof Inet4Address){
                                addresses.add(address.getHostAddress());
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

                // Print the contents of our array to a string.  Yeah, should have used StringBuilder
                String ipAddress = new String("");
                for(String str:addresses)
                {
                    ipAddress = ipAddress + str + "\n";
                }
                // Create the socket server using TCP protocol and listening on 9021
                // Only one app can listen to a port at a time, keep in mind many ports are reserved
                // especially in the lower numbers ( like 21, 80, etc )
                serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, 9021, serverSocketHint);

                // Loop forever
                while(true){

                    Socket socket = serverSocket.accept(null);
                    clientSockets.add(socket);
                    // Read data from the socket into a BufferedReader
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    for(Socket s : clientSockets)
                    {
                        System.out.println("client ip :"+s.getRemoteAddress());
                    }
                    for(int i = 0; i < 5; i++)
                    System.out.println("server ip :"+addresses.get(0));
                }
            }
        }).start();

        SocketHints socketHints = new SocketHints();
        // Socket will time our in 4 seconds
        socketHints.connectTimeout = 4000;
        //create the socket and connect to the server entered in the text box ( x.x.x.x format ) on port 9021
        Socket socket = Gdx.net.newClientSocket(Net.Protocol.TCP, addresses.get(0), 9021, socketHints);
    }

    public void dispose()
    {

    }

    public void sendGame()
    {

    }

    /*public Game getGameFromDatabase()
    {

    }*/



}
