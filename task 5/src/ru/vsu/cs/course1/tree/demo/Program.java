package ru.vsu.cs.course1.tree.demo;


import java.util.Locale;
import javax.swing.UIManager;
import ru.vsu.cs.util.SwingUtils;

public class Program {

    /**
     *ЗАДАНИЕ №9 из файла, который загружен на мудл
     *
     * Для двоичного дерева реализовать метод, который будет возвращать уровень дерева, в
     * котором больше всего элементов. Учитывая, что может быть несколько уровней, в
     * которых максимальное кол-во элементов, следует найти все такие уровни (вернуть в
     * виде списка номеров уровней).
     */

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);

        //SwingUtils.setLookAndFeelByName("Windows");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //SwingUtils.setDefaultFont(null, 20);
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreeDemoFrame().setVisible(true);
            }
        });
    }
}
