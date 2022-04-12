package it.polito.tdp.librettovoti;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model1.CorsoNonTrovato;
import it.polito.tdp.librettovoti.model1.Libretto;
import it.polito.tdp.librettovoti.model1.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;
	
	@FXML
	private Label labelErrore;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private ComboBox<Integer> cmbPunteggio;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtVoti;

    @FXML
    void hanldeNuovoVoto(ActionEvent event) {
    	
    	if(txtCorso.getText().equals("") || cmbPunteggio.getValue() == null) {
    		labelErrore.setText("ERRORE: occorre inserire nome del corso e voto\n");
    		return;
    	}
    	model.add(new Voto(txtCorso.getText() , cmbPunteggio.getValue()));
    	
    	List<Voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.setText("Hai superato " + voti.size() + " esami\n");
    	for(Voto v: voti) {
    		txtVoti.appendText(v.toString() + "\n");
    	}
    	txtCorso.clear();
    	cmbPunteggio.setValue(null);
    	labelErrore.setText("");
    }
    
    void setModel(Libretto model) {
    	this.model = model;
    	
    	List<Voto> voti = model.getVoti();
      	txtVoti.clear();
      	txtVoti.setText("Hai superato " + voti.size() + " esami\n");
      	for(Voto v: voti) {
      		txtVoti.appendText(v.toString() + "\n");
      	}
    }


    @FXML
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbPunteggio != null : "fx:id=\"cmbPunteggio\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
        
        cmbPunteggio.getItems().clear();
        
        for(int i=18;i<31;i++) {
        	cmbPunteggio.getItems().add(i);
        }

    }

}

