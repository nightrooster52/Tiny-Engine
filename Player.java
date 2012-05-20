public class Player extends Entity{
    private String type = "X";
    
    public Player(int x, int y){
	super(x, y);
    }

    public Player(int x, int y, String type){
	super(x, y, type);
    }

    public void move(int dx, int dy){
	this.x += dx;
	this.y += dy;
    }
    
}