public class Entity{

    protected int x, y;
    protected String type = "#";

    public Entity(int x, int y){
	this.x = x;
	this.y = y;
    }

    public Entity(int x, int y, String type){
	this(x, y);
	this.type = type;
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


}