import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TasKagitMakas extends JFrame implements ActionListener{
	
	JButton tasButton,kagitButton,makasButton,oynaButton,devamButton,cikisButton;
	JLabel oyuncu,bilgisayarJLabel,oyuncu_secim,pc_secim,pcJLabel,oyuncuJLabel;
	int bilgisayar = 0,bilgisayar_puan = 0, oyuncu_puan = 0;
	int human;
	


	public TasKagitMakas() {
		
		// Oyuncu Skorunu g�sterme
		oyuncu = new JLabel("Oyuncu: 0");
		oyuncu.setBounds(65,10,200,30);
		oyuncu.setFont(oyuncu.getFont().deriveFont(25.0f));
		oyuncu.setForeground(new Color(0x22a6b3));
		add(oyuncu);
		
		// Bilgisayar skoru g�sterme
		bilgisayarJLabel = new JLabel("Bilgisayar: 0");
		bilgisayarJLabel.setText("Bilgisayar: 0");
		bilgisayarJLabel.setBounds(505,10,200,30);
		bilgisayarJLabel.setFont(bilgisayarJLabel.getFont().deriveFont(25.0f));
		bilgisayarJLabel.setForeground(new Color(0x22a6b3));
		add(bilgisayarJLabel);
		
		oyuncu_secim = new JLabel("Oyuncu Se�imi");	
		oyuncu_secim.setText("Oyuncu Se�imi");
		oyuncu_secim.setBounds(40,120,200,30);
		oyuncu_secim.setFont(oyuncu_secim.getFont().deriveFont(25.0f));
		oyuncu_secim.setForeground(new Color(0x30336b));
		add(oyuncu_secim);
		
		pc_secim = new JLabel("Bilgisayar Se�imi");
		pc_secim.setText("Bilgisayar Se�imi");
		pc_secim.setBounds(480,120,200,30);
		pc_secim.setFont(pc_secim.getFont().deriveFont(24.0f));
		pc_secim.setForeground(new Color(0x30336b));
		add(pc_secim);
		
		// bilgisayar random yapt��� se�im
		pcJLabel = new JLabel("");
		pcJLabel.setText("");
		pcJLabel.setVisible(false);
		pcJLabel.setBounds(550,100,200,200);
		pcJLabel.setFont(pcJLabel.getFont().deriveFont(24.0f));
		add(pcJLabel);
		
		// Oyuncunun se�imi
		oyuncuJLabel = new JLabel("");
		oyuncuJLabel.setText("");
		oyuncuJLabel.setVisible(false);
		oyuncuJLabel.setBounds(97,100,200,200);
		oyuncuJLabel.setFont(oyuncuJLabel.getFont().deriveFont(24.0f));
		add(oyuncuJLabel);
		
		// Ta� butonu
		ImageIcon tasIcon = new ImageIcon("rock2.png");
		tasButton = new JButton(tasIcon);
		tasButton.setBackground(Color.white);
		tasButton.setFocusable(false);
		tasButton.setBounds(10, 400, 200, 150);
		add(tasButton);
		
		
		// Ka��t butonu
		ImageIcon kagitIcon = new ImageIcon("paper2.png");
		kagitButton = new JButton(kagitIcon);
		kagitButton.setBackground(Color.white);
		kagitButton.setFocusable(false);
		kagitButton.setBounds(260, 400, 200, 150);
		add(kagitButton);
		
		// Makas butonu
		ImageIcon makasIcon = new ImageIcon("scissors2.png");
		makasButton = new JButton(makasIcon);
		makasButton.setBackground(Color.white);
		makasButton.setFocusable(false);
		makasButton.setBounds(510,400,200,150);
		add(makasButton);
		
		// Oyuna ba�lama butonu
		oynaButton = new JButton();
		oynaButton.setText("Oyna");
		oynaButton.setBounds(270,180,150,50);
		oynaButton.setFocusable(false);
		add(oynaButton);

		
		// ��k�� butonu
		cikisButton = new JButton("��k��");
		cikisButton.setBounds(270,250,150,50);
		cikisButton.setFocusable(false);
		add(cikisButton);
		
		
		
		oynaButton.addActionListener(this);
		cikisButton.addActionListener(this);
		tasButton.addActionListener(this);
		kagitButton.addActionListener(this);
		makasButton.addActionListener(this);
		
		
		this.setSize(750,600); // Frame'in boyutu		
		this.getContentPane().setBackground(new Color(0xffeaa7)); // Ba��na 0x koyarak istedi�imiz rengin kodunu yazabiliriz
		this.setResizable(false); // Frame'in boyutunun de�i�tirilmemesi
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x'e bas�ld���nda uygulaman�n kapanmas�/sonlanmas�
		this.setLayout(null);
		this.setVisible(true);
	    this.setLocationRelativeTo(null); // Aray�z ekran�n ortas�nda ba�lar 
	}

	public static void main(String[] args) {	

		TasKagitMakas frame = new TasKagitMakas(); // frame class'�n�n tan�mlanmas�
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(oynaButton)) {
			
			bilgisayar = (int)(Math.random() * 3);
			if (bilgisayar == 0) {
				pcJLabel.setText("TA�");
				pcJLabel.setVisible(true);
			}
			else if (bilgisayar == 1) {
				pcJLabel.setText("KA�IT");
				pcJLabel.setVisible(true);
			}
			else {
				pcJLabel.setText("MAKAS");
				pcJLabel.setVisible(true);
			}
			kontrol();
		}
		
		else if (e.getSource().equals(cikisButton)) {
			System.exit(0);
		}

		else if (e.getSource().equals(tasButton)) {
			oyuncuJLabel.setText("TA�");
			oyuncuJLabel.setVisible(true);
			human = 0;
		}
		else if (e.getSource().equals(kagitButton)) {
			oyuncuJLabel.setText("KA�IT");
			oyuncuJLabel.setVisible(true);
			human = 1;
		}
		else if (e.getSource().equals(makasButton)) {
			oyuncuJLabel.setText("MAKAS");
			oyuncuJLabel.setVisible(true);
			human = 2;
		}
	}
	public void kontrol() {
		if (human == 0 && bilgisayar == 0 || human == 1 && bilgisayar == 1 || human == 2 && bilgisayar == 2) {
			JOptionPane.showMessageDialog(oynaButton, "Berabere");
			pcJLabel.setVisible(false);
			oyuncuJLabel.setVisible(false);
		}
		else if (human == 0 && bilgisayar == 1 || human == 1 && bilgisayar == 2 || human == 2 && bilgisayar == 0) {
			JOptionPane.showMessageDialog(oynaButton, "Bilgisayar Kazand�");
			pcJLabel.setVisible(false);
			oyuncuJLabel.setVisible(false);
			
			bilgisayar_puan++;
			bilgisayarJLabel.setText("Bilgisayar: " + bilgisayar_puan);
			
			if (bilgisayar_puan == 5) {
				JOptionPane.showMessageDialog(null, "Oyunun Kazan�n� Bilgisayar oldu...");
				System.exit(0);
			}
		}
		else if (human == 0 && bilgisayar == 2 || human == 1 && bilgisayar == 0 || human == 2 && bilgisayar == 1) {
			JOptionPane.showMessageDialog(oynaButton, "Oyuncu Kazand�");
			pcJLabel.setVisible(false);
			oyuncuJLabel.setVisible(false);
			
			oyuncu_puan++;
			oyuncu.setText("Oyuncu: " + oyuncu_puan);
			
			if (oyuncu_puan == 5) {		
				JOptionPane.showMessageDialog(null, "Oyunun Kazan�n� Oyuncu oldu...");
				System.exit(0);
			}
		}
	}
}