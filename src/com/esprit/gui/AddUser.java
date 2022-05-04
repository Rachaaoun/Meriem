/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.FloatingHint;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

import com.esprit.entities.User;

import java.util.Date;


/**
 *
 * @author Lenovo
 */
public class AddUser extends BaseForm {
    
    Form current;
    public AddUser(Resources res ) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout ");
        getContentPane().setScrollVisible(false);
        
        
//        super.addSideMenu(res);
        
        TextField cin = new TextField("", "cin  " , 20 , TextField.ANY);
        TextField nom = new TextField("", "nom  " , 20 , TextField.ANY);
        TextField prenom = new TextField("", "prenom " , 20 , TextField.ANY);
        TextField numtel = new TextField("", "numéro" , 20 , TextField.ANY);
        TextField date_naissance = new TextField("", "date " , 20 , TextField.ANY);
        TextField email = new TextField("", "email" , 20 , TextField.ANY);
        TextField password = new TextField("", "password " , 20 , TextField.ANY);
       
      
        cin.setUIID("NewsTopLine");
        
        
        //dateexpiration.setUIID("NewsTopLine");
        
        cin.setSingleLineTextArea(true);
        
        // dateexpiration.setSingleLineTextArea(true);
        
        Button btnAjouter = new Button("Ajouter");
       btnAjouter.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnAjouter.addPointerPressedListener(l ->   { 
           User r = new User();
           r.setCin(Integer. parseInt(cin.getText()));
           r.setNom(nom.getText());
           r.setPrenom(prenom.getText());
           r.setNumTel(Integer. parseInt(numtel.getText()));
          String sDate1=date_naissance.getText(); 
           
          
           r.setEmail(email.getText());
           r.setPassword(password.getText());
           
           
     //  r.setDateexpiration(r.getDateexpiration());
      
       
       //appel fonction modfier reclamation men service
       
       /*if(TypeReclamationService.getInstance().addType(r)) { // if true
           new ListType(res).show();
       }*/
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           //new ListType(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
       Label l1 = new Label();
       
      
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(cin),
                createLineSeparator(),
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(prenom),
                  new FloatingHint(date_naissance),
                createLineSeparator(),
                createLineSeparator(),
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(numtel),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
              
                createLineSeparator(),//ligne de séparation
                
                btnAjouter
                
                
               
        );
        
        add(content);
        show();
        
         
    }
}