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
public class pole extends JPanel{
	music2 musicThread;
	JLabel HP,MP,EXP;
	JLabel mes,head;
	JTextField textField;
	int inMessage;
	int xkoef,ykoef;
	Timer timerDraw;
	Image Battle;
	Image Stone;
	Image Enemy;
	Image Exit;
	Image Hero;
	Image Health;
	Image Mana;
	Image Treasure;
	Image Inventory;
	Image Inventory_ram;
	Image Eq_ram;
	Image Cloak;
	Image arrowup;
	Image arrowright;
	Image arrowleft;
	Image arrowdown;
	Image fireballup;
	Image fireballleft;
	Image fireballright;
	Image fireballdown;
	Image message;
	Image swordup,swordleft,swordright,sworddown;
	Image storm;
	Image cold_embrace;
	Image skills;
	Image skills_ram1;
	Image skills_ram2;
	Image Miss;
	Image editor_ram;
	Image Crit;
	Image Deathstrike;
	Image Flame_arrowup,Flame_arrowleft,Flame_arrowright,Flame_arrowdown;
	Image Flame_swordup,Flame_swordleft,Flame_swordright,Flame_sworddown;
	Image CanCreate;
	int hp=100;
	int mhp=100;
	int mp=100;
	int mmp=100;
	int hero;
	int scrW,scrH,xx,yy;
	int klX,klY,klStart;
	int exp;
	boolean stop=false;
	boolean ram=true;
	int animation=0;//Êîë-âî àíèìàöèé
	int anima=1; //Àíèìàöèÿ â äàííûé ìîìåíò
	int[][] anim = new int[100][5];//0 - äâèæåíèå, 1 - ñòðåëà, 2 - ôàåðáîë, 3 - ëåäÿíûå îáúÿòüÿ, 4 - âûñîêîå íàïðÿæåíèå; 1 - íà÷àëüíàÿ òî÷êà, 2 - êîíå÷íàÿ òî÷êà
	public String[][] lol = new String[15][10];
	public int[][] health = new int[15][10];
	public int[][] maxhealth = new int[15][10];
	public int[][] damage = new int[15][10];
	public int[][] armor = new int[15][10];
	public int[][] weapon = new int[15][10];
	int[][] inv = new int[5][6];
	Image[][] invimage = new Image[5][6];
	Image[] Armor = new Image[4];
	Image[] Weapon = new Image[4];
	Image[] Flame_Weapon = new Image[2];
	int sword,dual,bow,magic,koja,iron,gold,eqweapon,eqarmor,CampFinished,arrowpos,l,g;
	int menu=0;
	int inv_ram=0;
	int skills_ram=0;
	int texture;
	Image[] Grass = new Image[6];
	public pole(){
		setLayout(null);
		Dimension sSize =Toolkit.getDefaultToolkit ().getScreenSize ();
		scrW=(int)(sSize.getWidth());
		scrH=(int)(sSize.getHeight());
		klX=scrW*8/150;
		klY=scrH/10;
		//klStart=scrW/10;
		klStart=(scrW/2)-(klX*15/2);
		anim[anima][1]=-1;
		anim[anima][2]=-1;
		anim[anima][3]=-1;
		anim[anima][4]=-1;
		editor_ram=loadImage(editor_ram,"editor_ram",klX,klY);
		Battle=loadImage(Battle,"Battle",scrW,scrH);
		Stone=loadImage(Stone,"Stone",klX,klY);
		for(int i=0;i<6;i++){
			Grass[i]=loadImage(Grass[i],"Grass"+i,klX,klY);
		}
		Weapon[3]=loadImage(Weapon[3],"Bow",klX,klY);
		Enemy=loadImage(Enemy,"Enemy",klX,klY);
		Exit=loadImage(Exit,"Exit",klX,klY);
		Hero=loadImage(Hero,"Hero",klX,klY);
		Health=loadImage(Health,"Health",999,999);
		Mana=loadImage(Mana,"Mana",999,999);
		Armor[1]=loadImage(Armor[1],"Koja",klX,klY);
		Armor[2]=loadImage(Armor[2],"Iron",klX,klY);
		Armor[3]=loadImage(Armor[3],"Gold",klX,klY);
		Weapon[1]=loadImage(Weapon[1],"Sword",klX,klY);
		Weapon[2]=loadImage(Weapon[2],"Swords",klX,klY);
		Flame_Weapon[0]=loadImage(Flame_Weapon[0],"Flame_Sword",klX,klY);
		Flame_Weapon[1]=loadImage(Flame_Weapon[1],"Flame_Swords",klX,klY);
		Treasure=loadImage(Treasure,"Treasure",klX,klY);
		Miss=loadImage(Miss,"Miss",klX,klY);
		Crit=loadImage(Crit,"Crit",klX,klY);
		Deathstrike=loadImage(Deathstrike,"Deathstrike",klX,klY);
		Inventory=loadImage(Inventory,"Inventory",scrW,scrH);
		Inventory_ram=loadImage(Inventory_ram,"Inventory_ram",scrW*10/75,scrH/10);
		CanCreate=loadImage(CanCreate,"CanCreate",scrW*10/75,scrH/10);
		Eq_ram=loadImage(Eq_ram,"Eq_ram",scrW*10/75,scrH/10);
		Cloak=loadImage(Cloak,"Cloak",klX,klY);
		arrowup=loadImage(arrowup,"arrowup",klX/2,klY/2);
		arrowdown=loadImage(arrowdown,"arrowdown",klX/2,klY/2);
		arrowright=loadImage(arrowright,"arrowright",klX/2,klY/2);
		arrowleft=loadImage(arrowleft,"arrowleft",klX/2,klY/2);
		Flame_arrowup=loadImage(Flame_arrowup,"Flame_arrowup",klX/2,klY/2);
		Flame_arrowdown=loadImage(Flame_arrowdown,"Flame_arrowdown",klX/2,klY/2);
		Flame_arrowright=loadImage(Flame_arrowright,"Flame_arrowright",klX/2,klY/2);
		Flame_arrowleft=loadImage(Flame_arrowleft,"Flame_arrowleft",klX/2,klY/2);
		fireballleft=loadImage(fireballleft,"fireballleft",klX/2,klY/2);
		fireballup=loadImage(fireballup,"fireballup",klX/2,klY/2);
		fireballdown=loadImage(fireballdown,"fireballdown",klX/2,klY/2);
		fireballright=loadImage(fireballright,"fireballright",klX/2,klY/2);
		swordup=loadImage(swordup,"swordup",klX/2,klY/2);
		sworddown=loadImage(sworddown,"sworddown",klX/2,klY/2);
		swordright=loadImage(swordright,"swordright",klX/2,klY/2);
		swordleft=loadImage(swordleft,"swordleft",klX/2,klY/2);
		Flame_swordup=loadImage(Flame_swordup,"Flame_swordup",klX/2,klY/2);
		Flame_sworddown=loadImage(Flame_sworddown,"Flame_sworddown",klX/2,klY/2);
		Flame_swordright=loadImage(Flame_swordright,"Flame_swordright",klX/2,klY/2);
		Flame_swordleft=loadImage(Flame_swordleft,"Flame_swordleft",klX/2,klY/2);
		cold_embrace=loadImage(cold_embrace,"cold_embrace",klX,klY);
		storm=loadImage(storm,"storm",klX,klY);
		skills=loadImage(skills,"skills",scrW,scrH);
		skills_ram1=loadImage(skills_ram1,"skills_ram1",219*scrW/1500,68*scrH/800);
		skills_ram2=loadImage(skills_ram2,"skills_ram2",73*scrW/1500,69*scrH/800);
		try{
			message = ImageIO.read(new File("./Pasan_Textures/message.png"));
			message = message.getScaledInstance(message.getWidth(null)*scrW/1520,message.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		}
		catch(IOException ex){}
		for(int w=0;w<5;w++){
			for(int q=0; q<6;q++){
				invimage[w][q]=loadImage(invimage[w][q],"inv_"+w+q,scrW*10/75,scrH/10);
			}
		}
		
		timerDraw = new Timer(50,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint();
				
			}

		});
		timerDraw.setInitialDelay(0);
		HP=new JLabel("");
		HP.setFont(new Font("Courier New", Font.PLAIN, 24*scrW/1500));
		HP.setBounds(26*scrW/1500,473*scrH/800,150*scrW/1500,20);
		HP.setHorizontalTextPosition(SwingConstants.CENTER);
		HP.setVerticalTextPosition(SwingConstants.TOP);
		HP.setForeground(Color.ORANGE);
		HP.setVisible(true);
		add(HP);
		
