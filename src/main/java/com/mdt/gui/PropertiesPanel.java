package com.mdt.gui;
import com.mdt.gui.adapters.ShowSolutionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Panel displayed on the right side of the Maze Generation panel.
 */
public class PropertiesPanel extends JPanel {
    public final MazePropertiesPanel mazePropertiesPanel;

    /**
     * Creates a new properties panel
     */
    public PropertiesPanel(ShowSolutionListener listener) {
        super(new BorderLayout());
        CardLayout cardLayout = new CardLayout();
        JPanel propertiesPanelContainer = new JPanel(cardLayout);

        mazePropertiesPanel = new MazePropertiesPanel(listener);
        this.add(Box.createHorizontalStrut(200), BorderLayout.SOUTH); // Fixed width
        propertiesPanelContainer.add(mazePropertiesPanel, "MazeProperties");
        this.add(propertiesPanelContainer, BorderLayout.CENTER);
        cardLayout.show(propertiesPanelContainer, "MazeProperties");

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.WEST);
    }
}
