package wedgem.main;

import Window.Frame;

public class WedgemGame {
	Frame frame;

	public WedgemGame() {
		this.initWedgemGame();
	}

	public Frame getFrame() {
		return this.frame;
	}

	private void initWedgemGame() {
		this.setFrame(new Frame());
	}

	public void play() {
		// TODO play method
	}

	public void setFrame(final Frame frame) {
		this.frame = frame;
	}

}
