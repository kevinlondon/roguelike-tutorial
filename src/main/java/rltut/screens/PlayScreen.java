package rltut.screens;

import asciiPanel.AsciiPanel;
import rltut.Creature;
import rltut.CreatureFactory;
import rltut.World;
import rltut.WorldBuilder;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {

    private World world;
    private int screenWidth;
    private int screenHeight;
    private Creature player;

    public PlayScreen() {
        screenWidth = 80;
        screenHeight = 21;
        createWorld();

        CreatureFactory creatureFactory = new CreatureFactory(world);
        player = creatureFactory.newPlayer();
    }

    private void createWorld() {
        world = new WorldBuilder(90, 31).makeCaves().build();
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();
        displayTiles(terminal, left, top);
        terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H:
                player.moveBy(-1, 0);
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L:
                player.moveBy(1, 0);
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_K:
                player.moveBy(0, -1);
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J:
                player.moveBy(0, 1);
                break;

            case KeyEvent.VK_Y:
                player.moveBy(-1, -1);
                break;

            case KeyEvent.VK_U:
                player.moveBy(1, -1);
                break;

            case KeyEvent.VK_B:
                player.moveBy(-1, 1);
                break;

            case KeyEvent.VK_N:
                player.moveBy(1, 1);
                break;

            case KeyEvent.VK_ESCAPE:
                return new LoseScreen();

            case KeyEvent.VK_ENTER:
                return new WinScreen();
        }
        return this;
    }

    public int getScrollX() {
        int centerBound = player.x - screenWidth / 2;
        int worldBound = world.width() - screenWidth;
        return Math.max(0, Math.min(centerBound, worldBound));
    }

    public int getScrollY() {
        int centerBound = player.y - screenHeight / 2;
        int worldBound = world.height() - screenHeight;
        return Math.max(0, Math.min(centerBound, worldBound));
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wx));
            }
        }
    }

}
