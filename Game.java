import java.util.Scanner;

public class Game{


    public Game(){

	//example map change thing here v
	//board.getTile(5,5).mutate(block);

    }
    
    public static void main(String[] args){
	Game g = new Game();
	Scanner s = new Scanner(System.in);
	Board board = new Board();
	while (true){
	    System.out.println(g);
	    g.handleMove(s.next());
	}         
    }

    public String toString(){
	return board.toString();
    }
    public boolean checkTile(int x, int y){
	return (board.getTile(x,y).isOccupied()); //checks Tile occupancy

    }
    
    public boolean checkEdge(int x, int y){
	return (x<board.getWidth() && x>-1 && y<board.getHeight() && y>-1);

    }
    public void up(){
 	if (checkEdge(player.getX(),player.getY()-1) && checkTile(player.getX(),player.getY()-1)){
		board.getTile(player.getX(),player.getY()).vacate();
		player.move(0, -1);
		board.getTile(player.getX(),player.getY()).occupy(player);
	    }
    }
    public void down(){
 	if (checkEdge(player.getX(),player.getY()+1) && checkTile(player.getX(),player.getY()+1)){
		board.getTile(player.getX(),player.getY()).vacate();
		player.move(0, 1);
		board.getTile(player.getX(),player.getY()).occupy(player);
	    }
    }
    public void right(){
 	if (checkEdge(player.getX()+1,player.getY()) && checkTile(player.getX()+1,player.getY())){
		board.getTile(player.getX(),player.getY()).vacate();
		player.move(1, 0);
		board.getTile(player.getX(),player.getY()).occupy(player);
	    }
    }
    public void left(){
 	if (checkEdge(player.getX()-1,player.getY()) && checkTile(player.getX()-1,player.getY())){
		board.getTile(player.getX(),player.getY()).vacate();
		player.move(-1, 0);
		board.getTile(player.getX(),player.getY()).occupy(player);
	    }
    }

    public void handleMove(String s){
	if (s.equals("w")){
	    up();
	}
	else if (s.equals("a")){
	    left();
	}
	else if (s.equals("s")){
	    down();
	    }
	else if (s.equals("d")){
	    right();
	}
	else{}
    }
}