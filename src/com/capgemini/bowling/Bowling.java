package com.capgemini.bowling;

public class Bowling implements BowlingGameResultCalculator {
	
	private int total = 0;
	private int[][] rolls = new int[11][2]; //tablica na 10 tur po 2 rzuty, 11 tura tylko w przypadku gdy w 10. rzucimy dwa razy "10"
	private int[] scores = new int[11];
	private int[] bonus_indicator = new int[11]; //licznik pozostalych do przydzielenia bonusow dla kazdej tury
	private int second_indicator = 0; //wskaznik drugiego rzutu, pierwszy rzut = 0, drugi = 1
	int turn = 0; //tury od 0 od 9
	
	/**
	 * Register a thrown a ball.
	 * @param numberOfPins number of knocked down pins
	 */
	public void roll(int numberOfPins) {
		if (isFinished()) throw new IllegalStateException();
		else{			
			//zmiany wskaznika drugiego rzutu oraz przypisanie rzutow do tablicy rzutow
			if ((numberOfPins != 10 && second_indicator == 0) || (numberOfPins == 10 && second_indicator == 0 && turn == 9 )) {
				rolls[turn][0] = numberOfPins;
				second_indicator = 1;
			}
			else if (numberOfPins == 10 && second_indicator == 0 && turn != 9) {
				rolls[turn][0] = numberOfPins;
				bonus_indicator[turn] = 2;
				turn++;
			}
			else {
				rolls[turn][1] = numberOfPins;
				second_indicator = 0;
				if ((rolls[turn][0] + rolls[turn][1]) == 10 || (rolls[turn][0] + rolls[turn][1]) == 20) bonus_indicator[turn] = 1;
				turn++;
			}
		}
	}

	/**
	 * @return current game score
	 */
	public int score() {
		for (int i = 0; i < 10; i++) {
			scores[i] += rolls[i][0] + rolls[i][1]; 
			if (bonus_indicator[i] > 0) { 
				scores[i] += rolls[i+1][0];
				if (bonus_indicator[i] == 2) {
					if (rolls[i+1][0] != 10 || (i == 8 && rolls[i+1][0] == 10)) scores[i] += rolls[i+1][1];
					else if (i < 8 && rolls[i+1][0] == 10) scores[i] += rolls[i+2][0];
				}
			}
		}
		total = 0;
		for (int element : scores) total += element;
		return total;
	}

	/**
	 * @return true if a game is over, otherwise false
	 */
	public boolean isFinished() {
		if (turn < 10 || (turn == 10 && rolls[9][1] == 10)) return false;
		else return true;
	}
}
