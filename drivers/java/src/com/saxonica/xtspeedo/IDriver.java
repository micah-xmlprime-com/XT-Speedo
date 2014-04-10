package com.saxonica.xtspeedo;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * XT-Speedo class to be implemented by each driver
 */

public abstract class IDriver {

    private String name;
    private Map<String, String> options = new HashMap<String, String>();

    /**
     * Parse a source file and build a tree representation of the XML
     * @param sourceURI the location of the XML input file
     */

    public abstract void buildSource(URI sourceURI) throws TransformationException;

    /**
     * Compile a stylesheet
     * @param stylesheetURI the file containing the XSLT stylesheet
     */

    public abstract void compileStylesheet(URI stylesheetURI) throws TransformationException;

    /**
     * Run a transformation, transforming the supplied source document using the
     * supplied stylesheet
     */

    public abstract void treeToTreeTransform() throws TransformationException;

    /**
     * Run a transformation, from an input file to an output file
     */

    public abstract void fileToFileTransform(File source, File result) throws TransformationException;

    /**
     * Test that the result of the transformation satisfies a given assertion
     * @param assertion the assertion, in the form of an XPath expression which
     *                  must evaluate to TRUE when executed with the transformation
     *                  result as the context item
     * @return the result of testing the assertion
     */

    public abstract boolean testAssertion(String assertion) throws TransformationException;

    /**
     * Show the result document
     */

    public abstract void displayResultDocument();

    /**
     * Gets version of XSLT processor supported
     * @return version of XSLT
     */

    public abstract double getXsltVersion();

    /**
     * Set a short name for the driver to be used in reports
     * @param name name to be used for driver
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the short name for the driver to be used in reports
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * Set an option for this driver
     * @param name the name of the option
     * @param value the value of the option
     */

    public void setOption(String name, String value) {
        options.put(name, value);
    }

    /**
     * Get the value of an option that has been set
     * @param name the name of the option
     * @return the value of the option, or null if none has been set
     */

    public String getOption(String name) {
        return options.get(name);
    }

    public Iterable<String> iterateOptions() {
        return options.keySet();
    }
}
