package org.example.Attributes;

import java.util.Objects;

public class Color {

    // Schritt 1: Füge statische, finale Instanzen hinzu.
    // So hast du überall im Code Zugriff auf dieselben Weiß- und Schwarz-Objekte.
    public static final Color WHITE = new Color(new Hex("FFFFFF"), "white");
    public static final Color BLACK = new Color(new Hex("000000"), "black");

    private Hex hex;
    private String colorName;

    public Color(Hex hex, String colorName) {
        this.hex = hex;
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(colorName, color.colorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorName);
    }
}