// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.parser;

import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import android.content.res.Resources$NotFoundException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.ContentHandler;
import javax.xml.parsers.SAXParserFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserFactory;
import android.content.res.AssetManager;
import org.litepal.exceptions.ParseConfigurationFileException;
import org.litepal.LitePalApplication;
import java.io.InputStream;

public class LitePalParser
{
    static final String ATTR_CLASS = "class";
    static final String ATTR_VALUE = "value";
    static final String NODE_CASES = "cases";
    static final String NODE_DB_NAME = "dbname";
    static final String NODE_LIST = "list";
    static final String NODE_MAPPING = "mapping";
    static final String NODE_STORAGE = "storage";
    static final String NODE_VERSION = "version";
    private static LitePalParser parser;
    
    private InputStream getConfigInputStream() {
        final AssetManager assets = LitePalApplication.getContext().getAssets();
        final String[] list = assets.list("");
        if (list != null && list.length > 0) {
            final String[] array = list;
            for (int length = list.length, i = 0; i < length; ++i) {
                final String s = array[i];
                if ("litepal.xml".equalsIgnoreCase(s)) {
                    return assets.open(s, 3);
                }
            }
        }
        throw new ParseConfigurationFileException("litepal.xml file is missing. Please ensure it under assets folder.");
    }
    
    public static void parseLitePalConfiguration() {
        if (LitePalParser.parser == null) {
            LitePalParser.parser = new LitePalParser();
        }
        LitePalParser.parser.useSAXParser();
    }
    
    void usePullParse() {
        try {
            final LitePalAttr instance = LitePalAttr.getInstance();
            try {
                final XmlPullParserFactory instance2 = XmlPullParserFactory.newInstance();
                try {
                    final XmlPullParser pullParser = instance2.newPullParser();
                    try {
                        pullParser.setInput(this.getConfigInputStream(), "UTF-8");
                        int n = pullParser.getEventType();
                    Label_0267_Outer:
                        while (true) {
                            if (n == 1) {
                                return;
                            }
                            final String name = pullParser.getName();
                        Block_15_Outer:
                            while (true) {
                                if (n != 2) {
                                    break Label_0267;
                                }
                                if ("dbname".equals(name)) {
                                    instance.setDbName(pullParser.getAttributeValue("", "value"));
                                    break Label_0267;
                                }
                                Label_0173: {
                                    if (!"version".equals(name)) {
                                        break Label_0173;
                                    }
                                    final String attributeValue = pullParser.getAttributeValue("", "value");
                                    try {
                                        instance.setVersion(Integer.parseInt(attributeValue));
                                        n = pullParser.next();
                                        continue Label_0267_Outer;
                                        instance.addClassName(pullParser.getAttributeValue("", "class"));
                                        continue Block_15_Outer;
                                        // iftrue(Label_0267:, !"cases".equals((Object)name))
                                        while (true) {
                                            instance.setCases(pullParser.getAttributeValue("", "value"));
                                            continue Block_15_Outer;
                                            Label_0220: {
                                                continue;
                                            }
                                        }
                                    }
                                    // iftrue(Label_0220:, !"mapping".equals((Object)name))
                                    catch (IOException ex) {
                                        throw new ParseConfigurationFileException("IO exception happened");
                                    }
                                    catch (XmlPullParserException ex2) {
                                        throw new ParseConfigurationFileException("can not parse the litepal.xml, check if it's in correct format");
                                    }
                                }
                                break;
                            }
                        }
                    }
                    catch (IOException ex3) {}
                    catch (XmlPullParserException ex4) {}
                }
                catch (IOException ex5) {}
                catch (XmlPullParserException ex6) {}
            }
            catch (IOException ex7) {}
            catch (XmlPullParserException ex8) {}
        }
        catch (IOException ex9) {}
        catch (XmlPullParserException ex10) {}
    }
    
    void useSAXParser() {
        try {
            final SAXParserFactory instance = SAXParserFactory.newInstance();
            try {
                final SAXParser saxParser = instance.newSAXParser();
                try {
                    final XMLReader xmlReader = saxParser.getXMLReader();
                    try {
                        try {
                            final LitePalContentHandler contentHandler = new LitePalContentHandler();
                            final XMLReader xmlReader2 = xmlReader;
                            try {
                                xmlReader2.setContentHandler(contentHandler);
                                try {
                                    final InputSource inputSource = new InputSource(this.getConfigInputStream());
                                    final XMLReader xmlReader3 = xmlReader;
                                    try {
                                        xmlReader3.parse(inputSource);
                                    }
                                    catch (IOException ex) {
                                        throw new ParseConfigurationFileException("IO exception happened");
                                    }
                                    catch (ParserConfigurationException ex2) {
                                        throw new ParseConfigurationFileException("parse configuration is failed");
                                    }
                                    catch (SAXException ex3) {
                                        throw new ParseConfigurationFileException("can not parse the litepal.xml, check if it's in correct format");
                                    }
                                    catch (Resources$NotFoundException ex4) {
                                        throw new ParseConfigurationFileException("litepal.xml file is missing. Please ensure it under assets folder.");
                                    }
                                }
                                catch (IOException ex5) {}
                                catch (ParserConfigurationException ex6) {}
                                catch (SAXException ex7) {}
                                catch (Resources$NotFoundException ex8) {}
                            }
                            catch (IOException ex9) {}
                            catch (ParserConfigurationException ex10) {}
                            catch (SAXException ex11) {}
                            catch (Resources$NotFoundException ex12) {}
                        }
                        catch (IOException ex13) {}
                        catch (ParserConfigurationException ex14) {}
                        catch (SAXException ex15) {}
                        catch (Resources$NotFoundException ex16) {}
                    }
                    catch (IOException ex17) {}
                    catch (ParserConfigurationException ex18) {}
                    catch (SAXException ex19) {}
                    catch (Resources$NotFoundException ex20) {}
                }
                catch (IOException ex21) {}
                catch (ParserConfigurationException ex22) {}
                catch (SAXException ex23) {}
                catch (Resources$NotFoundException ex24) {}
            }
            catch (IOException ex25) {}
            catch (ParserConfigurationException ex26) {}
            catch (SAXException ex27) {}
            catch (Resources$NotFoundException ex28) {}
        }
        catch (IOException ex29) {}
        catch (ParserConfigurationException ex30) {}
        catch (SAXException ex31) {}
        catch (Resources$NotFoundException ex32) {}
    }
}
