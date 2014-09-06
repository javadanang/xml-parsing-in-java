package net.acegik.xmlparsinginjava;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author pnhung177
 */
public class DemoSAXParser extends DemoAbstractParser {

    public DemoSAXParser(String filename) {
        super(filename);
    }

    @Override
    public List<Student> getAllStudents() {
        try {
            SAXParserFactory parserFactor = SAXParserFactory.newInstance();
            SAXParser parser = parserFactor.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(ClassLoader.getSystemResourceAsStream(getFilename()), handler);
            return handler.getResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class SAXHandler extends DefaultHandler {

        List<Student> studentList = new ArrayList<>();
        Student student = null;
        String content = null;

        @Override
        public void startElement(String uri, String localName,
                String qName, Attributes attributes) throws SAXException {
            if ("student".equals(qName)) {
                student = new Student();
                student.setId(attributes.getValue("id"));
            }
        }

        @Override
        public void endElement(String uri, String localName,
                String qName) throws SAXException {
            if ("student".equals(qName)) {
                studentList.add(student);
            } else if ("fullname".equals(qName)) {
                student.setFullname(content);
            } else if ("email".equals(qName)) {
                student.setEmail(content);
            } else if ("address".equals(qName)) {
                student.setAddress(content);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content = String.copyValueOf(ch, start, length).trim();
        }

        public List<Student> getResult() {
            return studentList;
        }
    }
}
