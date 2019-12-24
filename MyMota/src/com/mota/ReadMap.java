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
			try {
				for (int i = 1; i < fs.length; i++) {
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
						//System.out.println("i:"+i+"row:"+row);
					}
					in.close();
				}
				//初始化怪物
				BufferedReader br1= new BufferedReader(new FileReader("MyMota/enemyMap.dat"));
				String line="";
				while((line=br1.readLine())!=null)
				{
					String[] temp = line.split(" ");
					maps[Integer.parseInt(temp[0])][Integer.parseInt(temp[2])][Integer.parseInt(temp[1])]=enemyMapping(temp[3])+1;
				}
				br1.close();
				//初始化道具
				BufferedReader br2= new BufferedReader(new FileReader("MyMota/itemMap.dat"));
		    	while((line=br2.readLine())!=null)
		    	{
		    		String[] temp = line.split(" ");
		    		maps[Integer.parseInt(temp[0])][Integer.parseInt(temp[2])][Integer.parseInt(temp[1])]=ToolMapping(temp[3]);
		    	}
		    	br2.close();
		    	//初始化NPC
		    	BufferedReader br3= new BufferedReader(new FileReader("MyMota/dialogueMap.dat"));
		    	while((line=br3.readLine())!=null)
		    	{
		    		String[] temp = line.split(" ");
		    		maps[Integer.parseInt(temp[0])][Integer.parseInt(temp[2])][Integer.parseInt(temp[1])]=NPCMapping(temp[3]);
		    	}
		    	br3.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
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
	//怪物映射
	public Integer enemyMapping (String value) {
		switch(Integer.parseInt(value)) {
		case 0:return 18;
		case 1:return 19;
		case 2:return 20;
		case 3:return 46;
		case 4:return 21;
		case 5:return 27;
		case 6:return 28;
		case 7:return 22;
		case 8:return 23;
		case 9:return 29;
		case 10:return 24; 
		case 11:return 45;
		case 12:return 26;
		case 13:return 30;
		case 14:return 25;
		case 15:return 35;
		case 16:return 31;
		case 17:return 32;
		case 18:return 38;
		case 19:return 40;
		case 20:return 36;
		case 21:return 42;
		case 22:return 41;
		case 23:return 37;
		case 24:return 33;
		case 25:return 34;
		case 26:return 43;
		case 27:return 45;
		case 28:return 44;
		case 29:return 46;
		case 30:return 49; 
		case 31:return 48;
		case 32:return 50;
		}
		return null;
	}
	//NPC映射
	public Integer NPCMapping (String value) {
		switch(Integer.parseInt(value)) {
		case 2:return 12;
		case 3:return 13;
		case 4:return 17;
		case 5:return 16;
		case 6:return 18;
		case 7:return 12;
		case 8:return 13;
		case 9:return 17;
		case 10:return 16; 
		case 11:return 18;
		case 12:return 11;
		case 13:return 11;
		case 14:return 13;
		case 15:return 12;
		case 16:return 12;
		case 17:return 13;
		case 19:return 15;
		}
		return null;
	}
	
	//道具映射
		public Integer ToolMapping (String value) {
			switch(Integer.parseInt(value)) {
			case 0:return 55;
			case 1:return 56;
			case 2:return 54;
			case 3:return 57;
			case 4:return 58;
			case 5:return 53;
			case 6:return 52;
			case 7:return 60;
			case 8:return 62;
			case 9:return 68;
			case 10:return 61; 
			case 11:return 64;
			case 12:return 63;
			case 13:return 65;
			case 14:return 66;
			case 15:return 69;
			case 16:return 71;
			case 17:return 59;
			case 18:return 67;
			case 19:return 72;
			case 20:return 73;
			}
			return null;
		}
}
