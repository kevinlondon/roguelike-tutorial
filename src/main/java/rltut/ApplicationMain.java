package rltut;

import asciiPanel.AsciiPanel;
import rltut.screens.Screen;
import rltut.screens.StartScreen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ApplicationMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;
    private AsciiPanel terminal;
    private Screen screen;

    private ApplicationMain() {
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

}
