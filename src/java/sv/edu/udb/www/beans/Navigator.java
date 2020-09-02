/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.beans;
import java.io.Serializable;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import org.apache.log4j.Logger;
 
@ManagedBean
@SessionScoped
public class Navigator implements Serializable {

    private static Logger logger = Logger.getLogger(Navigator.class);
    private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String validate() {

        String navResult = "";
        logger.info("Username is?=");
       
        return navResult;
    }
}