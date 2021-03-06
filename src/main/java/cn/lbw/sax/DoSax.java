package cn.lbw.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Bowei Liu on 2017/10/18.
 */
public class DoSax {
    public static void main(String[] args) {
        System.setProperty("entityExpansionLimit", "7000000");
        Long start = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();

            SAXParserHandler handler = new SAXParserHandler();
            parser.parse(new File("dblp.xml"), handler);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start) / 1000 + " seconds");
    }
}
