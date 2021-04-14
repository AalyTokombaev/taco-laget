package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Objects.States;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.io.IOException;
import java.util.HashMap;

public class GameServer{
    private Server server;
    public int numPlayers = 0;
    RoboRally game;
    public Player player;

    // the idea
    //{"playerId": {"x": str(int), "y":str(int), "state": str() }}

    public HashMap<String, HashMap<String, String>> playerData;
    public int clientX, clientY;
    public TiledMapTileLayer.Cell clientState;


    public GameServer(RoboRally game){
        server = new Server();
        this.game = game;
        playerData = new HashMap<>();

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof String) {
                    String msg[] = object.toString().split(":");
                    if (msg[0].equals("connectClient")){
                        numPlayers++;
                        connection.sendTCP(String.format("connectOK:%d", numPlayers));
                    }
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("hostX:%d", player.getx()));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("hostY:%d", player.gety()));
                    }
                    if (msg[0].equals("getState")){
                        connection.sendTCP(String.format("state:%s", player.getStringState()));
                    }
                    if (msg[0].equals("clientX")) {
                        clientX = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("clientY")) {
                        clientY = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("state")){
                        clientState = player.stringToState(msg[1]);
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
        //System.out.println("server asking for data");
        server.sendToAllTCP("getY");
        server.sendToAllTCP("getX");
        server.sendToAllTCP("getState");

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
