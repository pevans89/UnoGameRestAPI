package com.unogame.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class UnoGameAPI {

	private static HashMap<String, UnoGameAPI> games = new HashMap<>();

	Deck deck = new Deck();
	ArrayList<Hand> hands = new ArrayList<Hand>();

	private int i = 0;
	private int total = 0;
	private int pp;
	Cards card;
	private boolean winner = false;
	private boolean reverse = false;

	private int getNextPlayer(int i, boolean reverse) {
		if (!reverse) {
			i++;
			if (i >= 4) {
				i = 0;
			}

		} else {
			i--;
			if (i == -1) {
				i = 3;
			}
		}
		return i;
	}

	public static UnoGameAPI getGame(String gameName) {

		UnoGameAPI game = games.get(gameName);
		if (game == null) {
			game = new UnoGameAPI();
			games.put(gameName, game);
		}
		return game;

	}

	public static String[] getGameNames() {
		Set<String> keys = games.keySet();
		return keys.toArray(new String[0]);
	}

	public boolean nextTurn() {

		if (hands.get(i).isWinner() == true) { // checks if player won
			winner = true;
			// System.out.println(" Player" + i + " WON!! \n");

			return false;
		} else {
			return true;

		}
	}

	public Turn getTurn() {

		// checks if deck needs to be replenished
		deck.replenish();
		// getting the top card on the discard deck
		Cards topDiscard = deck.topDiscard();

		if (!winner) {
			card = hands.get(i).hasMatch(topDiscard);
			// if the player can play a card
			if (card != null) {
				// takes the card the player played and puts it at the top of the
				deck.addToDiscard(card);
				// checks if player can call Uno
				if (hands.get(i).isUno() == true) {

				}

				if (card.getValue() == CardsValue.REVERSE) {
					reverse = !reverse;

				}
				if (card.getValue() == CardsValue.SKIP) {
					pp = getNextPlayer(i, reverse);
					i = getNextPlayer(i, reverse);

				}

				if (card.getValue() == CardsValue.DRAWTWO) {
					pp = getNextPlayer(i, reverse);
					hands.get(pp).drawCard(deck.dealCard());
					hands.get(pp).drawCard(deck.dealCard());
					i = getNextPlayer(i, reverse);

				}

				if (card.getValue() == CardsValue.WILD_DRAWFOUR) {
					pp = getNextPlayer(i, reverse);
					hands.get(pp).drawCard(deck.dealCard());
					hands.get(pp).drawCard(deck.dealCard());
					hands.get(pp).drawCard(deck.dealCard());
					hands.get(pp).drawCard(deck.dealCard());
					i = getNextPlayer(i, reverse);

				}

				i = getNextPlayer(i, reverse); // next player for do loop

			} else {
				// if the player can't match a card they pick one up
				// player draws one card
				hands.get(i).drawCard(deck.dealCard());
				// so player only draws one card
				i = getNextPlayer(i, reverse);
			}

			// for (Hand h : hands) {
			//
			// total += h.getScore();
			//
			// }
			// System.out.println("******* WINNER'S SCORE ******");
			//
			// System.out.println("\nPlayer " + (i) + "'s winning score total is " + total);
		}
		return new Turn(i, hands, card, topDiscard);

	}

	private UnoGameAPI() {
		deck.populate();

		deck.shuffle();

		// Establishing four players

		hands.add(new Hand());
		hands.add(new Hand());
		hands.add(new Hand());
		hands.add(new Hand());

		// adding cards into the hands of the players
		for (int i = 0; i < 7; i++) {
			for (Hand hand : hands) {
				hand.drawCard(deck.dealCard());
			}
		}

		deck.discardPile();

	}

}
