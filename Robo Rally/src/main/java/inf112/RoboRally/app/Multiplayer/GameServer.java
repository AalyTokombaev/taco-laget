package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Controls;
import inf112.RoboRally.app.Objects.Player;
import inf112.RoboRally.app.Objects.States;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.RoboRallyBeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class GameServer{
    private Server server;
    private boolean active;
    public int numPlayers = 0;
    RoboRally game;
    Controls ctrl;
    public Player player;
    public final int id = 0;
    Queue<Action> actions;
    ArrayList<Player> players;

    public int clientX, clientY;
    public TiledMapTileLayer.Cell clientState;


    public GameServer(RoboRally game, Controls ctrl){
        server = new Server();
        this.game = game;
        this.ctrl = ctrl;
        players = new ArrayList<>();

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof String) {
                    String msg[] = object.toString().split(":");
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("hostX:%d", player.getx()));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("hostY:%d", player.gety()));
                    }
                    if (msg[0].equals("clientX")) {
                        clientX = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("clientY")) {
                        clientY = Integer.parseInt(msg[1]);
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

    public void askForData() {
        System.out.println("server asking for data");
        server.sendToAllTCP("getY");
        server.sendToAllTCP("getX");
        System.out.println("serfer got data");
        System.out.println(String.format("ClientX %d, ClientY %d", clientX, clientY));
        System.out.println(String.format("clientSTate %s", clientState));
        System.out.println("server stop asking for data");

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

    public void setPlayer(Player player) {
        this.player = player;
        System.out.println("host player has now");
        System.out.println(player.getx());
        System.out.println(player.gety());
    }

    public void sendPlayerData(){

    }

}
