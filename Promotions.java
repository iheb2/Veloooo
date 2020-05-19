/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velo.Entity;

import accessoires.Accessoires;
import java.sql.Date;

/**
 *
 * @author mouhamedahed
 */
public class Promotions {

    private int id;
    private Accessoires accessoire_id;
    private Date startDate;
    private Date finishDate;
    private int percentage;

    public Promotions(int id, Accessoires accessoire_id, Date startDate, Date finishDate, int percentage) {
        this.id = id;
        this.accessoire_id = accessoire_id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.percentage = percentage;
    }

    public Promotions(Accessoires accessoire_id, Date startDate, Date finishDate, int percentage) {
        this.accessoire_id = accessoire_id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.percentage = percentage;
    }

    public Promotions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accessoires getAccessoire_id() {
        return accessoire_id;
    }

    public void setAccessoire_id(Accessoires accessoire_id) {
        this.accessoire_id = accessoire_id;
    }
 

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Promotions{" + "id=" + id + ", accessoire_id=" + accessoire_id + ", startDate=" + startDate + ", finishDate=" + finishDate + ", percentage=" + percentage + '}';
    }

  //  public void setAccessoire(Accessoire P) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }

  



    
    
    

}
