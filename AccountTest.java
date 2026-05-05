import javax.swing.JOptionPane;

public class AccountTest {
    public static void main(String[] args) {
        // Cria um objeto Account inicial
        Account myAccount = new Account("João Silva", 50.00);

        // Exibe saldo inicial
        String message = String.format("Nome: %s\nSaldo Inicial: R$ %.2f", 
                myAccount.getName(), myAccount.getBalance());
        JOptionPane.showMessageDialog(null, message);

        // Pede um valor de depósito via interface gráfica
        String input = JOptionPane.showInputDialog("Quanto deseja depositar?");
        double depositAmount = Double.parseDouble(input);

        // Realiza o depósito
        myAccount.deposit(depositAmount);

        // Exibe o saldo atualizado
        String finalMessage = String.format("Novo saldo de %s: R$ %.2f", 
                myAccount.getName(), myAccount.getBalance());
        JOptionPane.showMessageDialog(null, finalMessage);
    }
}