package it.unibo.mvc;

import java.awt.BorderLayout;
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
                } else if (result != JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(browseButton, "Error");
                }
            }
        });
    } 

}
