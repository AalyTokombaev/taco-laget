package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import inf112.RoboRally.app.Objects.States;
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
    //public int hostX, hostY;
    //public TiledMapTileLayer.Cell hostState;

    // ok
    public HashMap<Integer, PlayerData> playerData;

    public GameClient(RoboRally game, Player player) {
        client = new Client();
        this.game = game;
        this.player = player;

        id = 0;

        playerData = new HashMap<>();
        PlayerData data = new PlayerData();
        for (int i = 0; i < 8; i++) {playerData.put(i, new PlayerData());}

        Kryo kryo = client.getKryo();
        kryo.register(PlayerData.class);
        kryo.register(Request.class);


        client.addListener(new Listener(){
            public void received(Connection connection, Object object) {
                if (object instanceof Request) {
                    int i = ((Request) object).id;
                    int rx = ((Request) object).data.x;
                    int ry = ((Request) object).data.y;
                    TiledMapTileLayer.Cell rstate = ((Request) object).data.state;
                    playerData.get(i).x = rx;
                    playerData.get(i).y = ry;
                    playerData.get(i).state = rstate;
                }
                if (object instanceof String){
                    String[] msg = ((String) object).split(":");
                    if (msg[0].equals("connectOK")){
                        id  = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("requestData")){
                        Request send = new Request();
                        PlayerData sendData = new PlayerData();
                        sendData.x = player.getx();
                        sendData.y = player.gety();
                        sendData.state = player.getState();
                        send.data = sendData;
                        send.id = id;
                        connection.sendTCP(send);
                    }
                }
            }
        });

        /*
        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof String) {
                    String[] msg = object.toString().split(":");
                    if (msg[0].equals("connectOK")){
                        id = Integer.parseInt(msg[1]);

                    }
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("clientX:%d:%d", player.getx(), id));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("clientY:%d:%d", player.gety(), id));
                    }
                    if (msg[0].equals("getState")){
                        connection.sendTCP(String.format("state:%s:%d", player.getStringState(), id));
                    }
                    if (msg[0].equals("hostX")) {
                        // "hostX:X:id
                        int i = Integer.parseInt(msg[2]);
                        playerData.get(i).x = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("hostY")) {
                        int i = Integer.parseInt(msg[2]);
                        playerData.get(i).y = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("state")){
                        int i = Integer.parseInt(msg[2]);
                        playerData.get(i).state = player.stringToState(msg[1]);
                    }
                }
            }
        });

         */
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
        client.sendTCP("getState");
    }

    public void setPlayer(Player player){
        PlayerData data = new PlayerData();
        data.x = player.getx();
        data.y = player.gety();
        data.state = player.getState();
        playerData.put(id, data);
    }


}
