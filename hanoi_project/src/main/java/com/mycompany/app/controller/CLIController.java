package com.mycompany.app.controller;

import com.mycompany.app.view.*;
import java.security.InvalidParameterException;
import java.util.EmptyStackException;


public class CLIController {

    public static Board board = new Board(3);
    public static final Tower finalTower = board.getFinalTower();

    private static boolean isOver(){
       return finalTower.areDiscsSorted()
               && board.getFinalTower().getDiscs().size()==board.getNumberOfDiscs();
    }

    public static void play(String playerName){
        HumanPlayer player = new HumanPlayer(playerName);
        while( ! isOver()){
            try{
                applyMove(player.playerMove(board));
                System.out.println(board.toString());
            }catch(InvalidParameterException | EmptyStackException e){
                System.err.println("Invalid Move");
                continue;
            }
            
        }
    }

    public static void applyMove(Move move){
        move.destination.add(move.movedDisc);
        move.origin.remove();
    }

}
