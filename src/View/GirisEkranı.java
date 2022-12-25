package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Helper.*;
public class GirisEkranı extends JFrame {
 CalisanIslemleri islemler = new CalisanIslemleri();
	private JPanel w_pane;
	private JTextField kullanıcı_alanı;
	private JTextField kullanıc_adi_alanı;
	private JPasswordField parola_alanı;
	private JPasswordField parola_alani1;
    private JButton giris;
    private JLabel uyari;
    private JLabel uyari1;
    private DataBase  conn= new DataBase();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkranı frame = new GirisEkranı();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GirisEkranı() {
		setTitle("Şirket Çalışanları Giriş");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 441);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(255, 255, 255));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lb_logo = new JLabel(new ImageIcon(getClass().getResource("Toyota-Logo1.jpg")));
		lb_logo.setBounds(87, 10, 318, 125);
		w_pane.add(lb_logo);
		
		JLabel lb_yazı = new JLabel("Şirket Yönetim Sistemine Hoşgeldiniz");
		lb_yazı.setBounds(97, 145, 403, 35);
		lb_yazı.setForeground(new Color(206, 0, 0));
		lb_yazı.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lb_yazı.setBackground(Color.WHITE);
		w_pane.add(lb_yazı);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 190, 452, 204);
		w_pane.add(tabbedPane);
		
		JPanel pn_bir = new JPanel();
		pn_bir.setForeground(new Color(0, 0, 255));
		pn_bir.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Çalışan Girişi", null, pn_bir, null);
		pn_bir.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı :");
		lblNewLabel.setBounds(23, 10, 137, 32);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		pn_bir.add(lblNewLabel);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(23, 52, 137, 32);
		lblParola.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		pn_bir.add(lblParola);
		
		kullanıcı_alanı = new JTextField();
		kullanıcı_alanı.setBounds(190, 8, 189, 38);
		kullanıcı_alanı.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		kullanıcı_alanı.setColumns(10);
		pn_bir.add(kullanıcı_alanı);
		
		JButton btnNewButton = new JButton("Giriş");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kullanıcı_alanı.getText().length()==0||parola_alani1.getText().length()==0)
				{
					Helper.showMsg("fill");
					}else {
				
				
				
					
					try {
						Connection con =conn.connDb();
						Statement st=(Statement) con.createStatement();
						ResultSet rs= st.executeQuery("SELECT*FROM kullanici_adi");
						while(rs.next()) {
							if(kullanıcı_alanı.getText().equals(rs.getString("kullanıcı adı")) && parola_alani1.getText().equals(rs.getString("parola"))){
								
							}
						}
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					}
				
			}
			
			
		});
		
		

			

		
		btnNewButton.setBounds(232, 124, 149, 43);
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		pn_bir.add(btnNewButton);
		
		parola_alani1 = new JPasswordField();
		parola_alani1.setBounds(190, 50, 189, 38);
		parola_alani1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		pn_bir.add(parola_alani1);
		
		JLabel uyari = new JLabel("");
		uyari.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		uyari.setForeground(new Color(240, 0, 0));
		uyari.setBounds(67, 94, 254, 18);
		pn_bir.add(uyari);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Yönetici Girişi", null, panel, null);
		panel.setLayout(null);
	
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_1.setBounds(23, 10, 137, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Parola :");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_2.setBounds(23, 52, 137, 32);
		panel.add(lblNewLabel_2);
		
		kullanıc_adi_alanı = new JTextField();
		kullanıc_adi_alanı.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		kullanıc_adi_alanı.setColumns(10);
		kullanıc_adi_alanı.setBounds(190, 8, 189, 38);
		panel.add(kullanıc_adi_alanı);
		
		JButton btnNewButton_1 = new JButton("Giriş");
		
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnNewButton_1.setBounds(233, 124, 149, 43);
		panel.add(btnNewButton_1);
		
		parola_alanı = new JPasswordField();
		parola_alanı.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		parola_alanı.setBounds(190, 50, 189, 38);
		panel.add(parola_alanı);
		
		JLabel uyari1 = new JLabel("");
		uyari1.setForeground(new Color(240, 0, 0));
		uyari1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		uyari1.setBounds(67, 94, 254, 18);
		panel.add(uyari1);
	}
}
