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
		
		// Oyuncu Skorunu gösterme
		oyuncu = new JLabel("Oyuncu: 0");
		oyuncu.setBounds(65,10,200,30);
		oyuncu.setFont(oyuncu.getFont().deriveFont(25.0f));
		oyuncu.setForeground(new Color(0x22a6b3));
		add(oyuncu);
		
		// Bilgisayar skoru gösterme
		bilgisayarJLabel = new JLabel("Bilgisayar: 0");
		bilgisayarJLabel.setText("Bilgisayar: 0");
		bilgisayarJLabel.setBounds(505,10,200,30);
		bilgisayarJLabel.setFont(bilgisayarJLabel.getFont().deriveFont(25.0f));
		bilgisayarJLabel.setForeground(new Color(0x22a6b3));
		add(bilgisayarJLabel);
		
		oyuncu_secim = new JLabel("Oyuncu Seçimi");	
		oyuncu_secim.setText("Oyuncu Seçimi");
		oyuncu_secim.setBounds(40,120,200,30);
		oyuncu_secim.setFont(oyuncu_secim.getFont().deriveFont(25.0f));
		oyuncu_secim.setForeground(new Color(0x30336b));
		add(oyuncu_secim);
		
		pc_secim = new JLabel("Bilgisayar Seçimi");
		pc_secim.setText("Bilgisayar Seçimi");
		pc_secim.setBounds(480,120,200,30);
		pc_secim.setFont(pc_secim.getFont().deriveFont(24.0f));
		pc_secim.setForeground(new Color(0x30336b));
		add(pc_secim);
		
		// bilgisayar random yaptigi secim
		pcJLabel = new JLabel("");
		pcJLabel.setText("");
		pcJLabel.setVisible(false);
		pcJLabel.setBounds(550,100,200,200);
		pcJLabel.setFont(pcJLabel.getFont().deriveFont(24.0f));
		add(pcJLabel);
		
		// Oyuncunun seçimi
		oyuncuJLabel = new JLabel("");
		oyuncuJLabel.setText("");
		oyuncuJLabel.setVisible(false);
		oyuncuJLabel.setBounds(97,100,200,200);
		oyuncuJLabel.setFont(oyuncuJLabel.getFont().deriveFont(24.0f));
		add(oyuncuJLabel);
		
		// Taþ butonu
		ImageIcon tasIcon = new ImageIcon("rock2.png");
		tasButton = new JButton(tasIcon);
		tasButton.setBackground(Color.white);
		tasButton.setFocusable(false);
		tasButton.setBounds(10, 400, 200, 150);
		add(tasButton);
		
		
		// Kaðýt butonu
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
		
		// Oyuna baþlama butonu
		oynaButton = new JButton();
		oynaButton.setText("Oyna");
		oynaButton.setBounds(270,180,150,50);
		oynaButton.setFocusable(false);
		add(oynaButton);

		
		// Çýkýþ butonu
		cikisButton = new JButton("CIKIS");
		cikisButton.setBounds(270,250,150,50);
		cikisButton.setFocusable(false);
		add(cikisButton);
		
		
		
		oynaButton.addActionListener(this);
		cikisButton.addActionListener(this);
		tasButton.addActionListener(this);
		kagitButton.addActionListener(this);
		makasButton.addActionListener(this);
		
		
		this.setSize(750,600); // Frame'in boyutu		
		this.getContentPane().setBackground(new Color(0xffeaa7)); // Basina 0x koyarak istedigimiz rengin kodunu yazabiliriz
		this.setResizable(false); // Frame'in boyutunun degistirilmemesi
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x'e basildiginda uygulamanin kapanmasi/sonlanmasi
		this.setLayout(null);
		this.setVisible(true);
	    this.setLocationRelativeTo(null); // Arayüz ekranin ortasinda baslar 
	}

	public static void main(String[] args) {	

		TasKagitMakas frame = new TasKagitMakas(); // frame class'inin tanimlanmasi
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(oynaButton)) {
			
			bilgisayar = (int)(Math.random() * 3);
			if (bilgisayar == 0) {
				pcJLabel.setText("TAS");
				pcJLabel.setVisible(true);
			}
			else if (bilgisayar == 1) {
				pcJLabel.setText("KAGIT");
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
			oyuncuJLabel.setText("TAS");
			oyuncuJLabel.setVisible(true);
			human = 0;
		}
		else if (e.getSource().equals(kagitButton)) {
			oyuncuJLabel.setText("KAGIT");
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
			JOptionPane.showMessageDialog(oynaButton, "Bilgisayar Kazandi");
			pcJLabel.setVisible(false);
			oyuncuJLabel.setVisible(false);
			
			bilgisayar_puan++;
			bilgisayarJLabel.setText("Bilgisayar: " + bilgisayar_puan);
			
			if (bilgisayar_puan == 5) {
				JOptionPane.showMessageDialog(null, "Oyunun Kazanini Bilgisayar oldu...");
				System.exit(0);
			}
		}
		else if (human == 0 && bilgisayar == 2 || human == 1 && bilgisayar == 0 || human == 2 && bilgisayar == 1) {
			JOptionPane.showMessageDialog(oynaButton, "Oyuncu Kazandi");
			pcJLabel.setVisible(false);
			oyuncuJLabel.setVisible(false);
			
			oyuncu_puan++;
			oyuncu.setText("Oyuncu: " + oyuncu_puan);
			
			if (oyuncu_puan == 5) {		
				JOptionPane.showMessageDialog(null, "Oyunun Kazanini Oyuncu oldu...");
				System.exit(0);
			}
		}
	}
}
