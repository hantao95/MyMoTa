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
 * 对话框/商店/怪物图鉴
 * @author lelouch
 *
 */
public class Speaking {

	
	/**
	 * 对话框方法
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
	
	public static void showshop(Graphics drawOffScreen,int type) {
		switch(type) {
		case 1:break;
		case 2:break;
		case 3:break;
		case 4:break;
		}
	}
	
	/**
	 * 怪物信息
	 * @param drawOffScreen
	 * @param string
	 */
	public static int MonsterInfo(Graphics drawOffScreen,List<Monster> monsterList,Hero hero,int page) {
		//背景
		drawOffScreen.setColor(Color.BLACK);
		drawOffScreen.fillRect(0, 0, 352, 352);
		//边框
		drawOffScreen.setColor(Color.RED);
		drawOffScreen.drawRoundRect(0, 0, 342, 342, 10, 10);
		int time = 0;
		int x=32;
		int y=-40;
		for(int t=(page-1)*6;t<((monsterList.size()>(page*6))?page*6:monsterList.size());t++) {	
			Monster monster=monsterList.get(t);
			int tx = x;
			y+=48;
			int ty = y;
			drawOffScreen.drawImage(monster.mimage, x, y, null); // 怪物图片
			drawOffScreen.setColor(Color.WHITE);
			drawOffScreen.setFont(new Font("TimesRoman", Font.BOLD, 10));//字体设置
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
		//文字
		drawOffScreen.setColor(Color.WHITE);
		drawOffScreen.setFont(new Font("TimesRoman", Font.BOLD, 15));//字体设置
		drawOffScreen.drawString("---space---", 115, 300);
		drawOffScreen.drawString("<<  >>", 280, 320);
		drawOffScreen.setColor(Color.BLACK);
		return time;
	}
}
