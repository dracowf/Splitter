package com.dracowf.tmp;

import javax.swing.JFileChooser;

public class JFileChooserSelectionMode {

    public static void main(String[] a) {

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        fileChooser.showOpenDialog(null);
    }
}