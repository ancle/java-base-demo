package design.adapter.advanced;

public class MP4MediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String filename) {
		// TODO Auto-generated method stub
		System.out.println("MP4 Media Player do not play the vlc file ");
	}

	@Override
	public void playMp4(String filename) {
		// TODO Auto-generated method stub
		System.out.println("MP4 Media Player play the file " + filename);
	}

}
