package com.mycompany.app;

import java.util.Scanner;
import com.mycompany.app.controller.CLIController;

public class AppCLI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("entrez votre nom : ");
        String playerName = scan.nextLine();
        System.out.println("votre nom est  : " + playerName);
        CLIController.play(playerName);
    }
}
