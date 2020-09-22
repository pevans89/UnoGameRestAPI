package com.unogame.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.unogame.models.Game;
import com.unogame.services.Turn;
//import com.unogame.services.Turn;
import com.unogame.services.UnoGameAPI;
@CrossOrigin(maxAge = 3600)
@RestController
public class GameControllers {

	@PostMapping("/games")
	Game postGame(@RequestBody Game game) {

		UnoGameAPI.getGame(game.getGameId());
		return new Game(game.getGameId());
	}

	@GetMapping("/games")
	List<Game> getGames() {

		String[] names = UnoGameAPI.getGameNames();

		List<Game> games = new ArrayList<>();
		for (String name : names) {
			games.add(new Game(name));
		}
		return games;
	}

	@PutMapping("/games")
	Turn getTurn(@RequestBody Game game) {

		UnoGameAPI gameAPI = UnoGameAPI.getGame(game.getGameId());

		if (gameAPI != null) {
			gameAPI.nextTurn();
			return gameAPI.getTurn();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
	}

}
