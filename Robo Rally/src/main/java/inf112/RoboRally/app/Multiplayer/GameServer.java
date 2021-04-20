package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.io.IOException;

public class GameServer{
    private Server server;
    public int numPlayers = 0;
    RoboRally game;
    PlayerControls ctrl;
    public Player player;

    public int clientX, clientY;
    public TiledMapTileLayer.Cell clientState;


    public GameServer(RoboRally game, PlayerControls ctrl){
        server = new Server();
        this.game = game;
        this.ctrl = ctrl;

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof String) {
                    String msg[] = object.toString().split(":");
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("hostX:%d", player.getX()));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("hostY:%d", player.getY()));
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
        //System.out.println("server asking for data");
        server.sendToAllTCP("getY");
        server.sendToAllTCP("getX");
        //System.out.println("serfer got data");
        //System.out.println(String.format("ClientX %d, ClientY %d", clientX, clientY));
        //System.out.println(String.format("clientSTate %s", clientState));
        //System.out.println("server stop asking for data");

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
        System.out.println(player.getX());
        System.out.println(player.getY());
    }

    public void sendPlayerData(){

    }

}
