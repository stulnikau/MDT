package com.mdt.gui;
import javax.swing.*;
import java.awt.*;

public class PropertiesPanel extends JPanel {
    public final MazePropertiesPanel mazePropertiesPanel;
    public final ImagePropertiesPanel imagePropertiesPanel;
    private final CardLayout cardLayout;

    public PropertiesPanel() {
        super(new BorderLayout());
        cardLayout = new CardLayout();
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
