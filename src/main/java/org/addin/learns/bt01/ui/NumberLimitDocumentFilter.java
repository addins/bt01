/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.ui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Addin
 */
public class NumberLimitDocumentFilter extends DocumentFilter {

    private int limit;

    public NumberLimitDocumentFilter(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit cannot be <= 0");
        }
        this.limit = limit;
    }

    public void replace(FilterBypass fb, int offs, int length,
            String str, AttributeSet a) throws BadLocationException {

        String text = fb.getDocument().getText(0,
                fb.getDocument().getLength());
        text += str;
        if ((fb.getDocument().getLength() + str.length() - length) <= limit
                && text.matches("^[0-9]+$")) {
            super.replace(fb, offs, length, str, a);
        } else {
            // wrong input
        }
    }

    public void insertString(FilterBypass fb, int offs, String str,
            AttributeSet a) throws BadLocationException {

        String text = fb.getDocument().getText(0,
                fb.getDocument().getLength());
        text += str;
        if ((fb.getDocument().getLength() + str.length()) <= limit
                && text.matches("^[0-9]+$")) {
            super.insertString(fb, offs, str, a);
        } else {
            // wrong input
        }
    }

}
