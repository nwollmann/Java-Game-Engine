package flappy;
import com.nwollmann.jgame.GameInput;
public class InputListener extends GameInput{
	@Override
	public void keyPressed(int keyID){
		if(keyID == 32){
			Player.getInstance().translateY(-50);
		}
	}
}
