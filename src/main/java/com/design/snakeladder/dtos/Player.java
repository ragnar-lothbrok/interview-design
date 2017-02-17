package com.design.snakeladder.dtos;

import java.io.Serializable;

public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	private String playerId;
	private Integer currentPosition = 0;
	private Integer steps = 0;
	private boolean completed;

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public Integer getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Integer currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", currentPosition=" + currentPosition + ", steps=" + steps + ", completed=" + completed + "]";
	}

}
