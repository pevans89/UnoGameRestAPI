package com.unogame.models;

import org.springframework.stereotype.Component;

@Component
public class Game {
	
	private String gameId;
	
	public Game() {
	}
	
	public String getGameId() {
		return gameId;
	}

	public Game(String gameId) {
		super();
		this.gameId = gameId;
	}
}
