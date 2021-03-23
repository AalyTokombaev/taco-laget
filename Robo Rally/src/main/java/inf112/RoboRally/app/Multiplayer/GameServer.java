package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputAdapter;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Controls;
import inf112.RoboRally.app.Objects.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.RoboRallyBeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class GameServer{
    private Server server;
    private boolean active;
    int numPlayers = 0;
    RoboRally game;
    Controls ctrl;
    public Player player;
    public final int id = 0;
    Queue<Action> actions;
    ArrayList<Player> players;


    public GameServer(RoboRally game, Controls ctrl){
        server = new Server();
        this.game = game;
        this.ctrl = ctrl;
        players = new ArrayList<>();



        server.addListener(new Listener(){
            public void recieved(Connection connection, Object object) {
                if (object instanceof String) {
                    String[] msg = object.toString().split(":");
                    if (msg[0].equals("connectClient")){
                        addPlayer();
                        System.out.println("client connected");
                        numPlayers++;
                        System.out.println(String.format("Sending client id {}", numPlayers));
                        connection.sendTCP(String.format("connectClientOK:{}", numPlayers));
                    }
                    if (msg[0].equals("keyUpClient")) {
                        int i = Integer.parseInt(msg[1]);
                        ctrl.keyDown(i);
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
        System.out.println("hosting");
    }

    public void setPlayer(Player player) { this.player = player; }

}
