package com.mota;

import java.awt.Image;

public class Hero extends Stuff {
	private int level;// Ӣ�۵ȼ�
	private int hp;
	private int atk;
	private int def;
	private int money;
	private int exp;
	private int ykey;
	private int bkey;
	private int rkey;
	private int maxstair;
	public Image hImage;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getYkey() {
		return ykey;
	}

	public void setYkey(int ykey) {
		this.ykey = ykey;
	}

	public int getBkey() {
		return bkey;
	}

	public void setBkey(int bkey) {
		this.bkey = bkey;
	}

	public int getRkey() {
		return rkey;
	}

	public void setRkey(int rkey) {
		this.rkey = rkey;
	}

	public int getMaxstair() {
		return maxstair;
	}

	public void setMaxstair(int maxstair) {
		this.maxstair = maxstair;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Hero(int level, int hp, int atk, int def, int money, int exp, int ykey, int bkey, int rkey, int maxstair,
			Image hImage) {
		super();
		this.level = level;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.money = money;
		this.exp = exp;
		this.ykey = ykey;
		this.bkey = bkey;
		this.rkey = rkey;
		this.maxstair = maxstair;
		this.hImage = hImage;
	}

	/**
	 * �򲻹�����-1�����򷵻���ʧѪ��
	 * @param m
	 * @return
	 */
	public int attack(Monster m) {
		// ��Ч�˺�ֵ
		int h_harm = atk - m.def;
		// �����˺�ֵ
		int m_harm = m.atk - def;
		//�غ���
		int Rounds = 0;
		if (h_harm>0) {
			//�غ���
			Rounds = (int)Math.ceil((double)m.hp/h_harm);
			Rounds -=1;//Ӣ���������֣����Իغ�����1
		}else {
			//�޷���������
			return -1;
		}
		if (h_harm > 0 && m_harm <= 0) {
			//��ѹ���﷽��
			money = money + m.money;
			exp = exp + m.exp;
			return 0;
		}  else if(Rounds*m_harm>=hp){
			//�򲻹�
			return -1;
		} else {
			//ս������
			hp=hp-(Rounds*m_harm);
			money = money + m.money;
			exp = exp + m.exp;
		}
		return Rounds*m_harm;
	}
	
	/**
	 * �򲻹�����-1�����򷵻���ʧѪ��
	 * @param m
	 * @return
	 */
	public int attackCheck(Monster m) {
		// ��Ч�˺�ֵ
		int h_harm = atk - m.def;
		// �����˺�ֵ
		int m_harm = m.atk - def;
		//�غ���
		int Rounds = 0;
		if (h_harm>0) {
			//�غ���
			Rounds = (int)Math.ceil((double)m.hp/h_harm);
			Rounds -=1;//Ӣ���������֣����Իغ�����1
		}else {
			//�޷���������
			return -1;
		}
		if (h_harm > 0 && m_harm <= 0) {
			//��ѹ���﷽��
			return 0;
		}  else if(Rounds*m_harm>=hp){
			//�򲻹�
			return -1;
		} else {
			//ս������
		}
		return Rounds*m_harm;
	}

	
}
