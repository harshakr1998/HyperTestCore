package harshakr.HyperTestCore;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardUtils {

    
    /**
     * Copy text to clipboard and paste it immediately
     * Here if you are using it for file upload, pass the file path to the @param textToCopy
     * 
     * @param textToCopy
     * @return
     */
    public static String copyAndPaste(String textToCopy) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Copy to clipboard
        StringSelection stringSelection = new StringSelection(textToCopy);
        clipboard.setContents(stringSelection, null);

        // Paste from clipboard
        try {
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            throw new RuntimeException("Failed to paste from clipboard: " + e.getMessage(), e);
        }
    }
}
