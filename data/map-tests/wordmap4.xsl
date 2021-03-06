<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:map="http://www.w3.org/2005/xpath-functions/map" exclude-result-prefixes="xs map"
    version="3.0">
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:variable name="doc" select="/"/>

    <xsl:template match="/">
        <out>
            <xsl:variable name="words" as="map(xs:string, element()*)">
                <xsl:map>
                    <xsl:for-each-group select="//*" group-by="tokenize(., '\W+')[.!='']">
                        <xsl:map-entry key="current-grouping-key()" select="current-group()"/>
                    </xsl:for-each-group>
                </xsl:map>
            </xsl:variable>
            <read>
                    <xsl:for-each select="$doc//*/tokenize(., '\W+')[.!='']">
                        <c w="{.}"><xsl:value-of select="count($words(.))"/></c>
                    </xsl:for-each>
            </read>
        </out>
    </xsl:template>

</xsl:stylesheet>
