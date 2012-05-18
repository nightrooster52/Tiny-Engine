public class Entity{
    private int x, y;
    private String type = "X";

    public Entity(int x, int y){
	this.x = x;
	this.y = y;
    }
    public String toString(){
	return type;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void move(int dx, int dy){
	x += dx;
	y += dy;
    }


}