public class ESeekerBrain{
    
    private Entity target;
    protected Ai body;
    protected Board board;
    protected Game game;

    public ESeekerBrain(Ai body, Entity target, Board board){
	this.body = body;
	this.target = target;
	this.board = board;


    }

    public String goToXY(int targetx, int targety, Board b){


	int ix = body.getX();
	int iy = body.getY();
	//System.out.println("AI");
	//System.out.println(ix);
	//System.out.println(iy);


	int tx = targetx;
	int ty = targety;
	//System.out.println(tx);
	//System.out.println("Target");
	//System.out.println(ty);

	
	int distancex = (tx - ix);
	int distancey = (ty - iy);
	//System.out.println("Distance");
	//System.out.println(distancex);
	//System.out.println(distancey);
	
	//set up the dx/dy
	int attemptx;
	int attempty;
	String aXstr = "";
	String aYstr = "";
	if (distancex > 0){
	    attemptx = 1;
	    aXstr = "d";
	    //System.out.println("Right attempt");
	}else{
	    attemptx = -1;
	    aXstr = "a";
	    //System.out.println("Left attempt");
	    	}
	if (distancey > 0){
	    attempty = 1;
	    aYstr = "s";

	    //System.out.println("Down attempt");
	}else{
	    attempty = -1;
	    aYstr = "w";
	    //System.out.println("Up attempt");
	}

	int dx = ix + attemptx;
	int dy = iy + attempty;

	String attempt = "w";
	//farther in x than y distance (squared for absolute value), x dominates
	if (distancex*distancex > distancey*distancey){
	    //System.out.println("distance larger: y");
	    if (board.checkTile(dx, iy)){
		//System.out.println("check x valid");
		    attempt = aXstr;
	    }else{
		attempt =  aYstr;
		    }
	}else{
	    //System.out.println("distance larger: y");
	    if (board.checkTile(ix, dy)){
		//System.out.println("check y valid");
		attempt = aYstr;
	    }else{
		attempt = aXstr;
	    }
		    }
	return attempt;
	    }

    public String goToTarget(){
	int targetx = target.getX();
	int targety = target.getY();
	String attempt = goToXY(targetx, targety, board);
	//System.out.println("Ai attempted move");
	return attempt;
    }

    public void takeGame(){
	this.game = board.getGame();
    }
    public void tick(){
	//System.out.println("ESeekerBrain ticked");
	//System.out.println(board.testString);
	String output= goToTarget();
	//System.out.println(output);
	//throws nullpointer exception
	game.handleMove(output, body); 
    }
}
