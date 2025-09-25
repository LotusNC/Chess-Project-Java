package org.example.Chesspieces;

import org.example.Attributes.Color;
import org.example.Attributes.Point;

public class Queen extends Chesspiece {
    public Queen(Point position, Color color) {
        super(position, color);
    }

    @Override
    public boolean canMoveTo(Point from, Point to) {

        if (from.equals(to)) {
            return false;
        }

        // Berechne die absolute Differenz auf der x- und y-Achse.
        int dx = Math.abs(from.x() - to.x());
        int dy = Math.abs(from.y() - to.y());

        // Bedingung für Turm-Bewegung (horizontal oder vertikal)
        boolean isStraight = (dx == 0 || dy == 0);

        // Bedingung für Läufer-Bewegung (diagonal)
        boolean isDiagonal = (dx == dy);

        // Die Dame kann sich bewegen, wenn der Zug entweder gerade ODER diagonal ist.
        return isStraight || isDiagonal;
    }
}

