package image;

import java.awt.Image;

import gameSettings.GameSettings;

public abstract class SpriteProvider {

	public static Image getBoardSprite() {
		return ImageLoader.load(GameSettings.getSpriteBoard());
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
