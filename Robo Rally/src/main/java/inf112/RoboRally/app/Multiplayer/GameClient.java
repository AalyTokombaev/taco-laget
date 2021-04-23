package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.io.IOException;
import java.util.HashMap;

public class GameClient {
    private Client client;
    public int id;
    RoboRally game;
    public Player player;

    public HashMap<Integer, PlayerData> playerData;

    public GameClient(RoboRally game,  Player player) {
        client = new Client();
        this.game = game;
        this.player = player;

        // initialize the hashmap
        playerData = new HashMap<>();
        for (int i = 0; i < 10; i++){
            playerData.put(i, new PlayerData());
        }

        Kryo kryo = client.getKryo();
        kryo.register(Request.class);

        client.addListener(new Listener() {
            public void received(Connection connection, Object object){
            }
        });
    }

    public int connect(String address, int port) {
        try{
            client.start();
            client.connect(4000, "localhost", 1337, 1337);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.sendTCP("connectClient");
        System.out.println("connecting");
        return id;
    }

    public void askForData(){
        // System.out.println("client asking for data");
        client.sendTCP("getY");
        client.sendTCP("getX");
        //System.out.println("client got data:");
        //System.out.println(String.format("hostX %d, hostY %d", hostX, hostY));
        //System.out.println(String.format("hostSTate %s", hostState));
        //System.out.println("client sop asking for data");
    }

    public void setPlayer(Player player){
        this.player = player;
        System.out.println("client player has now");
        System.out.println(player.getX());
        System.out.println(player.getY());
    }


}
