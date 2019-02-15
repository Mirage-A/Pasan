// I wrote this game ~2 years ago, so pls dont look source code unless you want your eyes to bleed :)
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class music extends Thread
{
	Clip clip;
	Clip gameclip;
	@Override
	public void run()
	{
	}
	public void load(int i){
		try {
			File soundFile = new File("./Pasan_Music/menu"+i+".wav");
			gameclip = AudioSystem.getClip();
			gameclip.open(AudioSystem.getAudioInputStream(soundFile));
			gameclip.setFramePosition(0);
			gameclip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
			exc.printStackTrace();
		}
	}
	public void closeall(){
		gameclip.close();
	}
}
