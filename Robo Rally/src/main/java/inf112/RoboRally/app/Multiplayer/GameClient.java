package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class GameClient {
    public Client client;
    public int id;
    RoboRally game;
    public Player player;
    public int hostX, hostY;
    public TiledMapTileLayer.Cell hostState;

    HashMap<Integer, ArrayList<ProgramCard>> playerCards;
    public boolean playersReady;

    public GameClient(RoboRally game, Player player) {
        client = new Client();
        this.game = game;
        this.player = player;
        hostX = hostY = 0;
        hostState = new TiledMapTileLayer.Cell();
        playersReady = false;

        playerCards = new HashMap<>();
        for (int i = 0; i < 10; i++){
            playerCards.put(i, new ArrayList<>());
        }

        Kryo kryo = client.getKryo();
        kryo.register(ProgramCard.class);
        kryo.register(ArrayList.class);
        kryo.register(Request.class);
        kryo.register(Stack.class);

        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {

                if (object instanceof Request) {
                    Request recv = (Request) object;
                    int i = recv.id;
                    ArrayList<ProgramCard> recvCards = recv.cards;
                    playerCards.put(i, recvCards);
                }

                if (object instanceof String) {
                    // System.out.println("client recieved " + object.toString());
                    if (object.toString().equals("OK")){

                        System.out.println("OK");
                    }
                    if (object.toString().equals(("ready"))){
                        playersReady = true;
                    }
                    String[] msg = object.toString().split(":");
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("clientX:%d", player.getX()));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("clientY:%d", player.getY()));
                    }
                    if (msg[0].equals("hostX")) {
                        hostX = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("hostY")) {
                        hostY = Integer.parseInt(msg[1]);
                    }
                }
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
    }


}
