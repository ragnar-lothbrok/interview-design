package com.design.snakeladder.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.design.snakeladder.api.PlayerApi;
import com.design.snakeladder.dtos.Player;

public class PlayerImpl implements PlayerApi {

	private PlayerImpl() {

	}

	private static class SingletonHelper {
		public static final PlayerApi playerApi = new PlayerImpl();
	}

	public static PlayerApi getPlayerApiInstance() {
		return SingletonHelper.playerApi;
	}

	List<Player> playersList = new ArrayList<Player>();

	public Player addPlayer() {
		Player player = new Player();
		player.setPlayerId(UUID.randomUUID().toString());
		playersList.add(player);
		return player;
	}

	public List<Player> getPlayers() {
		return playersList;
	}
	
}
