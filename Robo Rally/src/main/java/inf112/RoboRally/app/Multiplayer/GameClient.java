package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryo.Kryo;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.io.IOException;
import java.util.ArrayList;

public class GameClient {
    private Client client;
    public int id;
    RoboRally game;
    private PlayerControls ctrl;
    public Player player;
    public int hostX, hostY;
    public TiledMapTileLayer.Cell hostState;
    private ArrayList<ProgramCard> tempDeck;

    public GameClient(RoboRally game, Player player) {
        client = new Client();
        this.game = game;
        this.ctrl = ctrl;
        hostX = hostY = 0;
        hostState = new TiledMapTileLayer.Cell();
        this.player = player;

        Kryo kryo = client.getKryo();
        kryo.register(ProgramCard.class);

        for (int i = 0; i < 9; i++) {
            player.getDeck().takeCard(new ProgramCard(0, "", 0, "dummycard.jpg"));
        }
        tempDeck = new ArrayList<>();


        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof ProgramCard){
                    System.out.println("recieved card");
                    System.out.println(tempDeck.size());
                    System.out.println((((ProgramCard) object).getFilename()));
                    if (tempDeck.size() >= 9) {
                        player.getDeck().cards = tempDeck;
                        tempDeck = new ArrayList<>();
                    }
                    tempDeck.add((ProgramCard) object);
                }
                if (object instanceof String) {
                    // System.out.println("client recieved " + object.toString());
                    if (object.toString().equals("OK")){
                        System.out.println("OK");
                    }
                    String[] msg = object.toString().split(":");
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("clientX:%d", player.getx()));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("clientY:%d", player.gety()));
                    }
                    if (msg[0].equals("hostX")) {
                        hostX = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("hostY")) {
                        hostY = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("turnStart")){
                        for (int i = 0; i < 9; i++){
                            client.sendTCP("requestCard");
                        }
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

    public void askForCard(){
        client.sendTCP("requestCard");
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
        System.out.println(player.getx());
        System.out.println(player.gety());
    }


}
