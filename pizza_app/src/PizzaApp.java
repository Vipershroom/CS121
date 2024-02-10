import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PizzaApp extends JFrame {
    // GUI Constants
    private JComboBox<String> pizzaComboBox;
    private JComboBox<String> sizeComboBox;
    private JCheckBox[] toppingsCheckBoxes;
    private JButton calculateBtn;
    private JLabel priceLabel;

    // Menu Arrays
    private String[] pizzaTypes = {"Cheese", "Pepperoni", "Vegetarian", "BBQ Chicken"};
    private String[] sizes = {"Small", "Medium", "Large", "X-Large"};
    private String[] toppings = {"Extra Cheese", "Mushrooms", "Peppers", "Onions", "Olives"};

    // Main method to initialize gui and provide functionality
    public PizzaApp() {

        // Initial GUI set up
        setTitle("BigY Store");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(10, 10, 10, 10);

        // Add the title label to the top of the program
        JLabel titleLabel = new JLabel("BigY Store", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 2;
        add(titleLabel, grid);

        // Handles the menu items and buttons
        grid.gridwidth = 1;
        grid.gridy = 1;
        add(new JLabel("Select Pizza:"), grid);
        grid.gridx = 1;
        pizzaComboBox = new JComboBox<>(pizzaTypes);
        add(pizzaComboBox, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        add(new JLabel("Select Size:"), grid);
        grid.gridx = 1;
        sizeComboBox = new JComboBox<>(sizes);
        add(sizeComboBox, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        add(new JLabel("Select Toppings (Max 3):"), grid);
        grid.gridx = 1;
        grid.gridy = 3;
        grid.gridwidth = 2;


        // Initialize radio buttons
        JPanel toppingsPanel = new JPanel(new GridLayout(0, 1));
        toppingsCheckBoxes = new JCheckBox[toppings.length];
        for (int i = 0; i < toppings.length; i++) {
            toppingsCheckBoxes[i] = new JCheckBox(toppings[i]);
            toppingsCheckBoxes[i].addItemListener(new ToppingsItemListener());
            toppingsPanel.add(toppingsCheckBoxes[i]);
        }
        add(toppingsPanel, grid);

        // Initialize calculate button and add event listener
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 2;
        grid.fill = GridBagConstraints.NONE;
        calculateBtn = new JButton("Calculate Price");
        calculateBtn.addActionListener(new CalculateButtonListener());
        add(calculateBtn, grid);

        grid.gridy = 5;
        priceLabel = new JLabel();
        add(priceLabel, grid);
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