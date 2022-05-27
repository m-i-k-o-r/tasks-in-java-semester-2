package ru.vsu.cs.course1;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableInput;
    private JTable tableOutput;
    private JTable tableInputFinal;
    private JButton buttonRandomInput;
    private JScrollPane scrollPaneTableInput;
    private JScrollPane scrollPaneTableInputFinal;
    private JScrollPane scrollPaneTableOutput;
    private JButton выполнитьЧерезВстроенныеМетодыButton;
    private JButton выполнитьЧерезСвязанныеСпискиButton;
    private JTable tableOutput2;
    private JScrollPane scrollPaneTableOutput2;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;


    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, false, false, false, false);
        JTableUtils.initJTableForArray(tableInputFinal, 40, false, false, false, false);
        JTableUtils.initJTableForArray(tableOutput, 40, true, false, false, false);
        JTableUtils.initJTableForArray(tableOutput2, 40, false, false, false, false);
        tableInput.setRowHeight(25);
        tableInputFinal.setRowHeight(25);
        tableOutput.setRowHeight(25);
        tableOutput.setRowHeight(25);
        scrollPaneTableInput.setPreferredSize(new Dimension(-1, 100));
        scrollPaneTableInputFinal.setPreferredSize(new Dimension(-1, 100));
        scrollPaneTableOutput.setPreferredSize(new Dimension(-1, 100));
        scrollPaneTableOutput2.setPreferredSize(new Dimension(-1, 100));

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(tableInput, new int[]{0, 0});
        JTableUtils.writeArrayToJTable(tableInputFinal, new int[]{3, 3});

        this.pack();


        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(tableInput.getColumnCount(), 10);
                    JTableUtils.writeArrayToJTable(tableInput, arr);
                    int[] arrF = ArrayUtils.createRandomIntArray(tableInputFinal.getColumnCount(), 10);
                    JTableUtils.writeArrayToJTable(tableInputFinal, arrF);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        /*buttonExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(tableInput);
                    Task.Process(arr);
                    JTableUtils.writeArrayToJTable(tableOutput, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });*/

        выполнитьЧерезВстроенныеМетодыButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(tableInput);
                    int[] arrFinal = JTableUtils.readIntArrayFromJTable(tableInputFinal);
                    int[][] arr2 = MainVstr.main(arr, arrFinal);
                    int[] arr3 = {arr2.length - 1};
                    JTableUtils.writeArrayToJTable(tableOutput, arr2);
                    JTableUtils.writeArrayToJTable(tableOutput2, arr3);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        выполнитьЧерезСвязанныеСпискиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(tableInput);
                    int[] arrFinal = JTableUtils.readIntArrayFromJTable(tableInputFinal);
                    int[][] arr2 = MainList.main(arr, arrFinal);
                    int[] arr3 = {arr2.length - 1};
                    JTableUtils.writeArrayToJTable(tableOutput, arr2);
                    JTableUtils.writeArrayToJTable(tableOutput2, arr3);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayoutManager(10, 2, new Insets(10, 10, 10, 10), 10, 10));
        scrollPaneTableInput = new JScrollPane();
        scrollPaneTableInput.setVerticalScrollBarPolicy(21);
        panelMain.add(scrollPaneTableInput, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 45), null, 0, false));
        tableInput = new JTable();
        scrollPaneTableInput.setViewportView(tableInput);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panel1, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonRandomInput = new JButton();
        buttonRandomInput.setText("Заполнить случайными числами");
        panel1.add(buttonRandomInput, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(100, -1), null, 0, false));
        scrollPaneTableOutput = new JScrollPane();
        scrollPaneTableOutput.setEnabled(true);
        scrollPaneTableOutput.setVerticalScrollBarPolicy(21);
        panelMain.add(scrollPaneTableOutput, new GridConstraints(9, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 150), null, 0, false));
        tableOutput = new JTable();
        tableOutput.setEnabled(true);
        scrollPaneTableOutput.setViewportView(tableOutput);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panel2, new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        выполнитьЧерезВстроенныеМетодыButton = new JButton();
        выполнитьЧерезВстроенныеМетодыButton.setText("Выполнить через встроенные методы");
        panel2.add(выполнитьЧерезВстроенныеМетодыButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        выполнитьЧерезСвязанныеСпискиButton = new JButton();
        выполнитьЧерезСвязанныеСпискиButton.setText("Выполнить через связанные списки");
        panel2.add(выполнитьЧерезСвязанныеСпискиButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollPaneTableInputFinal = new JScrollPane();
        scrollPaneTableInputFinal.setVerticalScrollBarPolicy(21);
        panelMain.add(scrollPaneTableInputFinal, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 45), null, 0, false));
        tableInputFinal = new JTable();
        scrollPaneTableInputFinal.setViewportView(tableInputFinal);
        final JLabel label1 = new JLabel();
        label1.setText("начальная точка");
        panelMain.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("конечная точка");
        panelMain.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollPaneTableOutput2 = new JScrollPane();
        scrollPaneTableOutput2.setVerticalScrollBarPolicy(21);
        panelMain.add(scrollPaneTableOutput2, new GridConstraints(7, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 40), null, 0, false));
        tableOutput2 = new JTable();
        scrollPaneTableOutput2.setViewportView(tableOutput2);
        final JLabel label3 = new JLabel();
        label3.setText("количество затраченных ходов");
        panelMain.add(label3, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("\"дорога\" фигуры");
        panelMain.add(label4, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
