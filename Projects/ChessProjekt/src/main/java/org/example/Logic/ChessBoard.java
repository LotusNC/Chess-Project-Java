package org.example.Logic;

import org.example.Attributes.Point;
import org.example.Chesspieces.Chesspiece;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private final int height;
    private final int width;

    public Map<Point, Chesspiece> piecesOnBoard = new HashMap<>();

    public ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public String getBoardInfo() {
        return "Height: " + this.height + ", Width: " + this.width;
    }

}
