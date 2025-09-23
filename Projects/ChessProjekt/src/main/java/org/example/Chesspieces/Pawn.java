package org.example.Chesspieces;

import org.example.Attributes.Color;
import org.example.Attributes.Direction;
import org.example.Attributes.Point;

public class Pawn extends Chesspiece {

    private final Direction direction;
    private boolean hasMoved;

    public Pawn(Point position, Color color, Direction direction) {
        super(position, color);
        this.direction = direction;
        this.hasMoved = false;
    }

    @Override
    public boolean canMoveTo(Point from, Point to) {
        if (from.equals(to)) {
            return false;
        }

        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();

        switch (this.direction) {
            case UP:
                    // Normaler Zug: 1 Feld nach oben
                if (dx == 0 && dy == 1) return true;
                    // Anfangszug: 2 Felder nach oben (nur wenn noch nicht bewegt)
                if (!hasMoved && dx == 0 && dy == 2) return true;
                    // Schlagzug: 1 Feld diagonal nach oben
                if (Math.abs(dx) == 1 && dy == 1) return true;
                break;
            case DOWN:
                if (dx == 0 && dy == -1) return true;
                if (!hasMoved && dx == 0 && dy == -2) return true;
                if (Math.abs(dx) == 1 && dy == -1) return true;
                break;
            case RIGHT:
                if (dx == 1 && dy == 0) return true;
                if (!hasMoved && dx == 2 && dy == 0) return true;
                if (dx == 1 && Math.abs(dy) == 1) return true;
                break;
            case LEFT:
                if (dx == -1 && dy == 0) return true;
                if (!hasMoved && dx == -2 && dy == 0) return true;
                if (dx == -1 && Math.abs(dy) == 1) return true;
                break;
        }

        return false;
    }
}