package flappy;
import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.util.GameObject;
public class Player extends GameObject{
	private static Player instance;
	
	private double score;
	
	public Player(){
		super();
		instance = this;
		score = 0;
	}
	
	public void adjustScore(double change){
		score += change;
		Main.label.setText("Score: " + (int)score);
	}
	
	public double getScore(){
		return score;
	}
	
	public static Player getInstance(){
		return instance;
	}
	@Override
	public void update(){
		if(this.getPosition().y >= 550) GameManager.getInstance().haltGame();
		this.translateY(3);
	}
}
