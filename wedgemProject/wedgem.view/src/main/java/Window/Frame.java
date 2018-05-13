package Window;

import javax.swing.JFrame;

import gameSettings.GameSettings;

public class Frame extends JFrame {

	private static final long serialVersionUID = 8629432388334700177L;

	public Frame() {
		this.initFrame();
	}

	private void initFrame() {

		this.setTitle("Wedg'em! (alpha)");
		this.setSize(GameSettings.getBoardwidth() * GameSettings.getSquaresize(),
				GameSettings.getBoardheight() * GameSettings.getSquaresize());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
