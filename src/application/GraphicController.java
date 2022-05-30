/**
 * Sample Skeleton for 'Graphic.fxml' Controller Class
 */

package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import model.Link;

public class GraphicController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="add"
    private JFXButton add; // Value injected by FXMLLoader

    @FXML // fx:id="remove"
    private JFXButton remove; // Value injected by FXMLLoader

    @FXML // fx:id="update"
    private JFXButton update; // Value injected by FXMLLoader

    @FXML // fx:id="btnimport"
    private JFXButton btnimport; // Value injected by FXMLLoader

    @FXML // fx:id="table"
    private JFXTreeTableView<Link> table; // Value injected by FXMLLoader


    @FXML // fx:id="search"
    private JFXTextField search; // Value injected by FXMLLoader

    @FXML // fx:id="select"
    private JFXComboBox<?> select; // Value injected by FXMLLoader

    @FXML // fx:id="boxradio"
    private VBox boxradio; // Value injected by FXMLLoader

    @FXML // fx:id="radionone"
    private JFXRadioButton radionone; // Value injected by FXMLLoader

    @FXML // fx:id="radio"
    private ToggleGroup radio; // Value injected by FXMLLoader

    @FXML // fx:id="radiobest"
    private JFXRadioButton radiobest; // Value injected by FXMLLoader

    @FXML // fx:id="radiopoor"
    private JFXRadioButton radiopoor; // Value injected by FXMLLoader

    @FXML
    void onadd(ActionEvent event) {

    }

    @SuppressWarnings("unchecked")
	@FXML
    void onimport(ActionEvent event) throws IOException {

    	try {
    		FileChooser fileChooser = new FileChooser();
        	fileChooser.setTitle("Open Resource File");
        	File file = fileChooser.showOpenDialog(null);
			FileReader fr = new FileReader(file);
			try (BufferedReader br = new BufferedReader(fr)) {
				String line;
				HashMap<String,String> linkList = new HashMap<>();
				do {
					line = br.readLine();
					if (line != null && line.length() > 0 && line.contains("HREF")) {
						line = line.replace("\t", "");
						String[] splitLine = line.split("\">");
						String value = splitLine[0].replace("<DT><A HREF=\"", "");
						String key = splitLine[1].replace("</A>", "");
						linkList.put(key, value);
					}
				}
				while(line!=null);
				
				/*colonna nome*/
				JFXTreeTableColumn<Link, String> name = new JFXTreeTableColumn<>("name");
				name.setPrefWidth(150);
				name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Link,String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Link, String> param) {
						return param.getValue().getValue().name;
					}
				});
				/*colonna link*/
				JFXTreeTableColumn<Link, String> link = new JFXTreeTableColumn<>("link");
				link.setPrefWidth(150);
				link.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Link,String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Link, String> param) {
						return param.getValue().getValue().link;
					}
				});
				/*colonna lenguage*/
				JFXTreeTableColumn<Link, String> lenguage = new JFXTreeTableColumn<>("lenguage");
				lenguage.setPrefWidth(100);
				lenguage.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Link,String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Link, String> param) {
						return param.getValue().getValue().lenguage;
					}
				});
				
				/*creo un'istanza di tipo Observable list*/
				ObservableList<Link> datasethardcoded = FXCollections.observableArrayList();
				
				/*aggiungo elemente all'observable*/
				
				for (Map.Entry<String, String> entry : linkList.entrySet()) {
						datasethardcoded.add(new Link(entry.getKey(),entry.getValue(),"xx"));		
				}
				
				final TreeItem<Link> root = new RecursiveTreeItem<Link>(datasethardcoded, RecursiveTreeObject::getChildren);
				table.getColumns().setAll(name,link,lenguage);
				table.setRoot(root);
			}
			table.setShowRoot(false);
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}
    	

    }

    @FXML
    void onremove(ActionEvent event) {

    }

    @FXML
    void onsearch(KeyEvent event) {

    }

    @FXML
    void onselect(ActionEvent event) {

    }

    @FXML
    void onupdate(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	
  
    	
    
    	
    
    	
    	
    	
    	
    	
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert remove != null : "fx:id=\"remove\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert btnimport != null : "fx:id=\"btnimport\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert select != null : "fx:id=\"select\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert boxradio != null : "fx:id=\"boxradio\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert radionone != null : "fx:id=\"radionone\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert radio != null : "fx:id=\"radio\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert radiobest != null : "fx:id=\"radiobest\" was not injected: check your FXML file 'Graphic.fxml'.";
        assert radiopoor != null : "fx:id=\"radiopoor\" was not injected: check your FXML file 'Graphic.fxml'.";

    }
}
