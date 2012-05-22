import java.util.Scanner;

public class Game{
    Board board = new Board();
    Player player;
    Ai[] aiArray;

  public Game(){
    player = board.getPlayer();
    aiArray = board.getAiArray();
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

    public void moveEntity(int dx, int dy, Entity e){
      //System.out.println("called moveEntity");

      int px = e.getX();
      int py = e.getY();

      int x = px + dx;
      int y = py + dy;
      System.out.println(x);      
      System.out.println(y);      

      // if location is valid
      if ( checkEdge(x, y) ){

	  Tile targetTile = board.getTile(x, y);
	  if( !targetTile.isOccupied() ){

	      // vacate Entity's current tile
	      board.getTile(px, py).vacate();

	      // move the entity
	      e.move(dx, dy);
        
	      // occupy the new tile
	      targetTile.occupy(e);
	  }      
      }
  }
    



    public void handleMove(String s, Entity e){
      System.out.println("called handleMove");
      if (s.equals("w")){
	  moveEntity(0, -1, e);
      }
      else if (s.equals("a")){
	  moveEntity(-1, 0, e);
      }
      else if (s.equals("s")){
	  moveEntity(0, 1, e);
      }
      else if (s.equals("d")){
	  moveEntity(1, 0, e);
      }
      else{
	  ; // do nothing
      }
  }
    public void mainloop(Game g, Scanner s){
	while (true){
	    System.out.println(g);
	    g.handleMove(s.next(), player);
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