package com.mdt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MazeCellBorderPanel extends JPanel implements MouseListener {
    private boolean wallStatus;

    private void setColorBasedOnWallStatus() {
        if (wallStatus) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.WHITE);
        }
    }

    public MazeCellBorderPanel(boolean enabled) {
        addMouseListener(this);
        wallStatus = enabled;
        setColorBasedOnWallStatus();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        wallStatus = !wallStatus;
        setColorBasedOnWallStatus();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setColorBasedOnWallStatus();
    }
}
