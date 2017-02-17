package com.design.snakeladder.api;

import java.util.List;

import com.design.snakeladder.dtos.Player;

public interface PlayerApi {

	public Player addPlayer();
	
	public List<Player> getPlayers();
}
