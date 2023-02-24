package serverinputpanel;

import java.awt.Toolkit;

import javax.swing.text.*;

class IPInputFilter extends DocumentFilter {
	
	
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
    	
        fb.replace(offset, length, text.replaceAll("[^0-9.]", ""), attrs);
    }
}