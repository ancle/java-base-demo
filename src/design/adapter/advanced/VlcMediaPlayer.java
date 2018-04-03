package design.adapter.advanced;

public class VlcMediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String filename) {
		// TODO Auto-generated method stub
		System.out.println("Vle Media Player play the file " + filename );
	}

	@Override
	public void playMp4(String filename) {
		// TODO Auto-generated method stub
		System.out.println("Vle Media Player Do not play the MP4 file ");
	}
	
}
