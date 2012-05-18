import java.util.Scanner;

public class Game{
    Board board = new Board();

    public Game(){

	//example map change thing here v
	//board.getTile(5,5).mutate(block);

    }
    
    public static void main(String[] args){
	Game g = new Game();
	Scanner s = new Scanner(System.in);
	
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
 	if (checkEdge(entity.getX(),entity.getY()-1) && checkTile(entity.getX(),entity.getY()-1)){
		board.getTile(entity.getX(),entity.getY()).vacate();
		entity.move(0, -1);
		board.getTile(entity.getX(),entity.getY()).occupy(entity);
	    }
    }
    public void down(){
 	if (checkEdge(entity.getX(),entity.getY()+1) && checkTile(entity.getX(),entity.getY()+1)){
		board.getTile(entity.getX(),entity.getY()).vacate();
		entity.move(0, 1);
		board.getTile(entity.getX(),entity.getY()).occupy(entity);
	    }
    }
    public void right(){
 	if (checkEdge(entity.getX()+1,entity.getY()) && checkTile(entity.getX()+1,entity.getY())){
		board.getTile(entity.getX(),entity.getY()).vacate();
		entity.move(1, 0);
		board.getTile(entity.getX(),entity.getY()).occupy(entity);
	    }
    }
    public void left(){
 	if (checkEdge(entity.getX()-1,entity.getY()) && checkTile(entity.getX()-1,entity.getY())){
		board.getTile(entity.getX(),entity.getY()).vacate();
		entity.move(-1, 0);
		board.getTile(entity.getX(),entity.getY()).occupy(entity);
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