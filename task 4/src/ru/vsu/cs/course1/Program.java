package ru.vsu.cs.course1;

import ru.vsu.cs.util.SwingUtils;
import java.util.Locale;

public class Program {

    /**
     * ЗАДАЧА №29 из файла, который загружен на мудл
     *
     * Модифицировать алгоритм сортировки выбором (SelectionSort) таким образом, чтобы можно
     * было сортировать элементы массива из заданного диапазона элементов (от from до to,
     * где from – индекс первого элемента диапазона, to – индекс элемента, следующего за
     * последним элементом диапазона.
     */
    
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);
        //SwingUtils.setLookAndFeelByName("Windows");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
}

