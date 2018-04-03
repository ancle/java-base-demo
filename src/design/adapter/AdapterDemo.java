package design.adapter;

import design.adapter.tradition.AudioPlayer;
import design.adapter.tradition.MediaPlayer;

public class AdapterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MediaPlayer mediaPlayer = new AudioPlayer();
		mediaPlayer.play("mp4", "I Love U");
	}

}
