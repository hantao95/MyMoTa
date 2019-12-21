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
	
	/**
	 * 怪物信息
	 * @param drawOffScreen
	 * @param string
	 */
	public static int MonsterInfo(Graphics drawOffScreen,Set<Monster> monsterList) {
		//背景
		drawOffScreen.setColor(Color.BLACK);
		drawOffScreen.fillRect(0, 0, 352, 352);
		//边框
		drawOffScreen.setColor(Color.RED);
		drawOffScreen.drawRoundRect(0, 0, 342, 342, 10, 10);
		int time = 0;
		int x=0;
		int y=0;
		Set<Image> images = new HashSet<>();
		for(Monster monster : monsterList) {
			drawOffScreen.drawImage(monster.mimage, x+=32, y+=32, null);
		}
		//文字
		drawOffScreen.setColor(Color.WHITE);
		drawOffScreen.setFont(new Font("TimesRoman", Font.BOLD, 15));//字体设置
		drawOffScreen.drawString("---space---", 160, 247);
		drawOffScreen.setColor(Color.BLACK);
		return time;
	}
}
