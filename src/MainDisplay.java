import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.*;

public class MainDisplay extends JFrame {
    private JDialog currencyDialog = null;
    public MainDisplay()
    {
        JLabel dayum = new JLabel("Why you here?!");
        dayum.setBounds(40, 600, 200 ,200);
        JLabel dayum2 = new JLabel("Why you here?!");
        dayum2.setBounds(1000, 600, 200 ,200);
        JLabel dayum3 = new JLabel("Why you here?!");
        dayum3.setBounds(1000, 40, 200 ,200);
        setTitle("Currency Exchange");
        JPanel mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.add(dayum);
        mainPanel.add(dayum2);
        mainPanel.add(dayum3);
        mainPanel.setLayout(null);

        mainPanel.setBackground(new Color(212, 212, 212));

        JPanel LeftPanel = new JPanel();
        mainPanel.add(LeftPanel);
        LeftPanel.setLayout(null);
        LeftPanel.setBounds(25, 25, 300, 310); // x, y, width, height


        JPanel rightPanel = new JPanel();
        mainPanel.add(rightPanel);
        rightPanel.setLayout(null);
        rightPanel.setBounds(356, 25, 300, 235); // x, y, width, height



        //LEFT

        JLabel baseC = new JLabel("Input the base currency");
        baseC.setBounds(50, 10, 200, 30);
        LeftPanel.add(baseC);
        JTextField baseCurrency = new JTextField();
        baseCurrency.setBounds(50, 45, 200, 30);
        LeftPanel.add(baseCurrency);

        JLabel targetC = new JLabel("Input the target currency");
        targetC.setBounds(50, 85, 200, 30);
        LeftPanel.add(targetC);
        JTextField targetCurrency = new JTextField();
        targetCurrency.setBounds(50, 120, 200, 30);
        LeftPanel.add(targetCurrency);

        JLabel amC = new JLabel("Input the amount of currency");
        amC.setBounds(50, 160, 200, 30);
        LeftPanel.add(amC);
        JTextField amount = new JTextField();
        amount.setBounds(50, 195, 200, 30);
        LeftPanel.add(amount);

        //RIGHT Island
        JLabel convertedShi = new JLabel("Try the exchange");
        convertedShi.setFont(new Font("Arial", Font.BOLD, 17)); // name, style, size
        convertedShi.setBounds(60, rightPanel.getWidth()/2, 250, 30); // adjust position
        rightPanel.add(convertedShi);

        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(70, 260, 160, 30);
        LeftPanel.add(convertBtn);
        convertBtn.addActionListener(e -> {
            String base = baseCurrency.getText();
            String target = targetCurrency.getText();
            String amt = amount.getText();
            try {
                String result = Exchange.Exchanger(base, target, amt); // get the converted string
                convertedShi.setText(result);

                // Center horizontally on rightPanel
                int panelWidth = rightPanel.getWidth();
                int labelWidth = convertedShi.getPreferredSize().width;
                int x = (panelWidth - labelWidth) / 2;
                convertedShi.setBounds(x, convertedShi.getY(), labelWidth, convertedShi.getHeight());
                
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });



        //RIGHT

        ImageIcon icon = new ImageIcon("../assets/logo.png");
        JLabel imgLabel = new JLabel(icon);
        imgLabel.setBounds(100, 5, 100, 100);
        Image img = icon.getImage();
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imgLabel.setIcon(new ImageIcon(img));
        rightPanel.add(imgLabel);



        JButton showCurrency = new JButton("Show all Currencies");
        showCurrency.setBounds(410, 275, 200, 50);
        mainPanel.add(showCurrency);

            showCurrency.addActionListener(Ev -> {
                try {
                    // Check if dialog already exists and is visible
                    if (currencyDialog == null || !currencyDialog.isShowing()) {
                        String allCurrencies = Exchange.getAllCurrencies();
                        JTextArea area = new JTextArea(allCurrencies);
                        area.setEditable(false);
                        area.setMargin(new Insets(5, 20, 5, 5)); // left padding
                        JScrollPane scroll = new JScrollPane(area);
                        scroll.setPreferredSize(new java.awt.Dimension(280, 400));

                        currencyDialog = new JDialog(this, "All Currencies", false); // non-modal
                        currencyDialog.add(scroll);
                        currencyDialog.pack();
                        currencyDialog.setLocationRelativeTo(this);
                        currencyDialog.setVisible(true);

                        // Dispose dialog on close so it can be reopened
                        currencyDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    } else {
                        // Optionally, bring the existing dialog to front
                        currencyDialog.toFront();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });


        
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
