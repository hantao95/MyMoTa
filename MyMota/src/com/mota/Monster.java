package com.mota;
import java.awt.Image;

public class Monster extends Stuff{
	public String name;
	public Image mimage;
	 
	/**
	 * 
	 * @param paramString ����
	 * @param paramInt1 ����
	 * @param paramInt2 ����
	 * @param paramInt3 ����
	 * @param paramInt4 ��ֵ
	 * @param paramInt5 ����
	 * @param miImage ͼƬ
	 */
	public Monster(String paramString,int paramInt1,int paramInt2,int paramInt3,int paramInt4,int paramInt5,Image miImage) {
		this.name=paramString;//����
		this.hp=paramInt1;//����
		this.atk=paramInt2;//����
		this.def=paramInt3;//����
		this.money=paramInt4;//��ֵ
		this.exp=paramInt5;//����
		this.mimage=miImage;//ͼƬ
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
