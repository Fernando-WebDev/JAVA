import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckOfCardsGUI extends JFrame {
    private DeckOfCards baralho;
    private JTable tabelaCartas;
    private DefaultTableModel modeloTabela;

    public DeckOfCardsGUI() {
        // Configurações iniciais da janela (JFrame)
        super("Sistema de Baralho Digital - IFAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 400);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout(10, 10));

        // Inicializa o sistema do baralho
        baralho = new DeckOfCards();
        baralho.shuffle(); // Embaralha inicialmente [cite: 137]

        // Configuração da Tabela para exibir em 4 colunas 
        String[] colunas = {"Coluna 1", "Coluna 2", "Coluna 3", "Coluna 4"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaCartas = new JTable(modeloTabela);
        tabelaCartas.setRowHeight(22); // Melhora o espaçamento visual das linhas
        tabelaCartas.setEnabled(false); // Desabilita edição direta nas células

        // Adiciona barra de rolagem para a tabela se necessário
        JScrollPane scrollPane = new JScrollPane(tabelaCartas);
        add(scrollPane, BorderLayout.CENTER);

        // Criando o botão de ação para embaralhar novamente
        JButton botaoEmbaralhar = new JButton("Embaralhar e Distribuir");
        botaoEmbaralhar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoEmbaralhar.setBackground(new Color(34, 139, 34)); // Verde floresta
        botaoEmbaralhar.setForeground(Color.WHITE);
        
        // Painel inferior para acomodar o botão
        JPanel painelBotao = new JPanel();
        painelBotao.add(botaoEmbaralhar);
        add(painelBotao, BorderLayout.SOUTH);

        // Preenche a tabela com as cartas pela primeira vez
        atualizarTabela();

        // Evento do botão: re-embaralha e atualiza a interface gráfica
        botaoEmbaralhar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baralho.shuffle(); // Embaralha as cartas [cite: 137]
                atualizarTabela();  // Redesenha as linhas na tabela
            }
        });
    }

    // Método auxiliar para distribuir as 52 cartas no grid de 4 colunas 
    private void atualizarTabela() {
        modeloTabela.setRowCount(0); // Limpa a tabela anterior

        // Como são 52 cartas em 4 colunas, teremos exatamente 13 linhas (52 / 4 = 13) 
        for (int linha = 0; linha < 13; linha++) {
            String[] linhaCartas = new String[4];
            for (int col = 0; col < 4; col++) {
                Card carta = baralho.dealCard(); // Distribui a carta [cite: 139]
                linhaCartas[col] = (carta != null) ? carta.toString() : ""; 
            }
            modeloTabela.addRow(linhaCartas); // Adiciona a linha na interface gráfica
        }
    }

    // Método principal para rodar a aplicação gráfica
    public static void main(String[] args) {
        // Garante que a GUI seja executada na thread correta de eventos do Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DeckOfCardsGUI().setVisible(true);
            }
        });
    }
}