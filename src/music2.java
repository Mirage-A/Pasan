// I wrote this game ~2 years ago, so pls dont look source code unless you want your eyes to bleed :)
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class music2 extends Thread
{
	public final int kol=5;
	Clip gameclip;
	Clip fireclip,arrowclip,stormclip,coldclip;
	public void load(int i){
		try {
			File soundFile = new File("./Pasan_Music/arrow.wav");
			arrowclip = AudioSystem.getClip();
			arrowclip.open(AudioSystem.getAudioInputStream(soundFile));
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
			exc.printStackTrace();
		}
			
		try{
			File soundFile = new File("./Pasan_Music/fireball.wav");
			fireclip = AudioSystem.getClip();
			fireclip.open(AudioSystem.getAudioInputStream(soundFile));
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
			exc.printStackTrace();
		}
		try{	
			File soundFile = new File("./Pasan_Music/storm.wav");
			stormclip = AudioSystem.getClip();
			stormclip.open(AudioSystem.getAudioInputStream(soundFile));
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
			exc.printStackTrace();
		}
		try{
			File soundFile = new File("./Pasan_Music/cold_embrace.wav");
			coldclip = AudioSystem.getClip();
			coldclip.open(AudioSystem.getAudioInputStream(soundFile));
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
			exc.printStackTrace();
		}
			
				try{
			File soundFile = new File("./Pasan_Music/game"+i+".wav");
			gameclip = AudioSystem.getClip();
			gameclip.open(AudioSystem.getAudioInputStream(soundFile));
			gameclip.setFramePosition(0);
			gameclip.start();
				} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
					exc.printStackTrace();
				}
			
	}
	public void closeall(){
		arrowclip.close();
		fireclip.close();
		coldclip.close();
		stormclip.close();
		gameclip.close();
	}
	public void game(){
		gameclip.setFramePosition(0);
		gameclip.start();
	}
	public void fireball(){
		//if(fireclip.isActive()){fireclip.stop();}
		fireclip.setFramePosition(0);
		fireclip.start();
	}
	public void arrow(){
		//if(arrowclip.isActive()){arrowclip.stop();}
		arrowclip.setFramePosition(0);
		arrowclip.start();
	}
	public void storm(){
		//if(stormclip.isActive()){stormclip.stop();}
		stormclip.setFramePosition(0);
		stormclip.start();
	}
	public void cold_embrace(){
		//if(coldclip.isActive()){coldclip.stop();}
		coldclip.setFramePosition(0);
		coldclip.start();
	}
}
