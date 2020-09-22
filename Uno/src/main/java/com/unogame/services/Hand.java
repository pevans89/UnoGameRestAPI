package com.unogame.services;

import java.util.ArrayList;


public class Hand {

	// drawing cards
	public void drawCard(Cards card) {
		hand.add(card);
	}

	// checking if the player has a card to put down
	public Cards hasMatch(Cards cardToMatch) {

		Cards match = null;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).isMatch(cardToMatch) || (hand.get(i).getValue() == CardsValue.WILD) // added wild play
					|| (hand.get(i).getValue() == CardsValue.WILD_DRAWFOUR) == true) {
				match = hand.get(i);
				hand.remove(i);
				// Show what card was played
				// System.out.println("Match Card Played " + match);

				// changed Wild Color to Blue
				if (match.getValue() == (CardsValue.WILD) || match.getValue() == (CardsValue.WILD_DRAWFOUR)) {
					match.setColor(CardsColor.BLUE);
					// System.out.println("*****Wild Played*****");

				}

				// added a break rather than a return match
				break;
			}
		}
		return match;
	}

	// checks for Uno
	public boolean isUno() {
		if (hand.size() == 1) {
			return true;
		}
		return false;
	}

	// checks for win condition
	public boolean isWinner() {
		if (hand.size() == 0) {

			return true;
		}
		return false;
	}

	// public void hasPoints() {
	// if(hand.get(i) == CardsValue.ZERO)
	// }
	public int size() {
		return hand.size();
	}

	public Cards eachCard(int p) {
		return hand.get(p);
	}

	public ArrayList<Cards> getHand() {
		return hand;
	}

	public int getScore() {

		int i = 0;
		int a = 0;

		for (i = 0; i < hand.size(); i++) {

			a += hand.get(i).getPoints();

		}

		return a;
	}

	private ArrayList<Cards> hand = new ArrayList<Cards>();

	@Override
	public String toString() {
		return "Hand = " + hand + "]";
	}

}
