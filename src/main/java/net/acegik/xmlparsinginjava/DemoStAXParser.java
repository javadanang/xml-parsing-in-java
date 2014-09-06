package net.acegik.xmlparsinginjava;

import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author pnhung177
 */
public class DemoStAXParser extends DemoAbstractParser {

    public DemoStAXParser(String filename) {
        super(filename);
    }

    @Override
    public List<Student> getAllStudents() {
        try {
            List<Student> studentList = null;
            Student current = null;
            String tagContent = null;
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(
                    ClassLoader.getSystemResourceAsStream(getFilename()));

            while (reader.hasNext()) {
                int event = reader.next();
                
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String localName = reader.getLocalName();
                        if ("students".equals(localName)) {
                            studentList = new ArrayList<Student>();
                        } else if ("student".equals(localName)) {
                            current = new Student();
                            current.setId(reader.getAttributeValue(0));
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        localName = reader.getLocalName();
                        if ("student".equals(localName)) {
                            studentList.add(current);
                        } else if ("fullname".equals(localName)) {
                            current.setFullname(tagContent);
                        } else if ("email".equals(localName)) {
                            current.setEmail(tagContent);
                        } else if ("address".equals(localName)) {
                            current.setAddress(tagContent);
                        }
                        break;
                }

            }
            return studentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
