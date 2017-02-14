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
	 * W ostatniej turze po rzuceniu "10" mamy dodatkowy rzut razem maksymalnie 3 rzuty
	 * tak aby w kazdej turze mozna bylo zdobyc maks 30 pkt, a w calej grze 300.
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
	
	@Test
	public void shouldReturn_300_WhenRolls_12x10() {
		//given
		Bowling game = new Bowling();
		game.roll(10); //1
		game.roll(10); //2
		game.roll(10); //3
		game.roll(10); //4
		game.roll(10); //5
		game.roll(10); //6
		game.roll(10); //7
		game.roll(10); //8
		game.roll(10); //9
		game.roll(10); //10
		game.roll(10); //11
		game.roll(10); //12
		//when
		int actual = game.score();
		//then
		Assert.assertEquals(300, actual);
	}
	
	@Test
	public void shouldReturn_0_WhenRolls_20x0() {
		//given
		Bowling game = new Bowling();
		game.roll(0); //1
		game.roll(0); //2
		game.roll(0); //3
		game.roll(0); //4
		game.roll(0); //5
		game.roll(0); //6
		game.roll(0); //7
		game.roll(0); //8
		game.roll(0); //9
		game.roll(0); //10
		game.roll(0); //11
		game.roll(0); //12
		game.roll(0); //13
		game.roll(0); //14
		game.roll(0); //15
		game.roll(0); //16
		game.roll(0); //17
		game.roll(0); //18
		game.roll(0); //19
		game.roll(0); //20
		//when
		int actual = game.score();
		//then
		Assert.assertEquals(0, actual);
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldNotRollWhenTurnIsMoreThan_9() {
		//given
		Bowling game = new Bowling();
		game.turn = 10;
		//when
		game.roll(5);
		//then
	}
}
