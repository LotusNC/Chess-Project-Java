package org.example.Attributes;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        // 1. Prüfe, ob es dasselbe Objekt im Speicher ist
        if (this == o) return true;
        // 2. Prüfe, ob das andere Objekt null ist oder eine andere Klasse hat
        if (o == null || getClass() != o.getClass()) return false;
        // 3. Wandle das Objekt in einen Point um
        Point point = (Point) o;
        // 4. Vergleiche die relevanten Werte (x und y)
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        // Benutze die Werte, die du in equals() vergleichst, um den Hash-Code zu erzeugen
        return Objects.hash(x, y);
    }

}
