package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    AlienDictionary ad=new AlienDictionary();
   
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
     String parola=txtWord.getText();
     
     parola=parola.trim();
     
   String s[]=parola.split(" ");
   if( s.length==2) {
	   ad.addWord(s[0], s[1]);
	   txtWord.clear();
	   txtResult.appendText("Hai aggiunto un parola al dizionario\n");
   }
   else if(s.length==1) {
     for(Word w:ad.listaparole) {
    	 if (w.getAlienWord().compareTo(parola)==0)
    	 {
    		 txtResult.appendText("La parola "+parola+" significa in alienese: "+w.getTranslation()+"\n");
    		 txtWord.clear();
    		 return;
    	 }
     }
     if(s[0].length()>0 && s.length==1)
     { txtResult.appendText("La parola "+parola+" non è contenuta nel dizionario!\n");
     txtWord.clear();}
     
    } else txtResult.appendText("Errore nell'input!\n"); }
    
    
    @FXML
    void doReset(ActionEvent event) {
   txtResult.clear();
   txtWord.clear();
    }
  
 
}
