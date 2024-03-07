package com.lab5.servingwebcontent.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab5.servingwebcontent.setup.factoryMethod.GuessFactoryMethod;

@Component
public class GuessModel {

	private int prize;
	private String participant;
	private int numTries; 
	private boolean winner;
	private int guessNumber;
	GuessFactoryMethod guessFactoryMethod;
	
	@Autowired
	public GuessModel(GuessFactoryMethod guessFactoryMethod) {
		this.guessFactoryMethod = guessFactoryMethod;
		prize = guessFactoryMethod.createPrize();
		participant = guessFactoryMethod.createParticipant();
		numTries = guessFactoryMethod.createNumTries();
		winner = guessFactoryMethod.createWinner();
		guessNumber = getRandomNumber();
	}

	public int getPrize() {
		return prize;
	}
	
	public String getParticipant() {
		return participant;
	}
	
	public int getNumTries() {
		return numTries;
	}
	
	public boolean isWinner() {
		return winner;
	}
	
	public void increaseNumTries() {
		this.numTries += 1;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}
	
	public void makeAGuess(int guessNumber) {
		if (this.guessNumber == guessNumber) {
			this.winner = true;
		}
		else {
			this.numTries += 1;
			this.prize -= 10000;
			this.guessNumber = getRandomNumber();
		}
	}
	public void reset() {
		prize = guessFactoryMethod.createPrize();
		participant = guessFactoryMethod.createParticipant();
		numTries = guessFactoryMethod.createNumTries();
		winner = guessFactoryMethod.createWinner();
		guessNumber = getRandomNumber();
	}
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(0,11);
	}
	

	
}
