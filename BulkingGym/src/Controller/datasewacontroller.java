/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.List;
import DAOdatasewa.datasewaDAO;
import SewaAlat.*;
import bulkinggymmain.MainViewGym;
import DAOImplement.DataPenyewaImplement;

/**
 *
 * @author Lab Informatika
 */
public class datasewacontroller {
    MainViewGym frame;
    DataPenyewaImplement impldatasewa;
    List<DataSewaAlat> ds;
    public datasewacontroller(MainViewGym frame) {
        this.frame = frame;
        impldatasewa = new datasewaDAO();
        ds = impldatasewa.getAll();
    }
    
    public void isiTabel(){
        ds = impldatasewa.getAll();
        TabelDataGym tf = new TabelDataGym(ds);
        frame.getTabledata().setModel(tf);
    }
    public void insert(){
        DataSewaAlat ds = new DataSewaAlat();
        ds.setPenyewa(frame.getNpenyewa().getText());
        ds.setNamaAlat(frame.getNalat().getText());
        ds.setNoHP(frame.getNohp().getText());
        ds.setWaktuSewa(Integer.parseInt(frame.getWsewa().getText()));        
        impldatasewa.insert(ds);
    }
    public void update(){
        DataSewaAlat ds = new DataSewaAlat();
        ds.setPenyewa(frame.getNpenyewa().getText());
        ds.setNamaAlat(frame.getNalat().getText());
        ds.setNoHP(frame.getNohp().getText());
        ds.setWaktuSewa(Integer.parseInt(frame.getWsewa().getText()));        
        impldatasewa.update(ds);
    }
    public void delete(){
        String penyewa = frame.getNpenyewa().getText();
        impldatasewa.delete(penyewa);
    }
    
}
