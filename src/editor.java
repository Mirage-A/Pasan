// I wrote this game ~2 years ago, so pls dont look source code unless you want your eyes to bleed :)
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class editor extends JFrame{
	editorMenu gameY;
	String name;
	String[][] lol = new String[15][10];
	int[][] health = new int[15][10];
	int[][] maxhealth = new int[15][10];
	int[][] damage = new int[15][10];
	int[][] armor = new int[15][10];
	int[][] weapon = new int[15][10];
	int ram=0;
	int kod;
	boolean start = false;
	boolean konec = false;
	boolean active = false;
	boolean saved=true;
	int sum=0;
	int sp=-1;
	int kp=-1;
	String map="";
	int sum2=0;
	int scrW,scrH;
	boolean edit;
	String profile,omg;
	int gmo,i,n;
	KeyListener keylis1,keylis2,keylis3,keylis4,keylis5;
	public class myKey implements KeyListener{
	
		public void keyPressed(KeyEvent e){
			int key_ = e.getKeyCode();
			if(gameY.inMessage==0){
			if(key_==37){//Âëåâî
				if(ram-ram/15*15>0){
					ram-=1;
					gameY.ram=ram;
				}
			}
			else if(key_==38){//Ââåðõ
				if(ram/15>0){
					ram-=15;
					gameY.ram=ram;
				}
			}
			else if(key_==39){//Âïðàâî
				if(ram-ram/15*15<14){
					ram+=1;
					gameY.ram=ram;
				}
			}
			else if(key_==40){//Âíèç
				if(ram/15<9){
					ram+=15;
					gameY.ram=ram;
				}
			}
			else if((key_==32)|(key_==10)){//Ïðîáåë
					gameY.inMessage=1;
					gameY.mes.setVisible(true);
					gameY.head.setVisible(true);
					gameY.textField.setVisible(true);
					gameY.head.setText("Èçìåíåíèå êëåòêè");
					gameY.mes.setText("<html>Ââåäèòå íîìåð êëåòêè:<br>0-Ñòàðòîâàÿ òî÷êà (òîëüêî îäíà)<br>1-Òðàâà 2-Äåðåâî 3-Äîðîãà<br>4-Ñîêðîâèùå 5-Ïðîòèâíèê<br>6-Êîíå÷íàÿ òî÷êà (òîëüêî îäíà)</html>");
					gameY.textField.setText("");
					gameY.textField.requestFocus();
					gameY.textField.addKeyListener(keylis1);
					
				
			}
			
			else if(key_==27){//Esc
				if((sp!=-1)&(kp!=-1)&(start==true)&(konec==true)){
					gameY.inMessage=8;
					gameY.mes.setVisible(true);
					gameY.head.setVisible(true);
					gameY.textField.setVisible(false);
					gameY.head.setText("Âûõîä èç ðåäàêòîðà");
					gameY.mes.setText("<html>Ïîêèíóòü ðåäàêòîð?</html>");
				
				}
				else{
					gameY.inMessage=10;
					gameY.mes.setVisible(true);
					gameY.head.setVisible(true);
					gameY.textField.setVisible(false);
					gameY.head.setText("Âûõîä èç ðåäàêòîðà");
					gameY.mes.setText("<html>Íà êàðòå íåò ñòàðòîâîé èëè êîíå÷íîé òî÷êè.<br>Êàðòà íå áóäåò ñîõðàíåíà.<br>Ïîêèíóòü ðåäàêòîð?</html>");
				}
			}
			else if (key_==KeyEvent.VK_S){
				if((konec==true)&(start==true)){
				gameY.inMessage=12;
				gameY.mes.setVisible(true);
				gameY.head.setVisible(true);
				gameY.textField.setVisible(false);
				gameY.head.setText("Ñîõðàíåíèå êàðòû");
				gameY.mes.setText("<html>Ñîõðàíèòü êàðòó?</html>");
				}
				else{
					gameY.inMessage=13;
					gameY.mes.setVisible(true);
					gameY.head.setVisible(true);
					gameY.textField.setVisible(false);
					gameY.head.setText("Ñîõðàíåíèå êàðòû");
					gameY.mes.setText("<html>Ðàçìåñòèòå íà êàðòå ñòàðòîâóþ è êîíå÷íóþ òî÷êó, ÷òîáû ñîõðàíèòü å¸.</html>");
					
				}
			}
	}
		////////////////////////////////
		else if(gameY.inMessage==2){
				if(key_==10){
					if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==6){
						konec=false;
					}
					lol[sp-sp/15*15][sp/15]="1";
					gameY.lol[sp-sp/15*15][sp/15]="1";
					lol[ram-ram/15*15][ram/15]="0";
					gameY.lol[ram-ram/15*15][ram/15]="0";
					sp=ram;
					saved=false;
					clearMessage();
					gameY.textField.removeKeyListener(keylis1);
				}
				else if(key_==27){	
					clearMessage();
					gameY.textField.removeKeyListener(keylis1);
				}
		}
		else if(gameY.inMessage==7){
			if((key_==10)|(key_==27)){
				clearMessage();
				gameY.textField.removeKeyListener(keylis1);
			}
		}
		else if(gameY.inMessage==8){
			if(key_==10){
				if(saved==true){
					stop();
				}
				else{
					gameY.inMessage=9;
					gameY.mes.setVisible(true);
					gameY.head.setVisible(true);
					gameY.textField.setVisible(false);
					gameY.head.setText("Âûõîä èç ðåäàêòîðà");
					gameY.mes.setText("<html>Ñîõðàíèòü èçìåíåíèÿ?</html>");
				}
			}
			else if(key_==27){
					clearMessage();
			}
		}
		else if(gameY.inMessage==9){
			if(key_==10){
			clearMessage();
			saveMap();
			stop();
			}
			else if(key_==27){
			clearMessage();
			stop();
			}
		}
		else if(gameY.inMessage==10){
			if(key_==10){
				clearMessage();
				if(edit==false){
					File file = new File("./Pasan_UserMaps/"+name+".pasan");
					file.delete();
						}
				stop();
			}
			else if(key_==27){
				clearMessage();
			}
		}
		else if(gameY.inMessage==11){
			if(key_==10){
				if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==0){
					start=false;
				}
				lol[kp-kp/15*15][kp/15]="1";
				gameY.lol[kp-kp/15*15][kp/15]="1";
				lol[ram-ram/15*15][ram/15]="6";
				gameY.lol[ram-ram/15*15][ram/15]="6";
				kp=ram;
				saved=false;
				clearMessage();
				gameY.textField.removeKeyListener(keylis1);
			}
			else if(key_==27){	
				clearMessage();
				gameY.textField.removeKeyListener(keylis1);
			}
		}
		else if(gameY.inMessage==12){
			if(key_==10){
				gameY.inMessage=13;
				gameY.mes.setVisible(true);
				gameY.head.setVisible(true);
				gameY.textField.setVisible(false);
				gameY.head.setText("Ñîõðàíåíèå êàðòû");
				gameY.mes.setText("<html>Êàðòà óñïåøíî ñîõðàíåíà.</html>");
				saveMap();
				saved=true;
			}
			else if(key_==27){
				clearMessage();
			}
		}
		else if(gameY.inMessage==13){
			if((key_==10)|(key_==27)){
				clearMessage();
			}
		}
		}
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}
}
	public editor(){
		{
			Dimension sSize =Toolkit.getDefaultToolkit ().getScreenSize ();
			scrW=(int)(sSize.getWidth());
			scrH=(int)(sSize.getHeight());
			}
		addKeyListener(new myKey());
		//setBounds(0,0,1520,838);
		Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		setSize (sSize);
		setUndecorated(true);
		setTitle("PasanEditor");
		gameY = new editorMenu();
		Container con = getContentPane();
		con.add(gameY);
		ImageIcon icon = new ImageIcon("./Pasan_Textures/Hero.png");
		setIconImage(icon.getImage());
		setVisible(false);
		this.addWindowListener(new WindowAdapter() {            
            @Override
            public void windowClosing(WindowEvent e) {
              System.exit(0);
            }
      });
		keylis1=new KeyAdapter() {
		     @Override
		     public void keyPressed(KeyEvent e) {
		    	 int key = e.getKeyCode();
		    	 if(key==10){
		    		 String rez=gameY.textField.getText().trim();
						kod = rez.charAt(0)-'0';
						if(kod==0){
							if (start==false){
								if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==6){
									konec=false;
								}
								start=true;
								lol[ram-ram/15*15][ram/15]="0";
								gameY.lol[ram-ram/15*15][ram/15]="0";
								sp=ram;
								saved=false;
								clearMessage();
								gameY.textField.removeKeyListener(keylis1);
							}
							else{
								gameY.inMessage=2;
								gameY.mes.setVisible(true);
								gameY.head.setVisible(true);
								gameY.textField.setVisible(false);
								gameY.head.setText("Ñòàðòîâàÿ òî÷êà");
								gameY.mes.setText("<html>Íà ýòîé êàðòå óæå åñòü ñòàðòîâàÿ òî÷êà.<br>Ïåðåìåñòèòü å¸ â ýòó êëåòêó?</html>");
								requestFocus();
								gameY.textField.removeKeyListener(keylis1);
							}
						}
						else if(kod==1){
							if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==0){
								start=false;
							}
							else if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==6){
								konec=false;
							}
							lol[ram-ram/15*15][ram/15]="1";
							gameY.lol[ram-ram/15*15][ram/15]="1";
							saved=false;
				    		clearMessage();
							gameY.textField.removeKeyListener(keylis1);
						}
						else if(kod==2){
							if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==0){
								start=false;
							}
							else if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==6){
								konec=false;
							}
							lol[ram-ram/15*15][ram/15]="2";
							gameY.lol[ram-ram/15*15][ram/15]="2";
							saved=false;
				    		clearMessage();
							gameY.textField.removeKeyListener(keylis1);
						}
						else if(kod==3){
							if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==0){
								start=false;
							}
							else if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==6){
								konec=false;
							}
							lol[ram-ram/15*15][ram/15]="3";
							gameY.lol[ram-ram/15*15][ram/15]="3";
							saved=false;
				    		clearMessage();
							gameY.textField.removeKeyListener(keylis1);
						}
						else if(kod==4){
							if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==0){
								start=false;
							}
							else if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==6){
								konec=false;
							}
							lol[ram-ram/15*15][ram/15]="4";
							gameY.lol[ram-ram/15*15][ram/15]="4";
							saved=false;
				    		clearMessage();
							gameY.textField.removeKeyListener(keylis1);
						}
						else if(kod==5){
							if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==0){
								start=false;
							}
							else if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==6){
								konec=false;
							}
							gameY.inMessage=3;
							gameY.mes.setVisible(true);
							gameY.head.setVisible(true);
							gameY.textField.setVisible(true);
							gameY.head.setText("Ðàçìåùåíèå ïðîòèâíèêà");
							gameY.mes.setText("<html>Ââåäèòå íîìåð îðóæèÿ ïðîòèâíèêà:<br>0-Áåç îðóæèÿ (áëèæíèé áîé)<br>1-Ìå÷ (áëèæíèé áîé)<br>2-Ïàðíûå êëèíêè (áëèæíèé áîé)<br>3-Ëóê (äàëüíèé áîé)</html>");
							gameY.textField.setText("");
							gameY.textField.requestFocus();
							gameY.textField.addKeyListener(keylis2);
							gameY.textField.removeKeyListener(keylis1);
						}
						else if(kod==6){
							if (konec==false){
								if(Integer.parseInt(lol[ram-ram/15*15][ram/15])==0){
									start=false;
								}
								konec=true;
								lol[ram-ram/15*15][ram/15]="6";
								gameY.lol[ram-ram/15*15][ram/15]="6";
								kp=ram;
								saved=false;
								clearMessage();
								gameY.textField.removeKeyListener(keylis1);
							}
							else{
								gameY.inMessage=11;
								gameY.mes.setVisible(true);
								gameY.head.setVisible(true);
								gameY.textField.setVisible(false);
								gameY.head.setText("Êîíå÷íàÿ òî÷êà");
								gameY.mes.setText("<html>Íà ýòîé êàðòå óæå åñòü êîíå÷íàÿ òî÷êà.<br>Ïåðåìåñòèòü å¸ â ýòó êëåòêó?</html>");
								gameY.textField.removeKeyListener(keylis1);
								requestFocus();
							}
						}
						else{
							gameY.inMessage=7;
							gameY.mes.setVisible(true);
							gameY.head.setVisible(true);
							gameY.textField.setVisible(false);
							gameY.head.setText("Îøèáêà");
							gameY.mes.setText("<html>Äàííûå ââåäåíû íåâåðíî.</html>");
							gameY.textField.removeKeyListener(keylis1);
							requestFocus();
						}
		    	 }
		    	 else if(key==27){
		    		clearMessage();
					gameY.textField.removeKeyListener(keylis1);
		    	 }
		     }
		};
		keylis2 = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
				int key=e.getKeyCode();
				if(key==10){
					String res=gameY.textField.getText().trim();
					kod = res.charAt(0)-'0';
					if((kod>=0)&&(kod<=3)){
						weapon[ram-ram/15*15][ram/15]=kod;
						gameY.weapon[ram-ram/15*15][ram/15]=kod;
						gameY.inMessage=4;
						gameY.mes.setVisible(true);
						gameY.head.setVisible(true);
						gameY.textField.setVisible(true);
						gameY.head.setText("Ðàçìåùåíèå ïðîòèâíèêà");
						gameY.mes.setText("<html>Ââåäèòå íîìåð áðîíè ïðîòèâíèêà:<br>(áðîíÿ íå âëèÿåò íà çàùèòó ïðîòèâíèêîâ)<br>0-Áåç áðîíè<br>1-Êîæàíàÿ áðîíÿ<br>2-Æåëåçíàÿ áðîíÿ<br>3-Çîëîòàÿ áðîíÿ</html>");
						gameY.textField.setText("");
						gameY.textField.requestFocus();
						gameY.textField.addKeyListener(keylis3);
						gameY.textField.removeKeyListener(keylis2);
					}
					else{
						gameY.inMessage=7;
						gameY.mes.setVisible(true);
						gameY.head.setVisible(true);
						gameY.textField.setVisible(false);
						gameY.head.setText("Îøèáêà");
						gameY.mes.setText("<html>Äàííûå ââåäåíû íåâåðíî.</html>");
						gameY.textField.setText("");
						gameY.textField.removeKeyListener(keylis2);
						requestFocus();
					}
						
				}
		    	 else if(key==27){
		    		 clearMessage();
						gameY.textField.removeKeyListener(keylis2);
		    	 }
			}
		};
		keylis3 = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
				int key=e.getKeyCode();
				if(key==10){
					String res=gameY.textField.getText().trim();
					kod = res.charAt(0)-'0';
					if((kod>=0)&&(kod<=3)){
						armor[ram-ram/15*15][ram/15]=kod;
						gameY.armor[ram-ram/15*15][ram/15]=kod;
						gameY.inMessage=5;
						gameY.mes.setVisible(true);
						gameY.head.setVisible(true);
						gameY.textField.setVisible(true);
						gameY.head.setText("Ðàçìåùåíèå ïðîòèâíèêà");
						gameY.mes.setText("<html>Ââåäèòå óðîí, íàíîñèìûé ïðîòèâíèêîì:<br>(÷èñëî îò 0 äî 999)</html>");
						gameY.textField.setText("");
						gameY.textField.requestFocus();
						gameY.textField.addKeyListener(keylis4);
						gameY.textField.removeKeyListener(keylis3);
					}
					else{
						gameY.inMessage=7;
						gameY.mes.setVisible(true);
						gameY.head.setVisible(true);
						gameY.textField.setVisible(false);
						gameY.head.setText("Îøèáêà");
						gameY.mes.setText("<html>Äàííûå ââåäåíû íåâåðíî.</html>");
						gameY.textField.setText("");
						gameY.textField.removeKeyListener(keylis3);
						requestFocus();
					}
						
				}
		    	 else if(key==27){
		    		clearMessage();
					gameY.textField.removeKeyListener(keylis3);
		    	 }
			}
		};
		keylis4 = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
				int key=e.getKeyCode();
				if(key==10){
					String res=gameY.textField.getText().trim();
					sum=0;
					if (res.length()==1){
						res="00" + res;
					}
					else if (res.length()==2){
						res="0" + res;
					}
					for(int i=0; i<=2; i++){
						if ((res.charAt(i)-'0'>=0)&&(res.charAt(i)-'0'<=9)){
							if(i==0){
								sum=sum+(res.charAt(i)-'0')*100;
							}
							else if(i==1){
								sum=sum+(res.charAt(i)-'0')*10;
							}
							else if(i==2){
								sum=sum+(res.charAt(i)-'0');
							}
						}
						else{
							gameY.inMessage=7;
							gameY.mes.setVisible(true);
							gameY.head.setVisible(true);
							gameY.textField.setVisible(false);
							gameY.head.setText("Îøèáêà");
							gameY.mes.setText("<html>Äàííûå ââåäåíû íåâåðíî.</html>");
							gameY.textField.setText("");
							gameY.textField.removeKeyListener(keylis4);
							requestFocus();
						}
					}
					damage[ram-ram/15*15][ram/15]=sum;
					gameY.damage[ram-ram/15*15][ram/15]=sum;
					gameY.inMessage=6;
					gameY.mes.setVisible(true);
					gameY.head.setVisible(true);
					gameY.textField.setVisible(true);
					gameY.head.setText("Ðàçìåùåíèå ïðîòèâíèêà");
					gameY.mes.setText("<html>Ââåäèòå ìàêñèìàëüíîå çäîðîâüå ïðîòèâíèêà:<br>(÷èñëî îò 1 äî 999)</html>");
					gameY.textField.setText("");
					gameY.textField.requestFocus();
					gameY.textField.addKeyListener(keylis5);
					gameY.textField.removeKeyListener(keylis4);
				}
		    	 else if(key==27){
		    		clearMessage();
		    		gameY.textField.removeKeyListener(keylis4);
		    	 }
			}
		};
		keylis5 = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
				int key=e.getKeyCode();
				if(key==10){
					String res=gameY.textField.getText().trim();
					sum=0;
					if (res.length()==1){
						res="00" + res;
					}
					else if (res.length()==2){
						res="0" + res;
					}
					for(int i=0; i<=2; i++){
						if ((res.charAt(i)-'0'>=0)&&(res.charAt(i)-'0'<=9)){
							if(i==0){
								sum=sum+(res.charAt(i)-'0')*100;
							}
							else if(i==1){
								sum=sum+(res.charAt(i)-'0')*10;
							}
							else if(i==2){
								sum=sum+(res.charAt(i)-'0');
							}
						
						}
						else{
							gameY.inMessage=7;
							gameY.mes.setVisible(true);
							gameY.head.setVisible(true);
							gameY.textField.setVisible(false);
							gameY.head.setText("Îøèáêà");
							gameY.mes.setText("<html>Äàííûå ââåäåíû íåâåðíî.</html>");
							gameY.textField.setText("");
							gameY.textField.removeKeyListener(keylis5);
							requestFocus();
						}
					}
					if(sum==0){
						sum=1;
					}
					health[ram-ram/15*15][ram/15]=sum;
					gameY.health[ram-ram/15*15][ram/15]=sum;
					maxhealth[ram-ram/15*15][ram/15]=sum;
					gameY.maxhealth[ram-ram/15*15][ram/15]=sum;
				lol[ram-ram/15*15][ram/15]="5";
				gameY.lol[ram-ram/15*15][ram/15]="5";
				saved=false;
				clearMessage();
				gameY.textField.removeKeyListener(keylis5);
				}
		    	 else if(key==27){
		    		clearMessage();
					gameY.textField.removeKeyListener(keylis5);
		    	 }
			}
		};
}
	public void start(boolean isEdit){
		saved=true;
		edit=isEdit;
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		getContentPane().setCursor(blankCursor);
		gameY.ram=0;
		gameY.timerDraw.start();
		setVisible(true);
		ram=0;
		active = true;
		map="";
		gameY.ram=0;
		sum=0;
		sum2=0;
		if(edit==false){
		for(int i=0; i<=14; i++){
			for(int j=0; j<=9; j++){
				lol[i][j]="1";
				gameY.lol[i][j]="1";
				health[i][j]=0;
				gameY.health[i][j]=0;
				maxhealth[i][j]=0;
				gameY.maxhealth[i][j]=0;
				damage[i][j]=0;
				gameY.damage[i][j]=0;
				armor[i][j]=0;
				gameY.armor[i][j]=0;
				weapon[i][j]=0;
				gameY.weapon[i][j]=0;
			}
		}
		start = false;
		konec = false;
		sp=-1;
		kp=-1;
		}
		else{
			map="";
			try(FileReader reader = new FileReader("./Pasan_UserMaps/"+name+".pasan"))
	        {
	            int d;
	            while((d=reader.read())!=-1){
	                 
	               
	            	map=map+((char)d);
	            } 
	            
	        }
	        catch(IOException ex){}
			try{
				i=0;
				n=0;
				start=true;
				konec=true;
				while(i<=149){
				omg=Character.toString(map.charAt(i+n));
				lol[i-i/15*15][i/15]=omg;
				gameY.lol[i-i/15*15][i/15]=omg;
				if(Integer.parseInt(omg)==0){sp=i;}
				if(Integer.parseInt(omg)==6){kp=i;}
				if(Character.getNumericValue(map.charAt(i+n))==5){
					
					gmo = Character.getNumericValue(map.charAt(i+n+1));
					weapon[i-i/15*15][i/15]= gmo;
					gameY.weapon[i-i/15*15][i/15]= gmo;
					gmo = Character.getNumericValue(map.charAt(i+n+2));
					armor[i-i/15*15][i/15]= gmo;
					gameY.armor[i-i/15*15][i/15]=gmo;
					damage[i-i/15*15][i/15]= Character.getNumericValue(map.charAt(i+n+3))*100;
					damage[i-i/15*15][i/15]+= Character.getNumericValue(map.charAt(i+n+4))*10;
					damage[i-i/15*15][i/15]+= Character.getNumericValue(map.charAt(i+n+5));
					health[i-i/15*15][i/15]= Character.getNumericValue(map.charAt(i+n+6))*100;
					maxhealth[i-i/15*15][i/15]= Character.getNumericValue(map.charAt(i+n+6))*100;
					health[i-i/15*15][i/15]+= Character.getNumericValue(map.charAt(i+n+7))*10;
					maxhealth[i-i/15*15][i/15]+= Character.getNumericValue(map.charAt(i+n+7))*10;
					health[i-i/15*15][i/15]+= Character.getNumericValue(map.charAt(i+n+8));
					maxhealth[i-i/15*15][i/15]+= Character.getNumericValue(map.charAt(i+n+8));
					damage[i-i/15*15][i/15]=damage[i-i/15*15][i/15];
					health[i-i/15*15][i/15]=health[i-i/15*15][i/15];
					maxhealth[i-i/15*15][i/15]=maxhealth[i-i/15*15][i/15];
					gameY.damage[i-i/15*15][i/15]=damage[i-i/15*15][i/15];
					gameY.health[i-i/15*15][i/15]=health[i-i/15*15][i/15];
					gameY.maxhealth[i-i/15*15][i/15]=maxhealth[i-i/15*15][i/15];
					n+=8;
				}
				i+=1;
				}
		}catch(Exception ex){
			for(int i=0; i<=14; i++){
				for(int j=0; j<=9; j++){
					lol[i][j]="1";
					gameY.lol[i][j]="1";
					health[i][j]=0;
					gameY.health[i][j]=0;
					maxhealth[i][j]=0;
					gameY.maxhealth[i][j]=0;
					damage[i][j]=0;
					gameY.damage[i][j]=0;
					armor[i][j]=0;
					gameY.armor[i][j]=0;
					weapon[i][j]=0;
					gameY.weapon[i][j]=0;
				}
			}
			start = false;
			konec = false;
			sp=-1;
			kp=-1;
		}
		}
		clearMessage();
	}
	public void stop(){
		active=false;
		setVisible(false);
		gameY.timerDraw.stop();
		gameY.inMessage=0;
		gameY.head.setText("");
		gameY.mes.setText("");
		gameY.textField.setText("");
		gameY.head.setVisible(false);
		gameY.mes.setVisible(false);
		gameY.textField.setVisible(false);
	}
	public void clearMessage(){
		gameY.inMessage=0;
		gameY.mes.setVisible(false);
		gameY.head.setVisible(false);
		gameY.textField.setVisible(false);
		gameY.head.setText("");
		gameY.mes.setText("");
		gameY.textField.setText("");
		requestFocus();
	}
	public void saveMap(){
		map="";
		//Çàïèñü â ôàéë
			File file = new File("./Pasan_UserMaps/"+name+".pasan");
			try {
		        
		        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
		 
		        try{
		        	for(int j=0;j<=9;j++){
		        		for(int i=0;i<=14;i++){
		        			map=map+lol[i][j];
		        			if(Integer.parseInt(lol[i][j])==5){
		        			map=map+Integer.toString(weapon[i][j]);
		        			map=map+Integer.toString(armor[i][j]);
		        			if(damage[i][j]>=100){
		        				map=map+Integer.toString(damage[i][j]/100);
		        				map=map+Integer.toString(damage[i][j]/10-damage[i][j]/100*10);
		        				map=map+Integer.toString(damage[i][j]-damage[i][j]/10*10);
		        			}
		        			else if(damage[i][j]>=10){
		        					map=map+"0";
		        					map=map+Integer.toString(damage[i][j]/10);
		        					map=map+Integer.toString(damage[i][j]-damage[i][j]/10*10);
		        				}
		        			else{
		        				map=map+"0";
		        				map=map+"0";
		        				map=map+Integer.toString(damage[i][j]-damage[i][j]/10*10);
		        			}
		        			
		        			if(maxhealth[i][j]>=100){
		        				map=map+Integer.toString(maxhealth[i][j]/100);
		        				map=map+Integer.toString(maxhealth[i][j]/10-maxhealth[i][j]/100*10);
		        				map=map+Integer.toString(maxhealth[i][j]-maxhealth[i][j]/10*10);
		        			}
		        			else if(maxhealth[i][j]>=10){
		        					map=map+"0";
		        					map=map+Integer.toString(maxhealth[i][j]/10);
		        					map=map+Integer.toString(maxhealth[i][j]-maxhealth[i][j]/10*10);
		        				}
		        			else{
		        				map=map+"0";
		        				map=map+"0";
		        				map=map+Integer.toString(maxhealth[i][j]-maxhealth[i][j]/10*10);
		        			}
		        		}}
		        	}
		            out.print(map);
		            
		        } finally {
		            out.close();
		        }
		    } catch(IOException ex) {}
		
	}
}
