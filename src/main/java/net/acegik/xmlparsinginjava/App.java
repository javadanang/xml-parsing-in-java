package net.acegik.xmlparsinginjava;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main( String[] args ) {
        String xmlFilename = "xml/student.xml";
        Map<String, DemoXmlParser> parsers = new LinkedHashMap<>();

        parsers.put("DOMParser", new DemoDOMParser(xmlFilename));
        parsers.put("SAXParser", new DemoSAXParser(xmlFilename));
        parsers.put("StAXParser", new DemoStAXParser(xmlFilename));

        for(Map.Entry<String, DemoXmlParser> entry:parsers.entrySet()) {
            System.out.println("Parsing student.xml using " + entry.getKey() + ":");
            List<Student> result = entry.getValue().getAllStudents();
            for (Student student : result) {
                System.out.println(student);
            }
        }
    }
}
