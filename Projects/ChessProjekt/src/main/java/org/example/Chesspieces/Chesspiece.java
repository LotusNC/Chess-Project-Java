package org.example.Chesspieces;

import org.example.Attributes.Color;
import org.example.Attributes.Point;

public abstract class Chesspiece implements ChesspieceInterface {

    private Point position;
    private Color color;

    public Chesspiece(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public boolean canMoveTo(Point from, Point to) {
        return false;
    }

    public Point getPosition() {
        return new Point(this.position.getX(), this.position.getY());
    }

    public Color getColor() {
        return this.color;
    }
}
