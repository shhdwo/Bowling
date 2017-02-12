package com.capgemini.bowling;

public class Bowling implements BowlingGameResultCalculator {
	
	int total = 0;
	int[][] rolls = new int[10][2];
	int[] scores = new int[10];
	int[] bonus_indicator = new int[10]; //licznik pozostalych do przydzielenia bonusow dla kazdej tury
	int turn = 0; //tury od 0 od 9
	int second_indicator = 0; //wskaznik drugiego rzutu, pierwszy rzut = 0, drugi = 1
	
	/**
	 * Register a thrown a ball.
	 * @param numberOfPins number of knocked down pins
	 */
	public void roll(int numberOfPins) {
		
		scores[turn] += numberOfPins; //powiekszenie wyniku aktualnej tury
		
		if (turn > 0) { //powiekszenie wyniku poprzednich tur
			for (int i = 0; i < turn; i++) {
				if (bonus_indicator[i] > 0) {
					bonus_indicator[i] -= 1;
					scores[i] += numberOfPins;
				}
			}
		}	
		
		//zmiany wskaznika drugiego rzutu oraz przypisanie rzutow do tablicy rzutow
		if (numberOfPins != 10 && second_indicator == 0) {
			rolls[turn][0] = numberOfPins;
			second_indicator = 1;
		}
		else if (numberOfPins == 10 && second_indicator == 0) {
			rolls[turn][0] = numberOfPins;
			bonus_indicator[turn] = 2;
			turn++;
		}
		else {
			rolls[turn][1] = numberOfPins;
			second_indicator = 0;
			if ((rolls[turn][0] + rolls[turn][1]) == 10) bonus_indicator[turn] = 1;
			turn++;
		}
		
		if (turn == 10 && (rolls[turn-1][0] + rolls[turn-1][1]) == 10) scores[turn-1] += 10; //bonus ostatniej tury
	}

	/**
	 * @return current game score
	 */
	public int score() {
		total = 0;
		for (int element : scores) total += element;
		return total;
	}

	/**
	 * @return true if a game is over, otherwise false
	 */
	public boolean isFinished() {
		if (turn > 9) return true; 
		else return false;
	}
}
