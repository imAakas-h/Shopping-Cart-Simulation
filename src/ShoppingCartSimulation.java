import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShoppingCartSimulation extends JFrame implements ActionListener {
    JCheckBox laptop, phone, headphones;
    JButton generateBill, reset, discount;
    JLabel result;
    final double DISCOUNT_RATE = 0.1; // 10% discount

    public ShoppingCartSimulation() {
        setTitle("Shopping Cart");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Checkboxes with emojis/icons
        laptop = new JCheckBox("💻 Laptop - ₹60000");
        phone = new JCheckBox("📱 Phone - ₹30000");
        headphones = new JCheckBox("🎧 Headphones - ₹2000");

        // Buttons
        generateBill = new JButton("Generate Bill");
        reset = new JButton("Reset");
        discount = new JButton("Apply 10% Discount");

        // Result label
        result = new JLabel("");

        // Add components
        add(laptop);
        add(phone);
        add(headphones);
        add(generateBill);
        add(discount);
        add(reset);
        add(result);

        // Add listeners
        generateBill.addActionListener(this);
        reset.addActionListener(this);
        discount.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int total = 0;
        String items = "Selected Items: ";

        if (laptop.isSelected()) { total += 60000; items += "Laptop "; }
        if (phone.isSelected()) { total += 30000; items += "Phone "; }
        if (headphones.isSelected()) { total += 2000; items += "Headphones "; }

        if (e.getSource() == discount) {
            total = (int)(total * (1 - DISCOUNT_RATE));
        }

        if (e.getSource() == reset) {
            laptop.setSelected(false);
            phone.setSelected(false);
            headphones.setSelected(false);
            result.setText("");
            return;
        }

        result.setText("<html>" + items + "<br>Total: ₹" + total + "</html>");
    }

    public static void main(String[] args) {
        new ShoppingCartSimulation();
    }
}
