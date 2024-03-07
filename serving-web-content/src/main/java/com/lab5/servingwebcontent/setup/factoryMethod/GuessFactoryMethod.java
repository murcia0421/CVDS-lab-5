package com.lab5.servingwebcontent.setup.factoryMethod;


import org.springframework.stereotype.Component;

@Component
public class GuessFactoryMethod {
	private int prize;
	private String participant;
	private int numTries;
	private boolean winner;
	
	public GuessFactoryMethod() {
		prize = 100000;
		numTries = 0;
		participant = "user";
		winner = false;
	}

	public int createPrize() {
		return prize;
	}

	public String createParticipant() {
		return participant;
	}

	public int createNumTries() {
		return numTries;
	}

	public boolean createWinner() {
		return winner;
	}
}