		MP=new JLabel("");
		MP.setFont(HP.getFont());
		MP.setBounds(1374*scrW/1500,473*scrH/800,150*scrW/1500,20);
		MP.setHorizontalTextPosition(SwingConstants.CENTER);
		MP.setVerticalTextPosition(SwingConstants.TOP);
		MP.setForeground(Color.BLUE);
		MP.setVisible(true);
		add(MP);
		
		EXP=new JLabel("");
		EXP.setFont(new Font("Courier New", Font.PLAIN, 24*scrW/1500));
		EXP.setBounds(1353*scrW/1500,42*scrH/800,150*scrW/1500,20);
		EXP.setHorizontalTextPosition(SwingConstants.CENTER);
		EXP.setVerticalTextPosition(SwingConstants.TOP);
		EXP.setForeground(Color.BLACK);
		EXP.setVisible(true);
		add(EXP);
		
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
		if(menu==0){
		gr.drawImage(Battle, 0, 0, null);
		if(hp>0){
		gr.drawImage(Health, 26*scrW/1500, (62+395-395*hp/mhp)*scrH/800, 97*scrW/1500, 395*hp/mhp*scrH/800, null);
		}
		gr.drawImage(Mana, 1376*scrW/1500, (60+395-395*mp/mmp)*scrH/800, 97*scrW/1500, 395*mp/mmp*scrH/800, null);
		for (int h=0;h<=14;h++){
			for(int t=0;t<=9;t++){
				if(lol[h][t]==null){
					lol[h][t]="1";
				}
				if (Integer.parseInt(lol[h][t])==0){
					gr.drawImage(Stone,klStart+h*klX,(t)*klY,null);
					gr.drawImage(Hero,klStart+h*klX,(t)*klY,null);
					if (ram==true){
						gr.drawImage(editor_ram,klStart+h*klX,(t)*klY,null);
					}
					if(CampFinished>=1){
						gr.drawImage(Cloak,klStart+h*klX,(t)*klY,null);	
					}
					if(magic<10){
					if(eqweapon<=4){
						gr.drawImage(Weapon[1],klStart+h*klX,(t)*klY,null);
					}
					else if(eqweapon<=9){
						gr.drawImage(Weapon[2],klStart+h*klX,(t)*klY,null);
					}
					else if(eqweapon<=14){
					gr.drawImage(Weapon[3],klStart+h*klX,(t)*klY,null);
					}
					}
					else{
						if(eqweapon<=4){
							gr.drawImage(Flame_Weapon[0],klStart+h*klX,(t)*klY,null);
						}
						else if(eqweapon<=9){
							gr.drawImage(Flame_Weapon[1],klStart+h*klX,(t)*klY,null);
						}
						else if(eqweapon<=14){
						gr.drawImage(Weapon[3],klStart+h*klX,(t)*klY,null);
						}
					}
					if(eqarmor<=4){
						gr.drawImage(Armor[1],klStart+h*klX,(t)*klY,null);
					}
					else if(eqarmor<=9){
						gr.drawImage(Armor[2],klStart+h*klX,(t)*klY,null);
					}
					else if(eqarmor<=14){
						gr.drawImage(Armor[3],klStart+h*klX,(t)*klY,null);
					}
				}
				else if (Integer.parseInt(lol[h][t])==1){
					gr.drawImage(Grass[texture*2],klStart+h*klX,(t)*klY,null);
				}
				else if (Integer.parseInt(lol[h][t])==2){
					gr.drawImage(Grass[texture*2+1],klStart+h*klX,(t)*klY,null);
				}
				else if (Integer.parseInt(lol[h][t])==3){
					gr.drawImage(Stone,klStart+h*klX,(t)*klY,null);
				}
				else if (Integer.parseInt(lol[h][t])==4){
					gr.drawImage(Treasure,klStart+h*klX,(t)*klY,null);
				}
				else if (Integer.parseInt(lol[h][t])==5){
					gr.drawImage(Stone,klStart+h*klX,(t)*klY,null);
					
					
				if(!((anim[anima][0]==0)&(anim[anima][2]==h+t*15))){
				gr.drawImage(Enemy,klStart+h*klX,(t)*klY,null);
				if(armor[h][t]==1){
					gr.drawImage(Armor[1],klStart+h*klX,(t)*klY,null);
				}
				else if(armor[h][t]==2){
					gr.drawImage(Armor[2],klStart+h*klX,(t)*klY,null);
				}
				else if(armor[h][t]==3){
					gr.drawImage(Armor[3],klStart+h*klX,(t)*klY,null);
				}
				if(weapon[h][t]==1){
					gr.drawImage(Weapon[1],klStart+h*klX,(t)*klY,null);
				}
				else if(weapon[h][t]==2){
					gr.drawImage(Weapon[2],klStart+h*klX,(t)*klY,null);
				}
				else if(weapon[h][t]==3){
					gr.drawImage(Weapon[3],klStart+h*klX,(t)*klY,null);
				}
				gr.drawImage(Health,klStart+h*klX+5,(t)*klY+5, (klX-10)*health[h][t]/maxhealth[h][t], 5,null);
				
				}
			}
				else if(Integer.parseInt(lol[h][t])==6){
					gr.drawImage(Exit,klStart+h*klX,(t)*klY,null);	
				}
		
		}
		
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(animation>0){
			if(anim[anima][0]==0){ // Äâèæåíèå
				if(anim[anima][1]==0){//Âëåâî
						gr.drawImage(Enemy,klStart+((anim[anima][2]-1)-(anim[anima][2]-1)/15*15)*klX+(anim[anima][2]-(anim[anima][2]-1))*(10-arrowpos)*klX/10,(anim[anima][2]-1)/15*klY,null);
						xx=(anim[anima][2]-1)-(anim[anima][2]-1)/15*15;
						yy=(anim[anima][2]-1)/15;
						gr.drawImage(Armor[armor[xx+1][yy]],klStart+((anim[anima][2]-1)-(anim[anima][2]-1)/15*15)*klX+(anim[anima][2]-(anim[anima][2]-1))*(10-arrowpos)*klX/10,(anim[anima][2]-1)/15*klY,null);
						gr.drawImage(Weapon[weapon[xx+1][yy]],klStart+((anim[anima][2]-1)-(anim[anima][2]-1)/15*15)*klX+(anim[anima][2]-(anim[anima][2]-1))*(10-arrowpos)*klX/10,(anim[anima][2]-1)/15*klY,null);
						gr.drawImage(Health,5+klStart+((anim[anima][2]-1)-(anim[anima][2]-1)/15*15)*klX+(anim[anima][2]-(anim[anima][2]-1))*(10-arrowpos)*klX/10,5+(anim[anima][2]-1)/15*klY,(klX-10)*health[xx+1][yy]/maxhealth[xx+1][yy], 5,null);
						arrowpos+=1;
				}
				else if(anim[anima][1]==1){//Âïðàâî
						gr.drawImage(Enemy,klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+((anim[anima][2]+1)-anim[anima][2])*arrowpos*klX/10,anim[anima][2]/15*klY,null);
						xx=(anim[anima][2]+1)-(anim[anima][2]+1)/15*15;
						yy=(anim[anima][2]+1)/15;
						gr.drawImage(Armor[armor[xx-1][yy]],klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+((anim[anima][2]+1)-anim[anima][2])*arrowpos*klX/10,anim[anima][2]/15*klY,null);
						gr.drawImage(Weapon[weapon[xx-1][yy]],klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+((anim[anima][2]+1)-anim[anima][2])*arrowpos*klX/10,anim[anima][2]/15*klY,null);
						gr.drawImage(Health,5+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+((anim[anima][2]+1)-anim[anima][2])*arrowpos*klX/10,5+anim[anima][2]/15*klY,(klX-10)*health[xx-1][yy]/maxhealth[xx-1][yy], 5,null);
						arrowpos+=1;
				}
				else if(anim[anima][1]==2){//Ââåðõ
						gr.drawImage(Enemy,klStart+((anim[anima][2]-15)-(anim[anima][2]-15)/15*15)*klX,(anim[anima][2]-15)/15*klY+(anim[anima][2]-(anim[anima][2]-15))/15*klY*(10-arrowpos)/10,null);
						xx=(anim[anima][2]-15)-(anim[anima][2]-15)/15*15;
						yy=(anim[anima][2]-15)/15;
						gr.drawImage(Armor[armor[xx][yy+1]],klStart+((anim[anima][2]-15)-(anim[anima][2]-15)/15*15)*klX,(anim[anima][2]-15)/15*klY+(anim[anima][2]-(anim[anima][2]-15))/15*klY*(10-arrowpos)/10,null);
						gr.drawImage(Weapon[weapon[xx][yy+1]],klStart+((anim[anima][2]-15)-(anim[anima][2]-15)/15*15)*klX,(anim[anima][2]-15)/15*klY+(anim[anima][2]-(anim[anima][2]-15))/15*klY*(10-arrowpos)/10,null);
						gr.drawImage(Health,5+klStart+((anim[anima][2]-15)-(anim[anima][2]-15)/15*15)*klX,5+(anim[anima][2]-15)/15*klY+(anim[anima][2]-(anim[anima][2]-15))/15*klY*(10-arrowpos)/10,(klX-10)*health[xx][yy+1]/maxhealth[xx][yy+1], 5,null);
						arrowpos+=1;
				}
				else if(anim[anima][1]==3){//Âíèç
					gr.drawImage(Enemy,klStart+((anim[anima][2]+15)-(anim[anima][2]+15)/15*15)*klX,anim[anima][2]/15*klY+((anim[anima][2]+15)-anim[anima][2])/15*arrowpos*klY/10,null);
						xx=(anim[anima][2]+15)-(anim[anima][2]+15)/15*15;
						yy=(anim[anima][2]+15)/15;
						gr.drawImage(Armor[armor[xx][yy-1]],klStart+((anim[anima][2]+15)-(anim[anima][2]+15)/15*15)*klX,anim[anima][2]/15*klY+((anim[anima][2]+15)-anim[anima][2])/15*arrowpos*klY/10,null);
						gr.drawImage(Weapon[weapon[xx][yy-1]],klStart+((anim[anima][2]+15)-(anim[anima][2]+15)/15*15)*klX,anim[anima][2]/15*klY+((anim[anima][2]+15)-anim[anima][2])/15*arrowpos*klY/10,null);
						gr.drawImage(Health,5+klStart+((anim[anima][2]+15)-(anim[anima][2]+15)/15*15)*klX,5+anim[anima][2]/15*klY+((anim[anima][2]+15)-anim[anima][2])/15*arrowpos*klY/10,(klX-10)*health[xx][yy-1]/maxhealth[xx][yy-1], 5,null);
						arrowpos+=1;
				}
				if(arrowpos>=10){
					lol[xx][yy]="5";
					if(anim[anima][1]==0){
						armor[xx][yy]=armor[xx+1][yy];
						weapon[xx][yy]=weapon[xx+1][yy];
						health[xx][yy]=health[xx+1][yy];
						maxhealth[xx][yy]=maxhealth[xx+1][yy];
						lol[xx+1][yy]="3";
					}
					else if(anim[anima][1]==1){
						armor[xx][yy]=armor[xx-1][yy];
						weapon[xx][yy]=weapon[xx-1][yy];
						health[xx][yy]=health[xx-1][yy];
						maxhealth[xx][yy]=maxhealth[xx-1][yy];
							lol[xx-1][yy]="3";
					}
					else if(anim[anima][1]==2){
						armor[xx][yy]=armor[xx][yy+1];
						weapon[xx][yy]=weapon[xx][yy+1];
						health[xx][yy]=health[xx][yy+1];
						maxhealth[xx][yy]=maxhealth[xx][yy+1];
						lol[xx][yy+1]="3";
					}
					else if(anim[anima][1]==3){
						armor[xx][yy]=armor[xx][yy-1];
						weapon[xx][yy]=weapon[xx][yy-1];
						health[xx][yy]=health[xx][yy-1];
						maxhealth[xx][yy]=maxhealth[xx][yy-1];
						lol[xx][yy-1]="3";
					}
					anim[anima][0]=-1;
					anim[anima][1]=-1;
					anim[anima][2]=-1;
					anim[anima][3]=-1;
					anim[anima][4]=-1;
					if (anima<animation){anima+=1;}
					else {anima = 1; animation = 0;}
					arrowpos=0;
				}
				
				
			}
			
			/////////////////////////////////
			
		else if(anim[anima][0]==1){
			if(anim[anima][1]>anim[anima][2]){//Âëåâî èëè ââåðõ
				if(anim[anima][1]-anim[anima][2]>=15){//Ââåðõ
					if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
					gr.drawImage(arrowup,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
					}
					else{
					gr.drawImage(Flame_arrowup,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
					}
					arrowpos+=1;
				}
				else{//Âëåâî
					if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
					gr.drawImage(arrowleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/4+anim[anima][2]/15*klY,null);
					}
					else {
						gr.drawImage(Flame_arrowleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/4+anim[anima][2]/15*klY,null);
						}
					arrowpos+=1;
				}
			}
			else if(anim[anima][2]>anim[anima][1]){//Âïðàâî èëè âíèç
				if(anim[anima][2]-anim[anima][1]>=15){//Âíèç
					if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
					gr.drawImage(arrowdown,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
					}
					else{
						gr.drawImage(Flame_arrowdown,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
						}
					arrowpos+=1;
				}
				else{//Âïðàâî
					if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
					gr.drawImage(arrowright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/4+anim[anima][1]/15*klY,null);
					}
					else {
						gr.drawImage(Flame_arrowright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/4+anim[anima][1]/15*klY,null);
						}
					arrowpos+=1;
				}
			}
			if(arrowpos==1){
				musicThread.arrow();
			}
			if(arrowpos>=10){
				//TODO
				
				if (anima<animation){anima+=1;}
				else {anima = 1; animation = 0;};
				arrowpos=0;
			}
			
			
		}
				else if(anim[anima][0]==2){
					if(anim[anima][1]>anim[anima][2]){//Âëåâî èëè ââåðõ
						if(anim[anima][1]-anim[anima][2]>=15){//Ââåðõ
							
							gr.drawImage(fireballup,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
							
							arrowpos+=1;
						}
						else{//Âëåâî
							gr.drawImage(fireballleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/4+anim[anima][2]/15*klY,null);
							arrowpos+=1;
						}
					}
					else if(anim[anima][2]>anim[anima][1]){//Âïðàâî èëè âíèç
						if(anim[anima][2]-anim[anima][1]>=15){//Âíèç
							gr.drawImage(fireballdown,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
							arrowpos+=1;
						}
						else{//Âïðàâî
							gr.drawImage(fireballright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/4+anim[anima][1]/15*klY,null);
							arrowpos+=1;
						}
					}
					if(arrowpos==8){
						musicThread.fireball();
					}
					if(arrowpos>=10){
						anim[anima][1]=-1;
						anim[anima][2]=-1;
						anim[anima][3]=-1;
						anim[anima][4]=-1;
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
					
					
				}
				else if(anim[anima][0]==3){
					//System.out.println(hero);
					gr.drawImage(cold_embrace, klStart+(hero-hero/15*15)*klX, hero/15*klY, null);
					if(anim[anima][1]>-1){
						gr.drawImage(cold_embrace, klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX, anim[anima][1]/15*klY, null);
					}
					if(anim[anima][2]>-1){
						gr.drawImage(cold_embrace, klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX, anim[anima][2]/15*klY, null);
					}
					if(anim[anima][3]>-1){
						gr.drawImage(cold_embrace, klStart+(anim[anima][3]-anim[anima][3]/15*15)*klX, anim[anima][3]/15*klY, null);
					}
					if(anim[anima][4]>-1){
						gr.drawImage(cold_embrace, klStart+(anim[anima][4]-anim[anima][4]/15*15)*klX, anim[anima][4]/15*klY, null);
					}
					arrowpos+=1;
					if(arrowpos>=20){
						anim[anima][1]=-1;
						anim[anima][2]=-1;
						anim[anima][3]=-1;
						anim[anima][4]=-1;
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
					
				}
				else if(anim[anima][0]==4){
					if((arrowpos<5)|((arrowpos>=10)&(arrowpos<15))|(arrowpos>=20)){
					for(l=anim[anima][1];l<=anim[anima][2];l++){
						for(g=anim[anima][3];g<=anim[anima][4];g++){
							gr.drawImage(storm,klStart+l*klX,g*klY,null);
						}
					}
					}
					arrowpos+=1;
					if(arrowpos>=25){
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
				}
				else if(anim[anima][0]==5){ // Ïðîìàõ
					gr.drawImage(Miss,klStart+anim[anima][1]*klX,anim[anima][2]*klY,null);
					arrowpos+=1;
					if(arrowpos>=10){
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
				}
				else if(anim[anima][0]==6){ // Êðèò
					gr.drawImage(Crit,klStart+anim[anima][1]*klX,anim[anima][2]*klY,null);
					arrowpos+=1;
					if(arrowpos>=10){
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
				}
				else if(anim[anima][0]==7){ // Ñìåðòåëüíûé óäàð
					gr.drawImage(Deathstrike,klStart+anim[anima][1]*klX,anim[anima][2]*klY,null);
					arrowpos+=1;
					if(arrowpos>=10){
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
				}
				else if(anim[anima][0]==8){ // Òû÷êà ìå÷îì
					if(anim[anima][1]>anim[anima][2]){//Âëåâî èëè ââåðõ
						if(anim[anima][1]-anim[anima][2]>=15){//Ââåðõ
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(swordup,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
							}
							else{
							gr.drawImage(Flame_swordup,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
							}
							arrowpos+=1;
						}
						else{//Âëåâî
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(swordleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/4+anim[anima][2]/15*klY,null);
							}
							else {
								gr.drawImage(Flame_swordleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/4+anim[anima][2]/15*klY,null);
								}
							arrowpos+=1;
						}
					}
					else if(anim[anima][2]>anim[anima][1]){//Âïðàâî èëè âíèç
						if(anim[anima][2]-anim[anima][1]>=15){//Âíèç
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(sworddown,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
							}
							else{
								gr.drawImage(Flame_sworddown,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
								}
							arrowpos+=1;
						}
						else{//Âïðàâî
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(swordright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/4+anim[anima][1]/15*klY,null);
							}
							else {
								gr.drawImage(Flame_swordright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/4+anim[anima][1]/15*klY,null);
								}
							arrowpos+=1;
						}
					}
					if(arrowpos==1){
						//TODO
						//musicThread.arrow();
					}
					if(arrowpos>=10){
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
					
					
				}
				else if(anim[anima][0]==9){ // Òû÷êà äóàëàìè
					if(anim[anima][1]>anim[anima][2]){//Âëåâî èëè ââåðõ
						if(anim[anima][1]-anim[anima][2]>=15){//Ââåðõ
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(swordup,klX/6+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
							gr.drawImage(swordup,klX/3+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
							}
							else{
							gr.drawImage(Flame_swordup,klX/6+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
							gr.drawImage(Flame_swordup,klX/3+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][2]/15*klY+(anim[anima][1]-anim[anima][2])/15*klY*(10-arrowpos)/10,null);
							}
							arrowpos+=1;
						}
						else{//Âëåâî
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(swordleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/6+anim[anima][2]/15*klY,null);
							gr.drawImage(swordleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/3+anim[anima][2]/15*klY,null);
							}
							else {
								gr.drawImage(Flame_swordleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/6+anim[anima][2]/15*klY,null);
								gr.drawImage(Flame_swordleft,klX/4+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX+(anim[anima][1]-anim[anima][2])*(10-arrowpos)*klX/10,klY/3+anim[anima][2]/15*klY,null);
								}
							arrowpos+=1;
						}
					}
					else if(anim[anima][2]>anim[anima][1]){//Âïðàâî èëè âíèç
						if(anim[anima][2]-anim[anima][1]>=15){//Âíèç
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(sworddown,klX/6+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
							gr.drawImage(sworddown,klX/3+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
							}
							else{
								gr.drawImage(Flame_sworddown,klX/6+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
								gr.drawImage(Flame_sworddown,klX/3+klStart+(anim[anima][2]-anim[anima][2]/15*15)*klX,klY/4+anim[anima][1]/15*klY+(anim[anima][2]-anim[anima][1])/15*arrowpos*klY/10,null);
								}
							arrowpos+=1;
						}
						else{//Âïðàâî
							if((magic<10)|(Integer.parseInt(lol[anim[anima][1]-anim[anima][1]/15*15][anim[anima][1]/15])!=0)){
							gr.drawImage(swordright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/6+anim[anima][1]/15*klY,null);
							gr.drawImage(swordright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/3+anim[anima][1]/15*klY,null);
							}
							else {
								gr.drawImage(Flame_swordright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/6+anim[anima][1]/15*klY,null);
								gr.drawImage(Flame_swordright,klX/4+klStart+(anim[anima][1]-anim[anima][1]/15*15)*klX+(anim[anima][2]-anim[anima][1])*arrowpos*klX/10,klY/3+anim[anima][1]/15*klY,null);
								}
							arrowpos+=1;
						}
					}
					if(arrowpos==1){
						//TODO
						//musicThread.arrow();
					}
					if(arrowpos>=10){
						if (anima<animation){anima+=1;}
						else {anima = 1; animation = 0;};
						arrowpos=0;
					}
					
					
				}
		
		}
		
		} 
		else if (menu==1){
			gr.drawImage(Inventory, 0, 0, null);
			if (inv[0][0]>0){
				gr.drawImage(invimage[0][0], 311*scrW/1500, 116*scrH/800, null);
			}
			if (inv[1][0]>0){
				gr.drawImage(invimage[1][0], 563*scrW/1500, 116*scrH/800, null);
			}
			if (inv[2][0]>0){
				gr.drawImage(invimage[2][0], 806*scrW/1500, 115*scrH/800, null);
			}
			if (inv[3][0]>0){
				gr.drawImage(invimage[3][0], 1039*scrW/1500, 115*scrH/800, null);
			}
			if (inv[4][0]>0){
				gr.drawImage(invimage[4][0], 1282*scrW/1500, 114*scrH/800, null);
			}
			if (inv[0][1]>0){
				gr.drawImage(invimage[0][1], 313*scrW/1500, 225*scrH/800, null);
			}
			if (inv[1][1]>0){
				gr.drawImage(invimage[1][1], 565*scrW/1500, 225*scrH/800, null);
			}
			if (inv[2][1]>0){
				gr.drawImage(invimage[2][1], 808*scrW/1500, 224*scrH/800, null);
			}
			if (inv[3][1]>0){
				gr.drawImage(invimage[3][1], 1041*scrW/1500, 224*scrH/800, null);
			}
			if (inv[4][1]>0){
				gr.drawImage(invimage[4][1], 1284*scrW/1500, 223*scrH/800, null);
			}
			if (inv[0][2]>0){
				gr.drawImage(invimage[0][2], 312*scrW/1500, 330*scrH/800, null);
			}
			if (inv[1][2]>0){
				gr.drawImage(invimage[1][2], 564*scrW/1500, 330*scrH/800, null);
			}
			if (inv[2][2]>0){
				gr.drawImage(invimage[2][2], 807*scrW/1500, 329*scrH/800, null);
			}
			if (inv[3][2]>0){
				gr.drawImage(invimage[3][2], 1040*scrW/1500, 329*scrH/800, null);
			}
			if (inv[4][2]>0){
				gr.drawImage(invimage[4][2], 1283*scrW/1500, 328*scrH/800, null);
			}
			if (inv[0][3]>0){
				gr.drawImage(invimage[0][3], 311*scrW/1500, 438*scrH/800, null);
			}
			if (inv[1][3]>0){
				gr.drawImage(invimage[1][3], 563*scrW/1500, 438*scrH/800, null);
			}
			if (inv[2][3]>0){
				gr.drawImage(invimage[2][3], 806*scrW/1500, 437*scrH/800, null);
			}
			if (inv[3][3]>0){
				gr.drawImage(invimage[3][3], 1039*scrW/1500, 437*scrH/800, null);
			}
			if (inv[4][3]>0){
				gr.drawImage(invimage[4][3], 1282*scrW/1500, 436*scrH/800, null);
			}
			if (inv[0][4]>0){
				gr.drawImage(invimage[0][4], 309*scrW/1500, 545*scrH/800, null);
			}
			if (inv[1][4]>0){
				gr.drawImage(invimage[1][4], 561*scrW/1500, 545*scrH/800, null);
			}
			if (inv[2][4]>0){
				gr.drawImage(invimage[2][4], 804*scrW/1500, 544*scrH/800, null);
			}
			if (inv[3][4]>0){
				gr.drawImage(invimage[3][4], 1037*scrW/1500, 544*scrH/800, null);
			}
			if (inv[4][4]>0){
				gr.drawImage(invimage[4][4], 1280*scrW/1500, 543*scrH/800, null);
			}
			if (inv[0][5]>0){
				gr.drawImage(invimage[0][5], 309*scrW/1500, 649*scrH/800, null);
			}
			if (inv[1][5]>0){
				gr.drawImage(invimage[1][5], 561*scrW/1500, 649*scrH/800, null);
			}
			if (inv[2][5]>0){
				gr.drawImage(invimage[2][5], 804*scrW/1500, 648*scrH/800, null);
			}
			if (inv[3][5]>0){
				gr.drawImage(invimage[3][5], 1037*scrW/1500, 648*scrH/800, null);
			}
			if (inv[4][5]>0){
				gr.drawImage(invimage[4][5], 1280*scrW/1500, 647*scrH/800, null);
			}
			////////////////////////////////////////////////////////////////////////////////////
			if ((inv[0][1]==0)&(inv[0][0]>=2)){
				gr.drawImage(CanCreate, 313*scrW/1500, 225*scrH/800, null);
			}
			if ((inv[1][1]==0)&(inv[1][0]>=2)){
				gr.drawImage(CanCreate, 565*scrW/1500, 225*scrH/800, null);
			}
			if ((inv[2][1]==0)&(inv[2][0]>=2)){
				gr.drawImage(CanCreate, 808*scrW/1500, 224*scrH/800, null);
			}
			if ((inv[3][1]==0)&(inv[3][0]>=2)){
				gr.drawImage(CanCreate, 1041*scrW/1500, 224*scrH/800, null);
			}
			if ((inv[4][1]==0)&(inv[4][0]>=2)){
				gr.drawImage(CanCreate, 1284*scrW/1500, 223*scrH/800, null);
			}
			////////////////////////////////////////////////////////////////////////////////////
			if(eqweapon==0){
				gr.drawImage(Eq_ram, 311*scrW/1500, 116*scrH/800, null);
			}
			else if(eqweapon==1){
				gr.drawImage(Eq_ram, 563*scrW/1500, 116*scrH/800, null);
			}
			else if(eqweapon==2){
				gr.drawImage(Eq_ram, 806*scrW/1500, 115*scrH/800, null);
			}
			else if(eqweapon==3){
				gr.drawImage(Eq_ram, 1039*scrW/1500, 115*scrH/800, null);
			}
			else if(eqweapon==4){
				gr.drawImage(Eq_ram, 1282*scrW/1500, 114*scrH/800, null);
			}
			else if(eqweapon==5){
				gr.drawImage(Eq_ram, 313*scrW/1500, 225*scrH/800, null);
			}
			else if(eqweapon==6){
				gr.drawImage(Eq_ram, 565*scrW/1500, 225*scrH/800, null);
			}
			else if(eqweapon==7){
				gr.drawImage(Eq_ram, 808*scrW/1500, 224*scrH/800, null);
			}
			else if(eqweapon==8){
				gr.drawImage(Eq_ram, 1041*scrW/1500, 224*scrH/800, null);
			}
			else if(eqweapon==9){
				gr.drawImage(Eq_ram, 1284*scrW/1500, 223*scrH/800, null);
			}
			else if(eqweapon==10){
				gr.drawImage(Eq_ram, 312*scrW/1500, 330*scrH/800, null);
			}
			else if(eqweapon==11){
				gr.drawImage(Eq_ram, 564*scrW/1500, 330*scrH/800, null);
			}
			else if(eqweapon==12){
				gr.drawImage(Eq_ram, 807*scrW/1500, 329*scrH/800, null);
			}
			else if(eqweapon==13){
				gr.drawImage(Eq_ram, 1040*scrW/1500, 329*scrH/800, null);
			}
			else if(eqweapon==14){
				gr.drawImage(Eq_ram, 1283*scrW/1500, 328*scrH/800, null);
			}
			if(eqarmor==0){
				gr.drawImage(Eq_ram, 311*scrW/1500, 438*scrH/800, null);
			}
			else if(eqarmor==1){
				gr.drawImage(Eq_ram, 563*scrW/1500, 438*scrH/800, null);
			}
			else if(eqarmor==2){
				gr.drawImage(Eq_ram, 806*scrW/1500, 437*scrH/800, null);
			}
			else if(eqarmor==3){
				gr.drawImage(Eq_ram, 1039*scrW/1500, 437*scrH/800, null);
			}
			else if(eqarmor==4){
				gr.drawImage(Eq_ram, 1282*scrW/1500, 436*scrH/800, null);
			}
			else if(eqarmor==5){
				gr.drawImage(Eq_ram, 309*scrW/1500, 545*scrH/800, null);
			}
			else if(eqarmor==6){
				gr.drawImage(Eq_ram, 561*scrW/1500, 545*scrH/800, null);
			}
			else if(eqarmor==7){
				gr.drawImage(Eq_ram, 804*scrW/1500, 544*scrH/800, null);
			}
			else if(eqarmor==8){
				gr.drawImage(Eq_ram, 1037*scrW/1500, 544*scrH/800, null);
			}
			else if(eqarmor==9){
				gr.drawImage(Eq_ram, 1280*scrW/1500, 543*scrH/800, null);
			}
			else if(eqarmor==10){
				gr.drawImage(Eq_ram, 309*scrW/1500, 649*scrH/800, null);
			}
			else if(eqarmor==11){
				gr.drawImage(Eq_ram, 561*scrW/1500, 648*scrH/800, null);
			}
			else if(eqarmor==12){
				gr.drawImage(Eq_ram, 804*scrW/1500, 648*scrH/800, null);
			}
			else if(eqarmor==13){
				gr.drawImage(Eq_ram, 1031*scrW/1500, 648*scrH/800, null);
			}
			else if(eqarmor==14){
				gr.drawImage(Eq_ram, 1280*scrW/1500, 647*scrH/800, null);
			}
			if (inv_ram==0){
				gr.drawImage(Inventory_ram, 311*scrW/1500, 116*scrH/800, null);
			}
			else if (inv_ram==1){
				gr.drawImage(Inventory_ram, 563*scrW/1500, 116*scrH/800, null);
			}
			else if (inv_ram==2){
				gr.drawImage(Inventory_ram, 806*scrW/1500, 115*scrH/800, null);
			}
			else if (inv_ram==3){
				gr.drawImage(Inventory_ram, 1039*scrW/1500, 115*scrH/800, null);
			}
			else if (inv_ram==4){
				gr.drawImage(Inventory_ram, 1282*scrW/1500, 114*scrH/800, null);
			}
			else if (inv_ram==5){
				gr.drawImage(Inventory_ram, 313*scrW/1500, 225*scrH/800, null);
			}
			else if (inv_ram==6){
				gr.drawImage(Inventory_ram, 565*scrW/1500, 225*scrH/800, null);
			}
			else if (inv_ram==7){
				gr.drawImage(Inventory_ram, 808*scrW/1500, 224*scrH/800, null);
			}
			else if (inv_ram==8){
				gr.drawImage(Inventory_ram, 1041*scrW/1500, 224*scrH/800, null);
			}
			else if (inv_ram==9){
				gr.drawImage(Inventory_ram, 1284*scrW/1500, 223*scrH/800, null);
			}
			else if (inv_ram==10){
				gr.drawImage(Inventory_ram, 312*scrW/1500, 330*scrH/800, null);
			}
			else if (inv_ram==11){
				gr.drawImage(Inventory_ram, 564*scrW/1500, 330*scrH/800, null);
			}
			else if (inv_ram==12){
				gr.drawImage(Inventory_ram, 807*scrW/1500, 329*scrH/800, null);
			}
			else if (inv_ram==13){
				gr.drawImage(Inventory_ram, 1040*scrW/1500, 329*scrH/800, null);
			}
			else if (inv_ram==14){
				gr.drawImage(Inventory_ram, 1283*scrW/1500, 328*scrH/800, null);
			}
			else if (inv_ram==15){
				gr.drawImage(Inventory_ram, 311*scrW/1500, 438*scrH/800, null);
			}
			else if (inv_ram==16){
				gr.drawImage(Inventory_ram, 563*scrW/1500, 438*scrH/800, null);
			}
			else if (inv_ram==17){
				gr.drawImage(Inventory_ram, 806*scrW/1500, 437*scrH/800, null);
			}
			else if (inv_ram==18){
				gr.drawImage(Inventory_ram, 1039*scrW/1500, 437*scrH/800, null);
			}
			else if (inv_ram==19){
				gr.drawImage(Inventory_ram, 1282*scrW/1500, 436*scrH/800, null);
			}
			else if (inv_ram==20){
				gr.drawImage(Inventory_ram, 309*scrW/1500, 545*scrH/800, null);
			}
			else if (inv_ram==21){
				gr.drawImage(Inventory_ram, 561*scrW/1500, 545*scrH/800, null);
			}
			else if (inv_ram==22){
				gr.drawImage(Inventory_ram, 804*scrW/1500, 544*scrH/800, null);
			}
			else if (inv_ram==23){
				gr.drawImage(Inventory_ram, 1037*scrW/1500, 544*scrH/800, null);
			}
			else if (inv_ram==24){
				gr.drawImage(Inventory_ram, 1280*scrW/1500, 543*scrH/800, null);
			}
			else if (inv_ram==25){
				gr.drawImage(Inventory_ram, 309*scrW/1500, 649*scrH/800, null);
			}
			else if (inv_ram==26){
				gr.drawImage(Inventory_ram, 561*scrW/1500, 649*scrH/800, null);
			}
			else if (inv_ram==27){
				gr.drawImage(Inventory_ram, 804*scrW/1500, 648*scrH/800, null);
			}
			else if (inv_ram==28){
				gr.drawImage(Inventory_ram, 1037*scrW/1500, 648*scrH/800, null);
			}
			else if (inv_ram==29){
				gr.drawImage(Inventory_ram, 1280*scrW/1500, 647*scrH/800, null);
			}
			
		
		}
		else if (menu==2){
			gr.drawImage(skills, 0, 0, null);
			if(skills_ram==0){
				gr.drawImage(skills_ram1, 14*scrW/1500, 15*scrH/800, null);
			}
			else if(skills_ram==1){
				gr.drawImage(skills_ram2, 260*scrW/1500, 15*scrH/800, null);
			}
			else if(skills_ram==2){
				gr.drawImage(skills_ram2, 559*scrW/1500, 11*scrH/800, null);
			}
			else if(skills_ram==3){
				gr.drawImage(skills_ram2, 862*scrW/1500, 10*scrH/800, null);
			}
			else if(skills_ram==4){
				gr.drawImage(skills_ram2, 1149*scrW/1500, 10*scrH/800, null);
			}
			else if(skills_ram==5){
				gr.drawImage(skills_ram1, 15*scrW/1500, 116*scrH/800, null);
			}
			else if(skills_ram==6){
				gr.drawImage(skills_ram2, 259*scrW/1500, 115*scrH/800, null);
			}
			else if(skills_ram==7){
				gr.drawImage(skills_ram2, 560*scrW/1500, 113*scrH/800, null);
			}
			else if(skills_ram==8){
				gr.drawImage(skills_ram2, 863*scrW/1500, 111*scrH/800, null);
			}
			else if(skills_ram==9){
				gr.drawImage(skills_ram2, 1149*scrW/1500, 110*scrH/800, null);
			}
			else if(skills_ram==10){
				gr.drawImage(skills_ram1, 15*scrW/1500, 216*scrH/800, null);
			}
			else if(skills_ram==11){
				gr.drawImage(skills_ram2, 261*scrW/1500, 215*scrH/800, null);
			}
			else if(skills_ram==12){
				gr.drawImage(skills_ram2, 560*scrW/1500, 213*scrH/800, null);
			}
			else if(skills_ram==13){
				gr.drawImage(skills_ram2, 863*scrW/1500, 211*scrH/800, null);
			}
			else if(skills_ram==14){
				gr.drawImage(skills_ram2, 1149*scrW/1500, 209*scrH/800, null);
			}
			else if(skills_ram==15){
				gr.drawImage(skills_ram1, 15*scrW/1500, 316*scrH/800, null);
			}
			else if(skills_ram==16){
				gr.drawImage(skills_ram2, 260*scrW/1500, 315*scrH/800, null);
			}
			else if(skills_ram==17){
				gr.drawImage(skills_ram2, 560*scrW/1500, 313*scrH/800, null);
			}
			else if(skills_ram==18){
				gr.drawImage(skills_ram2, 863*scrW/1500, 312*scrH/800, null);
			}
			else if(skills_ram==19){
				gr.drawImage(skills_ram2, 1149*scrW/1500, 309*scrH/800, null);
			}
			else if(skills_ram==20){
				gr.drawImage(skills_ram1, 15*scrW/1500, 416*scrH/800, null);
			}
			else if(skills_ram==21){
				gr.drawImage(skills_ram2, 260*scrW/1500, 415*scrH/800, null);
			}
			else if(skills_ram==22){
				gr.drawImage(skills_ram2, 561*scrW/1500, 412*scrH/800, null);
			}
			else if(skills_ram==23){
				gr.drawImage(skills_ram2, 863*scrW/1500, 411*scrH/800, null);
			}
			else if(skills_ram==24){
				gr.drawImage(skills_ram2, 1149*scrW/1500, 410*scrH/800, null);
			}
			else if(skills_ram==25){
				gr.drawImage(skills_ram1, 15*scrW/1500, 516*scrH/800, null);
			}
			else if(skills_ram==26){
				gr.drawImage(skills_ram2, 260*scrW/1500, 515*scrH/800, null);
			}
			else if(skills_ram==27){
				gr.drawImage(skills_ram2, 560*scrW/1500, 514*scrH/800, null);
			}
			else if(skills_ram==28){
				gr.drawImage(skills_ram2, 863*scrW/1500, 512*scrH/800, null);
			}
			else if(skills_ram==29){
				gr.drawImage(skills_ram2, 1149*scrW/1500, 510*scrH/800, null);
			}
			else if(skills_ram==30){
				gr.drawImage(skills_ram1, 15*scrW/1500, 616*scrH/800, null);
			}
			else if(skills_ram==31){
				gr.drawImage(skills_ram2, 259*scrW/1500, 615*scrH/800, null);
			}
			else if(skills_ram==32){
				gr.drawImage(skills_ram2, 560*scrW/1500, 613*scrH/800, null);
			}
			else if(skills_ram==33){
				gr.drawImage(skills_ram2, 862*scrW/1500, 613*scrH/800, null);
			}
			else if(skills_ram==34){
				gr.drawImage(skills_ram2, 1149*scrW/1500, 611*scrH/800, null);
			}
			////////////
			if (sword<=10){
				gr.drawImage(Health, 332*scrW/1500, 30*scrH/800, 228*sword/10*scrW/1500, 35*scrH/800, null);
			}
			else{
				gr.drawImage(Health, 332*scrW/1500, 30*scrH/800, 228*scrW/1500, 35*scrH/800, null);
				if(sword<=20){
					gr.drawImage(Health, 632*scrW/1500, 30*scrH/800, 230*(sword-10)/10*scrW/1500, 32*scrH/800, null);
				}
				else{
					gr.drawImage(Health, 632*scrW/1500, 30*scrH/800, 230*scrW/1500, 32*scrH/800, null);
					gr.drawImage(Health, 936*scrW/1500, 29*scrH/800, 212*(sword-20)/10*scrW/1500, 31*scrH/800, null);
				}
				
			}
			////////////
			if (dual<=10){
				gr.drawImage(Health, 332*scrW/1500, 130*scrH/800, 228*dual/10*scrW/1500, 35*scrH/800, null);
			}
			else{
				gr.drawImage(Health, 332*scrW/1500, 130*scrH/800, 228*scrW/1500, 35*scrH/800, null);
				if(dual<=20){
					gr.drawImage(Health, 632*scrW/1500, 130*scrH/800, 230*(dual-10)/10*scrW/1500, 32*scrH/800, null);
				}
				else{
					gr.drawImage(Health, 632*scrW/1500, 130*scrH/800, 230*scrW/1500, 32*scrH/800, null);
					gr.drawImage(Health, 936*scrW/1500, 128*scrH/800, 212*(dual-20)/10*scrW/1500, 31*scrH/800, null);
				}
				
			}
			////////////
				if (bow<=10){
					gr.drawImage(Health, 332*scrW/1500, 230*scrH/800, 228*bow/10*scrW/1500, 35*scrH/800, null);
				}
				else{
					gr.drawImage(Health, 332*scrW/1500, 230*scrH/800, 228*scrW/1500, 35*scrH/800, null);
					if(bow<=20){
						gr.drawImage(Health, 632*scrW/1500, 230*scrH/800, 230*(bow-10)/10*scrW/1500, 32*scrH/800, null);
					}
					else{
						gr.drawImage(Health, 632*scrW/1500, 230*scrH/800, 230*scrW/1500, 32*scrH/800, null);
						gr.drawImage(Health, 936*scrW/1500, 229*scrH/800, 212*(bow-20)/10*scrW/1500, 31*scrH/800, null);
					}
					
				}
				////////////
				if (magic<=10){
					gr.drawImage(Health, 332*scrW/1500, 330*scrH/800, 228*magic/10*scrW/1500, 35*scrH/800, null);
				}
				else{
					gr.drawImage(Health, 332*scrW/1500, 330*scrH/800, 228*scrW/1500, 35*scrH/800, null);
					if(magic<=20){
						gr.drawImage(Health, 632*scrW/1500, 330*scrH/800, 230*(magic-10)/10*scrW/1500, 32*scrH/800, null);
					}
					else{
						gr.drawImage(Health, 632*scrW/1500, 330*scrH/800, 230*scrW/1500, 32*scrH/800, null);
						gr.drawImage(Health, 936*scrW/1500, 328*scrH/800, 212*(magic-20)/10*scrW/1500, 31*scrH/800, null);
					}
					
				}
				////////////
				if (koja<=10){
					gr.drawImage(Health, 332*scrW/1500, 430*scrH/800, 228*koja/10*scrW/1500, 35*scrH/800, null);
				}
				else{
					gr.drawImage(Health, 332*scrW/1500, 430*scrH/800, 228*scrW/1500, 35*scrH/800, null);
					if(koja<=20){
						gr.drawImage(Health, 632*scrW/1500, 431*scrH/800, 230*(koja-10)/10*scrW/1500, 32*scrH/800, null);
					}
					else{
						gr.drawImage(Health, 632*scrW/1500, 431*scrH/800, 230*scrW/1500, 32*scrH/800, null);
						gr.drawImage(Health, 936*scrW/1500, 429*scrH/800, 212*(koja-20)/10*scrW/1500, 31*scrH/800, null);
					}
					
				}
				////////////
				if (iron<=10){
					gr.drawImage(Health, 332*scrW/1500, 530*scrH/800, 228*iron/10*scrW/1500, 35*scrH/800, null);
				}
				else{
					gr.drawImage(Health, 332*scrW/1500, 530*scrH/800, 228*scrW/1500, 35*scrH/800, null);
					if(iron<=20){
						gr.drawImage(Health, 632*scrW/1500, 530*scrH/800, 230*(iron-10)/10*scrW/1500, 32*scrH/800, null);
					}
					else{
						gr.drawImage(Health, 632*scrW/1500, 530*scrH/800, 230*scrW/1500, 32*scrH/800, null);
						gr.drawImage(Health, 936*scrW/1500, 528*scrH/800, 212*(iron-20)/10*scrW/1500, 31*scrH/800, null);
					}
					
				}
				////////////
				if (gold<=10){
					gr.drawImage(Health, 332*scrW/1500, 630*scrH/800, 228*gold/10*scrW/1500, 35*scrH/800, null);
				}
				else{
					gr.drawImage(Health, 332*scrW/1500, 630*scrH/800, 228*scrW/1500, 35*scrH/800, null);
					if(gold<=20){
						gr.drawImage(Health, 632*scrW/1500, 631*scrH/800, 230*(gold-10)/10*scrW/1500, 32*scrH/800, null);
					}
					else{
						gr.drawImage(Health, 632*scrW/1500, 631*scrH/800, 230*scrW/1500, 32*scrH/800, null);
						gr.drawImage(Health, 936*scrW/1500, 629*scrH/800, 212*(gold-20)/10*scrW/1500, 31*scrH/800, null);
					}
					
				}
		}
		if(menu==0){
			HP.setText(hp+"/"+mhp);
			MP.setText(mp+"/"+mmp);
			HP.setVisible(true);
			MP.setVisible(true);
		}
		else{
			HP.setVisible(false);
			MP.setVisible(false);
		}
		if(menu==2){
			EXP.setText(exp+"");
			EXP.setVisible(true);
		}
		else{
			EXP.setVisible(false);
		}
	
		if(inMessage>0){
			gr.drawImage(message,360*scrW/1520,169*scrH/838,null);
		}
	}
	public Image loadImage(Image im,String name,int x,int y){
		try {
			im = ImageIO.read(new File("./Pasan_Textures/"+name+".png"));
			im = im.getScaledInstance(x,y, Image.SCALE_SMOOTH);
			//im = im.getScaledInstance(im.getWidth(null)*scrW/1520,im.getHeight(null)*scrH/838, Image.SCALE_SMOOTH);
		} catch (IOException e) {}
		return(im);
	}
	public int animint(){
		if(anim[anima][1]==0){
			return(-1);
		}
		else if(anim[anima][1]==1){
			return(1);
		}
		else if(anim[anima][1]==2){
			return(-15);
		}
		else if(anim[anima][1]==3){
			return(15);
		}
		else{
			return(-1);
		}
	}
}
