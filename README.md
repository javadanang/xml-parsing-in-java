XML parsing in Java using DOM, SAX and StAX
===========================================

This is a simple example to XML parsing in Java. This example show three type of parsing: DOM, SAX and StAX.  The DOM parser implements the DOM API and it creates a DOM tree in memory for a XML document. The SAX parser implements the SAX API and it is event driven interface: callback methods are invoked when the parser parsing a XML document. The StAX parser pulls the required data from the XML: it maintains a cursor at the current position in the document allows to extract the content available at the cursor.
