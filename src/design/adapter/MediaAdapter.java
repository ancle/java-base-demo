package design.adapter;

import design.adapter.advanced.AdvancedMediaPlayer;
import design.adapter.advanced.MP4MediaPlayer;
import design.adapter.advanced.VlcMediaPlayer;
import design.adapter.tradition.MediaPlayer;

public class MediaAdapter implements MediaPlayer {
	private AdvancedMediaPlayer advancedMediaPlayer;
	
	public MediaAdapter(String autoType) {
		if (autoType.equalsIgnoreCase("vlc")) {
			this.advancedMediaPlayer = new VlcMediaPlayer();
		}
		
		if (autoType.equalsIgnoreCase("mp4")) {
			this.advancedMediaPlayer = new MP4MediaPlayer();
		}
	}
	
	@Override
	public void play(String autoType, String filename) {
		switch(autoType) {
		case "vlc":
			this.advancedMediaPlayer.playVlc(filename);
			break;
		case "mp4":
			this.advancedMediaPlayer.playMp4(filename);
			break;
		default :
		}
	}
	

}
