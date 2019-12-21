package com.mota;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {
	public static void main(String[] args) throws IOException {
		new startGame();
	}
}

class startGame extends JFrame {
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
	Set<Monster> monsterSet = new HashSet<Monster>();
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

	/**
	 * ��ʼ��Ӣ�����������
	 */
	public void init() {
		hero = new Hero(1, 10000, 10, 10, 0, 0, 10, 0, 0, 1, mapimg[75]);
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
			if (mapimg[m-1].equals(monster[m - 19].mimage)) {
				return monster[m - 19];
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

	public startGame() {
		super("ħ��demo");
		init();
		mypanel = new Mypanel();
		mypanel.setBounds(200, 32, 352, 352);
		myState = mypanel.new MyState();
		myState.setBounds(30, 32, 128, 352);
		//��ҳ��͹���ͼ���л�
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
		 * ÿ����ƶ����� ǰΪ��¥�������꣬��Ϊ��¥�������꣺ 10,5�ǵ�һ�������1,5����¥ʱ����λ�� [0][0][0]
		 * [0][0][1]��¥�����һ��ʱ����λ��x,y [0][1][0] [0][1][1]��¥�����һ��ʱ����λ��x,y
		 */
		private int location[][][] = { { { 0, 5 }, { 0, 1 } }, { { 10, 4 }, { 0, 1 } } };// 22

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
			monsterSet.clear();
			for(int[] child:tempmap[level]) {
				for(int m:child) {
					if(m>=MTConstant.monsters_image_19&&m<=MTConstant.monsters_image_51)
					monsterSet.add(fmonster(m));
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
			} else if (isShowSpeaking!=0) {
				switch(isShowSpeaking) {
				case 1:Speaking.showSpeaking(gBuffer, string);break;
				case 2:getThisMonster();Speaking.MonsterInfo(gBuffer,monsterSet);break;
				case 3:break;
				case 4:break;
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
					} else if (e.getKeyCode() == 39) {
						// ���ҷ�ҳ
					} 
				}
			}
			mypanel.repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// �ո����
				isShowSpeaking = 0;
				canmove = true;
				isShow=false;
				myState.repaint();
				repaint();
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				// �س�����
			}else if (e.getKeyCode()==KeyEvent.VK_L) {
				//����L�� ��������ͼ��
				if(showMonster) {
					if(!isShow) {
						isShow=true;
						isShowSpeaking = 2;
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
				if ((hero.attack(fmonster(tempmap[level][gox][goy] - 1)) == -1)
						|| (hero.attack(fmonster(tempmap[level][gox][goy] - 1)) == 1)) {
					moveto(gox, goy, face);
				} else {
					canmove = false;
					isShowSpeaking = 1;
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
			case MTConstant.tools_image_52:moveto(gox, goy, face);myState.def += 2;hero.setDef(myState.def);break;
			case MTConstant.tools_image_53:moveto(gox, goy, face);myState.atk += 2;hero.setAtk(myState.atk);break;
			case MTConstant.tools_image_54:moveto(gox, goy, face);myState.redkey++;hero.setRkey(myState.redkey);break;
			case MTConstant.tools_image_55:moveto(gox, goy, face);myState.yellowkey++;hero.setYkey(myState.yellowkey);break;
			case MTConstant.tools_image_56:moveto(gox, goy, face);myState.bluekey++;hero.setBkey(myState.bluekey);break;
			case MTConstant.tools_image_57:moveto(gox, goy, face);myState.hp+=250;hero.setHp(myState.hp);break;
			case MTConstant.tools_image_58:moveto(gox, goy, face);myState.hp+=500;hero.setHp(myState.hp);break;
			case MTConstant.tools_image_59:moveto(gox, goy, face);showMonster=true;canmove = false;isShowSpeaking = 1;string = "��L�򿪹���ͼ����";break;
			case MTConstant.tools_image_60:moveto(gox, goy, face);myState.atk += 15;hero.setAtk(myState.atk);break;
			case MTConstant.tools_image_61:moveto(gox, goy, face);break;
			case MTConstant.tools_image_62:moveto(gox, goy, face);myState.atk += 15;hero.setAtk(myState.atk);break;
			case MTConstant.tools_image_63:moveto(gox, goy, face);break;
			case MTConstant.tools_image_64:moveto(gox, goy, face);break;
			case MTConstant.tools_image_65:moveto(gox, goy, face);break;
			case MTConstant.tools_image_66:moveto(gox, goy, face);break;
			case MTConstant.tools_image_67:moveto(gox, goy, face);myState.atk += 50;hero.setAtk(myState.atk);break;
			case MTConstant.tools_image_68:moveto(gox, goy, face);myState.atk += 50;hero.setAtk(myState.atk);break;
			case MTConstant.tools_image_69:moveto(gox, goy, face);break;
			case MTConstant.tools_image_70:moveto(gox, goy, face);break;
			case MTConstant.tools_image_71:moveto(gox, goy, face);myState.hp*=2;hero.setHp(myState.hp);break;
			case MTConstant.tools_image_72:moveto(gox, goy, face);myState.atk += 250;hero.setAtk(myState.atk);break;
			case MTConstant.tools_image_73:moveto(gox, goy, face);myState.atk += 250;hero.setAtk(myState.atk);break;
			}
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
