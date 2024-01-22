
package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener {

    JTextArea textArea;

    public TextEditor() {
        setTitle("Simple Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(this);
        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(this);
        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(this);
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        JMenu themesMenu = new JMenu("Themes");
        JMenuItem darkThemeItem = new JMenuItem("Dark Theme");
        darkThemeItem.addActionListener(this);
        JMenuItem defaultThemeItem = new JMenuItem("Default Theme");
        defaultThemeItem.addActionListener(this);
        themesMenu.add(darkThemeItem);
        themesMenu.add(defaultThemeItem);

        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(themesMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Save":
                // Perform save operation
                break;
            case "Exit":
                System.exit(0);
                break;
            case "Cut":
                textArea.cut();
                break;
            case "Copy":
                textArea.copy();
                break;
            case "Paste":
                textArea.paste();
                break;
            case "Dark Theme":
                textArea.setBackground(Color.DARK_GRAY);
                textArea.setForeground(Color.WHITE);
                break;
            case "Default Theme":
                textArea.setBackground(Color.WHITE);
                textArea.setForeground(Color.BLACK);
                break;
            // Add help functionality here if needed
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextEditor editor = new TextEditor();
            editor.setVisible(true);
        });
    }
}
