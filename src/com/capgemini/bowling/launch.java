package com.capgemini.bowling;

public class launch {

	public static void main(String[] args) {
		
		Bowling gra = new Bowling();
		gra.roll(6);
		gra.roll(3);
		gra.roll(10);
		gra.roll(9);
		gra.roll(1);
		gra.roll(3);
		gra.roll(4);
		gra.roll(2);
		gra.roll(4);
		gra.roll(10);
		gra.roll(7);
		gra.roll(3);
		gra.roll(10);
		gra.roll(10);
		gra.roll(10);
		gra.roll(10);
		System.out.println(gra.score());
	}

}
