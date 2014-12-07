package com.dracowf.tmp;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class JDirChooser extends JPanel implements ActionListener {

    JButton inputFolder;
    JButton outputFolder;
    JButton runSplitter;

    JFileChooser chooser;
    //String choosertitle;

    public JDirChooser() {
        inputFolder = new JButton("Input Folder");
        inputFolder.addActionListener(this);
        add(inputFolder);

        outputFolder = new JButton("Output Folder");
        outputFolder.addActionListener(this);
        add(outputFolder);

        runSplitter = new JButton("Run");
        runSplitter.addActionListener(this);
        add(runSplitter);
    }

    public void actionPerformed(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        //chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        //chooser.setDialogTitle(choosertitle);
        // disable the "All files" option.
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(300, 100);
    }

    public static void main(String s[]) {
        JFrame frame = new JFrame();
        JDirChooser panel = new JDirChooser();
        frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        frame.getContentPane().add(panel);
        frame.setSize(panel.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getInputFolder() {
        return inputFolder;
    }
}