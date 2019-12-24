package com.mota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MTConstant {
	//***************地形 maparea************//
	/**岩浆**/
	public static final int maparea_image_1 = 1;
	/**星空**/
	public static final int maparea_image_2 = 2;
	/**黄门**/
	public static final int maparea_image_3 = 3;
	/**上楼楼梯**/
	public static final int maparea_image_4 = 4;
	/**地面**/
	public static final int maparea_image_5 = 5;
	/**土墙**/
	public static final int maparea_image_6 = 6;
	/**红门**/
	public static final int maparea_image_7 = 7;
	/**蓝门**/
	public static final int maparea_image_8 = 8;
	/**守卫门**/
	public static final int maparea_image_9 = 9;
	/**铁门**/
	public static final int maparea_image_10 = 10;
	/**下楼楼梯**/
	public static final int mapare_image_78 = 78;
	/**石墙**/
	public static final int mapare_image_82 = 82;

	//***************NPC ************//
	/**贼**/
	public static final int NPC_image_11 = 11;
	/**老人**/
	public static final int NPC_image_12 = 12;
	/**商人**/
	public static final int NPC_image_13 = 13;
	/**精灵**/
	public static final int NPC_image_14 = 14;
	/**公主**/
	public static final int NPC_image_15 = 15;
	/**商店中**/
	public static final int NPC_image_16 = 16;
	/**商店左**/
	public static final int NPC_image_17 = 17;
	/**商店右**/
	public static final int NPC_image_18 = 18;
	/**商店中**/
	public static final int NPC_image_79 = 79;
	/**商店左**/
	public static final int NPC_image_80 = 80;
	/**商店右**/
	public static final int NPC_image_81 = 81;
	//***************怪物 monsters************//
	/**绿史莱姆**/
	public static final int monsters_image_19 = 19;
	/**红史莱姆**/
	public static final int monsters_image_20 = 20;
	/**黑史莱姆**/
	public static final int monsters_image_21 = 21;
	/**小蝙蝠**/
	public static final int monsters_image_22 = 22;
	/**骷髅**/
	public static final int monsters_image_23 = 23;
	/**骷髅战士**/
	public static final int monsters_image_24 = 24;
	/**法师**/
	public static final int monsters_image_25 = 25;
	/**兽人**/
	public static final int monsters_image_26 = 26;
	/**女巫**/
	public static final int monsters_image_27 = 27;
	/**大蝙蝠**/
	public static final int monsters_image_28 = 28;
	/**红蝙蝠**/
	public static final int monsters_image_29 = 29;
	/**骷髅队长**/
	public static final int monsters_image_30 = 30;
	/**红女巫**/
	public static final int monsters_image_31 = 31;
	/**石头人**/
	public static final int monsters_image_32 = 32;
	/**初级卫士**/
	public static final int monsters_image_33 = 33;
	/**黄骑士**/
	public static final int monsters_image_34 = 34;
	/**双手剑士**/
	public static final int monsters_image_35 = 35;
	/**红法师**/
	public static final int monsters_image_36 = 36;
	/**魔卫**/
	public static final int monsters_image_37 = 37;
	/**红骑士**/
	public static final int monsters_image_38 = 38;
	/**兽人队长**/
	public static final int monsters_image_39 = 39;
	/**中级卫士**/
	public static final int monsters_image_40 = 40;
	/**高级卫士**/
	public static final int monsters_image_41 = 41;
	/**骷髅卫士**/
	public static final int monsters_image_42 = 42;
	/**冥卫士**/
	public static final int monsters_image_43 = 43;
	/**黑骑士**/
	public static final int monsters_image_44 = 44;
	/**史莱姆人**/
	public static final int monsters_image_45 = 45;
	/**黑法师**/
	public static final int monsters_image_46 = 46;
	/**魔王1**/
	public static final int monsters_image_47 = 47;
	/**史莱姆王**/
	public static final int monsters_image_48 = 48;
	/**塔主1**/
	public static final int monsters_image_49 = 49;
	/**魔王2**/
	public static final int monsters_image_50 = 50;
	/**塔主2**/
	public static final int monsters_image_51 = 51;
	//***************道具 tools************//
	/**蓝宝石**/
	public static final int tools_image_52 = 52;
	/**红宝石**/
	public static final int tools_image_53 = 53;
	/**红钥匙**/
	public static final int tools_image_54 = 54;
	/**黄钥匙**/
	public static final int tools_image_55 = 55;
	/**蓝钥匙**/
	public static final int tools_image_56 = 56;
	/**小血瓶**/
	public static final int tools_image_57 = 57;
	/**大血瓶**/
	public static final int tools_image_58 = 58;
	/**怪物之书**/
	public static final int tools_image_59 = 59;
	/**剑1**/
	public static final int tools_image_60 = 60;
	/**宝箱**/
	public static final int tools_image_61 = 61;
	/**盾1**/
	public static final int tools_image_62 = 62;
	/**金币**/
	public static final int tools_image_63 = 63;
	/**升级**/
	public static final int tools_image_64 = 64;
	/**十字架**/
	public static final int tools_image_65 = 65;
	/**纹章**/
	public static final int tools_image_66 = 66;
	/**剑2**/
	public static final int tools_image_67 = 67;
	/**盾2**/
	public static final int tools_image_68 = 68;
	/**稿**/
	public static final int tools_image_69 = 69;
	/**疲劳药**/
	public static final int tools_image_70 = 70;
	/**圣水**/
	public static final int tools_image_71 = 71;
	/**剑3**/
	public static final int tools_image_72 = 72;
	/**盾3**/
	public static final int tools_image_73 = 73;
	
	//***************角色 role************//
	/**左**/
	public static final int role_image_74 = 74;
	/**右**/
	public static final int role_image_75 = 75;
	/**下**/
	public static final int role_image_76 = 76;
	/**上**/
	public static final int role_image_77 = 77;
	
	
	/**不可移动地形**/
	public static final Set<Integer> DismoveSet = new HashSet<>(Arrays.asList(new Integer[]{maparea_image_1,maparea_image_2,maparea_image_6,maparea_image_9,NPC_image_80,NPC_image_81,mapare_image_82}));

	
}
