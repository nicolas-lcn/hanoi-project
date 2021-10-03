package com.mycompany.app.controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.app.view.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.geometry.HPos;
import java.util.*;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;



import java.security.InvalidParameterException;
import java.util.EmptyStackException;
import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;



public class GUIController implements Initializable{

	private Board board; 
	public GridPane leftTower;
	public GridPane midTower;
	public GridPane rightTower;
	public TextField numberDiscsField;
	public Text errorText;

	private int numberOfDiscs; 
	private final int DEFAULT_NUMBER_OF_DISCS = 3;




	@Override
	public void initialize(URL location, ResourceBundle resources){
		board = new Board(DEFAULT_NUMBER_OF_DISCS);
		fillTowerGrid(leftTower, 0);

	}

	public void printOnError(String s){
		errorText.setText(s);
	}
	
///////////////////////////////DISPLAY METHODS/////////////////////////////////////

	public void fillTowerGrid(GridPane tower, int towerIndex){
		int discVpos = 7;
		try{
			for(Disc disc : board.getTowers().get(towerIndex).getDiscs()){
			ImageView discImage = new ImageView(new Image("file:./src/main/resources/app/hanoiapp/assets/ring"+disc.getSize()+".png"));
			tower.add(discImage,0, discVpos);
			GridPane.setHalignment(discImage, HPos.CENTER);
			discVpos--;
			}	
		}catch(IllegalArgumentException e){
			printOnError("Cannot find image ");
		}
		
	}

	public void updateTowerGrids(){
		clearTowerGrids();
		if( ! isTowerEmpty(0)){
			fillTowerGrid(leftTower, 0);
		}
		if( ! isTowerEmpty(1)){
			fillTowerGrid(midTower, 1);
		}
		if( ! isTowerEmpty(2)){
			fillTowerGrid(rightTower, 2);
		}

	}

	public void clearTowerGrids(){
		if( leftTower.getChildren() != null){
			leftTower.getChildren().clear();
		}
		if( midTower.getChildren() != null){
			midTower.getChildren().clear();
		}
		if( rightTower.getChildren() != null){
			rightTower.getChildren().clear();
		}
	}

	private boolean isTowerEmpty(int index){
		return board.getTowerAtIndex(index).isEmpty();
	}

/////////////////////////BUTTON CLICKED EVENT HANDLERS/////////////////////////

	public void onResetClicked(){
		board.reset(this.numberOfDiscs);
		updateTowerGrids();
	}

	public void rightButtonClicked(){
		errorText.setText("");
		try{
			Move move = new Move(board.getTowerAtIndex(0), board.getTowerAtIndex(1));
			applyMove(move);
		}catch(EmptyStackException e){
			printOnError("Invalid Move");
		}
		updateTowerGrids();
	}

	public void rightButtonMidClicked(){
		errorText.setText("");
		try{
			Move move = new Move(board.getTowerAtIndex(1), board.getTowerAtIndex(2));
			applyMove(move);
		}catch(EmptyStackException e){
			printOnError("Invalid Move");
		}
		updateTowerGrids();
	}

	public void leftButtonMidClicked(){
		errorText.setText("");
		try{	
			Move move = new Move(board.getTowerAtIndex(1), board.getTowerAtIndex(0));
			applyMove(move);
		}catch(EmptyStackException e){
			printOnError("Invalid Move");
		}
		updateTowerGrids();
	}

	public void leftButtonClicked(){
		errorText.setText("");
		try{
			Move move = new Move(board.getTowerAtIndex(2), board.getTowerAtIndex(1));
			applyMove(move);
		}catch(EmptyStackException e){
			printOnError("Invalid Move");
		}
		updateTowerGrids();
	}

	public void quickRightButtonClicked(){
		errorText.setText("");
		try{
			Move move = new Move(board.getTowerAtIndex(0), board.getTowerAtIndex(2));
			applyMove(move);
		}catch(EmptyStackException e){
			printOnError("Invalid Move");
		}
		updateTowerGrids();
	}

	public void quickLeftButtonClicked(){
		errorText.setText("");
		try{
			Move move = new Move(board.getTowerAtIndex(2), board.getTowerAtIndex(0));
			applyMove(move);
		}catch(EmptyStackException e){
			printOnError("Invalid Move");
		}
		updateTowerGrids();
	}


	public void applyMove(Move move){
		try{
			move.destination.add(move.movedDisc);
        	move.origin.remove();
		}catch(InvalidParameterException e){
               printOnError("Invalid Move");
        }
		
	}

	//////////////////NUMBER OF DISCS TEXTFIELD HANDLER //////////////////
	

	public void onEnterKeyPressed (KeyEvent k){
		if (!k.getCode().equals(KeyCode.ENTER)) return;
		try{
		 	this.numberOfDiscs = Integer.parseInt(numberDiscsField.getText());
		 	if(this.numberOfDiscs>8 || this.numberOfDiscs<3) throw new NumberFormatException();
		 	board.reset(this.numberOfDiscs);
		 	updateTowerGrids();
		}catch(NumberFormatException e){
		 	printOnError("Invalid input, try a number between 3 and 8 included");
		}
		numberDiscsField.setText("");

	}

	////////////////////DRAG AND DROP ///////////////////////////////

	
}
