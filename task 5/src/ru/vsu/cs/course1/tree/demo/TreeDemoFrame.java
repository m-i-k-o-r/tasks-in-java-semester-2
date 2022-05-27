package ru.vsu.cs.course1.tree.demo;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import ru.vsu.cs.course1.tree.BinaryTreeAlgorithms;
import ru.vsu.cs.course1.tree.SimpleBinaryTree;
import ru.vsu.cs.course1.tree.BinaryTreePainter;
import ru.vsu.cs.course1.tree.BinaryTree;
import ru.vsu.cs.course1.tree.bst.BSTree;
import ru.vsu.cs.course1.tree.bst.SimpleBSTree;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class TreeDemoFrame extends JFrame {
    private JPanel panelMain;
    private JTextField textFieldValues;
    private JSpinner spinnerRandomCount;
    private JButton buttonRandomGenerate;
    private JButton buttonMakeBSTree2;
    private JPanel panelPaintArea;
    private JTable tableOutPut;

    private JMenuBar menuBarMain;
    private JPanel paintPanel = null;
    private JFileChooser fileChooserSave;

    BinaryTree<Integer> tree = new SimpleBinaryTree<>();


    public TreeDemoFrame() {
        this.setTitle("Двоичные деревья");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableOutPut, 40, false, false, false, false);
        tableOutPut.setRowHeight(25);


        paintPanel = new JPanel() {
            private Dimension paintSize = new Dimension(0, 0);

            @Override
            public void paintComponent(Graphics gr) {
                super.paintComponent(gr);
                paintSize = BinaryTreePainter.paint(tree, gr);
                if (!paintSize.equals(this.getPreferredSize())) {
                    SwingUtils.setFixedSize(this, paintSize.width, paintSize.height);
                }
            }
        };
        JScrollPane paintJScrollPane = new JScrollPane(paintPanel);
        panelPaintArea.add(paintJScrollPane);

        spinnerRandomCount.setValue(30);

        buttonRandomGenerate.addActionListener(actionEvent -> {
            int size = ((Integer) spinnerRandomCount.getValue()).intValue();
            int[] arr = ArrayUtils.createRandomIntArray(size, (size <= 50) ? 100 : 1000);
            textFieldValues.setText(ArrayUtils.toString(arr));
        });

        buttonMakeBSTree2.addActionListener(actionEvent -> {
            try {
                makeBSTFromValues(new SimpleBSTree<>(Integer::parseInt));
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }

            try {
                int[] sizeTree = {0};
                BinaryTreeAlgorithms.preOrderVisit(tree.getRoot(), (value, level) -> {
                    if (sizeTree[0] < level) {
                        sizeTree[0] = level;
                    }
                });

                int[] Arr = new int[sizeTree[0] + 1];

                Arr = BinaryTreeAlgorithms.largeLevel(tree.getRoot(), Arr, (value, level) -> {
                });

                int maxValue = Arr[0];
                for (int i = 1; i < Arr.length; i++) {
                    if (Arr[i] > maxValue) {
                        maxValue = Arr[i];
                    }
                }

                ArrayList<Integer> maxQuantityList = new ArrayList<>();
                for (int i = 0; i < Arr.length; i++) {
                    if (Arr[i] == maxValue) {
                        maxQuantityList.add(i);
                    }
                }

                int[] maxQuantity = new int[maxQuantityList.size()];
                for (int i = 0; maxQuantityList.size() > i; i++) {
                    maxQuantity[i] = maxQuantityList.get(i);
                }

                JTableUtils.writeArrayToJTable(tableOutPut, maxQuantity);
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
    }


    /**
     * Перерисовка дерева
     */
    public void repaintTree() {
        //panelPaintArea.repaint();
        paintPanel.repaint();
        //panelPaintArea.revalidate();
    }

    /**
     * Выполнение действия с выводом стандартного вывода в окне (textAreaSystemOut)
     *
     * @param action Выполняемое действие
     */
    private void showSystemOut(Runnable action) {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(baos, true, "UTF-8"));

            action.run();

            //textAreaSystemOut.setText(baos.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            SwingUtils.showErrorMessageBox(e);
        }
        System.setOut(oldOut);
    }

    /**
     * Заполнить дерево добавлением всех элементов (textFieldValues)
     *
     * @param tree Дерево
     */
    private void makeBSTFromValues(BSTree<Integer> tree) {
        int[] values = ArrayUtils.toIntArray(textFieldValues.getText());
        tree.clear();
        for (int v : values) {
            tree.put(v);
        }
        this.tree = tree;
        repaintTree();
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
        panelMain.setLayout(new GridLayoutManager(6, 1, new Insets(10, 10, 10, 10), 10, 10));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldValues = new JTextField();
        textFieldValues.setText("6, 8, 3, 5, 7, 2, 16, 1, 15, 12, 9");
        panel1.add(textFieldValues, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        spinnerRandomCount = new JSpinner();
        panel2.add(spinnerRandomCount, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        buttonRandomGenerate = new JButton();
        buttonRandomGenerate.setText("Сгенерировать");
        panel2.add(buttonRandomGenerate, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("cлучайных чисел");
        panel2.add(label1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonMakeBSTree2 = new JButton();
        buttonMakeBSTree2.setText("Построить дерево поиска и найти уровени с макс. кол-вом элементов");
        panel3.add(buttonMakeBSTree2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel3.add(spacer2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(14, 46), null, 0, false));
        panelPaintArea = new JPanel();
        panelPaintArea.setLayout(new BorderLayout(0, 0));
        panelMain.add(panelPaintArea, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(11, 249), null, 0, false));
        final Spacer spacer3 = new Spacer();
        panelPaintArea.add(spacer3, BorderLayout.CENTER);
        final JScrollPane scrollPane1 = new JScrollPane();
        panelMain.add(scrollPane1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 50), null, 0, false));
        tableOutPut = new JTable();
        scrollPane1.setViewportView(tableOutPut);
        final Spacer spacer4 = new Spacer();
        panelMain.add(spacer4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("дерево");
        panelMain.add(label2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("номера уровней с макс. кол-вом элементов (отсчет уровней начинается с 0)");
        panelMain.add(label3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
