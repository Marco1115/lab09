package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 2;

    private final JFrame frame = new JFrame();

    /**
     * Creates a new SimpleGUIWithFileChooser.
     * 
     * @param controller the controller of the GUI
     */
    private SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout());
        final JTextField fileName = new JTextField(controller.getCurrentFilePath());
        fileName.setEditable(false);
        browsePanel.add(fileName, BorderLayout.CENTER);
        final JButton browseButton = new JButton("Browse");
        browsePanel.add(browseButton, BorderLayout.LINE_END);
        canvas.add(browsePanel, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try {
                    controller.writeString(textArea.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(frame, e, "IO Error", JOptionPane.ERROR);
                }
            }
        });
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                final JFileChooser chooser = new JFileChooser();
                final var result = chooser.showSaveDialog(browseButton);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(chooser.getSelectedFile());
                    fileName.setText(controller.getCurrentFilePath());
                } else if (result != JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(browseButton, "Error");
                }
            }
        });
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        final int screenWidth = (int) screenDim.getWidth();
        final int screenHeight = (int) screenDim.getHeight();
        frame.setSize(screenWidth / PROPORTION, screenHeight / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Starts the application with the SimpleGUIWithFileChooser interface.
     * 
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
