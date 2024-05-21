/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import SewaAlat.*;

/**
 *
 * @author Lab Informatika
 */
public interface DataPenyewaImplement {
    public void insert(DataSewaAlat s);
    public void update(DataSewaAlat s);
    public void delete(String s);
    public List<DataSewaAlat> getAll();
}
