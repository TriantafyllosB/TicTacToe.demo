package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Game {
    public enum Tictactoe {
        Empty,
        Cross,
        Circle
    }

    Tictactoe[] state;
    Tictactoe player;
    public Game() {
//        this.state = new ArrayList<>(9);
        this.state = new Tictactoe[9];
        for(int i = 0; i < this.state.length; ++i) {
            this.state[i] = Tictactoe.Empty;
        }
//        int[] myIntArray = new int[3];
//        this.state = new Vector<>(9);
        this.player = Tictactoe.Cross;
    }

    /**
     * 0|1|2
     * 3|4|5
     * 6|7|8
     */
    public void move(int x, int y) throws Exception {
        if (x < 0 || x > 2) throw new Exception("Unsupported x");
        if (y < 0 || y > 2) throw new Exception("Unsupported y");
        int pos = 3 * y + x;
        this.state[pos] = this.player;
        this.player = this.player == Tictactoe.Cross ? Tictactoe.Circle : Tictactoe.Cross;
    }

    public Tictactoe validate () {

        for (int x= 0 ; x < 3 ; ++x) {
            int horizontal = 1;
            int vertical = 1;
            for (int y= 0 ; y < 3 ; ++y) {
                horizontal *= this.state[x * 3 + y].ordinal();
                vertical *= this.state[x + (3 * y)].ordinal();
            }
            if (horizontal == 1 || vertical == 1) return Tictactoe.Cross;
            if (horizontal == 8 || vertical == 8) return Tictactoe.Circle;
        }
        int diagonal1 = this.state[0].ordinal() * this.state[4].ordinal() * this.state[8].ordinal();
        int diagonal2 = this.state[2].ordinal() * this.state[4].ordinal() * this.state[6].ordinal();
        if (diagonal1 == 1 || diagonal2 == 1) return Tictactoe.Cross;
        if (diagonal1 == 8 || diagonal2 == 8) return Tictactoe.Circle;
        return Tictactoe.Empty;
    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < this.state.length; ++i) {
            Tictactoe p = this.state[i];
            if (p == Tictactoe.Cross) ret.append("[X]");
            else if (p == Tictactoe.Circle) ret.append("[O]");
            else ret.append("[ ]");
            if(((i+1) % 3) == 0) ret.append('\n');
        }
        return ret.toString();
    }
}
