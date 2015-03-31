package blackjack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import com.nwollmann.jgame.graphics.ColorRenderer;
import com.nwollmann.jgame.graphics.ImageRenderer;
import com.nwollmann.jgame.util.GameObject;

public class Table extends GameObject{
	
	private ColorRenderer color;
	private ImageRenderer texture;
	
	private int r, g, b, tarR, tarG, tarB;
	
	public Table(){
		texture = new ImageRenderer("tabletop.png");
		color = new ColorRenderer(new Color(0,0,0));
	}
	
	
	
	@Override
	public void draw(Graphics2D graphics){
		color.render(this.getPosition().x, this.getPosition().y, this.getSize(), graphics);
		texture.render(this.getPosition().x, this.getPosition().y, this.getSize(), graphics);
	}
	
	@Override
	public void update(){
		if(r < tarR) r++;
		else if(r > tarR) r--;
		if(g < tarG) g++;
		else if(g > tarG) g--;
		if(b < tarB) b++;
		else if(b > tarB) b--;
		if(r == tarR && g == tarG && b == tarB){
			Random rand = new Random();
			tarR = rand.nextInt(255);
			tarG = rand.nextInt(255);
			tarB = rand.nextInt(255);
		}
		color.setColor(new Color(r, g, b));
	}
	
}
