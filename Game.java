import java.util.Scanner;
import java.util.Arrays;

public class Game{
    Board board;
    Player player;
    Ai[] aiArray;
    public String testString = "GAME REFERENCE VALID";

    public Game(){
	this.testString =  "GAME REFERENCE VALID";
	this.board = new Board();
	this.player = board.getPlayer();
	this.aiArray = board.getAiArray();
    }

    public String toString(){
	return board.toString();
    }
    
    

    public void moveEntity(int dx, int dy, Entity e){
      //System.out.println("called moveEntity");

      int px = e.getX();
      int py = e.getY();

      int x = px + dx;
      int y = py + dy;
      //System.out.println(x);      
      //System.out.println(y);      


      if (board.checkTile(x,y)){
	  //System.out.println("checkTile valid");
	  Tile targetTile = board.getTile(x, y);

	  // vacate Entity's current tile
	  board.getTile(px, py).vacate();

	  // move the entity
	  e.move(dx, dy);
        
	  // occupy the new tile
	  targetTile.occupy(e);
	        
      }
    }

    public void handleMove(String s, Entity e){
	//System.out.println("called handleMove");
	if (s.equals("w")){
	    e.face(s);
	    moveEntity(0, -1, e);
	}
	else if (s.equals("a")){
	    e.face(s);
	    moveEntity(-1, 0, e);
	}
	else if (s.equals("s")){
	    e.face(s);
	    moveEntity(0, 1, e);
	}
	else if (s.equals("d")){
	    e.face(s);
	    moveEntity(1, 0, e);
	}
	else{
	    ; // do nothing
	}
    }

    public void mainloop(Game g, Scanner s){
	board.takeGame(this);
	board.gameAi();
	while (true){
	    System.out.println(g);
	    g.handleMove(s.next(), player);
	    for (int i=0 ; i<aiArray.length; i++){
		aiArray[i].tick();
	    }
	}
    }
    

  /***********************************/
  public static void main(String[] args){
      Game g = new Game();
      Scanner s = new Scanner(System.in);
      g.mainloop(g, s);

  }
  /************************************/

}