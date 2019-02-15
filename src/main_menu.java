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
public class main_menu extends JPanel{
	int ram=1;
	boolean stop=false;
	int inMessage;
	Image Main_menu;
	Timer timerDraw;
	Timer fastTimer;
	Image menu_ram;
	Image menu_koja,menu_iron,menu_gold,menu_sword,menu_dual,menu_bow,menu1,menu2,menu3,menu4,menu_cloak;
	Image message;
	public int armor=0,weapon=0;
	int pasx=890;
	int pasy=250;
	int speed;
	int minx=-300;
	int cloudkol=5;
	int xxx=0;
	Image cloud[] = new Image[10];
	int cloudpos[][] = new int[15][3]; // Ïåðâàÿ öèôðà - íîìåð îáëàêà, âòîðàÿ - 0-õ, 1-ó, 2-íîìåð ìîäåëüêè
	int scrW,scrH;
	int CampFinished;
	JLabel mes,head;
	JTextField textField;
	
	public main_menu(){
		setLayout(null);
		{
			Dimension sSize =Toolkit.getDefaultToolkit ().getScreenSize ();
			scrW=(int)(sSize.getWidth());
			scrH=(int)(sSize.getHeight());
			}
		
		try{
			Main_menu = ImageIO.read(new File("./Pasan_Textures/Main_menu.png"));
			Main_menu = Main_menu.getScaledInstance(scrW,scrH, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_ram = ImageIO.read(new File("./Pasan_Textures/menu_ram.png"));
			menu_ram = menu_ram.getScaledInstance(menu_ram.getWidth(null)*scrW/1520,menu_ram.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_koja = ImageIO.read(new File("./Pasan_Textures/menu_koja.png"));
			menu_koja = menu_koja.getScaledInstance(menu_koja.getWidth(null)*scrW/1520,menu_koja.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_iron = ImageIO.read(new File("./Pasan_Textures/menu_iron.png"));
			menu_iron = menu_iron.getScaledInstance(menu_iron.getWidth(null)*scrW/1520,menu_iron.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_gold = ImageIO.read(new File("./Pasan_Textures/menu_gold.png"));
			menu_gold = menu_gold.getScaledInstance(menu_gold.getWidth(null)*scrW/1520,menu_gold.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_cloak = ImageIO.read(new File("./Pasan_Textures/menu_cloak.png"));
			menu_cloak = menu_cloak.getScaledInstance(menu_cloak.getWidth(null)*scrW/1520,menu_cloak.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_sword = ImageIO.read(new File("./Pasan_Textures/menu_sword.png"));
			menu_sword = menu_sword.getScaledInstance(menu_sword.getWidth(null)*scrW/1520,menu_sword.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_dual = ImageIO.read(new File("./Pasan_Textures/menu_dual.png"));
			menu_dual= menu_dual.getScaledInstance(menu_dual.getWidth(null)*scrW/1520,menu_dual.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu_bow = ImageIO.read(new File("./Pasan_Textures/menu_bow.png"));
			menu_bow= menu_bow.getScaledInstance(menu_bow.getWidth(null)*scrW/1520,menu_bow.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu1 = ImageIO.read(new File("./Pasan_Textures/menu1.png"));
			menu1= menu1.getScaledInstance(menu1.getWidth(null)*scrW/1520,menu1.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu2 = ImageIO.read(new File("./Pasan_Textures/menu2.png"));
			menu2= menu2.getScaledInstance(menu2.getWidth(null)*scrW/1520,menu2.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu3 = ImageIO.read(new File("./Pasan_Textures/menu3.png"));
			menu3= menu3.getScaledInstance(menu3.getWidth(null)*scrW/1520,menu3.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			menu4 = ImageIO.read(new File("./Pasan_Textures/menu4.png"));
			menu4= menu4.getScaledInstance(menu4.getWidth(null)*scrW/1520,menu4.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		try{
			message = ImageIO.read(new File("./Pasan_Textures/message.png"));
			message = message.getScaledInstance(message.getWidth(null)*scrW/1520,message.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		
		
		for(int i=0;i<=9;i++){
		try{
			cloud[i] = ImageIO.read(new File("./Pasan_Textures/cloud0"+i+".png"));
			cloud[i] = cloud[i].getScaledInstance(350*scrW/1520,175*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		}
		
		timerDraw = new Timer(50,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(int i=0;i<cloudkol;i++){
					cloudpos[i][0]-=speed;
					if(cloudpos[i][0]<minx){
						cloudpos[i][0]=scrW;
						cloudpos[i][1]=(int)(Math.random()*scrH*250/838);
						cloudpos[i][2]=(int)(Math.random()*9);
						minx=-300-((int)(Math.random()*1000));
					}
				}
				repaint();
				
			}

		});
		timerDraw.setInitialDelay(0);
		fastTimer = new Timer(5000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(speed<=70){
					speed++;
				}
				if(speed-speed/10*10==0){
					cloudpos[cloudkol][0]=scrW;
					cloudpos[cloudkol][1]=(int)(Math.random()*scrH*250/838);
					cloudpos[cloudkol][2]=(int)(Math.random()*9);
					cloudkol++;
				}
				
			}

		});
		fastTimer.setInitialDelay(0);
		
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


		gr.drawImage(Main_menu, 0, 0, null);
		for(int i=0;i<cloudkol;i++){
			gr.drawImage(cloud[cloudpos[i][2]],cloudpos[i][0],cloudpos[i][1],null);
		}
		gr.drawImage(menu1,1218*scrW/1520,497*scrH/838,null);
		gr.drawImage(menu2,1218*scrW/1520,574*scrH/838,null);
		gr.drawImage(menu3,1218*scrW/1520,651*scrH/838,null);
		gr.drawImage(menu4,1218*scrW/1520,723*scrH/838,null);
		
		if (ram==1){gr.drawImage(menu_ram,1218*scrW/1520,497*scrH/838,null);}
		else if (ram==2){gr.drawImage(menu_ram,1218*scrW/1520,574*scrH/838,null);}
		else if (ram==3){gr.drawImage(menu_ram,1218*scrW/1520,651*scrH/838,null);}
		else if (ram==4){gr.drawImage(menu_ram,1218*scrW/1520,723*scrH/838,null);}
		
		if(armor==0){gr.drawImage(menu_koja,pasx*scrW/1520,pasy*scrH/838,null);}
		else if(armor==1){gr.drawImage(menu_iron,pasx*scrW/1520,pasy*scrH/838,null);}
		else if(armor==2){gr.drawImage(menu_gold,pasx*scrW/1520,pasy*scrH/838,null);}
		
		if(CampFinished>=1){
			gr.drawImage(menu_cloak,pasx*scrW/1520,pasy*scrH/838,null);
		}
		
		if(weapon==0){gr.drawImage(menu_sword,pasx*scrW/1520,pasy*scrH/838,null);}
		else if(weapon==1){gr.drawImage(menu_dual,pasx*scrW/1520,pasy*scrH/838,null);}
		else if(weapon==2){gr.drawImage(menu_bow,pasx*scrW/1520,pasy*scrH/838,null);}
		
		if(inMessage>0){
			gr.drawImage(message,360*scrW/1520,169*scrH/838,null);
		}
	}
	
}
