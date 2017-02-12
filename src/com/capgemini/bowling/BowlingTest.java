package com.capgemini.bowling;

import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {
	/**
	 * Po zbiciu 10 kregli w jednym rzucie do wyniku dopisywany jest
	 * bonus rowny zbitym kreglow w dwoch kolejnych rzutach.
	 * 
	 * Po zbiciu 10 kregli w dwoch rzutach do wyniku jest bonus 
	 * rowny zbitym kreglom w jednym kolejnym rzucie.
	 * 
	 * Nie mozna wykonac rzutu jesli tura jest wieksza od 9
	 * (mamy 10 tur od 0-9)
	 */
	
	
	@Test
	public void shouldReturn_20_WhenRolls_10_3_2() {
		//given
		Bowling game = new Bowling();
		game.roll(10);
		game.roll(3);
		game.roll(2);
		//when
		int actual = game.score();
		//then
		Assert.assertEquals(20, actual);
	}
	
	@Test
	public void shouldReturn_24_WhenRolls_7_3_5_4() {
		//given
		Bowling game = new Bowling();
		game.roll(7);
		game.roll(3);
		game.roll(5);
		game.roll(4);
		//when
		int actual = game.score();
		//then
		Assert.assertEquals(24, actual);
	}
	
	@Test
	public void shouldReturn_18_WhenRolls_6_3_5_4() {
		//given
		Bowling game = new Bowling();
		game.roll(6);
		game.roll(3);
		game.roll(5);
		game.roll(4);
		//when
		int actual = game.score();
		//then
		Assert.assertEquals(18, actual);
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldNotRollWhenTurnIsMoreThan10() {
		//given
		Bowling game = new Bowling();
		game.turn = 10;
		//when
		game.roll(5);
		//then
	}
}
