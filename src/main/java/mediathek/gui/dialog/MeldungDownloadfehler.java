/*    
 *    MediathekView
 *    Copyright (C) 2008   W. Xaver
 *    W.Xaver[at]googlemail.com
 *    http://zdfmediathk.sourceforge.net/
 *    
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mediathek.gui.dialog;

import mediathek.config.Icons;
import mediathek.config.MVConfig;
import mediathek.daten.DatenDownload;
import mediathek.tool.EscBeenden;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MeldungDownloadfehler extends JDialog {
    private Timer countdownTimer = null;

    public MeldungDownloadfehler(java.awt.Frame parent, String text, DatenDownload datenDownload) {
        super(parent, false);
        initComponents();
        setFocusableWindowState(false);
        setFocusable(false);
        setTitle("Downloadfehler");
        if (parent != null) {
            setLocationRelativeTo(parent);
        }
        new EscBeenden(this) {
            @Override
            public void beenden_() {
                beenden();
            }
        };
        jTextArea1.setText(text);
        jTextFieldTitel.setText(datenDownload.arr[DatenDownload.DOWNLOAD_TITEL]);
        jButtonOk.addActionListener(e -> beenden());
        jLabelIcon.setText("");
        jLabelIcon.setIcon(Icons.ICON_ACHTUNG_32);

        //start the countdown...
        countdownTimer = new Timer(0, new CountdownAction());
        countdownTimer.setRepeats(true);
        countdownTimer.start();

        pack();
    }

    @Override
    public void setVisible(boolean vis) {
        if (Boolean.parseBoolean(MVConfig.get(MVConfig.Configs.SYSTEM_DOWNLOAD_ERRORMSG))
                && MVConfig.getInt(MVConfig.Configs.SYSTEM_PARAMETER_DOWNLOAD_ERRORMSG_IN_SEKUNDEN) > 0) {
            super.setVisible(vis);
        } else {
            beenden();
        }
    }

    private void beenden() {
        this.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOk = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelIcon = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jTextFieldTitel = new javax.swing.JTextField();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        jLabelTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOk.setText("Ok");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(4);
        jScrollPane1.setViewportView(jTextArea1);

        jLabelIcon.setText("Achtung");

        jLabel2.setText("Filmtitel:");

        jTextFieldTitel.setEditable(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabelTime.setText("0 s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOk))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTitel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabelTime)
                            .addComponent(jButtonOk)))
                    .addComponent(jLabelIcon))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldTitel;
    // End of variables declaration//GEN-END:variables

    /**
     * Implements the countdown based on Swing Timer for automatic placement on EDT.
     */
    private class CountdownAction implements ActionListener {

        private int w = MVConfig.getInt(MVConfig.Configs.SYSTEM_PARAMETER_DOWNLOAD_ERRORMSG_IN_SEKUNDEN);

        @Override
        public void actionPerformed(ActionEvent e) {
            if (w > 0) {
                jLabelTime.setText(w + " s");
                if (countdownTimer != null) {
                    countdownTimer.setDelay(1000);
                }
            } else {
                beenden();
            }
            w--;
        }
    }
}
