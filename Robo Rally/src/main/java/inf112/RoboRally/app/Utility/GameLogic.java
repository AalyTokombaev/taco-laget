package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Player.Player;

import java.util.Collections;

public class GameLogic implements ApplicationListener {

    Player player;
    MapManager mapster;
    TiledMapTileLayer holes;
    TiledMapTileLayer walls;
    TiledMapTileLayer flags;

    public GameLogic(Player player, MapManager mapster) {
        this.mapster = mapster;
        this.player = player;
        this.holes = (TiledMapTileLayer) mapster.getHoleLayer();
        this.walls = (TiledMapTileLayer) mapster.getWallLayer();
        this.flags = (TiledMapTileLayer) mapster.getFlagLayer();
    }

    public void update() {
        System.out.println("logic tick");
        if (holes.getCell((int) player.getPosition().x, (int) player.getPosition().y) != null) {
            player.setDamage(1);
        }
        if(flags.getCell((int) player.getPosition().x, (int)player.getPosition().y) != null) {

            int id = flagIdChecker(player.getPosition());
            if(player.flagsVisited.contains(id)){
                System.out.println("Already visited");
            }
            else if(player.flagsVisited.isEmpty() && id == 1){
                player.flagsVisited.add(id);
            }else if(!player.flagsVisited.isEmpty()){
                if(id > Collections.max(player.flagsVisited)&& player.flagsVisited.contains(id-1)){
                    player.flagsVisited.add(id);
                }
            }
        }
        player.getScore();
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    //Check if outBounds
    public boolean outOfBounds(Vector2 pos) {
        if (pos.x < 0 || pos.y < 0) {
            return true;
        }
        return pos.x > 14 || pos.y > 14;
    }

    //Checker used to find wall-tile-properties

    public String DirChecker(Vector2 pos) {
        String gg = "";
        if (walls.getCell((int) pos.x, (int) pos.y) != null) {
            TiledMapTileLayer.Cell cell = walls.getCell((int) pos.x, (int) pos.y);
            gg = (String) cell.getTile().getProperties().get("DIRECTION");
            return gg;
        } else {
            System.out.println(gg);
            return gg;
        }
    }

    public int flagIdChecker(Vector2 pos){

        if(flags.getCell((int) pos.x, (int) pos.y) != null){
            TiledMapTileLayer.Cell cell = flags.getCell((int) pos.x, (int)pos.y);
            int id = (int) cell.getTile().getProperties().get("ID");
            return id;
        }else{
            return 0;
        }
    }

}