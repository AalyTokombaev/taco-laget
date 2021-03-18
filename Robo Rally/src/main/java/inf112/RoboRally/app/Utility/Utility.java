package inf112.RoboRally.app.Utility;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Utility {

    public static final AssetManager assetManager = new AssetManager();

    private static InternalFileHandleResolver filePathResolver = new InternalFileHandleResolver();

    public static void unloadAssets(String assetFilePath){
        if(assetManager.isLoaded(assetFilePath)){
            assetManager.unload(assetFilePath);
        }else{
            System.out.println("error");
        }
    }

    public static float loadCompleted(){
        return assetManager.getProgress();
    }
    public static int assetsQueued(){
        return assetManager.getQueuedAssets();
    }
    public static boolean updateAssetsLoading(){
        return assetManager.update();
    }

    public static boolean isAssetLoaded(String filename){
        return assetManager.isLoaded(filename);
    }

    public static void loadMap(String mapName){
        if(mapName == null || mapName.isEmpty()){
            return;
        }

        if (filePathResolver.resolve(mapName).exists()){
            assetManager.setLoader(TiledMap.class, new TmxMapLoader(filePathResolver));
            assetManager.load(mapName,TiledMap.class);
            assetManager.finishLoadingAsset(mapName);
        }else{
            System.out.println("error2");
        }
    }
    public static TiledMap getMapAsset(String mapFilePath){
        TiledMap map = null;
        if(assetManager.isLoaded(mapFilePath)){
            map = assetManager.get(mapFilePath,TiledMap.class);
        }else{
            System.out.println("error3");
        }
        return map;
    }
    public static void loadTextureAsset(String textureFilenamePath){
        if( textureFilenamePath == null || textureFilenamePath.isEmpty()){
            return;
        }
        if(filePathResolver.resolve(textureFilenamePath).exists() ){
            assetManager.setLoader(Texture.class, new TextureLoader(filePathResolver));
            assetManager.load(textureFilenamePath, Texture.class);
            //Until we add loading screen,
            // just block until we load the map
            assetManager.finishLoadingAsset(textureFilenamePath);
        } else{
            System.out.println("error4");
        }
    }

    public static Texture getTextureAsset(String textureFilenamePath){
        Texture texture = null;
        // once the asset manager is done loading
        if(assetManager.isLoaded(textureFilenamePath) ){
            texture = assetManager.get(textureFilenamePath,Texture.class);
        } else {
            System.out.println("error4");  }

        return texture;
    }



}
