import asciiPanel.AsciiPanel;

import javax.swing.*;


public class ApplicationMain extends JFrame {
    private static final long serialVersionUID = 1060623638149583738L;
    private AsciiPanel terminal;

    private ApplicationMain() {
        super();
        terminal = new AsciiPanel();
        terminal.write("this is a test tutorial", 1, 1);
        add(terminal);
        pack();
    }

    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
