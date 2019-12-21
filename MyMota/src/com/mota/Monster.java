package com.mota;
import java.awt.Image;

public class Monster extends Stuff{
	public String name;
	public Image mimage;
	 
	/**
	 * 
	 * @param paramString 名称
	 * @param paramInt1 生命
	 * @param paramInt2 攻击
	 * @param paramInt3 防御
	 * @param paramInt4 价值
	 * @param paramInt5 经验
	 * @param miImage 图片
	 */
	public Monster(String paramString,int paramInt1,int paramInt2,int paramInt3,int paramInt4,int paramInt5,Image miImage) {
		this.name=paramString;//名称
		this.hp=paramInt1;//生命
		this.atk=paramInt2;//攻击
		this.def=paramInt3;//防御
		this.money=paramInt4;//价值
		this.exp=paramInt5;//经验
		this.mimage=miImage;//图片
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
