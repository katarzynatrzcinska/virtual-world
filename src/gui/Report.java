/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Insets;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Kasia
 */
public class Report extends JScrollPane {
    JTextArea reports;
    public Report(JTextArea textArea, int verticalScroll, int horizontalScroll) {
        super(textArea, verticalScroll, horizontalScroll);
        textArea.setMargin(new Insets(5,5,5,5));
        reports = textArea;
        reports.setEditable(false);
        reports.setFocusable(false);
        setFocusable(false);
    }
    
    public void refreshReports(List<String> reports) {
        this.reports.setText(null);
        for (String report : reports) {
            this.reports.append(report + "\n");
        }
    }
    
    public void addReport(String string) {
        this.reports.append(string + "\n");
    }
}