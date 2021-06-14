package com.company;

import javafx.*;

public class Main {

    public static void main(String[] args) {
	    Game tictactoe = new Game();
	    System.out.println("Start of game");
	    try {
            tictactoe.move(0, 0);
            tictactoe.move(1, 1);
            tictactoe.move(0, 1);
            tictactoe.move(1, 2);
            tictactoe.move(0, 2);
            System.out.println(tictactoe);
            System.out.println(tictactoe.validate());
        } catch(Exception e) {
	        System.out.println(e);
        }
    }
}
