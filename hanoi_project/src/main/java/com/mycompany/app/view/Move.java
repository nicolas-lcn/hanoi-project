package com.mycompany.app.view;

import java.security.InvalidParameterException;
import java.util.EmptyStackException;

public class Move {
    public Tower origin;

    public Tower destination;

    public final Disc movedDisc;

    public Move(Tower origin, Tower destination) {
        this.origin = origin;
        this.destination = destination;
        this.movedDisc = origin.getDiscs().peek();
    }

    public Move(int originPos, int destinationPos, Board board) throws EmptyStackException{
        this.origin = board.getTowers().get(originPos);
        this.destination = board.getTowers().get(destinationPos);
        this.movedDisc = this.origin.getDiscs().peek();
        if(this.origin.getDiscs().isEmpty()) throw new InvalidParameterException();

    }
}
