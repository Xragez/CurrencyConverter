import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.ArrayList;

public class View implements ViewInterface{
    private Controller controller;
    private JButton button = new JButton("Zamień");
    private JComboBox<Object> currencyCBox1;
    private JComboBox<Object> currencyCBox2;
    private JLabel resultLabel = new JLabel();
    private JTextArea amountText = new JTextArea(1, 3);
    @Override
    public void updateView(String result) {
        resultLabel.setText(result);
    }

    @Override
    public void init(ArrayList<String> currencyNames) {
        JFrame frame = new JFrame();
        JPanel pstart = new JPanel();
        JPanel center = new JPanel();
        JPanel value = new JPanel();
        JPanel pend = new JPanel();
        JLabel title = new JLabel("Zamiania walut");
        JLabel text1 = new JLabel(" na ");
        Object[] currencyName = currencyNames.toArray();
        currencyCBox1 = new JComboBox<>(currencyName);
        currencyCBox2 = new JComboBox<>(currencyName);
        amountText.setPreferredSize(new Dimension(50,20));
        frame.setLayout(new BorderLayout());
        frame.setSize(new Dimension(550, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        center.add(currencyCBox1);
        center.add(text1);
        center.add(currencyCBox2);
        value.add(amountText);
        center.add(value);
        center.add(resultLabel);
        pstart.add(title);
        pend.add(button);
        frame.add(pstart, BorderLayout.PAGE_START);
        frame.add(center, BorderLayout.CENTER);
        frame.add(pend, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

    public void AddListener(Controller controller){
        this.controller = controller;
        button.addActionListener(actionEvent -> controller.updateView(Double.parseDouble(amountText.getText()),
                currencyCBox1.getSelectedItem().toString(), currencyCBox2.getSelectedItem().toString()));
    }
}
