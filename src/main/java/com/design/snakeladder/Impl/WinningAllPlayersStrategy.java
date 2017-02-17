package com.design.snakeladder.Impl;

import com.design.snakeladder.api.PlayerApi;
import com.design.snakeladder.api.WinningStrategy;
import com.design.snakeladder.dtos.Player;

public class WinningAllPlayersStrategy implements WinningStrategy {

	public Boolean winningStrategy() {
		PlayerApi playerApi = PlayerImpl.getPlayerApiInstance();
		for(Player player : playerApi.getPlayers()){
			if(!player.isCompleted()){
				return false;
			}
		}
		return true;
	}
	
	private WinningAllPlayersStrategy() {

	}

	private static class SingletonHelper {
		public static final WinningStrategy winningStrategy = new WinningAllPlayersStrategy();
	}

	public static WinningStrategy getWinningStrategyInstance() {
		return SingletonHelper.winningStrategy;
	}

}
