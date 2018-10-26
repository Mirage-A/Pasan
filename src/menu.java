import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
public class menu extends JFrame{
	public main_menu gameP;
	int ram=1;
	File map;
	String name;
	int track;
	public editor ggwp;
	boolean active=true;
	public okno ggpw;
	Timer checktimer;
	music musicThread;
	String profile="";
	int scrW,scrH;
	KeyListener keylis1,keylis2,keylis3;
	Timer musicTimer;
	public class myKey implements KeyListener
	{
		public void keyPressed(KeyEvent e){
			int key_ = e.getKeyCode();
			if(gameP.inMessage==0){
			if(key_==38){
				if (ram>1) {ram-=1; gameP.ram=ram;};
			}
			else if(key_==40){
				if (ram<4) {ram+=1; gameP.ram=ram;};
			}
			else if((key_==32)|(key_==10)){
				if (ram==1) {
					stop();
					ggpw.start(name,true);
					
				}
				else if (ram==2) {
					gameP.inMessage=1;
					gameP.mes.setVisible(true);
					gameP.head.setVisible(true);
					gameP.textField.setVisible(true);
					gameP.head.setText("Выбор уровня");
					gameP.mes.setText("Введите название уровня:");
					gameP.textField.setText("");
					gameP.textField.requestFocus();
					gameP.textField.addKeyListener(keylis1);
				}
				else if (ram==3) {
					gameP.inMessage=3;
					gameP.mes.setVisible(true);
					gameP.head.setVisible(true);
					gameP.textField.setVisible(true);
					gameP.head.setText("Редактор карт");
					gameP.mes.setText("Введите название карты:");
					gameP.textField.setText("");
					gameP.textField.requestFocus();
					gameP.textField.addKeyListener(keylis2);
					
				}
				else if (ram==4) {
					System.exit(0);
				}
			}
		}	
		/////////////////////////////////////////////////////////////////////////////////////////////////
		else{
			if(gameP.inMessage==2){
				if((key_==27)|(key_==10)){
				gameP.inMessage=0;
				gameP.mes.setVisible(false);
				gameP.head.setVisible(false);
				gameP.textField.setVisible(false);
				gameP.head.setText("");
				gameP.mes.setText("");
				gameP.textField.setText("");
				}
			}
			else if(gameP.inMessage==4){
				if(key_==27){
				gameP.inMessage=0;
				gameP.mes.setVisible(false);
				gameP.head.setVisible(false);
				gameP.textField.setVisible(false);
				gameP.head.setText("");
				gameP.mes.setText("");
				gameP.textField.setText("");
				}
				else if(key_==10){
					stop();
					ggwp.name = name;
					ggwp.start(true);
				}
			}
		}
		}
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}
	}
	public menu(){
		ggpw = new okno();
		ggwp = new editor();
		musicThread = new music();
		musicThread.start();
		checktimer = new Timer(250,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((ggwp.active==false)&(ggpw.active==false)){
					start();
				}
				
			}

		});
		musicTimer = new Timer(60000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				musicThread.load(track);
				if(track<9){
				track++;
				}
			}

		});
		musicTimer.setInitialDelay(0);
		addKeyListener(new myKey());
		//setBounds(0,0,1520,838);
		Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		setSize (sSize);
		scrW=(int)(sSize.getWidth());
		scrH=(int)(sSize.getHeight());
		setUndecorated(true);
		setTitle("Pasan");
		gameP = new main_menu();
		Container con = getContentPane();
		con.add(gameP);
		
		ImageIcon icon = new ImageIcon("./Pasan_Textures/Hero.png");
		setIconImage(icon.getImage());
		this.addWindowListener(new WindowAdapter() {            
	            @Override
	            public void windowClosing(WindowEvent e) {
	              System.exit(0);
	            }
	      });
		
		
		
		try(FileReader reader = new FileReader("./Pasan_Campaign/profile.pasan"))
        {
            int d;
            while((d=reader.read())!=-1){
                 
               
            	profile=profile+((char)d);
            } 
            
        }
        catch(IOException ex){}
		ggpw.eqweapon=Character.getNumericValue(profile.charAt(78))*10+Character.getNumericValue(profile.charAt(79));
		ggpw.eqarmor=Character.getNumericValue(profile.charAt(80))*10+Character.getNumericValue(profile.charAt(81));
		ggpw.CampFinished=Character.getNumericValue(profile.charAt(82));
		
		keylis1=new KeyAdapter() {
		     @Override
		     public void keyPressed(KeyEvent e) {
						
		        int key = e.getKeyCode();
				        
		        if (key == 10) {		// нажата клавиша - Enter
		        	name=gameP.textField.getText().trim();
					if(name.length()==0){
						name="Без имени";
					}
					 map = new File("./Pasan_UserMaps/"+name+".pasan");
					
				        if(map.exists()){
							stop();
							ggpw.start(name,false);
							gameP.textField.removeKeyListener(keylis1);
				        }
				        else{
				        	gameP.inMessage=2;
							gameP.mes.setVisible(true);
							gameP.head.setVisible(true);
							gameP.textField.setVisible(false);
							gameP.head.setText("Ошибка");
							gameP.mes.setText("Уровень с таким именем не найден");
							requestFocus();
							gameP.textField.removeKeyListener(keylis1);
				        }

		        }
		        else if(key==27){
		        	gameP.inMessage=0;
					gameP.mes.setVisible(false);
					gameP.head.setVisible(false);
					gameP.textField.setVisible(false);
					gameP.head.setText("");
					gameP.mes.setText("");
					gameP.textField.setText("");
					requestFocus();
					gameP.textField.removeKeyListener(keylis1);
		        }
		     }
		};
		keylis2=new KeyAdapter() {
		     @Override
		     public void keyPressed(KeyEvent e) {
						
		        int key = e.getKeyCode();
				        
		        if (key == 10) {
		        	name=gameP.textField.getText().trim();
					if(name.length()==0){
						name="Без имени";
					}
					 map = new File("./Pasan_UserMaps/"+name+".pasan");
					 try{
				        if(!map.exists()){
							stop();
				            map.createNewFile();
							ggwp.name = name;
							ggwp.start(false);
							gameP.textField.removeKeyListener(keylis2);
				        }
				        else{
				        	gameP.inMessage=4;
							gameP.mes.setVisible(true);
							gameP.head.setVisible(true);
							gameP.textField.setVisible(false);
							
							gameP.head.setText("Редактор карт");
							gameP.mes.setText("<html>Карта с таким именем уже существует.<br>Открыть её для редактирования?</html>");
							requestFocus();
							gameP.textField.removeKeyListener(keylis2);
				        }
					 }
					 catch(IOException ex){}
		        }
		        else if(key==27){
		        	gameP.inMessage=0;
					gameP.mes.setVisible(false);
					gameP.head.setVisible(false);
					gameP.textField.setVisible(false);
					gameP.head.setText("");
					gameP.mes.setText("");
					gameP.textField.setText("");
					requestFocus();
					gameP.textField.removeKeyListener(keylis2);
		        }
		     }
		};
		start();
	}
	public void start(){
		track=0;
		musicTimer.start();
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		getContentPane().setCursor(blankCursor);
		gameP.xxx=0;
		gameP.speed=1;
		if(ggpw.eqarmor>=10){
			gameP.armor=2;
		}
		else if(ggpw.eqarmor>=5){
			gameP.armor=1;
		}
		else{
			gameP.armor=0;
		}
		if(ggpw.eqweapon>=10){
			gameP.weapon=2;
		}
		else if(ggpw.eqweapon>=5){
			gameP.weapon=1;
		}
		else{
			gameP.weapon=0;
		}
		ram=1;
		gameP.ram=1;
		active=true;
		setVisible(true);
		requestFocus();
		gameP.timerDraw.start();
		gameP.fastTimer.start();
		checktimer.stop();
		for(int i=0;i<gameP.cloudkol;i++){
				gameP.cloudpos[i][0]=(int)(Math.random()*scrW);
				gameP.cloudpos[i][1]=(int)(Math.random()*250*scrH/838);
				gameP.cloudpos[i][2]=(int)(Math.random()*9);
		}
		gameP.CampFinished=ggpw.CampFinished;
		gameP.inMessage=0;
		gameP.head.setText("");
		gameP.mes.setText("");
		gameP.textField.setText("");
		gameP.head.setVisible(false);
		gameP.mes.setVisible(false);
		gameP.textField.setVisible(false);
	}
	public void stop(){
		musicTimer.stop();
		musicThread.closeall();
		active=false;
		setVisible(false);
		gameP.timerDraw.stop();
		gameP.fastTimer.stop();
		checktimer.start();
		gameP.inMessage=0;
		gameP.head.setText("");
		gameP.mes.setText("");
		gameP.textField.setText("");
		gameP.head.setVisible(false);
		gameP.mes.setVisible(false);
		gameP.textField.setVisible(false);
	}
}
