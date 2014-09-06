package net.acegik.xmlparsinginjava;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author pnhung177
 */
public class DemoDOMParser extends DemoAbstractParser {

    public DemoDOMParser(String filename) {
        super(filename);
    }

    public List<Student> getAllStudents() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(
                    ClassLoader.getSystemResourceAsStream(getFilename()));

            List<Student> studentList = new ArrayList<>();

            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Student student = new Student();
                    student.setId(node.getAttributes().getNamedItem("id").getNodeValue());

                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode instanceof Element) {
                            String content = childNode.getLastChild().getTextContent().trim();
                            String nodeName = childNode.getNodeName();

                            if ("fullname".equals(nodeName)) {
                                student.setFullname(content);
                            } else if ("email".equals(nodeName)) {
                                student.setEmail(content);
                            } else if ("address".equals(nodeName)) {
                                student.setAddress(content);
                            }
                        }
                    }
                    studentList.add(student);
                }
            }

            return studentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
