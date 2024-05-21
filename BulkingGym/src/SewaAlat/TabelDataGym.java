/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SewaAlat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Lab Informatika
 */
public class TabelDataGym extends AbstractTableModel {
    List<DataSewaAlat> ds;
    public TabelDataGym(List<DataSewaAlat>ds){
        this.ds = ds;
    }
    @Override
    public int getRowCount(){
        return ds.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: 
                return "Nama Penyewa";
            case 1: 
                return "Nama Alat";
            case 2: 
                return "Nomor Telepon";
            case 3:
                return "Lama Sewa";
            case 4: 
                return "Biaya Sewa";
            default:
                return null;
        }
    }
    
    public Object getValueAt(int row, int column){
        switch(column){
            case 0: 
                return ds.get(row).getPenyewa();
            case 1: 
                return ds.get(row).getNamaAlat();
            case 2: 
                return ds.get(row).getNoHP();
            case 3:
                return ds.get(row).getWaktuSewa();
            case 4: 
                return ds.get(row).getHargaSewa();
            default:
                return null;
        }
    }
}
