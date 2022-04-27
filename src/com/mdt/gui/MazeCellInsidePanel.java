package com.mdt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MazeCellInsidePanel extends JPanel implements MouseListener {
    public MazeCellInsidePanel() {
        addMouseListener(this);
        this.setBackground(Color.WHITE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(null);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(144, 238, 144));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.WHITE);
    }
}
