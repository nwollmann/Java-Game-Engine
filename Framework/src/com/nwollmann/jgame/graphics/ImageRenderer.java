package com.nwollmann.jgame.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageRenderer implements GameRenderer{
	private BufferedImage image;

	public ImageRenderer(){

	}

	public ImageRenderer(String path){
		//image = Toolkit.getDefaultToolkit().getImage(path);
		//image = this.getClass().getResource();
		loadImage(path);
	}

	public void loadImage(String path){
		try{
			image = ImageIO.read(new File(path));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void render(int x, int y, Dimension size, Graphics2D graphics) {
		//graphics.drawImage(image, x, y, size.width, size.height, null);
		graphics.drawImage(image, x, y, size.width, size.height, null);
	}

}
