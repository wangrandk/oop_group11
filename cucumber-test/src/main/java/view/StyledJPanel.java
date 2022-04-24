package view;

import javax.swing.*;
import java.awt.*;


class StyledJPanel extends JPanel {

    
    public StyledJPanel(LayoutManager layoutManager) {
        this.setLayout(layoutManager);
        this.setOpaque(true);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
    }
}
