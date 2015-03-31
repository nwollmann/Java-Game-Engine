package flappy;
import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.input.GameInput;
public class InputListener implements GameInput{
	@Override
	public void keyPressed(int keyID){
		if(keyID == 32)
			Player.getInstance().translateY(-50);
		else if(keyID == 37)
			GameManager.getInstance().getGraphicsManager().translate(20, 0);
		else if(keyID == 39)
			GameManager.getInstance().getGraphicsManager().translate(-20, 0);
		
	}
}
