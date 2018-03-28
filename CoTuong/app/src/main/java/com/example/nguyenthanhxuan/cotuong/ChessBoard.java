package com.example.nguyenthanhxuan.cotuong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.Image;

import java.util.ArrayList;
import java.util.List;


public class ChessBoard {


    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private int[][] board;
    private int player;
    private Context context;
    private int bitmapWidth;
    private int bitmapHeight;
    private int colQty;
    private int rowQty;
    private List<Line> listLine;


    private Bitmap NDen;
    private Bitmap XDen;
    private Bitmap TDen;
    private Bitmap SDen;
    private Bitmap TuDen;
    private Bitmap PDen;
    private Bitmap CDen;

    private Bitmap NDo;
    private Bitmap XDo;
    private Bitmap TDo;
    private Bitmap SDo;
    private Bitmap TuDo;
    private Bitmap PDo;
    private Bitmap CDo;



    public ChessBoard(Context context, int bitmapWidth, int bitmapHeight, int colQty, int rowQty) {
        this.context = context;
        this.bitmapWidth = bitmapWidth;
        this.bitmapHeight = bitmapHeight;
        this.colQty = colQty;
        this.rowQty = rowQty;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getBitmapWidth() {
        return bitmapWidth;
    }

    public void setBitmapWidth(int bitmapWidth) {
        this.bitmapWidth = bitmapWidth;
    }

    public int getBitmapHeight() {
        return bitmapHeight;
    }

    public void setBitmapHeight(int bitmapHeight) {
        this.bitmapHeight = bitmapHeight;
    }

    public int getColQty() {
        return colQty;
    }

    public void setColQty(int colQty) {
        this.colQty = colQty;
    }

    public int getRowQty() {
        return rowQty;
    }

    public void setRowQty(int rowQty) {
        this.rowQty = rowQty;
    }

    public void init(){
        bitmap= Bitmap.createBitmap(bitmapWidth,bitmapHeight, Bitmap.Config.ARGB_8888);
        canvas=new Canvas(bitmap);
        paint=new Paint();
        int storkeWidth=1;
        paint.setStrokeWidth(storkeWidth);
        board=new int[rowQty][colQty];
        player=0;
        listLine=new ArrayList<>();

        int cellWidth=bitmapWidth/colQty;
        int cellHeight=bitmapHeight/rowQty;






       // bmCross= BitmapFactory.decodeResource(context.getResources(),R.drawable.circle);
       // bmTick=BitmapFactory.decodeResource(context.getResources(),R.drawable.xicon);



        for(int i=1;i<rowQty-1;i++){
            listLine.add(new Line(cellWidth,i*cellHeight,bitmapWidth-cellWidth,i*cellHeight));
        }

        listLine.add(new Line(cellWidth,10*cellHeight,9*cellWidth,10*cellHeight) );

        for (int j=1;j<colQty-1;j++){
            listLine.add(new Line(j*cellWidth,cellHeight,j*cellWidth,cellHeight*5));
            listLine.add(new Line(j*cellWidth,cellHeight*6,j*cellWidth,bitmapHeight-cellHeight));
        }

        listLine.add(new Line(cellWidth*9,cellHeight,cellWidth*9,10*cellHeight));
        listLine.add(new Line(cellWidth,cellHeight*5,cellWidth,cellHeight*6));
        listLine.add(new Line(cellWidth*4,cellHeight,cellWidth*6,cellHeight*3));
        listLine.add(new Line(cellWidth*6,cellHeight,cellWidth*4,cellHeight*3));
        listLine.add(new Line(cellWidth*4,cellHeight*10,cellWidth*6,cellHeight*8));
        listLine.add(new Line(cellWidth*6,cellHeight*10,cellWidth*4,cellHeight*8));


    }

    public Bitmap drawBoard(){
        Line line;
        int cellWidth=bitmapWidth/colQty;
        int cellHeight=bitmapHeight/rowQty;
        int halfWidth=cellWidth/2;
        int halfHeight=cellHeight/2;

        XDen=BitmapFactory.decodeResource(context.getResources(),R.drawable.XDen);
        canvas.drawBitmap(XDen,new Rect(0,0,XDen.getWidth(),XDen.getHeight()),new Rect(halfWidth,halfHeight,cellWidth+halfWidth,cellHeight+halfHeight),paint);
        canvas.drawBitmap(XDen,new Rect(0,0,XDen.getWidth(),XDen.getHeight()),new Rect(8*cellWidth-halfWidth,halfHeight,9*cellWidth-halfWidth,halfHeight+cellHeight),paint);

        NDen=BitmapFactory.decodeResource(context.getResources(),R.drawable.NDen);
        canvas.drawBitmap(NDen,new Rect(0,0,NDen.getWidth(),NDen.getHeight()),new Rect(2*cellWidth-halfWidth,halfHeight,3*cellWidth-halfWidth,cellHeight+halfHeight),paint);
        canvas.drawBitmap(NDen,new Rect(0,0,NDen.getWidth(),NDen.getHeight()),new Rect(9*cellWidth-halfWidth,halfHeight,10*cellWidth-halfWidth,cellHeight+halfHeight),paint);

        SDen=BitmapFactory.decodeResource(context.getResources(),R.drawable.SDen);
        canvas.drawBitmap(SDen,new Rect(0,0,SDen.getWidth(),SDen.getHeight()),new Rect(4*cellWidth-halfWidth,halfHeight,4*cellWidth+halfWidth,halfHeight+cellHeight),paint);
        canvas.drawBitmap(SDen,new Rect(0,0,SDen.getWidth(),SDen.getHeight()),new Rect(6*cellWidth-halfWidth,halfHeight,6*cellWidth+halfWidth,cellHeight+halfHeight),paint);

        TuDen=BitmapFactory.decodeResource(context.getResources(),R.drawable.TuDen);
        canvas.drawBitmap(TuDen,new Rect(0,0,SDen.getWidth(),SDen.getHeight()),new Rect(3*cellWidth-halfWidth,halfHeight,3*cellWidth+halfWidth,halfHeight+cellHeight),paint);
        canvas.drawBitmap(TuDen,new Rect(0,0,SDen.getWidth(),SDen.getHeight()),new Rect(7*cellWidth-halfWidth,halfHeight,7*cellWidth+halfWidth,halfHeight+cellHeight),paint);

        TDen=BitmapFactory.decodeResource(context.getResources(),R.drawable.TDen);
        canvas.drawBitmap(TDen,new Rect(0,0,TDen.getWidth(),TDen.getHeight()),new Rect(5*cellWidth-halfWidth,halfHeight,5*cellWidth+halfWidth,halfHeight+cellHeight),paint);

        CDen=BitmapFactory.decodeResource(context.getResources(),R.drawable.CDen);
        for(int i=1;i<colQty;i=i+2) {
            canvas.drawBitmap(CDen,new Rect(0,0,CDen.getWidth(),CDen.getHeight()),new Rect(i*cellWidth-halfWidth,4*cellHeight-halfHeight,i*cellWidth+halfWidth,4*cellHeight+halfHeight),paint);
        }

        PDen=BitmapFactory.decodeResource(context.getResources(),R.drawable.PDen);
        for(int j=2;j<colQty;j=j+6){
            canvas.drawBitmap(PDen,new Rect(0,0,PDen.getWidth(),PDen.getHeight()),new Rect(j*cellWidth-halfWidth,3*cellHeight-halfHeight,j*cellWidth+halfWidth,3*cellHeight+halfHeight),paint);
        }

        for(int i=0;i<listLine.size();i++){
            line=listLine.get(i);
            canvas.drawLine(line.getStartX(),line.getStartY(),line.getStopX(),line.getStopY(),paint);
        }

        XDo=BitmapFactory.decodeResource(context.getResources(),R.drawable.XDo);
        for(int i=1;i<colQty;i=i+8){
            canvas.drawBitmap(XDo,new Rect(0,0,XDo.getWidth(),XDo.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        NDo=BitmapFactory.decodeResource(context.getResources(),R.drawable.NDo);
        for(int i=2;i<colQty;i=i+6){
            canvas.drawBitmap(NDo,new Rect(0,0,NDo.getWidth(),NDo.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        TuDo=BitmapFactory.decodeResource(context.getResources(),R.drawable.TuDo);
        for(int i=3;i<colQty;i=i+4){
            canvas.drawBitmap(TuDo,new Rect(0,0,TuDo.getWidth(),TuDo.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        TDo=BitmapFactory.decodeResource(context.getResources(),R.drawable.TDo);
        canvas.drawBitmap(TDo,new Rect(0,0,TDo.getWidth(),TDo.getHeight()),new Rect(5*cellWidth-halfWidth,10*cellHeight-halfHeight,5*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);

        SDo=BitmapFactory.decodeResource(context.getResources(),R.drawable.SDo);
        canvas.drawBitmap(SDo,new Rect(0,0,SDo.getWidth(),SDo.getHeight()),new Rect(4*cellWidth-halfWidth,10*cellHeight-halfHeight,4*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        canvas.drawBitmap(SDo,new Rect(0,0,SDo.getWidth(),SDo.getHeight()),new Rect(6*cellWidth-halfWidth,10*cellHeight-halfHeight,6*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);

        PDo=BitmapFactory.decodeResource(context.getResources(),R.drawable.PDo);
        for(int j=2;j<colQty;j=j+6){
            canvas.drawBitmap(PDo,new Rect(0,0,PDo.getWidth(),PDo.getHeight()),new Rect(j*cellWidth-halfWidth,8*cellHeight-halfHeight,j*cellWidth+halfWidth,8*cellHeight+halfHeight),paint);
        }

        CDo=BitmapFactory.decodeResource(context.getResources(),R.drawable.CDo);
        for(int i=1;i<colQty;i=i+2) {
            canvas.drawBitmap(CDo,new Rect(0,0,CDo.getWidth(),CDo.getHeight()),new Rect(i*cellWidth-halfWidth,7*cellHeight-halfHeight,i*cellWidth+halfWidth,7*cellHeight+halfHeight),paint);
        }

        return bitmap;
    }


}
