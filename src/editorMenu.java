// I wrote this game ~2 years ago, so pls dont look source code unless you want your eyes to bleed :)
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
public class editorMenu extends JPanel{
	Timer timerDraw;
	Image Editor;
	Image Stone;
	Image Grass1;
	Image Grass2;
	Image Bow;
	Image Enemy;
	Image Exit;
	Image Hero;
	Image Koja;
	Image Iron;
	Image Gold;
	Image Sword;
	Image Swords;
	Image Treasure;
	Image editor_ram;
	Image message;
	boolean stop=false;
	String[][] lol = new String[15][10];
	int[][] health = new int[15][10];
	int[][] maxhealth = new int[15][10];
	int[][] damage = new int[15][10];
	int[][] armor = new int[15][10];
	int[][] weapon = new int[15][10];
	int ram=0;
	int scrW,scrH;
	int klStart,klX,klY;
	JLabel mes,head;
	JTextField textField;
	int inMessage;
	public editorMenu(){
		setLayout(null);
		{
			Dimension sSize =Toolkit.getDefaultToolkit ().getScreenSize ();
			scrW=(int)(sSize.getWidth());
			scrH=(int)(sSize.getHeight());
			klX=scrW*8/150;
			klY=scrH/10;
			//klStart=scrW/10;
			klStart=(scrW/2)-(klX*15/2);
			}
		Editor=loadImage(Editor,"Editor",scrW,scrH);
		editor_ram=loadImage(editor_ram,"editor_ram",klX,klY);
		Stone=loadImage(Stone,"Stone",klX,klY);
		Grass1=loadImage(Grass1,"Grass0",klX,klY);
		Grass2=loadImage(Grass2,"Grass1",klX,klY);
		Bow=loadImage(Bow,"Bow",klX,klY);
		Enemy=loadImage(Enemy,"Enemy",klX,klY);
		Exit=loadImage(Exit,"Exit",klX,klY);
		Hero=loadImage(Hero,"Hero",klX,klY);
		Koja=loadImage(Koja,"Koja",klX,klY);
		Iron=loadImage(Iron,"Iron",klX,klY);
		Gold=loadImage(Gold,"Gold",klX,klY);
		Sword=loadImage(Sword,"Sword",klX,klY);
		Swords=loadImage(Swords,"Swords",klX,klY);
		Treasure=loadImage(Treasure,"Treasure",klX,klY);
		try{
			message = ImageIO.read(new File("./Pasan_Textures/message.png"));
			message = message.getScaledInstance(message.getWidth(null)*scrW/1520,message.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		
		
		timerDraw = new Timer(50,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint();
				
			}

		});
		timerDraw.setInitialDelay(0);
		
		mes=new JLabel("");
		mes.setFont(new Font("Comic Sans MS", Font.PLAIN, 28*scrW/1500));
		mes.setBounds(437*scrW/1500,254*scrH/800,628*scrW/1500,277*scrH/800);
		mes.setHorizontalTextPosition(SwingConstants.CENTER);
		mes.setVerticalTextPosition(SwingConstants.CENTER);
		mes.setForeground(Color.RED);
		mes.setVisible(false);
		add(mes);
		
		head=new JLabel("");
		head.setFont(new Font("Comic Sans MS", Font.PLAIN, 28*scrW/1500));
		head.setBounds(503*scrW/1500,190*scrH/800,516*scrW/1500,66*scrH/800);
		head.setHorizontalTextPosition(SwingConstants.CENTER);
		head.setVerticalTextPosition(SwingConstants.CENTER);
		head.setForeground(Color.BLACK);
		head.setVisible(false);
		add(head);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16*scrW/1500));
		textField.setBounds(447*scrW/1500,505*scrH/800,602*scrW/1500,24*scrH/800);
		textField.setVisible(false);
		add(textField);
		textField.setColumns(10);
		
	}
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		gr.drawImage(Editor, 0, 0, null);
		for (int i=0;i<=14;i++){
			for(int j=0;j<=9;j++){
				if (Integer.parseInt(lol[i][j])==0){
					gr.drawImage(Stone,klStart+i*klX,(j)*klY,null);
					gr.drawImage(Hero,klStart+i*klX,(j)*klY,null);
				}
				else if (Integer.parseInt(lol[i][j])==1){
					gr.drawImage(Grass1,klStart+i*klX,(j)*klY,null);
				}
				else if (Integer.parseInt(lol[i][j])==2){
					gr.drawImage(Grass2,klStart+i*klX,(j)*klY,null);
				}
				else if (Integer.parseInt(lol[i][j])==3){
					gr.drawImage(Stone,klStart+i*klX,(j)*klY,null);
				}
				else if (Integer.parseInt(lol[i][j])==4){
					gr.drawImage(Treasure,klStart+i*klX,(j)*klY,null);
				}
				else if (Integer.parseInt(lol[i][j])==5){
					gr.drawImage(Stone,klStart+i*klX,(j)*klY,null);
					gr.drawImage(Enemy,klStart+i*klX,(j)*klY,null);
				if(armor[i][j]==1){
					gr.drawImage(Koja,klStart+i*klX,(j)*klY,null);
				}
				else if(armor[i][j]==2){
					gr.drawImage(Iron,klStart+i*klX,(j)*klY,null);
				}
				else if(armor[i][j]==3){
					gr.drawImage(Gold,klStart+i*klX,(j)*klY,null);
				}
				if(weapon[i][j]==1){
					gr.drawImage(Sword,klStart+i*klX,(j)*klY,null);
				}
				else if(weapon[i][j]==2){
					gr.drawImage(Swords,klStart+i*klX,(j)*klY,null);
				}
				else if(weapon[i][j]==3){
					gr.drawImage(Bow,klStart+i*klX,(j)*klY,null);
				}
			}
				else if (Integer.parseInt(lol[i][j])==6){
					gr.drawImage(Exit,klStart+i*klX,(j)*klY,null);
				}
		}
			gr.drawImage(editor_ram,(ram-ram/15*15)*klX+klStart,(ram/15)*klY,null);
			if(inMessage>0){
				gr.drawImage(message,360*scrW/1520,169*scrH/838,null);
			}
		}
	}
	public Image loadImage(Image im,String name,int x,int y){
		try {
			im = ImageIO.read(new File("./Pasan_Textures/"+name+".png"));
			im = im.getScaledInstance(x,y, Image.SCALE_SMOOTH);
		} catch (IOException e) {}
		return(im);
	}
	}

