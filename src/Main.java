import javax.swing.SwingUtilities;
import view.ClienteForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteForm().setVisible(true));
    }
}