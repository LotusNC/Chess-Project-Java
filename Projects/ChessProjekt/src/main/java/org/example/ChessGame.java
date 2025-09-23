package org.example;

import org.example.Attributes.Point;
import org.example.Chesspieces.Chesspiece;
import org.example.Logic.ChessBoard;
import org.example.Logic.LogicInterpreter;
import org.example.Visualizers.ChessVisualizer;

import java.util.HashMap;
import java.util.Map;

public class ChessGame {
    private ChessBoard currentBoard;
    private ChessVisualizer visualizer;

    private LogicInterpreter logicInterpreter = new LogicInterpreter();

    private Map<Point, Chesspiece> currentPieces;

    public ChessGame(ChessBoard board, ChessVisualizer visualizer) {
        this.currentBoard = board;
        currentPieces = currentBoard.piecesOnBoard;
        this.visualizer = visualizer;
    }

    public void movePiece(Point from, Point to) {}

}
