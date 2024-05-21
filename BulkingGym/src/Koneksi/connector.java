/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class connector {
    static Connection connect;
    public static Connection connection(){
        if(connect == null){
            //mengkoneksikan ke database
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_bullkinggym");
            data.setUser("root");
            data.setPassword("");
            
            try{
                //mengkoneksikan ke database
                connect = data.getConnection();
                //saat berhasil, akan keluar "koneksi berhasil" pada konsol
                System.out.println("Koneksi Berhasil!!");
            }catch(SQLException ex){ 
                ex.printStackTrace();
                //saat koneksi gagal, akan muncul "koneksi gagal" pada konsol
                System.out.println("Koneksi Gagal!!");
            }
        }
        return connect;
    }
}
