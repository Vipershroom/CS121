import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class PizzaApp extends JFrame {
    // GUI Constants
    private JComboBox<String> pizzaComboBox;
    private JComboBox<String> sizeComboBox;
    private JCheckBox[] toppingsCheckBoxes;
    private JButton calculateButton;
    private JLabel priceLabel;

    // Menu Arrays
    private String[] pizzaOptions = {"Cheese", "Pepperoni", "Vegetarian", "BBQ Chicken"};
    private String[] sizeOptions = {"Small", "Medium", "Large", "X-Large"};
    private String[] toppingsOptions = {"Extra Cheese", "Mushrooms", "Peppers", "Onions", "Olives"};

    // Main method to initialize gui and provide functionality
    public PizzaApp() {

        // Initial GUI set up
        setTitle("BigY Store");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add the title lable to the top of the program
        JLabel titleLabel = new JLabel("BigY Store", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Handles the menu items and buttons
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(new JLabel("Select Pizza:"), gbc);
        gbc.gridx = 1;
        pizzaComboBox = new JComboBox<>(pizzaOptions);
        add(pizzaComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Select Size:"), gbc);
        gbc.gridx = 1;
        sizeComboBox = new JComboBox<>(sizeOptions);
        add(sizeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Select Toppings (Max 3):"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;


        // Initialize radio buttons
        JPanel toppingsPanel = new JPanel(new GridLayout(0, 1));
        toppingsCheckBoxes = new JCheckBox[toppingsOptions.length];
        for (int i = 0; i < toppingsOptions.length; i++) {
            toppingsCheckBoxes[i] = new JCheckBox(toppingsOptions[i]);
            toppingsCheckBoxes[i].addItemListener(new ToppingsItemListener());
            toppingsPanel.add(toppingsCheckBoxes[i]);
        }
        add(toppingsPanel, gbc);

        // Initialize calculate button and add event listener
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        calculateButton = new JButton("Calculate Price");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(calculateButton, gbc);

        gbc.gridy = 5;
        priceLabel = new JLabel();
        add(priceLabel, gbc);
    }

    // Item Listener Class
    private class ToppingsItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            int numToppings = 0;
            for (JCheckBox checkBox : toppingsCheckBoxes) {
                if (checkBox.isSelected()) {
                    numToppings++;
                }
            }
            if (numToppings >= 3) {
                for (JCheckBox checkBox : toppingsCheckBoxes) {
                    if (!checkBox.isSelected()) {
                        checkBox.setEnabled(false);
                    }
                }
            } else {
                for (JCheckBox checkBox : toppingsCheckBoxes) {
                    checkBox.setEnabled(true);
                }
            }
        }
    }

    private class CalculateButtonListener implements ActionListener {
        // Performs calculations once the button is pressed
        @Override
        public void actionPerformed(ActionEvent e) {
            double price = 0.0;

            // Base price based on size
            switch (sizeComboBox.getSelectedIndex()) {
                case 0:
                    price += 5.0;
                    break;
                case 1:
                    price += 10.0;
                    break;
                case 2:
                    price += 15.0;
                    break;
                case 3:
                    price += 20.0;
                    break;
            }

            // Additional charge for toppings
            int numToppings = 0;
            for (JCheckBox checkBox : toppingsCheckBoxes) {
                if (checkBox.isSelected()) {
                    numToppings++;
                }
            }

            // Deal for three toppings
            if (numToppings > 0) {
                if (numToppings <= 2) {
                    price += 0.50 * numToppings;
                } else {
                    price += 1.25;
                }
            }

            priceLabel.setText("Total Price: $" + price);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PizzaApp app = new PizzaApp();
            app.setVisible(true);
        });
    }
}

//Creativity:
//- Food items in array
//- Event listener to black out the radio boxes
// Used Grid Bag layout to create a simple veritcal layout that supports multiple window sizes