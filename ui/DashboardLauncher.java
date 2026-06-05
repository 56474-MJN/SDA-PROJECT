// Pattern: MVC View
package com.sdapro.ui;

import javax.swing.SwingUtilities;

public class DashboardLauncher {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            DashboardFrame frame =
                    new DashboardFrame();

            frame.setVisible(true);
        });
    }
}