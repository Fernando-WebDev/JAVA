import javax.swing.JOptionPane;

public class AccountTest {
    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Digite seu nome de usuario: ");

        Account account1 = new Account(name, 50.00);
        Account account2 = new Account("MCloven", -7.50);

        String welcomeMessage = String.format("%s saldo: $%.2f%n%s saldo: $%.2f",
                name, account1.getBalance(),
                account2.getName(), account2.getBalance());
        
        JOptionPane.showMessageDialog(null, welcomeMessage);

        String inputAmount = JOptionPane.showInputDialog("Deposite um saldo para " + name);
        
        double depositAmount = Double.parseDouble(inputAmount);

        account1.deposit(depositAmount);

        String Message = String.format("Foi adicionado ou retirado %.2f da conta "+name+"%n%n" +
                "Novo saldo:%n%s: $%.2f%n%s: $%.2f",
                depositAmount,
                name, account1.getBalance(),
                account2.getName(), account2.getBalance());

        JOptionPane.showMessageDialog(null, Message);

        String valores = String.format("%s saldo: $%.2f%n%s saldo: $%.2f",
                name, account1.getBalance(),
                account2.getName(), account2.getBalance());
        
        JOptionPane.showMessageDialog(null, valores);

        String valor_conta2 = JOptionPane.showInputDialog("Deposite um saldo para " + account2.getName()+ ":");
    
        double deposito_conta2 = Double.parseDouble(valor_conta2);

        account2.deposit(deposito_conta2);

        String finalMessage = String.format("Foi adicionado ou retirado %.2f da conta "+account2.getName()+"%n%n" +
                "Novo saldo:%n%s: $%.2f%n%s: $%.2f",
                depositAmount,
                name, account1.getBalance(),
                account2.getName(), account2.getBalance());

        JOptionPane.showMessageDialog(null, finalMessage);
    }
}