package com.example.nguyenthanhxuan.cotuong;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    private ImageView img;
    private ChessBoard chessBoard;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        chessBoard = new ChessBoard(this, 300, 330, 10, 11);
        chessBoard.init();
        bitmap = chessBoard.drawBoard();

        img.setImageBitmap(bitmap);
    }


    }
