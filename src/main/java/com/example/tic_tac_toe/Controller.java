package com.example.tic_tac_toe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Random;

public class Controller implements Initializable {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winnerText;

    @FXML
    private Text scorebordText;

    private int playerTurn = 0;
    private int p1 = 0;
    private int p2 = 0;
    private int b = 0;
    private int a = 0;
    private int s = 0;
    private int d = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    Random rand = new Random();

    ArrayList<Button> buttons;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        if (playerTurn == 1){
            winnerText.setText("p2 start");
        } else {
            winnerText.setText("p1 start");
        }
        scorebordText.setText("0 - 0");
        p1 = 0;
        p2 = 0;
        b = 0;
        a = 0;
        s = 0;
        d = 0;
        f = 0;
        g = 0;
        h = 0;
        j = 0;
        k = 0;
        l = 0;
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    @FXML
    void nextTurn(ActionEvent event) {
        buttons.forEach(this::resetButton);
        if (playerTurn == 1){
            winnerText.setText("p2 start");
        } else {
            winnerText.setText("p1 start");
        }
        scorebordText.setText(p1 + " " + "-" + " " + p2);
        b = 0;
        a = 0;
        s = 0;
        d = 0;
        f = 0;
        g = 0;
        h = 0;
        j = 0;
        k = 0;
        l = 0;
    }
    public void nextTurn() {
        buttons.forEach(this::resetButton);
        if (playerTurn == 1){
            winnerText.setText("p2 start");
        } else {
            winnerText.setText("p1 start");
        }
        scorebordText.setText(p1 + " " + "-" + " " + p2);
        b = 0;
        a = 0;
        s = 0;
        d = 0;
        f = 0;
        g = 0;
        h = 0;
        j = 0;
        k = 0;
        l = 0;
    }

    @FXML
    void AITurn(ActionEvent event) {
        for(int q = 0 ; q<100 ; q++ ){
            int n = rand.nextInt(9);
            n += 1;
            if (n == 1 && a == 0) {
                setPlayerSymbol(button1);
                button1.setDisable(true);
                a = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 2 && s == 0) {
                setPlayerSymbol(button2);
                button2.setDisable(true);
                s = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 3 && d == 0) {
                setPlayerSymbol(button3);
                button3.setDisable(true);
                d = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 4 && f == 0) {
                setPlayerSymbol(button4);
                button4.setDisable(true);
                f = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 5 && g == 0) {
                setPlayerSymbol(button5);
                button5.setDisable(true);
                g = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 6 && h == 0) {
                setPlayerSymbol(button6);
                button6.setDisable(true);
                h = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 7 && j == 0) {
                setPlayerSymbol(button7);
                button7.setDisable(true);
                j = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 8 && k == 0) {
                setPlayerSymbol(button8);
                button8.setDisable(true);
                k = 1;
                checkIfGameIsOver();
                break;
            }
            if (n == 9 && l == 0) {
                setPlayerSymbol(button9);
                button9.setDisable(true);
                l = 1;
                checkIfGameIsOver();
                break;
            }
        }
    }

    private void AITurnButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }



    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            if (button == button1){
                a = 1;
            }
            if (button == button2){
                s = 1;
            }
            if (button == button3){
                d = 1;
            }
            if (button == button4){
                f = 1;
            }
            if (button == button5){
                g = 1;
            }
            if (button == button6){
                h = 1;
            }
            if (button == button7){
                j = 1;
            }
            if (button == button8){
                k = 1;
            }
            if (button == button9){
                l = 1;
            }
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
            b++;
        } else{
            button.setText("O");
            playerTurn = 0;
            b++;
        }
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            //draw
            if (b == 9) {
                winnerText.setText("Draw");
                buttons.forEach(this::resetButton);
                nextTurn();
            }

            //X winner
            if (line.equals("XXX")) {
                winnerText.setText("P1 won!");
                p1++;
                buttons.forEach(this::resetButton);
                nextTurn();
            }

            //O winner
            if (line.equals("OOO")) {
                winnerText.setText("P2 won!");
                p2++;
                buttons.forEach(this::resetButton);
                nextTurn();
            }


        }
    }


    }
