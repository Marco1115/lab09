package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;

    private final JFrame frame = new JFrame();

    private SimpleGUI(final Controller controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        // input field
        final JTextField inputField = new JTextField();
        canvas.add(inputField, BorderLayout.NORTH);
        // show history text area
        final JTextArea showHistory = new JTextArea();
        showHistory.setEditable(false);
        canvas.add(showHistory, BorderLayout.CENTER);
        // south panel
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        // print button
        final JButton printButton = new JButton("Print");
        buttonPanel.add(printButton);
        // show history button
        final JButton showHistoryButton = new JButton("Show History");
        buttonPanel.add(showHistoryButton);
        canvas.add(buttonPanel, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
    }

    private void display() {
        final Dimension displayDim = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) displayDim.getWidth();
        final int height = (int) displayDim.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setVisible(true);
    }

    /**
     * Starts the application with the SimpleGUI interface.
     * 
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
