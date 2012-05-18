public class Board{
    
    private Tile[][] board;
    private int height;
    private int width;

    String defaultTile = "0";
    String blockTile = "#";
    String playerTile = "X"; //spawn
    String aiTile = "+"; //spawn
	

    //default map
    private String map = "020 020 " 
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "0000000000X000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000"
	+ "00000000000000000000";


    public Board(){
	parse(this.map);
    }
    public Board(String map){
	this.map = map;
	parse(this.map);
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
		String type = map.substring(cursor, cursor+1);

		if (type == blockTile){
		    type = defaultTile;
		    board[row][col] = new Tile(type);
		    Entity entity = new Entity(row, col);
		    board[row][col].occupy(entity);
		    cursor++;
		}
		if (type == playerTile){
		    type = defaultTile;
		    board[row][col] = new Tile(type);
		    Player player = new Player(row, col, playerTile);
		    board[row][col].occupy(player);
		    cursor++;
		}
		else{
		    board[row][col] = new Tile(type);
		    cursor++;
		}
	    }
	}
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