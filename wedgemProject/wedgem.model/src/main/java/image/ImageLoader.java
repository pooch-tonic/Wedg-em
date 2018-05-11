package image;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoader {

	public static Image load(final String imageName) {
		try {
			return ImageIO.read(new File(imageName));
		} catch (IOException e) {
			return null;
		}
	}
}
