package lotto2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class lottFelulet extends JFrame implements ActionListener, MouseListener{
    private JPanel mainPanel;
    private List<JButton> gombLista;
    private Lotto lotto;
    private JButton sorsolButton;
    public lottFelulet(Lotto lotto) {
        this.lotto = lotto;
        init();
    }
    public void init(){
        this.setTitle("Lottó");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.mainPanel = (JPanel) this.getContentPane();
        this.mainPanel.setLayout(null);
        this.gombLista = new ArrayList<>();
        int osztas = 10;
        do {
            osztas--;
        } while (lotto.getMaxSzamok() %osztas != 0);
        
        int szamlalo = 1;
        for (int i = 0; i <lotto.getMaxSzamok(); i++) {
            int x = i / osztas;
            int y = i % osztas;
            JButton gomb = new JButton();
            gomb.setText(szamlalo+"");
            gomb.setSize(50,50);
            gomb.setLocation(20+55*y,20+55*x);
            gomb.setBorder(new LineBorder(Color.red));
            gomb.setBackground(Color.white);
            gomb.setForeground(Color.red);
            gomb.setFont(new Font("Arial",Font.BOLD,12));
            gomb.addMouseListener(this);
            this.gombLista.add(gomb);
            this.mainPanel.add(gomb);
            szamlalo++;
        }
        this.sorsolButton = new JButton();
        this.sorsolButton.setLocation(650,100);
        this.sorsolButton.setSize(130,60);
        this.sorsolButton.setText("SORSOL");
        this.mainPanel.add(sorsolButton);
        this.sorsolButton.addMouseListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource().equals(sorsolButton)) {
            System.out.println(this.lotto);
        }
        else{
            int i = 0;
            while(i<this.gombLista.size()&& !me.getSource().equals(this.gombLista.get(i))){
                i++;   
            }
            if (i<this.gombLista.size()) {
                JButton gomb = this.gombLista.get(i);
                gomb.setText("X");
                gomb.setBorder(new LineBorder(Color.green));
                gomb.setBackground(Color.white);
                gomb.setForeground(Color.green);

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        ((JButton)me.getSource()).setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        ((JButton)me.getSource()).setBackground(Color.WHITE);
    }
}
