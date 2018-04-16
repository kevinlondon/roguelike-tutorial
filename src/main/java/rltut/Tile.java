package rltut;

import asciiPanel.AsciiPanel;

import java.awt.*;

public enum Tile {
    FLOOR((char) 250, AsciiPanel.yellow),
    WALL((char) 177, AsciiPanel.yellow),
    STAIRS_DOWN('>', AsciiPanel.white),
    STAIRS_UP('<', AsciiPanel.white),
    BOUNDS('x', AsciiPanel.brightBlack);

    private char glyph;
    private Color color;

    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }

    public char glyph() {
        return glyph;
    }

    public Color color() {
        return color;
    }

    public boolean isDiggable() {
        return this == Tile.WALL;
    }

    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
}
