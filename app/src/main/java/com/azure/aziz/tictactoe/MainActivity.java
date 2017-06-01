package com.azure.aziz.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Player 1 starts.",Toast.LENGTH_SHORT).show();

    }

    public void butClick(View view) {
       Button buSelected = (Button)view;
        int cellID = 0;
        switch (buSelected.getId()){
            case R.id.but1:
                cellID = 1;
                break;
            case R.id.but2:
                cellID = 2;
                break;
            case R.id.but3:
                cellID = 3;
                break;
            case R.id.but4:
                cellID = 4;
                break;
            case R.id.but5:
                cellID = 5;
                break;
            case R.id.but6:
                cellID = 6;
                break;
            case R.id.but7:
                cellID = 7;
                break;
            case R.id.but8:
                cellID = 8;
                break;
            case R.id.but9:
                cellID = 9;
                break;
         }
        PlayGame(cellID ,buSelected);

    }
    ArrayList<Integer> dataOne = new ArrayList<Integer>();
    ArrayList<Integer> dataTwo = new ArrayList<Integer>();
    int ActivePlayer = 1;

    void PlayGame (int cellID, Button buSelected)
    {
            Log.d("Player : ",String.valueOf(cellID));

            if ((dataOne.contains(Integer.parseInt(String.valueOf(cellID))))||(dataTwo.contains(Integer.parseInt(String.valueOf(cellID)))))
            {
                Toast.makeText(this,"This case have already been played. \nChoose another one.",Toast.LENGTH_SHORT).show();
            }
            else {
                if (ActivePlayer == 1) {
                    buSelected.setText("X");
                    buSelected.setTextColor(Color.rgb(255, 0, 144));
                    ActivePlayer = 2;
                    dataOne.add(Integer.parseInt(String.valueOf(cellID)));
                    autoPlay ();

                } else {
                    buSelected.setText("O");
                    buSelected.setTextColor(Color.rgb(0, 35, 102));
                    ActivePlayer = 1;
                    dataTwo.add(Integer.parseInt(String.valueOf(cellID)));
                }
                checkWinner();
            }
    }

    void checkWinner (){
        int winner = -1;
        boolean playerOneBoll = ((dataOne.contains(1) && dataOne.contains(2) && dataOne.contains(3))
                                ||(dataOne.contains(4) && dataOne.contains(5) && dataOne.contains(6))
                                ||(dataOne.contains(7) && dataOne.contains(8) && dataOne.contains(9))
                                ||(dataOne.contains(1) && dataOne.contains(4) && dataOne.contains(7))
                                ||(dataOne.contains(2) && dataOne.contains(5) && dataOne.contains(8))
                                ||(dataOne.contains(3) && dataOne.contains(6) && dataOne.contains(9))
                                ||(dataOne.contains(1) && dataOne.contains(5) && dataOne.contains(9))
                                ||(dataOne.contains(3) && dataOne.contains(5) && dataOne.contains(7)));
        boolean playerTwoBoll = ((dataTwo.contains(1) && dataTwo.contains(2) && dataTwo.contains(3))
                                ||(dataTwo.contains(4) && dataTwo.contains(5) && dataTwo.contains(6))
                                ||(dataTwo.contains(7) && dataTwo.contains(8) && dataTwo.contains(9))
                                ||(dataTwo.contains(1) && dataTwo.contains(4) && dataTwo.contains(7))
                                ||(dataTwo.contains(2) && dataTwo.contains(5) && dataTwo.contains(8))
                                ||(dataTwo.contains(3) && dataTwo.contains(6) && dataTwo.contains(9))
                                ||(dataTwo.contains(1) && dataTwo.contains(5) && dataTwo.contains(9))
                                ||(dataTwo.contains(3) && dataTwo.contains(5) && dataTwo.contains(7)));
        if (playerOneBoll)
            winner = 1;
        if (playerTwoBoll)
            winner = 2;

        if (winner != -1)
            Toast.makeText(this,"The player : " + String.valueOf(winner) + " is the winner",Toast.LENGTH_LONG).show();

    }

    void autoPlay (){
        ArrayList<Integer> emptyCell = new ArrayList <Integer>();

        for (int cell=1;cell<10;cell++)
        {
            if (!(dataOne.contains(cell)&&dataTwo.contains(cell)))
            {
                emptyCell.add(cell);
            }
        }

        Random r = new Random();
        int randomIndex = r.nextInt(emptyCell.size()-0)+0;
        int cellID = emptyCell.get(randomIndex);
        Button buSelected=null;
        switch (cellID){
            case 1:
                buSelected = (Button) findViewById(R.id.but1);
                break;
            case 2:
                buSelected = (Button) findViewById(R.id.but2);
                break;
            case 3:
                buSelected = (Button) findViewById(R.id.but3);
                break;
            case 4:
                buSelected = (Button) findViewById(R.id.but4);
                break;
            case 5:
                buSelected = (Button) findViewById(R.id.but5);
                break;
            case 6:
                buSelected = (Button) findViewById(R.id.but6);
                break;
            case 7:
                buSelected = (Button) findViewById(R.id.but7);
                break;
            case 8:
                buSelected = (Button) findViewById(R.id.but8);
                break;
            case 9:
                buSelected = (Button) findViewById(R.id.but9);
                break;

        }
        PlayGame(cellID,buSelected);

    }
}
