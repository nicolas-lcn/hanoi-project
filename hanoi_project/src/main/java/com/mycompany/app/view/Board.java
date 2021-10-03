package com.mycompany.app.view;

import java.security.InvalidParameterException;
import java.util.*;

public class Board {
    private List<Tower> towers;

    private final int NUMBER_OF_TOWERS=3;
    private final int numberOfDiscs;

    public Board(int numberOfDiscs) {
        this.towers = new ArrayList<>();
        for (int towerIndex=0; towerIndex<NUMBER_OF_TOWERS; towerIndex++){
            this.towers.add(new Tower(towerIndex));
        }
        this.numberOfDiscs = numberOfDiscs;
        for(int discNumber = numberOfDiscs; discNumber>=1;discNumber--) {
            this.towers.get(0).add(new Disc(discNumber));
        }

    }

    public void reset(int newNumberOfDiscs){
        for (Tower tower : towers){
            tower.clear();
        }
        for(int discNumber = newNumberOfDiscs; discNumber>=1;discNumber--) {
            towers.get(0).add(new Disc(discNumber));
        }
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public Tower getTowerAtIndex(int index){
        return towers.get(index);
    }

    public Tower getFinalTower() {
        return towers.get(NUMBER_OF_TOWERS-1);
    }

    @Override
    public String toString(){
        String boardString = "";
        for(int index =0; index<towers.size(); index++){
            boardString+=towers.get(index).toString();
        }
        return boardString;
    }
}
