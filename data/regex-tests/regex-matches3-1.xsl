<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template name="main">
        <out>
            <xsl:for-each select="tokenize(unparsed-text('xmark1.txt'),'\n')">
                <xsl:if test="matches(.,'.*a.*b.*c.*d.*e.*f.*g.*h.*i.*j')">                     
                    <xsl:text>match    
                    </xsl:text>   
                </xsl:if>                               
            </xsl:for-each>                   
        </out>
    </xsl:template>
</xsl:stylesheet>