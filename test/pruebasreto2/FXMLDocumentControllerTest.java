/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasreto2;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentControllerTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception{
        new PruebasReto2().start(stage);
    }
    
    public FXMLDocumentControllerTest() {
    }

    @Test
    public void testSomeMethod() {
        clickOn("#btnAceptar");
        applyPath("F:\\Descargas\\PRUEBAS\\report.pdf");
        applyPath("F:\\Descargas\\PRUEBAS\\report2.pdf");
        
    }
    private void applyPath(String filePath){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(filePath);
        clipboard.setContents(stringSelection, stringSelection);
        press(KeyCode.CONTROL).press(KeyCode.V).release(KeyCode.V).release(KeyCode.CONTROL);
        push(KeyCode.ENTER);
    }
}
