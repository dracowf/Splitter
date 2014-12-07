package com.dracowf.file;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu {


    public static void createGUI() {

        final DirList dirList = new DirList();
        final String[] outputFolderName = {null};
        final String[] inputFolderName = {null};

        JFrame frame = new JFrame("Test frame");

        JPanel panel = new JPanel();

        JButton inputFolder = new JButton("Input Folder");
        panel.add(inputFolder);

        final JButton outputFolder = new JButton("Output Folder");
        panel.add(outputFolder);

        JButton runSplitter = new JButton("Run");
        runSplitter.setEnabled(false);
        panel.add(runSplitter);

        inputFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser dirChooser = new JFileChooser();
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                dirChooser.setAcceptAllFileFilterUsed(false);
                if (dirChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    inputFolderName[0] = String.valueOf(dirChooser.getSelectedFile().getPath());
                    System.out.println("Selected Directory: " + inputFolderName[0]);
                    dirList.getList(String.valueOf(dirChooser.getSelectedFile().getPath()));
                    runSplitter.setEnabled(true);
                }
                else {
                    System.out.println("No Selection ");
                }
            }
        });

        outputFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser dirChooser = new JFileChooser();
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                dirChooser.setAcceptAllFileFilterUsed(false);
                if (dirChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    outputFolderName[0] = String.valueOf(dirChooser.getSelectedFile().getPath());
                    System.out.println("Selected Directory: " + outputFolderName[0]);
                }
                else {
                    System.out.println("No Selection ");
                }
            }
        });

        runSplitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*List<String> textList = null;
                Txt txt = new Txt();
                textList = txt.getOnlyTxt(dirList.list);*/

                Manipulator manipulator = new Manipulator();
                manipulator.makeTxt(inputFolderName, outputFolderName, dirList.list);

                runSplitter.setEnabled(false);
                dirList.list.clear();
            }
        });

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(panel.getPreferredSize());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

}