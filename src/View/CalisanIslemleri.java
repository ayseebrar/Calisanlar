package View;
import java.util.logging.Level;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CalisanIslemleri 
{
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
  
	public CalisanIslemleri() 
{
		  String url = "jdbc:mysql://" + DataBase.host + ":" + DataBase.port + "/" + DataBase.db_ismi
				+ "?useUnicode= true&characterEncoding=utf8";
		// host port ve db_ismi ulaşmak için database bağlanmamız gerekiyor.oradaki
		// private leri public yaptık

	try 
		{

			Class.forName("com.mysql.jdbc.Driver");

		} 
	catch (ClassNotFoundException ex) 
		
		{
			System.out.println("Driver Bulunamadı....");
		}

	try 
	{
			con = DriverManager.getConnection(url, DataBase.kullanici_adi, DataBase.parola);// uygulama sabitlerimizi
																							// databaseden alıyoruz
			System.out.println("Baglanti Basarili...");

	}
	catch (SQLException ex) 
		{
			System.out.println("Baglanti Basarisiz...");
			// ex.printStackTrace();
		}

}
//şimdi bir tane giriş ekranı tasaralamaya çalışacağız eğer kullanıcı adımız ve parola doğruysa başka ekrana yöneleceğiz 
	//eğer yanlışsa hata masajı verdireceğiz 
	
	
}
