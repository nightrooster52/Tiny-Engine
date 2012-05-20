import java.util.Scanner;

public class Game{
  Board board = new Board();
  Player player;

  public Game(){
    player = board.getPlayer();
    //System.out.println(player);
    //example map change thing here v
    //board.getTile(5,5).mutate(block);

  }

  public String toString(){
    return board.toString();
  }

  public boolean checkTile(int x, int y){
      //System.out.println("called checkTile");      
      return (board.getTile(x,y).isOccupied()); //checks Tile occupancy
  }


  public boolean checkEdge(int x, int y){
      //System.out.println("called checkEdge");
      return (x<board.getWidth() && x>-1 && y<board.getHeight() && y>-1);

  }



  public void movePlayer(int dx, int dy){
      //System.out.println("called movePlayer");
      int px = player.getX();
      int py = player.getY();



      int x = px + dx;
      int y = py + dy;
      System.out.println(x);      
      System.out.println(y);      

      // if location is valid
      if ( checkEdge(x, y) ){

	  Tile targetTile = board.getTile(x, y);
	  if( !targetTile.isOccupied() ){

	      // vacate players current tile
	      board.getTile(px, py).vacate();

	      // move the player
	      player.move(dx, dy);
        
	      // occupy the new tile
	      targetTile.occupy(player);
      }      
    }
  }


  public void handleMove(String s){
      System.out.println("called handleMove");
      if (s.equals("w")){
	  movePlayer(0, -1);
      }
      else if (s.equals("a")){
	  movePlayer(-1, 0);
      }
      else if (s.equals("s")){
	  movePlayer(0, 1);
      }
      else if (s.equals("d")){
	  movePlayer(1, 0);
      }
      else{
	  ; // do nothing
      }
  }



  /***********************************/
  public static void main(String[] args){
      Game g = new Game();
      Scanner s = new Scanner(System.in);

      while (true){
	  System.out.println(g);
	  g.handleMove(s.next());
    }
  }
  /************************************/

}