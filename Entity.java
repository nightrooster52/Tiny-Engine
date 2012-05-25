public class Entity{

    protected int x, y;
    protected String string = "#";
    protected String facing = "w";



    public Entity(int x, int y){
	this.x = x;
	this.y = y;
    }

    public Entity(int x, int y, String string){
	this(x, y);
	this.string = string;
    }
    public String toString(){
	return string;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void die(){
	;
    }
    public void move(int dx, int dy){
	this.x += dx;
	this.y += dy;
    }
    public void face(String direction){
	this.facing = direction;
    }
}