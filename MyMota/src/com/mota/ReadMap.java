package com.mota;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadMap {

	private int[][][] maps = new int[23][11][11];

	/**
	 * 初始化地图数据
	 */
	public ReadMap() {
		File f = new File("MyMota/maps");
		File fs[] = f.listFiles();		
		for (int i = 1; i < fs.length; i++) {
			try {
				BufferedReader in = new BufferedReader(new FileReader("MyMota/maps/" + i + ".map"));
				String line; // 一行数据
				int row = 0;
		// 逐行读取，并将每个数组放入到数组中
				while ((line = in.readLine()) != null) {
					String[] temp = line.split("\\s+");
					for (int j = 0; j < temp.length; j++) {
						maps[i][row][j] = Integer.parseInt(temp[j]);
					}
					row++;
					System.out.println("i:"+i+"row:"+row);
				}
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int[][][] getMaps() {
		return maps;
	}
	/**
	 * 载入图片数据
	 */
	public static Image[] loadImage(Toolkit kit) {
		Image mapimg[] = { kit.getImage("MyMota/maparea/1.jpg"), kit.getImage("MyMota/maparea/2.jpg"), kit.getImage("MyMota/maparea/3.jpg"),
				kit.getImage("MyMota/maparea/4.jpg"), kit.getImage("MyMota/maparea/5.jpg"), kit.getImage("MyMota/maparea/6.jpg"),
				kit.getImage("MyMota/maparea/7.jpg"), kit.getImage("MyMota/maparea/8.jpg"), kit.getImage("MyMota/maparea/9.jpg"),
				kit.getImage("MyMota/maparea/10.jpg"), kit.getImage("MyMota/npc/11.jpg"), kit.getImage("MyMota/npc/12.jpg"),
				kit.getImage("MyMota/npc/13.jpg"), kit.getImage("MyMota/npc/14.jpg"), kit.getImage("MyMota/npc/15.jpg"),
				kit.getImage("MyMota/npc/16.jpg"), kit.getImage("MyMota/npc/17.jpg"), kit.getImage("MyMota/npc/18.jpg"),
				kit.getImage("MyMota/monsters/19.jpg"), kit.getImage("MyMota/monsters/20.jpg"), kit.getImage("MyMota/monsters/21.jpg"),
				kit.getImage("MyMota/monsters/22.jpg"), kit.getImage("MyMota/monsters/23.jpg"), kit.getImage("MyMota/monsters/24.jpg"),
				kit.getImage("MyMota/monsters/25.jpg"), kit.getImage("MyMota/monsters/26.jpg"), kit.getImage("MyMota/monsters/27.jpg"),
				kit.getImage("MyMota/monsters/28.jpg"), kit.getImage("MyMota/monsters/29.jpg"), kit.getImage("MyMota/monsters/30.jpg"),
				kit.getImage("MyMota/monsters/31.jpg"), kit.getImage("MyMota/monsters/32.jpg"), kit.getImage("MyMota/monsters/33.jpg"),
				kit.getImage("MyMota/monsters/34.jpg"), kit.getImage("MyMota/monsters/35.jpg"), kit.getImage("MyMota/monsters/36.jpg"),
				kit.getImage("MyMota/monsters/37.jpg"), kit.getImage("MyMota/monsters/38.jpg"), kit.getImage("MyMota/monsters/39.jpg"),
				kit.getImage("MyMota/monsters/40.jpg"), kit.getImage("MyMota/monsters/41.jpg"), kit.getImage("MyMota/monsters/42.jpg"),
				kit.getImage("MyMota/monsters/43.jpg"), kit.getImage("MyMota/monsters/44.jpg"), kit.getImage("MyMota/monsters/45.jpg"),
				kit.getImage("MyMota/monsters/46.jpg"), kit.getImage("MyMota/monsters/47.jpg"), kit.getImage("MyMota/monsters/48.jpg"),
				kit.getImage("MyMota/monsters/49.jpg"), kit.getImage("MyMota/monsters/50.jpg"), kit.getImage("MyMota/monsters/51.jpg"),
				kit.getImage("MyMota/tool/52.jpg"), kit.getImage("MyMota/tool/53.jpg"), kit.getImage("MyMota/tool/54.jpg"),
				kit.getImage("MyMota/tool/55.jpg"), kit.getImage("MyMota/tool/56.jpg"), kit.getImage("MyMota/tool/57.jpg"),
				kit.getImage("MyMota/tool/58.jpg"), kit.getImage("MyMota/tool/59.jpg"), kit.getImage("MyMota/tool/60.jpg"),
				kit.getImage("MyMota/tool/61.jpg"), kit.getImage("MyMota/tool/62.jpg"), kit.getImage("MyMota/tool/63.jpg"),
				kit.getImage("MyMota/tool/64.jpg"), kit.getImage("MyMota/tool/65.jpg"), kit.getImage("MyMota/tool/66.jpg"),
				kit.getImage("MyMota/tool/67.jpg"), kit.getImage("MyMota/tool/68.jpg"), kit.getImage("MyMota/tool/69.jpg"),
				kit.getImage("MyMota/tool/70.jpg"), kit.getImage("MyMota/tool/71.jpg"), kit.getImage("MyMota/tool/72.jpg"),
				kit.getImage("MyMota/tool/73.jpg"), kit.getImage("MyMota/role/74.jpg"), kit.getImage("MyMota/role/75.jpg"),
				kit.getImage("MyMota/role/76.jpg"), kit.getImage("MyMota/role/77.jpg"), kit.getImage("MyMota/extra/78.jpg"),
				kit.getImage("MyMota/extra/79.jpg"), kit.getImage("MyMota/extra/80.jpg"), kit.getImage("MyMota/extra/81.jpg"),
				kit.getImage("MyMota/extra/82.jpg"), kit.getImage("MyMota/extra/83.png") };
		return mapimg;
	}
}
