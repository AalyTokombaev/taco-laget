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
    public int id = 0;

    // the idea
    //{"playerId": {"x": str(int), "y":str(int), "state": str() }}

    public HashMap<Integer, PlayerData> playerData;
    public int clientX, clientY;
    public TiledMapTileLayer.Cell clientState;


    public GameServer(RoboRally game, Player player){
        server = new Server();
        this.game = game;
        this.player = player;
        playerData = new HashMap<>();
        PlayerData data = new PlayerData();
        data.x = player.getx();
        data.y = player.gety();
        data.state = player.getState();
        playerData.put(0, data);

        Kryo kryo = server.getKryo();
        kryo.register(PlayerData.class);

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof String) {
                    String msg[] = object.toString().split(":");
                    if (msg[0].equals("connectClient")){
                        numPlayers++;
                        connection.sendTCP(String.format("connectOK:%d", numPlayers)); // this be the id client wants

                    }
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("hostX:%d:%d", player.getx(), id));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("hostY:%d:%d", player.gety(), id));
                    }
                    if (msg[0].equals("getState")){
                        connection.sendTCP(String.format("state:%s:%d", player.getStringState(), id));
                    }
                    if (msg[0].equals("clientX")) {
                        int id = Integer.parseInt(msg[2]);
                        playerData.get(id).x = Integer.parseInt(msg[1]);
                        //clientX = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("clientY")) {
                        int id = Integer.parseInt(msg[2]);
                        playerData.get(id).y = Integer.parseInt(msg[1]);
                        //clientY = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("state")){
                        int id = Integer.parseInt(msg[2]);
                        playerData.get(id).state = player.stringToState(msg[1]);
                        //clientX = Integer.parseInt(msg[1]);
                        //clientState = player.stringToState(msg[1]);
                    }
                }
            }
        });
    }

    public TiledMapTileLayer.Cell stringToState(String state){
        return player.stringToState(state);
    }

    public int toInt(String s) {
        return Integer.parseInt(s);
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
        PlayerData data = new PlayerData();
        data.id = id;
        data.x = player.getx();
        data.y = player.gety();
        data.state = player.getState();
        playerData.put(id, data);
        System.out.println("host player has now");
        System.out.println(player.getx());
        System.out.println(player.gety());
    }

    public void sendPlayerData(){

    }

}
