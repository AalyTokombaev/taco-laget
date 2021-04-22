package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Cards.ProgramCard;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameServer{
    private Server server;
    public int numPlayers;
    // players done with turn
    int playersDone;
    RoboRally game;
    PlayerControls ctrl;
    public Player player;

    public int clientX, clientY;
    public TiledMapTileLayer.Cell clientState;

    HashMap<Integer, ArrayList<ProgramCard>> playersCards;


    public GameServer(RoboRally game, Player player){
        server = new Server();
        this.game = game;
        this.player = player;
        playersDone = 0;
        numPlayers = 0;
        playersCards = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            playersCards.put(i, new ArrayList<>());
        }

        Kryo kryo = server.getKryo();
        kryo.register(Request.class);
        kryo.register(Player.class);
        kryo.register(ArrayList.class);

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof Request) {
                    Request recv = (Request) object;
                    int i = recv.id;
                    ArrayList<ProgramCard> recvCards = recv.cards;
                    playersCards.put(i, recvCards);
                }
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
