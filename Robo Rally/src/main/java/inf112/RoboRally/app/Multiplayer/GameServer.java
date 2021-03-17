package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputAdapter;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import inf112.RoboRally.app.Objects.Player;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;

public class GameServer extends InputAdapter{
    private Server server;
    private boolean active;
    int numPlayers;

    Queue<Action> actions;


    public GameServer(){
        server = new Server();


        server.addListener(new Listener(){
            public void recieved(Connection connection, Object object) {
                if (object instanceof String) {
                    String[] msg = object.toString().split(":");
                    if (msg[0].equals("connected")){
                        addPlayer();
                        connection.sendTCP("OK");
                    }
                    if (msg[0] == "mov"){
                        int i = Integer.parseInt(msg[1]);
                        actions.offer(new Action("mov", i));

                    }
                }
            }
        });

    }

    private void addPlayer(){
        numPlayers++;
    }

    public Iterator<Action> getActons(){
        return actions.iterator();
    }

    void host(){
        try{
        server.bind(1337);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addPlayer();
    }


}
