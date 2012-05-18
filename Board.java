public class Board{
    
    private Tile[][] board;
    private int height;
    private int width;


    public Board(int width, int height){
	board = new Tile[height][width];

	this.height = height;
	this.width = width;

	for (int r = 0; r<height; r++){
	    for (int c = 0; c<width; c++){
		board[r][c] = new Tile();
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