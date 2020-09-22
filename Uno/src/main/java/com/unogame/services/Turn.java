package com.unogame.services;

import java.util.ArrayList;

public class Turn {
	private int i = 0;
//	private int pp;
	Cards card;
	Cards topDiscard;
	ArrayList<Hand> hands = new ArrayList<Hand>();
	
	
	public Turn(int i, ArrayList<Hand> hands, Cards card, Cards topDiscard ) {
		super();
		this.i = i;
//		this.pp = pp;
		this.card = card;
		this.topDiscard = topDiscard;
		this.hands = hands;
	}
	public int getI() {
		return i;
	}
//	public int getPp() {
//		return pp;
//	}
	public ArrayList<Hand> getHands() {
		return hands;
	}
	public Cards getCard() {
		return card;
	}
	public Cards getTopDiscard() {
		return topDiscard;
	}
	
	
	


}
