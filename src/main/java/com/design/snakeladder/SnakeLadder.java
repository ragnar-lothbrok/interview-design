package com.design.snakeladder;

import java.util.HashMap;
import java.util.Map;

import com.design.snakeladder.Impl.PlayerImpl;
import com.design.snakeladder.Impl.WinningAllPlayersStrategy;
import com.design.snakeladder.api.PlayerApi;
import com.design.snakeladder.dtos.Player;

public class SnakeLadder {

	PlayerApi playerApi = PlayerImpl.getPlayerApiInstance();

	public static void main(String[] args) {

		SnakeLadder sl = new SnakeLadder();
		Map<Integer, Integer> moves = new HashMap<Integer, Integer>();
		moves.put(14, 4);
		moves.put(98, 50);
		moves.put(40, 65);
		moves.put(12, 32);
		sl.startGame(2, 100, moves);

	}

	public void createPlayers(int count) {
		for (int i = 0; i < count; i++) {
			playerApi.addPlayer();
		}
	}

	public void startGame(Integer playerCount, Integer boardMax, Map<Integer, Integer> moves) {
		createPlayers(playerCount);
		while (!WinningAllPlayersStrategy.getWinningStrategyInstance().winningStrategy()) {
			for (int i = 0; i < playerApi.getPlayers().size(); i++) {
				Player player = playerApi.getPlayers().get(i);
				if (!player.isCompleted()) {
					Integer diceValue = throwDice();
					Integer currPosition = player.getCurrentPosition();
					Integer newPosition = currPosition + diceValue;
					if (!(newPosition > boardMax)) {
						if (moves.get(newPosition) != null) {
							player.setCurrentPosition(moves.get(newPosition));
							System.out.println("Player "+player.getPlayerId()+" moved due to strike.");
						} else if (newPosition == boardMax) {
							player.setCompleted(true);
						}
						player.setCurrentPosition(newPosition);
					}
					player.setSteps(player.getSteps()+1);
				}
			}
		}
		System.out.println("All players : "+playerApi.getPlayers());
	}

	private Integer throwDice() {
		return (int) (Math.random() * 6) + 1;
	}
}
