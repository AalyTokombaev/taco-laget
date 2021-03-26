package inf112.RoboRally.app.Multiplayer;


import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Player.Player;

public class Multiplayer {
    boolean hosting;

    Player player;
    Player[] players;
    int numPlayers;

    Server server;
    Client client;


    public Multiplayer() {
        server = new Server();
        client = new Client();
        players = new Player[5];

        // listeners

        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof String) {
                    String[] msg = object.toString().split(":");
                }
            }
        });

        client.addListener(new Listener() {
            public void recieved(Connection connection, Object object) {
                if (object instanceof String) {
                    String[] msg = object.toString().split(":");
                }
            }
        });
    }

    public void send() {

    }
}
