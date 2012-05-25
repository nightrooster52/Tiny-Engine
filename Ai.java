public class Ai extends Entity{
    protected ESeekerBrain brain;
    protected Board board;
    protected Entity target;

    public Ai(int x, int y, Board b){
	super(x, y);
	this.board = b;
	this.target = this;
	this.setTarget(this);
	this.string = "?";


	//make a default Brain.java type and instantiate it here
	//for now make sure to pass Ai a target every time
    }

    public Ai(int x, int y, Entity target, Board b){
	super(x, y);
	this.board = b;
	this.target = target;
	this.setTarget(target);

    }
    public void tick(){
	//System.out.println("asked the Ai to tick");
	//System.out.println(board.testString);
	brain.tick();
    }
    
    public void setTarget(Entity target){
	this.target = target;
	newBrain();
	this.string = "+";
    }
    public void newBrain(){
	this.brain = new ESeekerBrain(this, target, board);
    }

}