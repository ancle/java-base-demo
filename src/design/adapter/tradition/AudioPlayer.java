package design.adapter.tradition;

import design.adapter.MediaAdapter;

public class AudioPlayer implements MediaPlayer {
	private MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String filename) {
		// TODO Auto-generated method stub
		switch(audioType) {
		case "mp3" :
			System.out.println("Playing mp3 file. Name: "+ filename);
			break;
		case "vlc":
		case "mp4":
			this.mediaAdapter = new MediaAdapter(audioType);
			this.mediaAdapter.play(audioType, filename);
			break;
		default :
			System.out.println("Invalid media. "+ audioType + " format not supported");
		}
	}

}
