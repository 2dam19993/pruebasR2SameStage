/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasreto2;

import static java.awt.SystemColor.desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController implements Initializable {
    private Stage stage;
    private Stage stageAyuda;
    @FXML
    private WebView webView = new WebView();
    private WebEngine webEngine = webView.getEngine();
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
     public void initStage(Parent root){
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("App");
        
        
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void irSegunda(){
        /*
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("segunda.fxml"));
        
        Parent root = (Parent)loader.load();

        FXMLDocumentController2 controller = ((FXMLDocumentController2)loader.getController());
        controller.setStage(stage);
        controller.initStage(root);
        } catch (IOException e) {
            System.out.println("error 1 "+e);
        }
*/
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files","*.pdf"));
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile!=null){
            System.out.println("Bien");
            try{
               metodo(selectedFile);
               //metodo2(selectedFile);
            }catch(Exception e){
                System.out.println(e);
            }
            /*
             LOGGER.info("algo");
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        
        URL url = this.getClass().getResource("./ayudaPrincipal.html");
        webEngine.load(url.toString());
        
        stageAyuda=new Stage();
        stageAyuda.setTitle(webEngine.getTitle());
        
        Button ayudaCerrar=new Button("Cerrar");        
        ayudaCerrar.setOnAction(this::cerrarAyuda);
        ayudaCerrar.setMnemonicParsing(true);
        ayudaCerrar.setText("_Cerrar");
        // Al pulsar enter encima del boton se ejecute 
        ayudaCerrar.setOnKeyPressed((key) ->{
            if(key.getCode().equals(KeyCode.ENTER)) {
                 ayudaCerrar.fire();
            }
        });
        stageAyuda.setOnShowing((event)->{
            ayudaCerrar.requestFocus();
            
        });
        VBox root = new VBox();
        root.getChildren().addAll(browser,ayudaCerrar);
        
        Scene escenaAyuda=new Scene(root);
        stageAyuda.setScene(escenaAyuda);
        stageAyuda.initModality(Modality.APPLICATION_MODAL);
        
        stageAyuda.show();
            */
            
        }else{
            System.out.println("Error");
        }
        
    }

    private void metodo(File selectedFile) throws FileNotFoundException, IOException {
       final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        
        //URL url = this.getClass().getResource("./ayudaPrincipal.html");
        //INTENTO 1
        /*
        InputStream is = new FileInputStream(selectedFile.toString());
         BufferedReader buf = new BufferedReader(new InputStreamReader(is));
          String line = buf.readLine();
        */
        //System.out.println(selectedFile.getAbsoluteFile().get); 
        //INTENTO 2
        System.out.println(selectedFile.toString());
       // webEngine.loadContent(line);
        webEngine.loadContent("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>Page Title</title>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<h1>This is a Heading</h1>\n" +
"<p>This is a paragraph.</p>\n" +
"\n" +
"</body>\n" +
"</html>");
       // webEngine.load("https://google.com/");
        
        stageAyuda=new Stage();
        stageAyuda.setTitle(webEngine.getTitle());
        
        Button ayudaCerrar=new Button("Cerrar");        
        ayudaCerrar.setOnAction(this::cerrarAyuda);
        ayudaCerrar.setMnemonicParsing(true);
        ayudaCerrar.setText("_Cerrar");
        /* Al pulsar enter encima del boton se ejecute */
        ayudaCerrar.setOnKeyPressed((key) ->{
            if(key.getCode().equals(KeyCode.ENTER)) {
                 ayudaCerrar.fire();
            }
        });
        stageAyuda.setOnShowing((event)->{
            ayudaCerrar.requestFocus();
            
        });
        VBox root = new VBox();
        root.getChildren().addAll(browser,ayudaCerrar);
        
        Scene escenaAyuda=new Scene(root);
        stageAyuda.setScene(escenaAyuda);
        stageAyuda.initModality(Modality.APPLICATION_MODAL);
        
        stageAyuda.show();
    }
    public void cerrarAyuda(ActionEvent event){
        stageAyuda.hide();
    }
    private static String readLineByLineJava8(String filePath) 
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    private void metodo2(File selectedFile) {
       Stage stage2=new Stage();
       WebView myWebView= new WebView();
       WebEngine myEngine=myWebView.getEngine();
       
       Button btn= new Button();
       btn.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               //myEngine.load("https://www.google.com");
               myEngine.load(selectedFile.getPath());
           }
       });
       VBox root= new VBox();
       root.getChildren().addAll(myWebView,btn);
       
       Scene escena = new Scene(root,800,500);
       stage2.setScene(escena);
       stage2.show();
    }
    
    
}
