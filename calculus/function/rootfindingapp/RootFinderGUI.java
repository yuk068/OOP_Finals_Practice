package yukwork.calculus.function.rootfindingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class RootFinderGUI extends JFrame implements ActionListener {

    private final JTextField functionField;
    private final JTextField rangeAField;
    private final JTextField rangeBField;
    private final JTextField toleranceField;
    private final JTextField resultField;
    private final JButton refreshButton;
    private final JButton bisectionButton;
    private final JButton newtonRaphsonButton;
    private final JButton secantButton;

    public RootFinderGUI() {
        setTitle("Root Finding");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 5));

        JLabel functionLabel = new JLabel("Function f(x): ");
        functionField = new JTextField();
        JLabel rangeLabel = new JLabel("Initial guess or range (a): ");
        rangeAField = new JTextField();
        rangeBField = new JTextField();
        JLabel toleranceLabel = new JLabel("Tolerance: ");
        toleranceField = new JTextField();
        refreshButton = new JButton("Refresh");
        bisectionButton = new JButton("Bisection Method");
        newtonRaphsonButton = new JButton("Newton-Raphson Method");
        secantButton = new JButton("Secant Method");

        refreshButton.addActionListener(this);
        bisectionButton.addActionListener(this);
        newtonRaphsonButton.addActionListener(this);
        secantButton.addActionListener(this);

        add(functionLabel);
        add(functionField);
        add(rangeLabel);
        add(rangeAField);
        add(new JLabel("Initial guess or range (b): "));
        add(rangeBField);
        add(toleranceLabel);
        add(toleranceField);
        add(bisectionButton);
        add(secantButton);
        add(newtonRaphsonButton);
        add(refreshButton);

        JLabel resultLabel = new JLabel("Root: ");
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultLabel);
        add(resultField);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refreshButton) {
            functionField.setText("");
            rangeAField.setText("");
            rangeBField.setText("");
            toleranceField.setText("");
            resultField.setText("");
        } else if (e.getSource() == bisectionButton ||
                e.getSource() == newtonRaphsonButton ||
                e.getSource() == secantButton) {
            String functionExpr;
            double a, b, tol;
            try {
                functionExpr = functionField.getText();
                a = Double.parseDouble(rangeAField.getText());
                b = Double.parseDouble(rangeBField.getText());
                tol = Double.parseDouble(toleranceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please fill out all the fields.");
                return;
            }

            try {
                assert functionExpr != null;
                Function<Double, Double> func = FunctionEvaluator.createFunction(functionExpr.toLowerCase());
                RootFinder rootFinder = getRootFindingMethod(e);

                double root = rootFinder.findRoot(func, a, b, tol);
                resultField.setText(Double.toString(root));
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong during calculation.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numeric values.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Undefined function or calculation failure. Please check your input.");
            }
        }

    }

    private RootFinder getRootFindingMethod(ActionEvent e) {
        RootFindingStrategy strategy;

        if (e.getSource() == bisectionButton) {
            strategy = new BisectionMethod();
        } else if (e.getSource() == newtonRaphsonButton) {
            strategy = new NewtonRaphsonMethod();
        } else if (e.getSource() == secantButton) {
            strategy = new SecantMethod();
        } else {
            strategy = new BisectionMethod();
        }

        RootFinder rootFinder = new RootFinder();
        rootFinder.setStrategy(strategy);
        return rootFinder;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RootFinderGUI::new);
    }

}
