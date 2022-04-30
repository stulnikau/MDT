package com.mdt.gui;
import javax.swing.*;
import java.awt.*;

/**
 * Panel displayed on east Maze Generation panel.
 * cardlayout is used to switch between MazePropertiesPanel and ImagePropertiesPanel.
 */
public class PropertiesPanel extends JPanel {
    public final MazePropertiesPanel mazePropertiesPanel;
    public final ImagePropertiesPanel imagePropertiesPanel;


    public PropertiesPanel() {
        super(new BorderLayout());
        CardLayout cardLayout = new CardLayout();
        JPanel propertiesPanelContainer = new JPanel(cardLayout);

        mazePropertiesPanel = new MazePropertiesPanel();
        imagePropertiesPanel = new ImagePropertiesPanel();
        this.add(Box.createHorizontalStrut(200), BorderLayout.SOUTH); // Fixed width
        propertiesPanelContainer.add(mazePropertiesPanel, "MazeProperties");
        propertiesPanelContainer.add(imagePropertiesPanel, "ImageProperties");
        this.add(propertiesPanelContainer, BorderLayout.CENTER);
        cardLayout.show(propertiesPanelContainer, "MazeeProperties");

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.WEST);
    }
}
