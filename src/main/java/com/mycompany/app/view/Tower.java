package com.mycompany.app.view;


import java.security.InvalidParameterException;
import java.util.List;
import java.util.Stack;


public class Tower {
    private Stack<Disc> discs;
    private int position;

    public Tower(int position) {
        this.position = position;
        discs = new Stack<Disc>();
    }


    public void add(Disc disc){
        if(!discs.isEmpty()) {
            if (discs.peek().getSize() > disc.getSize())
                discs.push(disc);
            else throw new InvalidParameterException();
        }
        else{
            discs.push(disc);
        }
    }

    public boolean areDiscsSorted(){
        if(discs.empty()) return false;
        List<Disc> discList = discs.subList(0,discs.size());
        for(int index = 0; index<discList.size(); index++){
            if(index+1<discList.size()){
                if(discList.get(index).getSize()<discList.get(index+1).getSize()) return false;
            }
            
        }
        return true;
    }

    public Stack<Disc> getDiscs() {
        return discs;
    }

    public Disc remove(){
        return discs.pop();
    }

    public boolean isEmpty(){
        return discs.isEmpty();
    }

    public void clear(){
        discs.clear();
    }

    public int getPosition(){return position;}

    @Override
    public String toString(){
        StringBuilder towerString = new StringBuilder();
        towerString.append("[");
        for(int index =0; index<discs.size(); index++){
            towerString.append(discs.get(index).getSize());
            towerString.append(",");
        }
        towerString.append("]");
        return towerString.toString();

    }
}
