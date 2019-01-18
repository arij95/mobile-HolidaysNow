/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entites.ReservationActivite;

/**
 *
 * @author challakh
 */
public class ServiceReservationActivite {
     public void ajoutTask(ReservationActivite ta) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Holidaysnow01/web/app_dev.php/ajouterreservation2/"+ta.getId_activite()+".json";
        con.setUrl(Url);
        con.setPost(true);
        
        
        
        con.setContentType("application/json");        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(ta));
        
        con.setRequestBody(gson.toJson(ta));
        
        
        
        
        
        
        
        
        
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);                                                                                
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
