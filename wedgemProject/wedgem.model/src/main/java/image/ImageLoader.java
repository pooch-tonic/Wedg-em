package image;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoader {

	public static Image load(final String imagePath) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(imagePath));
		} catch (IOException e) {
			return null;
		}
	}
}
