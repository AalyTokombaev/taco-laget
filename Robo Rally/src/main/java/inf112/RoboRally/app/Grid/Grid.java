package inf112.RoboRally.app.Grid;

/**
 * This class represents a Grid with given x,y dimensions.
 * The grid at given x,y coordinates contains an ArrayList with Objects
 */
public class Grid {
/*
    public ArrayList[][] grid;
    public int width, height;
    private Board board;

    public Grid(){
        board = new Board("Vault.tmx");
        width = (Integer) board.getMap().getProperties().get("width");
        height = (Integer) board.getMap().getProperties().get("height");
        // direction = board.wallLayer.getProperties().get("direction");
        grid = new ArrayList[width][height];
        fillGrid();
    }

    private void fillGrid(){
        for(int x = 0; x<width; x++){
            for (int y = 0; y<height; y++){
                grid[x][y] = new ArrayList<Object>();
                Vector2 pos = new Vector2(x,y);

                if (board.upperWallLayer.getCell(x,y) != null /* && board.wallLayer ){
                    grid[x][y].add(new Wall(board.upperWallLayer.getCell(x,y).getTile().getId(), pos, GridDirection.NORTH));
                }if (board.lowerWallLayer.getCell(x,y) != null){
                    grid[x][y].add(new Wall(board.lowerWallLayer.getCell(x,y).getTile().getId(), pos, GridDirection.SOUTH));
                }if (board.leftWallLayer.getCell(x,y) != null){
                    grid[x][y].add(new Wall(board.leftWallLayer.getCell(x,y).getTile().getId(), pos, GridDirection.WEST));
                }if (board.rightWallLayer.getCell(x,y) != null){
                    grid[x][y].add(new Wall(board.rightWallLayer.getCell(x,y).getTile().getId(), pos, GridDirection.EAST));
                }
            }
        }
    }
*/
}
