package image;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameSettings.GameSettings;

public abstract class ImageLoader {

	public static Image load(final String imagePath) {
		try {
			Image image = ImageIO.read(ImageLoader.class.getResource(imagePath));
			return image.getScaledInstance((int) (image.getWidth(null) * GameSettings.getGraphicsscale()),
					(int) (image.getHeight(null) * GameSettings.getGraphicsscale()), Image.SCALE_SMOOTH);
		} catch (IOException e) {
			return null;
		}
	}
}
