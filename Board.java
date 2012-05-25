import java.util.Arrays;

public class Board{

    private Tile[][] board;
    private int height;
    private int width;
    private Player player;
    private Ai[] aiArray = new Ai[0];
    private Game game;


    private String defaultTile = "0";
    private String blockTile = "#";
    private String playerTile = "X"; //spawn
    private String aiTile = "+"; //spawn

    public String testString = "ACCESS TO BOARD";

    //default map
    private String map = "020 020 "
        + "00000000000000000000"
        + "00000000000000000000"
        + "000000000X0000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "000000000###00000000"
        + "00000000000000000000"
        + "000++000000000000000"
        + "00++++00000000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "00000000+++000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "00000000000000000000"
        + "00000000000000000000";



    public Board(String map){
        this.map = map;
        parse(this.map);
        //System.out.println(g.testString);
    }

    public Board(){
        parse(this.map);
        //System.out.println(this.game.testString);
    }


    public void parse(String map){
        //slices out the w and h
        this.width = Integer.parseInt(map.substring(0,3));
        this.height = Integer.parseInt(map.substring(4,7));

        //new tile array
        board = new Tile[height][width];

        int cursor = 8; //the starting index of the map data

        for (int row = 0; row<height; row++){
            for (int col = 0; col<width; col++){
                String type = (map.substring(cursor, cursor+1));

                if (type.equals(blockTile)){
                    //System.out.println("Block Generated");
                    type = defaultTile;
                    board[row][col] = new Tile(type);
                    Entity entity = new Entity(col, row, blockTile);
                    board[row][col].occupy(entity);
                    cursor++;
                } else if (type.equals(playerTile)){
                    type = defaultTile;
                    board[row][col] = new Tile(type);
                    this.player = new Player(col, row, playerTile);
                    board[row][col].occupy(player);
                    cursor++;
                } else if (type.equals(aiTile)){  //AI STUFF
                    type = defaultTile;
                    board[row][col] = new Tile(type);
                    int arraySize = aiArray.length;
                    this.aiArray = Arrays.copyOf(aiArray, arraySize + 1);
                    Ai ai = new Ai(col, row, this);
                    aiArray[arraySize] = ai;
                    board[row][col].occupy(ai);
                    cursor++;
                } else {
                    type = defaultTile;
                    board[row][col] = new Tile(type);
                    cursor++;
                }

            }
        }
        //System.out.println("EntityGen complete");

        for (int i = 0; i < aiArray.length; i++){
            aiArray[i].setTarget(player);
        }
    }

    public boolean checkTile(int x, int y){
        //System.out.println("called checkTile")
        boolean inBounds =  (x<width && x>-1 && y<height && y>-1);
        //System.out.println(inBounds);
        if (inBounds){
            return (!board[y][x].isOccupied());

        }
        return false;
    }
    public void gameAi(){
	for (int i = 0; i<aiArray.length ;i++){
	    aiArray[i].brain.takeGame();
	}
	

    }
    public void takeGame(Game g){
        this.game = g;
    }

    public Game getGame(){
        //System.out.println("getGame() called");
        return this.game;
    }

    public Tile getTile(int x, int y){
        return board[y][x];
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public Player getPlayer(){
        return player;
    }
    public Ai[] getAiArray(){
        return aiArray;
    }

    public String toString(){
        String t = "";
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++){
                t += board[row][col].toString() + " ";
            }

            t += "\n";
        }
        return t;
    }

}