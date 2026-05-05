import javax.swing.JOptionPane;

public class AccountTest {
    public static void main(String[] args) {
        
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.53);

        String welcomeMessage = String.format("%s balance: $%.2f%n%s balance: $%.2f",
                account1.getName(), account1.getBalance(),
                account2.getName(), account2.getBalance());
        
        JOptionPane.showMessageDialog(null, welcomeMessage);

        String inputAmount = JOptionPane.showInputDialog("Enter deposit amount for account1:");
        
        double depositAmount = Double.parseDouble(inputAmount);

        account1.deposit(depositAmount);

        String finalMessage = String.format("Adding %.2f to account1 balance.%n%n" +
                "New balances:%n%s: $%.2f%n%s: $%.2f",
                depositAmount,
                account1.getName(), account1.getBalance(),
                account2.getName(), account2.getBalance());

        JOptionPane.showMessageDialog(null, finalMessage);
    }
}