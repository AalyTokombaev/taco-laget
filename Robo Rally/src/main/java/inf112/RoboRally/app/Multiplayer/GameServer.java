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

import javax.swing.border.TitledBorder;
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


    public GameServer(RoboRally game, Player player){
        server = new Server();
        this.game = game;
        this.player = player;
        playerData = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            playerData.put(i, new PlayerData());
        }

        PlayerData data = new PlayerData();
        playerData.get(0).x = player.getx();
        playerData.get(0).y = player.gety();
        playerData.get(0).state = player.getStringState();


        Kryo kryo = server.getKryo();
        kryo.register(PlayerData.class);
        kryo.register(Request.class);


        server.addListener(new Listener(){
            public void received(Connection connection, Object object){
                if (object instanceof Request) {
                    System.out.println("server received request");
                    Request recv = (Request) object;
                    System.out.println(recv);
                    int i = recv.id;
                    int rx = recv.data.x;
                    int ry = recv.data.y;
                    String rstate = recv.data.state;
                    playerData.get(i).x = rx;
                    playerData.get(i).y = ry;
                    playerData.get(i).state = rstate;

                }

                if (object instanceof String) {
                    String[] msg  = ((String) object).split(":");
                    if (msg[0].equals("connectClient")){
                        numPlayers++;
                        connection.sendTCP(String.format("connectOK:%d", numPlayers));
                    }
                    if (msg[0].equals("requestData")) {
                            for (int i = 0; i < 10; i++){
                                System.out.println("sending player id" + i);
                                Request send = new Request();
                                PlayerData sendData = new PlayerData();
                                sendData.x = player.getx();
                                sendData.y = player.gety();
                                sendData.state = player.getStringState();
                                send.data = sendData;
                                send.id = id;
                                connection.sendTCP(send);
                        }
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
        server.sendToAllTCP("requestData");
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
        data.state = player.getStringState();
        playerData.put(id, data);
        System.out.println("host player has now");
        System.out.println(player.getx());
        System.out.println(player.gety());
    }

    public void sendPlayerData(){

    }

}
