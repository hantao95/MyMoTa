package com.mota;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;



 public class StartGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 0,��չʾ�Ի���
	 * 1,�Ի���
	 * 2,����ͼ��
	 * 3,����̵�
	 * 4,�����̵�
	 */
	int isShowSpeaking = 0;
	String string;
	boolean isStart = true;
	boolean canmove = true;
	private Image iBuffer;
	private Graphics gBuffer;// ��Ϸ����
	Mypanel mypanel;
	Mypanel.MyState myState;
	Hero hero;
	/** ��������	 */
	Monster monster[] = new Monster[33];
	/**�������**/
	List<Monster> monsterList = new ArrayList<Monster>();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image mapimg[] = ReadMap.loadImage(kit);
	/**�ϲ㿪��	 */
	boolean up_stair = false;
	/**�²㿪��	 */
	boolean down_stair = false;
	/**�ܷ�ʹ�ù���ͼ��״̬*/
	boolean showMonster = true;
	/**����ͼ��״̬*/
	boolean isShow = false;
	/**ҳ��*/
	int page = 0;
	/**�̵�ҳ��*/
	int shopType = 0;
	/**�̵�ѡ��*/
	int choose = 1;

	/**
	 * ��ʼ��Ӣ�����������
	 */
	public void init() {
		hero = new Hero(1, 10000, 100, 100, 1000, 1000, 100, 100, 100, 1, mapimg[75]);
		monster[0] = new Monster("Сʷ��ķ", 50, 20, 1, 1, 1, mapimg[18]);
		monster[1] = new Monster("��ʷ��ķ", 70, 15, 2, 2, 1, mapimg[19]);
		monster[2] = new Monster("��ʷ��ķ", 200, 35, 10, 5, 3, mapimg[20]);
		monster[3] = new Monster("С����", 100, 20, 5, 3, 2, mapimg[21]);
		monster[4] = new Monster("���ñ�", 110, 25, 5, 5, 3, mapimg[22]);
		monster[5] = new Monster("���ý�ʿ", 150, 40, 20, 8, 5, mapimg[23]);
		monster[6] = new Monster("������ʦ", 125, 50, 25, 10, 7, mapimg[24]);
		monster[7] = new Monster("����", 300, 75, 45, 13, 10, mapimg[25]);
		monster[8] = new Monster("����ɮ��", 250, 120, 70, 20, 15, mapimg[26]);
		monster[9] = new Monster("������", 150, 65, 30, 10, 8, mapimg[27]);
		monster[10] = new Monster("��Ѫ����", 550, 170, 100, 25, 20, mapimg[28]);
		monster[11] = new Monster("������ʿ", 400, 90, 50, 15, 12, mapimg[29]);
		monster[12] = new Monster("�߼�ɮ��", 500, 400, 260, 47, 35, mapimg[30]);
		monster[13] = new Monster("ʯͷ��", 500, 115, 65, 15, 15, mapimg[31]);
		monster[14] = new Monster("��������", 450, 150, 90, 22, 19, mapimg[32]);
		monster[15] = new Monster("��ʿ����", 850, 350, 200, 45, 35, mapimg[33]);
		monster[16] = new Monster("˫�ֽ�ʿ", 1200, 620, 520, 65, 50, mapimg[34]);
		monster[17] = new Monster("�м���ʦ", 100, 200, 110, 30, 25, mapimg[35]);
		monster[18] = new Monster("������", 1300, 300, 150, 40, 30, mapimg[36]);
		monster[19] = new Monster("����ʿ", 900, 750, 650, 77, 60, mapimg[37]);
		monster[20] = new Monster("����ʿ", 900, 450, 330, 50, 40, mapimg[38]);
		monster[21] = new Monster("�м�����", 1250, 500, 400, 55, 45, mapimg[39]);
		monster[22] = new Monster("�߼�����", 1500, 560, 460, 60, 50, mapimg[40]);
		monster[23] = new Monster("������", 2500, 900, 850, 84, 70, mapimg[41]);
		monster[24] = new Monster("ڤ����", 2000, 680, 590, 70, 55, mapimg[42]);
		monster[25] = new Monster("��ҹ��ʿ", 1200, 980, 900, 88, 75, mapimg[43]);
		monster[26] = new Monster("Ԫ��", 3100, 1300, 1300, 92, 80, mapimg[44]);
		monster[27] = new Monster("ħ��ʿ", 1500, 830, 730, 80, 65, mapimg[45]);
		monster[28] = new Monster("ħ��", 3100, 1200, 1200, 70, 70, mapimg[46]);
		monster[29] = new Monster("��ʷ��ķ", 700, 250, 125, 32, 25, mapimg[47]);
		monster[30] = new Monster("������ʦ", 15000, 1800, 1700, 100, 100, mapimg[48]);
		monster[31] = new Monster("ħ��", 25000, 2100, 2000, 150, 120, mapimg[49]);
		monster[32] = new Monster("��ħ��", 80000, 2300, 2100, 1000, 1000, mapimg[50]);
	}

	/**
	 * ͨ��ͼƬ��ȡ�������
	 */
	public Monster fmonster(int m) {
		if (m > 18) {
			if (mapimg[m].equals(monster[m - 18].mimage)) {
				return monster[m - 18];
			}
		} else {
			for (int i = 0; i < 33; i++) {
				if (mapimg[m].equals(monster[i].mimage)) {
					return monster[i];
				}
			}
		}
		return null;
	}

	public StartGame() {
		super("ħ��demo");
		init();
		mypanel = new Mypanel();
		mypanel.setBounds(200, 32, 352, 352);
		myState = mypanel.new MyState();
		myState.setBounds(30, 32, 128, 352);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLACK);
		c.add(mypanel);
		c.add(myState);
		setSize(590, 450);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mypanel.requestFocus();
	}

	
	
	
	class Mypanel extends JPanel implements KeyListener {
		private static final long serialVersionUID = 1L;

		private int level = 1;
		private int my, mx;
		private int tempmap[][][];
		/**
		 * ÿ����ƶ����� ǰΪ��¥�������꣬��Ϊ��¥�������꣺
		 * [0][0][0] [0][0][1]��¥�����һ��ʱ����λ��y,x [0][1][0] [0][1][1]��¥�����һ��ʱ����λ��y,x
		 */
		private int location[][][] = { { { 0, 1 }, { 0, 1 } }, //1
									  { { 1, 0 }, { 9, 0 } } ,//2
									  { { 10, 1 }, { 9, 10 } } ,//3
									  { { 9, 10 }, { 9, 0 } } ,//4
									  { { 9, 0 }, { 9, 9 } } ,//5
									  { { 9, 9 }, { 5, 10 } } ,//6
									  { { 5, 10 }, { 0, 1 } } ,//7
									  { { 1, 0 }, { 4, 8 } } ,//8
									  { { 3, 6 }, { 7, 6 } } ,  //9
									  { { 6, 4 }, { 9, 0 } } ,  //10
									  { { 10, 1 }, { 10, 9 } } ,  //11
									  { { 10, 9 }, { 10, 1 } } ,  //12
									  { { 10, 1 }, { 10, 4 } } ,  //13
									  { { 9, 5 }, { 0, 5 } } ,  //14
									  { { 0, 3 }, { 0, 7 } } ,  //15
									  { { 0, 5 }, { 7, 5 } } ,  //16
									  { { 8, 5 }, { 10, 1 } } ,  //17
									  { { 10, 1 }, { 10, 9 } } ,  //18
									  { { 10, 9 }, { 4, 5 } } ,  //19
									  { { 4, 5 }, { 6, 5 } } ,  //20
									  { { 6, 4 }, { 0, 0 } } ,  //21
		};// 22

		/** ��ʼ����ͼ��С��Ӣ����ʼ���꣬���ڲ�����JF��С����Ӽ��̼�����keyPressed��		 */
		public Mypanel() {
			setSize(352, 352);
			this.addKeyListener(this);
			this.tempmap = new ReadMap().getMaps();
			this.my = 10;
			this.mx = 5;
			requestFocus();
		}
		
		//��ȡ�������
		public void getThisMonster() {
 			monsterList.clear();
			for(int[] child:tempmap[level]) {
				for(int m:child) {
					if(m>=MTConstant.monsters_image_19&&m<=MTConstant.monsters_image_51) {
						int flag = 0;//ȥ�ر�ǡ����ﲻ��set����Ϊset�������
						for(Monster mt:monsterList) {
							Monster b=fmonster(m);
							if(mt==b) {
								flag=1;
							}
						}
						if(flag==0) {
							monsterList.add(fmonster(m));
						}
					}
				}
			}
		}
		

		public void readmaps(int level) {
			// ��ȡ���²�� ��ʼ����
			if (up_stair) {
				my = location[level - 1][0][0];
				mx = location[level - 1][0][1];
			} else if (down_stair) {
				my = location[level - 1][1][0];
				mx = location[level - 1][1][1];
			}
		}

		@Override
		public void paint(Graphics g) {
			if (iBuffer == null) {
				iBuffer = createImage(this.getSize().width, this.getSize().height);
				gBuffer = iBuffer.getGraphics();
			}
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					// ��ȡ�������ͼƬ
					gBuffer.drawImage(mapimg[tempmap[level][i][j] - 1], j * 32, i * 32, 32, 32, this);
				}
			}
			// ִֻ��һ��
			if (isStart) {
				tempmap[level][my][mx] = 76;
				gBuffer.drawImage(mapimg[76], mx * 32, my * 32, 32, 32, this);
				isStart = false;
			} else if (isShowSpeaking!=MTConstant.isShowSpeaking_0) {
				switch(isShowSpeaking) {
				/*
				 * 1.��ʾ�Ի���
				 * 2.����ͼ��
				 * 3.�̵�
				 * 
				 */
				case MTConstant.isShowSpeaking_1:Speaking.showSpeaking(gBuffer, string);break;
				case MTConstant.isShowSpeaking_2:getThisMonster();Speaking.MonsterInfo(gBuffer,monsterList,hero,page);break;
				case MTConstant.isShowSpeaking_3:Speaking.showshop(gBuffer, shopType, level, choose); break;

				}
			}

			g.drawImage(iBuffer, 0, 0, this);
			requestFocus();
		}


		/**
		 * �ƶ����� ���̼����Զ����ɷ���ͨ����ȡ������keycodeʵ���ƶ�
		 * 
		 */
		public void keyPressed(KeyEvent e) {
			if (canmove) {
				if (e.getKeyCode() == 37) {
					// �����ƶ�
					if(tempmap[level][my][mx]==MTConstant.role_image_74){
						if (mx - 1 > -1) 
							move(my, mx - 1, MTConstant.role_image_74);
						}else
						tempmap[level][my][mx]=MTConstant.role_image_74;
				} else if (e.getKeyCode() == 38) {
					// �����ƶ�
					if(tempmap[level][my][mx]==MTConstant.role_image_77) {
						if (my - 1 > -1) 
							move(my - 1, mx, MTConstant.role_image_77);
					}else
						tempmap[level][my][mx]=MTConstant.role_image_77;
				} else if (e.getKeyCode() == 39) {
					// �����ƶ�
					if(tempmap[level][my][mx]==MTConstant.role_image_75) {
						if (mx + 1 < 11) 
							move(my, mx + 1, MTConstant.role_image_75);
					}else
						tempmap[level][my][mx]=MTConstant.role_image_75;
				} else if (e.getKeyCode() == 40) {
					// �����ƶ�
					if(tempmap[level][my][mx]==MTConstant.role_image_76) {
						if (my + 1 < 11) 
							move(my + 1, mx, MTConstant.role_image_76);
					}else
						tempmap[level][my][mx]=MTConstant.role_image_76;
				}
				
			}else {
				if(isShow) {
					if (e.getKeyCode() == 37) {
						// ����ҳ
						if(page>1&&monsterList.size()>6) {
							page-=1;
							repaint();
						}
					} else if (e.getKeyCode() == 39) {
						// ���ҷ�ҳ
						if(page<monsterList.size()/6+1&&monsterList.size()>6) {
							page+=1;
							repaint();
						}
					} 
				}else if(shopType>0) {
					if(e.getKeyCode() == 38) {
						if(choose>1) {
							choose-=1;repaint();
						}
					}else if(e.getKeyCode() == 40){
						if(choose<3) {
							choose+=1;repaint();
						}
					}
				}
			}
			mypanel.repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// �ո����
				isShowSpeaking = MTConstant.isShowSpeaking_0;
				canmove = true;
				isShow=false;
				shopType=0;
				myState.repaint();
				repaint();
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(shopType>0) {
					reflushData(shopType,level,choose);
					myState.repaint();
					repaint();
				}
				// �س�����
			}else if (e.getKeyCode()==KeyEvent.VK_L) {
				//����L�� ��������ͼ��
				if(showMonster) {
					if(!isShow) {
						isShow=true;
						isShowSpeaking = MTConstant.isShowSpeaking_2;
						page = 1;
						canmove = false;
						repaint();
					}
				}
			}
		}

		public void move(int gox, int goy, int face) {
			if (tempmap[level][gox][goy] == 5) {
				moveto(gox, goy, face);
			}else if(MTConstant.DismoveSet.contains(tempmap[level][gox][goy])) {
				//���������ƶ����� ɶ������
			}else if (tempmap[level][gox][goy] >= 19 && tempmap[level][gox][goy] <= 50) {
				// ������
				if ((hero.attack(fmonster(tempmap[level][gox][goy] - 1))>=0)) {
					moveto(gox, goy, face);
				} else {
					canmove = false;
					isShowSpeaking = MTConstant.isShowSpeaking_1;
					string = "��ʿ���һ��򲻹�����";
				}
			} else if (tempmap[level][gox][goy] == 4) {
				tempmap[level][my][mx] = 5;
				level++;
				up_stair = true;// ��¥��ʶ��
				if (level > hero.getMaxstair()) {
					// ���µ������߲�
					hero.setMaxstair(level);
				}
				readmaps(level);// ��ȡ�²�����
				tempmap[level][my][mx] = face;
				up_stair = false;
			} else if (tempmap[level][gox][goy] == 78) {
				tempmap[level][my][mx] = 5;
				level--;
				down_stair = true;// ��¥��ʶ��
				readmaps(level);// ��ȡ�²�����
				tempmap[level][my][mx] = face;
				down_stair = false;
			} else if (tempmap[level][gox][goy] == 3 && myState.yellowkey > 0) {
				moveto(gox, goy, face);
				myState.yellowkey--;
				hero.setYkey(myState.yellowkey);
			} else if (tempmap[level][gox][goy] == 8 && myState.bluekey > 0) {
				moveto(gox, goy, face);
				myState.bluekey--;
				hero.setBkey(myState.bluekey);
			} else if (tempmap[level][gox][goy] == 7 && myState.redkey > 0) {
				moveto(gox, goy, face);
				myState.redkey--;
				hero.setRkey(myState.redkey);
			}else if(tempmap[level][gox][goy] == 10) {
				tempmap[level][gox][goy] = 5;
				tempmap[level][my][mx] = face;
			}
			else if(tempmap[level][gox][goy] >=52&&tempmap[level][gox][goy]<=73) {
				meetTools(gox,goy,face);
			}else if(tempmap[level][gox][goy] >=12&&tempmap[level][gox][goy]<=18) {
				meetNpc(gox,goy);
			}
			myState.repaint();
			repaint();
		}
		//�����ƶ�
		public void moveto(int gox,int goy,int face) {
			tempmap[level][gox][goy] = face;
			tempmap[level][my][mx] = 5;
			my = gox;
			mx = goy;
		}
		
		
		//��������
		public void meetTools(int gox,int goy,int face) {
			switch(tempmap[level][gox][goy]) {
			case MTConstant.tools_image_52:moveto(gox, goy, face);addDEF(3);break;
			case MTConstant.tools_image_53:moveto(gox, goy, face);addATK(3);break;
			case MTConstant.tools_image_54:moveto(gox, goy, face);addRKey(1);break;
			case MTConstant.tools_image_55:moveto(gox, goy, face);addYKey(1);break;
			case MTConstant.tools_image_56:moveto(gox, goy, face);addBKey(1);break;
			case MTConstant.tools_image_57:moveto(gox, goy, face);addHP(200);break;
			case MTConstant.tools_image_58:moveto(gox, goy, face);addHP(500);break;
			case MTConstant.tools_image_59:moveto(gox, goy, face);showMonster=true;canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "��L�򿪹���ͼ����";break;
			case MTConstant.tools_image_60:moveto(gox, goy, face);addATK(10);break;
			case MTConstant.tools_image_61:moveto(gox, goy, face);addRKey(1);addYKey(1);addBKey(1);break;
			case MTConstant.tools_image_62:moveto(gox, goy, face);addDEF(10);break;
			case MTConstant.tools_image_63:moveto(gox, goy, face);addmoney(300);break;
			case MTConstant.tools_image_64:moveto(gox, goy, face);levelup(1);break;
			case MTConstant.tools_image_65:moveto(gox, goy, face);addATK(myState.atk/4);addDEF(myState.def/4);break;
			case MTConstant.tools_image_66:moveto(gox, goy, face);break;
			case MTConstant.tools_image_67:moveto(gox, goy, face);addATK(70);break;
			case MTConstant.tools_image_68:moveto(gox, goy, face);addDEF(85);break;
			case MTConstant.tools_image_69:moveto(gox, goy, face);tempmap[18][8][5]=5;tempmap[18][9][5]=5;break;
			case MTConstant.tools_image_70:moveto(gox, goy, face);break;
			case MTConstant.tools_image_71:moveto(gox, goy, face);myState.hp*=2;hero.setHp(myState.hp);break;
			case MTConstant.tools_image_72:moveto(gox, goy, face);addATK(250);break;
			case MTConstant.tools_image_73:moveto(gox, goy, face);addDEF(250);break;
			}
		}
		
		//����NPC
		public void meetNpc(int gox,int goy) {
			switch(tempmap[level][gox][goy]) {
			case MTConstant.NPC_image_11:canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "2¥���㿪���ˡ�";tempmap[2][1][6]=5;break;
			case MTConstant.NPC_image_12:meetNpc12();break;
			case MTConstant.NPC_image_13:meetNpc13();break;
			case MTConstant.NPC_image_14:break;
			case MTConstant.NPC_image_15:canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "��˵�ϻ��˿���¥��";tempmap[18][10][10]=78;break;
			case MTConstant.NPC_image_16:shopType=MTConstant.shopType_1;choose=1;isShowSpeaking=MTConstant.isShowSpeaking_3;canmove = false;break;
			case MTConstant.NPC_image_17:break;
			case MTConstant.NPC_image_18:break;
			}
		}
		
		public void meetNpc12() {
			if(level==2) {
				canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "лл�������ң���ѽ����� ATK+30.";addATK(30);
			}else if(level==15) {
				if(myState.exp>500) {
					canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "500���飬��ѽ����� ATK+110��";addATK(110);addexp(-500);
				}else {
					canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "500���飬��ѽ����� ATK+110,������û�С�";
				}
			}else {
				shopType=MTConstant.shopType_2;choose=1;isShowSpeaking=MTConstant.isShowSpeaking_3;canmove = false;
			}
		}
		
		public void meetNpc13() {
			if(level==2) {
				canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "лл�������ң�����ܸ��� DEF+30��";addDEF(30);
			}else if(level==15) {
				if(myState.money>500) {
					canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "500��ң�����ܸ��� DEF+120��";addDEF(120);addmoney(-120);
				}else {
					canmove = false;isShowSpeaking = MTConstant.isShowSpeaking_1;string = "500��ң�����ܸ��� DEF+120,������û�С�";
				}
			}else {
				shopType=MTConstant.shopType_3;choose=1;isShowSpeaking=MTConstant.isShowSpeaking_3;canmove = false;
			}
		}
		
		//�̵���������
		public void reflushData(int shopType,int level,int choose) {
			switch(shopType) {
			case MTConstant.shopType_1:if(level==3) {
				switch(choose) {
				case 1:if(myState.money>25) {addmoney(-25);addHP(800);}break;
				case 2:if(myState.money>25) {addmoney(-25);addATK(4);}break;
				case 3:if(myState.money>25) {addmoney(-25);addDEF(4);}break;
				}
			}else{
				switch(choose) {
				case 1:if(myState.money>100) {addmoney(-100);addHP(4000);}break;
				case 2:if(myState.money>100) {addmoney(-100);addATK(20);}break;
				case 3:if(myState.money>100) {addmoney(-100);addDEF(20);}break;
				}
			};break;
			case MTConstant.shopType_2:if(level==5) {
				switch(choose) {
				case 1:if(myState.exp>100) {addexp(-100);levelup(1);}break;
				case 2:if(myState.exp>30) {addexp(-30);addATK(5);}break;
				case 3:if(myState.exp>30) {addexp(-30);addDEF(5);}break;
				}
			}else{
				switch(choose) {
				case 1:if(myState.exp>270) {addexp(-270);levelup(3);}break;
				case 2:if(myState.exp>95) {addexp(-95);addATK(17);}break;
				case 3:if(myState.exp>95) {addexp(-95);addDEF(17);}break;
				}
			};break;
			case MTConstant.shopType_3:if(level==5) {
				switch(choose) {
				case 1:if(myState.money>10) {addmoney(-10);addYKey(1);}break;
				case 2:if(myState.money>50) {addmoney(-50);addBKey(1);}break;
				case 3:if(myState.money>100) {addmoney(-100);addRKey(1);}break;
				}
			}else{
				switch(choose) {
				case 1:if(myState.yellowkey>1) {addmoney(7);addYKey(-1);}break;
				case 2:if(myState.bluekey>1) {addmoney(35);addBKey(-1);}break;
				case 3:if(myState.redkey>1) {addmoney(70);addRKey(-1);}break;
				}
			};break;
			}
		}
		public void levelup(int x) {
			addATK(7*x);
			addDEF(7*x);
			addHP(1000*x);
			hero.setLevel(hero.getLevel()+x);
		}
		
		public void addmoney(int gold) {
			myState.money+=gold;
			hero.setMoney(myState.money);
		}
		public void addexp(int exp) {
			myState.exp+=exp;
			hero.setExp(myState.exp);
		}
		
		public void addATK(int value) {
			myState.atk +=value;
			hero.setAtk(myState.atk);
		}
		public void addDEF(int value) {
			myState.def+=value;
			hero.setDef(myState.def);
		}
		public void addHP(int value) {
			myState.hp+=value;
			hero.setHp(myState.hp);
		}
		public void addYKey(int value) {
			myState.yellowkey+=value;
			hero.setYkey(myState.yellowkey);
		}
		public void addBKey(int value) {
			myState.bluekey+=value;
			hero.setBkey(myState.bluekey);
		}
		public void addRKey(int value) {
			myState.redkey+=value;
			hero.setRkey(myState.redkey);
		}

		
		class MyState extends JPanel {
			private static final long serialVersionUID = 1L;
			/**
			 * ����
			 */
			private int hp;
			/**
			 * ����
			 */
			private int atk;
			/**
			 * ����
			 */
			private int def;
			/**
			 * ���
			 */
			private int money;
			/**
			 * ����
			 */
			private int exp;
			/**
			 * Կ��
			 */
			private int yellowkey, bluekey, redkey;
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image image[] = { kit.getImage("MyMota/maparea/5.jpg"), kit.getImage("MyMota/tool/54.jpg"), kit.getImage("MyMota/tool/55.jpg"),
					kit.getImage("MyMota/tool/56.jpg"), kit.getImage("MyMota/tool/59.jpg"), kit.getImage("MyMota/tool/66.jpg"),
					kit.getImage("MyMota/tool/69.jpg"), kit.getImage("MyMota/tool/71.jpg") };

			public MyState() {
				hero.getLevel();
				this.hp = hero.getHp();
				this.atk = hero.getAtk();
				this.def = hero.getDef();
				this.money = hero.getMoney();
				this.exp = hero.getExp();
				this.yellowkey = hero.getYkey();
				this.bluekey = hero.getBkey();
				this.redkey = hero.getRkey();
				setSize(128, 352);
			}

			@Override
			public void paint(Graphics g) {
				Font font = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 18);
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 11; j++) {
						g.drawImage(image[0], i * 32, j * 32, 32, 32, this);
					}
				}
				g.setFont(font);
				g.drawString(hero.getLevel() + "��", 0, 1 * 32);
				g.drawString("����  " + hero.getHp(), 0, 2 * 32);
				g.drawString("����  " + hero.getAtk(), 0, 3 * 32);
				g.drawString("����  " + hero.getDef(), 0, 4 * 32);
				g.drawString("���  " + hero.getMoney(), 0, 5 * 32);
				g.drawString("����  " + hero.getExp(), 0, 6 * 32);
				g.drawImage(image[2], 0, 6 * 32 + 10, this);
				g.drawString("" + hero.getYkey(), 2 * 32, 7 * 32);
				g.drawImage(image[3], 0, 7 * 32 + 10, this);
				g.drawString("" + hero.getBkey(), 2 * 32, 8 * 32);
				g.drawImage(image[1], 0, 8 * 32 + 10, this);
				g.drawString("" + hero.getRkey(), 2 * 32, 9 * 32);
				g.drawString("��" + mypanel.level + "��", 0, 350);
			}
		}
		

		@Override
		public void keyTyped(KeyEvent e) {

		}
	}
}