/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatasewa;
import java.sql.*;
import Koneksi.connector;
import java.util.*;
import SewaAlat.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DAOImplement.DataPenyewaImplement;

/**
 *
 * @author Lab Informatika
 */
public class datasewaDAO implements DataPenyewaImplement{
    Connection connection;
    public int harga;
    public int waktu;
    final String select = "SELECT * from data_penyewa";
    final String insert = "insert into data_penyewa (Nama_Penyewa, Nama_Alat, Nomor_Telepon, Waktu_Sewa, Biaya_Sewa) values (?, ?, ?, ?, ?);";
    final String update = "update data_penyewa set Nama_Penyewa = ?, Nama_Alat=?, Nomor_Telepon=?, Waktu_Sewa=?, Biaya_Sewa=? where Nama_Penyewa =?";
    final String delete = "delete from data_penyewa where Nama_Penyewa = ?";

    public datasewaDAO() {
        connection = connector.connection();
    }

    @Override
    public void insert(DataSewaAlat s) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, s.getPenyewa());
            statement.setString(2, s.getNamaAlat());
            statement.setString(3, s.getNoHP());
            statement.setInt(4, s.getWaktuSewa());
            waktu = s.getWaktuSewa();
            if(waktu <=2){
                 harga = waktu*50000;
            }else{
                harga = 2*50000+(waktu-2)*25000;
            }
            statement.setInt(5, harga);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                s.setPenyewa(rs.getString(1));
            }
            JOptionPane.showMessageDialog(null, "Success Adding Data");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataSewaAlat s) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, s.getPenyewa());
            statement.setString(2, s.getNamaAlat());
            statement.setString(3, s.getNoHP());
            statement.setInt(4, s.getWaktuSewa());
            waktu = s.getWaktuSewa();
            if(s.getWaktuSewa() <=2){
                harga = waktu*50000;
            }else{
                harga = 2*50000+(waktu-2)*25000;
            }
            statement.setInt(5, harga);
            String dump = s.getPenyewa();
            statement.setString(6, dump);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success Updatting Data");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String s) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, s);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success Removing Data");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataSewaAlat> getAll() {
        List<DataSewaAlat> ds = null;
        try{
           ds = new ArrayList<DataSewaAlat>();
           Statement st = connection.createStatement();
           ResultSet rs = st.executeQuery(select);
           while(rs.next()){
               DataSewaAlat alat = new DataSewaAlat();
               alat.setPenyewa(rs.getString("Nama_Penyewa"));
               alat.setNamaAlat(rs.getString("Nama_Alat"));
               alat.setNoHP(rs.getString("Nomor_Telepon"));
               alat.setWaktuSewa(rs.getInt("Waktu_Sewa"));
               alat.setHargaSewa(rs.getInt("Biaya_Sewa"));
               ds.add(alat);
           }
        }catch(SQLException ex){
            Logger.getLogger(datasewaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return ds;
    }

    
    
    
    
}
