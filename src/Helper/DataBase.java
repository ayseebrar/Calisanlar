package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	public static final String kullanici_adi = "root";
    public  static final String parola = "";
    
    public  static final String db_ismi = "demo";
    
    public static final String host =  "localhost";
    
    public static final  int port = 3306;
Connection c =null;
	public Connection  connDb() {
		try {
			this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?kullanici_adi=root");
			return c ;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return c;
	}
}
//sabitleri dtaabase içine koyduk 
//calışanişlmelrinde de bağlantı işlemlerimizi gerçekleştirdik 
//çalışanişlemlerimizi jframe ve j dialoga ekliyeceğiz işlemlerimizi gerçekleştirmeye çalışacağız