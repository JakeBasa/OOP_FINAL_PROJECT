import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Dormitory extends JDialog {

    Information_Inheritance info = new Information_Inheritance();
    String firstName, lastName, middleInitial, gender, guardianName, contactNo, name, method, selectedDiscount, customerType, inputPayment;
    int count = 0, xrow = 0, yesNo;

    Object[] discountChoices ={"STUDENT", "SENIOR CITIZEN"};

    Object inputDiscount;

    double amount = 0.0, discount = 0.0, payment, change, discountedAmount;


    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JTextField fnameTxt;
    private JTextField lnameTxt;
    private JTextField middleTxt;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField guardianTxt;
    private JTable table1;
    private JButton ADDINFORMATIONButton;
    private JTable table2;
    private JComboBox studentCombo;
    private JComboBox comboBox2;
    private JRadioButton dayRadioButton;
    private JRadioButton weekRadioButton;
    private JRadioButton monthRadioButton;
    private JTextField amountText;
    private JButton PAYButton;
    private JButton ADDSTUDENTButton;
    private JTable table3;
    private JTextField contactTxt;

    public Dormitory() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        ADDINFORMATIONButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });

        maleRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onMale();
            }
        });

        femaleRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onFemale();
            }
        });

        dayRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDay();
            }
        });

        weekRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onWeek();
            }
        });

        monthRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onMonth();
            }
        });

        PAYButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPay();
            }
        });

        ADDSTUDENTButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddStudent();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        table1.setModel(new DefaultTableModel(null, new String[] {"StudentNo", "Name", "Gender", "GuardianName", "Contact"}
        ));

        table2.setModel(new DefaultTableModel(null, new String[] {"RoomNo", "Slots"}
        ));

        table3.setModel(new DefaultTableModel(null, new String[] {" ", "Name", "RoomNo"}
        ));
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onAdd() {
        DefaultTableModel studentList = (DefaultTableModel)table1.getModel();
        firstName = fnameTxt.getText();
        lastName = lnameTxt.getText();
        middleInitial = middleTxt.getText();
        guardianName = guardianTxt.getText();
        contactNo = contactTxt.getText();

        name = lastName + ", " + firstName + " " + middleInitial;
        count++;

        Object[] row = {count, name, gender, guardianName, contactNo};
        studentList.addRow(row);
        studentCombo.insertItemAt(studentList.getValueAt(xrow,1).toString(),xrow);
        xrow++;
    }

    private void onMale() {
        gender = "Male";
    }

    private void onFemale() {
        gender = "Female";
    }

    private void onDay() {
        method = "Day";
        amount = 25.00;
        amountText.setText(String.valueOf(amount));
    }

    private void onWeek() {
        method = "Week";
        amount = 170.00;
        amountText.setText(String.valueOf(amount));
    }

    private void onMonth() {
        method = "Month";
        amount = 1200.00;
        amountText.setText(String.valueOf(amount));
    }

    private void onPay() {
        yesNo = JOptionPane.showConfirmDialog(null, "Are there any discount?", "PAYMENT",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if(yesNo == 0){
            inputDiscount = JOptionPane.showInputDialog(null, "Choose customer: ", "Payment",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    discountChoices,
                    discountChoices[0]);

            selectedDiscount = inputDiscount.toString();

            if(selectedDiscount == "STUDENT"){
                customerType = "STUDENT";
                discount = 0.10;
                discountedAmount = info.getNewAmount(amount, discount);
                inputPayment = JOptionPane.showInputDialog("Amount: " + amount + "\nDiscount: " + discount + "\nNew Amount: " + discountedAmount + "\nEnter cash:");
                payment = Double.parseDouble(inputPayment);

                if(payment < discountedAmount){
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT FUNDS");
                }

                else{
                    change = info.computeTransaction(payment, discountedAmount);
                    JOptionPane.showMessageDialog(null, "\nAmount: " + discountedAmount +
                            "\nPayment: " + payment + "\nChange: " + change);
                }
            }

            else if(selectedDiscount == "SENIOR CITIZEN"){
                customerType = "SENIOR CITIZEN";
                discount = 0.20;
                discountedAmount = info.getNewAmount(amount, discount);
                inputPayment = JOptionPane.showInputDialog("Amount: " + amount + "\nDiscount: " + discount + "\nNew Amount: " + discountedAmount + "\nEnter cash:");
                payment = Double.parseDouble(inputPayment);

                if(payment < discountedAmount){
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT FUNDS");
                }

                else{
                    change = info.computeTransaction(payment, discountedAmount);
                    JOptionPane.showMessageDialog(null, "\nAmount: " + discountedAmount +
                            "\nPayment: " + payment + "\nChange: " + change);
                }


            }


        }
    }

    private void onAddStudent() {
        method = "Month";
    }




    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public static void main(String[] args) {
        Dormitory dialog = new Dormitory();
        dialog.pack();
        dialog.setBounds(300,200,1000,600);
        dialog.setVisible(true);
        System.exit(0);
    }
}
