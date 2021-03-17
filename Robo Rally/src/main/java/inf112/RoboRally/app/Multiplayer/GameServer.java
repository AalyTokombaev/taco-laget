package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputAdapter;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Objects.Player;
import inf112.RoboRally.app.RoboRallyBeta;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;

public class GameServer{
    private Server server;
    private boolean active;
    int numPlayers;
    RoboRallyBeta parent;

    Queue<Action> actions;


    public GameServer(){
        server = new Server();



        server.addListener(new Listener(){
            public void recieved(Connection connection, Object object) {
                if (object instanceof String) {
                    String[] msg = object.toString().split(":");
                    if (msg[0].equals("connectClient")){
                        addPlayer();
                        System.out.println("client connected");
                        connection.sendTCP(String.format("connectClientOK:{}", numPlayers));
                    }
                    if (msg[0].equals("keyUpClient")) {
                        int i = Integer.parseInt(msg[1]);
                    }
                }
            }
        });

    }

    private void addPlayer(){
        numPlayers++;
    }

    public int getNumPlayers(){
        return numPlayers;
    }

    public Iterator<Action> getActons(){
        return actions.iterator();
    }

    public void host(){
        try{
            server.start();
            server.bind(1337, 1337);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addPlayer();
    }



}
