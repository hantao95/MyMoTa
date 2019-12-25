package com.mota;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * �Ի���/�̵�/����ͼ��
 * @author lelouch
 *
 */
public class Speaking {

	
	/**
	 * �Ի��򷽷�
	 */
	public static void showSpeaking(Graphics drawOffScreen, String string) {
		drawOffScreen.setColor(Color.BLACK);
		drawOffScreen.fillRect(100, 132, 200, 120);
		drawOffScreen.setColor(Color.RED);
		drawOffScreen.drawRoundRect(100, 132, 200, 120, 10, 10);
		drawOffScreen.setColor(Color.WHITE);
		drawOffScreen.setFont(new Font("TimesRoman", Font.BOLD, 15));
		string += "                        ";
		for (int i = 0; !("            ".equals(string.substring(i * 12, (i + 1) * 12))); ++i) {
			drawOffScreen.drawString(string.substring(i * 12, (i + 1) * 12), 100, 148 + i * 20);
		}
		drawOffScreen.drawString("---space---", 160, 247);
		drawOffScreen.setColor(Color.BLACK);
	}
	
	/**
	 * �̵�
	 * 1.���
	 * 2.����
	 * 3.Կ��
	 * @param drawOffScreen
	 * @param type
	 */
	public static void showshop(Graphics drawOffScreen,int type,int level,int choose) {
		String[] strs = new String[4];
		switch(type) {
		case MTConstant.shopType_1:if(level==3) {
					strs[0]="25��һ����������";
					strs[1]="800HP";
					strs[2]="4ATK";
					strs[3]="4DEF";
				}else {
					strs[0]="100��һ����������";
					strs[1]="4000HP";
					strs[2]="20ATK";
					strs[3]="20DEF";	
				}
				break;
		case MTConstant.shopType_2:if(level==5) {
					strs[0]="���ľ�����Ի����������";
					strs[1]="level+1(100)";
					strs[2]="5ATK(30EXP)";
					strs[3]="5DEF(30EXP)";
				}else {
					strs[0]="���ľ�����Ի����������";
					strs[1]="level+3(270)";
					strs[2]="17ATK(95EXP)";
					strs[3]="17DEF(95EXP)";
				}
				break;
		case MTConstant.shopType_3:if(level==5) {
					strs[0]="������ý�ҹ���Կ��";
					strs[1]="��Կ�ף�10GOLD";
					strs[2]="��Կ�ף�50GOLD";
					strs[3]="��Կ�ף�100GOLD";
				}else {
					strs[0]="�����Կ�׿��Գ���";
					strs[1]="��Կ�ף�7GOLD";
					strs[2]="��Կ�ף�35GOLD";
					strs[3]="��Կ�ף�70GOLD";
				}
		break;
		}
		strs[choose]="��"+strs[choose];
		int x=32*2;
		int y=32*3;
		//����
		drawOffScreen.setColor(Color.BLACK);
		drawOffScreen.fillRect(x, y, 32*7, 32*5);
		//�߿�
		drawOffScreen.setColor(Color.blue);
		drawOffScreen.drawRoundRect(x, y, 32*7, 32*5, 10, 10);
		y+=10;
		drawOffScreen.setColor(Color.WHITE);
		drawOffScreen.setFont(new Font("TimesRoman", Font.BOLD, 15));//��������
		for(String str:strs) {
			drawOffScreen.drawString(str, x+15, y+=20);
		}
		drawOffScreen.drawString("�˳���space ȷ����enter", 84, y+=30);
		drawOffScreen.setColor(Color.BLACK);
	}
	
	/**
	 * ������Ϣ
	 * @param drawOffScreen
	 * @param string
	 */
	public static void MonsterInfo(Graphics drawOffScreen,List<Monster> monsterList,Hero hero,int page) {
		//����
		drawOffScreen.setColor(Color.BLACK);
		drawOffScreen.fillRect(0, 0, 352, 352);
		//�߿�
		drawOffScreen.setColor(Color.RED);
		drawOffScreen.drawRoundRect(0, 0, 342, 342, 10, 10);
		int x=32;
		int y=-40;
		for(int t=(page-1)*6;t<((monsterList.size()>(page*6))?page*6:monsterList.size());t++) {	
			Monster monster=monsterList.get(t);
			int tx = x;
			y+=48;
			int ty = y;
			drawOffScreen.drawImage(monster.mimage, x, y, null); // ����ͼƬ
			drawOffScreen.setColor(Color.WHITE);
			drawOffScreen.setFont(new Font("TimesRoman", Font.BOLD, 10));//��������
			String strs1[]={"ATK","DEF","BLOOD","GOLD","EXP","DAMAGE"};
			String strs2[]= {String.valueOf(monster.atk),String.valueOf(monster.def),String.valueOf(monster.hp),String.valueOf(monster.money),String.valueOf(monster.exp),String.valueOf(hero.attackCheck(monster))};
			if(strs2[5].equals("-1")) {
				strs2[5]="NaN";
			}
			String str1="";
			String str2="";
			for(int i=0;i<strs1.length;i++) {
				int length1 = strs1[i].length();
				int length2 = strs2[i].length();
				if(length1==length2) {					
				}else if(length1>length2) {
					for(int j=0;j<length1-length2;j++) {
						strs2[i]+="  ";
					}
				}else {
					for(int j=0;j<length2-length1;j++) {
						strs1[i]+=" ";
					}
				}
				strs1[i]+=" ";
				strs2[i]+="  ";
				str1 += strs1[i];
				str2 += strs2[i];
			}
			tx = x+52;
			ty +=13;
			drawOffScreen.drawString(str1, tx, ty);
			ty +=16;
			drawOffScreen.drawString(str2, tx, ty);
			drawOffScreen.setColor(Color.BLACK);
		}
		//����
		drawOffScreen.setColor(Color.WHITE);
		drawOffScreen.setFont(new Font("TimesRoman", Font.BOLD, 15));//��������
		drawOffScreen.drawString("---space---", 115, 300);
		drawOffScreen.drawString("��  ��", 280, 320);
		drawOffScreen.setColor(Color.BLACK);
	}


}
