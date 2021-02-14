package com.sda.serwice;

import javax.swing.*;

public class WindowMaker {
    public static JFrame setupJFrameAndGet(String title, int width, int height) {
        JFrame tmpJF = new JFrame(title);
        tmpJF.setSize(width, height);
        tmpJF.setLocationRelativeTo(null);
        tmpJF.setLayout(null);
        tmpJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return tmpJF;
    } // end of setupJFrameAndGet

    public static JTextArea setupJTextAreaAndGet(String text, int rows, int columns, boolean setEditableFlag, boolean setLineWrapFlag, boolean setWrapStyleWordFlag, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JTextArea tmpJTA = new JTextArea(text, rows, columns);
        tmpJTA.setEditable(setEditableFlag);
        tmpJTA.setLineWrap(setLineWrapFlag);
        tmpJTA.setWrapStyleWord(setWrapStyleWordFlag);
        if (setBoundsFlag == true) {
            tmpJTA.setBounds(xpos, ypos, width, height);
        }
        return tmpJTA;
    } // end of setupJTextAreaAndGet

    public static JScrollPane setupScrollableJTextAreaAndGet(JTextArea jta, int xpos, int ypos, int width, int height) {
        JScrollPane tmpJSP = new JScrollPane(jta);
        tmpJSP.setBounds(xpos, ypos, width, height);
        return tmpJSP;
    } // end of setupScrollableJTextAreaAndGet

    public static JMenuBar setupJMenuBarAndGet() {
        JMenuBar tmpJMB = new JMenuBar();
        return tmpJMB;
    } // end of setupJMenuBarAndGet

    public static JMenu setupJMenuAndGet(String text) {
        JMenu tmpJM = new JMenu(text);
        return tmpJM;
    } // end of setupJMenuAndGet

    public static JMenuItem setupJMenuItemAndGet(String text) {
        JMenuItem tmpJMI = new JMenuItem(text);
        return tmpJMI;
    } // end of setupJMenuItemAndGet

}

