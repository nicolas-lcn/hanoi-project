package com.mycompany.app.view;


import java.util.Scanner;

public class HumanPlayer {
    public String name;

    public HumanPlayer(String name) {
        this.name = name;
    }

    public Move playerMove(Board board){
        Scanner positions = new Scanner (System.in);
        System.out.println("Entrez la position de départ : ");
        int origin = positions.nextInt();
        System.out.println("Entrez la position d'arrivée : ");
        int destination = positions.nextInt();
        return new Move(origin, destination, board);
    }
}
