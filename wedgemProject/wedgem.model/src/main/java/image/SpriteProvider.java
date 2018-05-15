package image;

import java.awt.Image;

import gameSettings.GameSettings;
import interfacesModel.ISpriteProvider;

public abstract class SpriteProvider implements {

	public static Image getBoardSprite() {
		return ImageLoader.load(GameSettings.getSpriteBoard());
	}

	public static Image getDelimiterSprite() {
		return ImageLoader.load(GameSettings.getSpriteDelimiter());
	}

	public static Image getSpriteByPlayer(final int player) {
		switch (player) {
		case 1:
			return ImageLoader.load(GameSettings.getSpriteP1());
		case 2:
			return ImageLoader.load(GameSettings.getSpriteP2());
		default:
			return null;
		}
	}

}
