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
import com.esprit.services.UserService;

import java.util.Date;


/**
 *
 * @author Lenovo
 */
public class ModifierUser extends BaseForm {
    
    Form current;
    public ModifierUser(Resources res,User u ) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout ");
        getContentPane().setScrollVisible(false);
        
        
//        super.addSideMenu(res);
        
        TextField adresse = new TextField("", "Adresse  " , 20 , TextField.ANY);
        TextField nom = new TextField("", "nom  " , 20 , TextField.ANY);
        TextField prenom = new TextField("", "prenom " , 20 , TextField.ANY);
        TextField numtel = new TextField("", "numéro" , 20 , TextField.ANY);
        TextField date_naissance = new TextField("", "date " , 20 , TextField.ANY);
        TextField email = new TextField("", "email" , 20 , TextField.ANY);
        TextField password = new TextField("", "password " , 20 , TextField.ANY);
       
      
        adresse.setUIID("NewsTopLine");
        
        
        //dateexpiration.setUIID("NewsTopLine");
        
        adresse.setSingleLineTextArea(true);
        
        // dateexpiration.setSingleLineTextArea(true);
        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
        btnModifier.addPointerPressedListener(l ->   { 
            u.setAdresse(adresse.getText());
            u.setDate_naissance(date_naissance.getText());
            u.setEmail(email.getText());
            u.setPassword(password.getText());
            u.setNom(nom.getText());
            u.setPrenom(prenom.getText());
          
     //  r.setDateexpiration(r.getDateexpiration());
      
       
       //appel fonction modfier reclamation men service
       
       if(UserService.getInstance().modifierUser(u)) { // if true
           new ListUser(res).show();
       }
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
                new FloatingHint(adresse),
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
                
                btnModifier
                
                
               
        );
        
        add(content);
        show();
        
         
    }
}