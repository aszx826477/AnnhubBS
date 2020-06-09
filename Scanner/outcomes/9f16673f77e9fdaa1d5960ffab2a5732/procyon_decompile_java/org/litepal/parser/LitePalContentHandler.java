// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class LitePalContentHandler extends DefaultHandler
{
    private LitePalAttr litePalAttr;
    
    public void characters(final char[] array, final int n, final int n2) {
    }
    
    public void endDocument() {
    }
    
    public void endElement(final String s, final String s2, final String s3) {
    }
    
    public void startDocument() {
        this.litePalAttr = LitePalAttr.getInstance();
        this.litePalAttr.getClassNames().clear();
    }
    
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        if ("dbname".equalsIgnoreCase(s2)) {
            for (int i = 0; i < attributes.getLength(); ++i) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.litePalAttr.setDbName(attributes.getValue(i).trim());
                }
            }
        }
        else if ("version".equalsIgnoreCase(s2)) {
            for (int j = 0; j < attributes.getLength(); ++j) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(j))) {
                    this.litePalAttr.setVersion(Integer.parseInt(attributes.getValue(j).trim()));
                }
            }
        }
        else if ("mapping".equalsIgnoreCase(s2)) {
            for (int k = 0; k < attributes.getLength(); ++k) {
                if ("class".equalsIgnoreCase(attributes.getLocalName(k))) {
                    this.litePalAttr.addClassName(attributes.getValue(k).trim());
                }
            }
        }
        else if ("cases".equalsIgnoreCase(s2)) {
            for (int l = 0; l < attributes.getLength(); ++l) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(l))) {
                    this.litePalAttr.setCases(attributes.getValue(l).trim());
                }
            }
        }
        else if ("storage".equalsIgnoreCase(s2)) {
            for (int n = 0; n < attributes.getLength(); ++n) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(n))) {
                    this.litePalAttr.setStorage(attributes.getValue(n).trim());
                }
            }
        }
    }
}
