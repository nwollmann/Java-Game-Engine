package flappy;

public class ObstaclePair {
	private Obstacle top;
	private Obstacle bottom;
	
	public ObstaclePair(){
		top = new Obstacle();
		bottom = new Obstacle();
	}
	
	public ObstaclePair(Obstacle top, Obstacle bottom){
		this.top = top;
		this.bottom = bottom;
	}
	
	public Obstacle getTop(){
		return top;
	}
	
	public Obstacle getBottom(){
		return bottom;
	}
	
	public void setTop(Obstacle top){
		this.top = top;
	}
	
	public void setBottom(Obstacle bottom){
		this.bottom = bottom;
	}
}
