package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.Player.Player;


public class GameLogic implements ApplicationListener {

    Player player;
    MapManager mapster;
    TiledMapTileLayer holes;
    TiledMapTileLayer walls;

    public GameLogic(Player player, MapManager mapster) {
        this.mapster = mapster;
        this.player = player;
        this.holes = (TiledMapTileLayer) mapster.getHoleLayer();
        this.walls = (TiledMapTileLayer) mapster.getWallLayer();
    }

    public void update() {
        System.out.println("logic tick");
        if (holes.getCell((int) player.getPosition().x, (int) player.getPosition().y) != null) {
            player.setDamage(1);
        }

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

    //Check of outBounds
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

}
