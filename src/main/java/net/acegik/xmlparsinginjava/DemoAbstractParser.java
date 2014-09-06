package net.acegik.xmlparsinginjava;

/**
 *
 * @author pnhung177
 */
public abstract class DemoAbstractParser implements DemoXmlParser {

    protected String filename = null;

    public DemoAbstractParser(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
