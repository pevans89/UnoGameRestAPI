package com.unogame.services;

import java.util.ArrayList;

public class Cards {
	public Cards(CardsValue value, CardsColor color) {
		super();
		this.value = value;
		this.color = color;
	}

	public CardsValue getValue() {
		return value;
	}

	public CardsColor getColor() {
		return color;
	}
	
// added a set to change the color of WILD
	public void setColor(CardsColor color) {
		this.color = color;
	}

	public boolean isMatch(Cards card) {
		if (color == card.color || value == card.value) {
			return true;
		}

		return false;
	}

	private CardsValue value;
	private CardsColor color;
	
	public int getPoints() {
		
		switch (value) {
		case SKIP:
		case REVERSE:
		case DRAWTWO :
			return 20;
			
		case EIGHT:
			return 8;
			
		case FIVE:
			return 5;
			
		case FOUR:
			return 4;
			
		case NINE:
			return 9;
			
		case ONE:
			return 1;
				
		case SEVEN:
			return 7;
			
		case SIX:
			return 6;
					
		case THREE:
			return 3;
			
		case TWO:
			return 2;
			
		case WILD:
			return 50;
			
		case WILD_DRAWFOUR:
			return 50;
			
		case ZERO:
			return 0;
			
		
		
		}
		return 0;
		
	}

	

	@Override
	public String toString() {
		return "Cards [value=" + value + ", color=" + color + "]";
	}

}
