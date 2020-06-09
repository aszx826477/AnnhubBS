.class public Lorg/litepal/parser/LitePalParser;
.super Ljava/lang/Object;
.source "LitePalParser.java"


# static fields
.field static final ATTR_CLASS:Ljava/lang/String; = "class"

.field static final ATTR_VALUE:Ljava/lang/String; = "value"

.field static final NODE_CASES:Ljava/lang/String; = "cases"

.field static final NODE_DB_NAME:Ljava/lang/String; = "dbname"

.field static final NODE_LIST:Ljava/lang/String; = "list"

.field static final NODE_MAPPING:Ljava/lang/String; = "mapping"

.field static final NODE_STORAGE:Ljava/lang/String; = "storage"

.field static final NODE_VERSION:Ljava/lang/String; = "version"

.field private static parser:Lorg/litepal/parser/LitePalParser;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getConfigInputStream()Ljava/io/InputStream;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 192
    invoke-static {}, Lorg/litepal/LitePalApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 193
    .local v0, "assetManager":Landroid/content/res/AssetManager;
    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/content/res/AssetManager;->list(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 194
    .local v1, "fileNames":[Ljava/lang/String;
    if-eqz v1, :cond_2

    array-length v2, v1

    if-lez v2, :cond_2

    .line 195
    move-object v2, v1

    .local v2, "arr$":[Ljava/lang/String;
    array-length v3, v2

    .local v3, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v3, :cond_1

    aget-object v5, v2, v4

    .line 196
    .local v5, "fileName":Ljava/lang/String;
    const-string v6, "litepal.xml"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 197
    const/4 v6, 0x3

    invoke-virtual {v0, v5, v6}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;I)Ljava/io/InputStream;

    move-result-object v6

    return-object v6

    .line 196
    :cond_0
    nop

    .line 195
    .end local v5    # "fileName":Ljava/lang/String;
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_1
    goto :goto_1

    .line 194
    .end local v2    # "arr$":[Ljava/lang/String;
    .end local v3    # "len$":I
    .end local v4    # "i$":I
    :cond_2
    nop

    .line 201
    :goto_1
    new-instance v2, Lorg/litepal/exceptions/ParseConfigurationFileException;

    const-string v3, "litepal.xml file is missing. Please ensure it under assets folder."

    invoke-direct {v2, v3}, Lorg/litepal/exceptions/ParseConfigurationFileException;-><init>(Ljava/lang/String;)V

    throw v2

    return-void
.end method

.method public static parseLitePalConfiguration()V
    .locals 1

    .line 99
    sget-object v0, Lorg/litepal/parser/LitePalParser;->parser:Lorg/litepal/parser/LitePalParser;

    if-nez v0, :cond_0

    .line 100
    new-instance v0, Lorg/litepal/parser/LitePalParser;

    invoke-direct {v0}, Lorg/litepal/parser/LitePalParser;-><init>()V

    sput-object v0, Lorg/litepal/parser/LitePalParser;->parser:Lorg/litepal/parser/LitePalParser;

    goto :goto_0

    .line 99
    :cond_0
    nop

    .line 102
    :goto_0
    sget-object v0, Lorg/litepal/parser/LitePalParser;->parser:Lorg/litepal/parser/LitePalParser;

    invoke-virtual {v0}, Lorg/litepal/parser/LitePalParser;->useSAXParser()V

    .line 103
    return-void
.end method


# virtual methods
.method usePullParse()V
    .locals 7

    .line 146
    :try_start_0
    invoke-static {}, Lorg/litepal/parser/LitePalAttr;->getInstance()Lorg/litepal/parser/LitePalAttr;

    move-result-object v0

    .line 147
    .local v0, "litePalAttr":Lorg/litepal/parser/LitePalAttr;
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v1

    .line 148
    .local v1, "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    invoke-virtual {v1}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 149
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    invoke-direct {p0}, Lorg/litepal/parser/LitePalParser;->getConfigInputStream()Ljava/io/InputStream;

    move-result-object v3

    const-string v4, "UTF-8"

    invoke-interface {v2, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 150
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v3

    .line 151
    .local v3, "eventType":I
    :goto_0
    const/4 v4, 0x1

    if-eq v3, v4, :cond_5

    .line 152
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 153
    .local v4, "nodeName":Ljava/lang/String;
    const/4 v5, 0x2

    if-eq v3, v5, :cond_0

    goto :goto_2

    .line 155
    :cond_0
    const-string v5, "dbname"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 156
    const-string v5, ""

    const-string v6, "value"

    invoke-interface {v2, v5, v6}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 157
    .local v5, "dbName":Ljava/lang/String;
    invoke-virtual {v0, v5}, Lorg/litepal/parser/LitePalAttr;->setDbName(Ljava/lang/String;)V

    .line 158
    .end local v5    # "dbName":Ljava/lang/String;
    goto :goto_2

    :cond_1
    const-string v5, "version"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 159
    const-string v5, ""

    const-string v6, "value"

    invoke-interface {v2, v5, v6}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 160
    .local v5, "version":Ljava/lang/String;
    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v0, v6}, Lorg/litepal/parser/LitePalAttr;->setVersion(I)V

    .line 161
    .end local v5    # "version":Ljava/lang/String;
    goto :goto_2

    :cond_2
    const-string v5, "mapping"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 162
    const-string v5, ""

    const-string v6, "class"

    invoke-interface {v2, v5, v6}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 163
    .local v5, "className":Ljava/lang/String;
    invoke-virtual {v0, v5}, Lorg/litepal/parser/LitePalAttr;->addClassName(Ljava/lang/String;)V

    .end local v5    # "className":Ljava/lang/String;
    goto :goto_1

    .line 164
    :cond_3
    const-string v5, "cases"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 165
    const-string v5, ""

    const-string v6, "value"

    invoke-interface {v2, v5, v6}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 166
    .local v5, "cases":Ljava/lang/String;
    invoke-virtual {v0, v5}, Lorg/litepal/parser/LitePalAttr;->setCases(Ljava/lang/String;)V

    .line 167
    .end local v5    # "cases":Ljava/lang/String;
    goto :goto_2

    .line 164
    :cond_4
    :goto_1
    nop

    .line 173
    :goto_2
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v5
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move v3, v5

    .line 174
    .end local v4    # "nodeName":Ljava/lang/String;
    goto :goto_0

    .line 151
    :cond_5
    nop

    .line 180
    .end local v0    # "litePalAttr":Lorg/litepal/parser/LitePalAttr;
    .end local v1    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    .end local v2    # "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    .end local v3    # "eventType":I
    nop

    .line 181
    return-void

    .line 178
    :catch_0
    move-exception v0

    .line 179
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lorg/litepal/exceptions/ParseConfigurationFileException;

    const-string v2, "IO exception happened"

    invoke-direct {v1, v2}, Lorg/litepal/exceptions/ParseConfigurationFileException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 175
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 176
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lorg/litepal/exceptions/ParseConfigurationFileException;

    const-string v2, "can not parse the litepal.xml, check if it\'s in correct format"

    invoke-direct {v1, v2}, Lorg/litepal/exceptions/ParseConfigurationFileException;-><init>(Ljava/lang/String;)V

    throw v1

    return-void
.end method

.method useSAXParser()V
    .locals 5

    .line 117
    const/4 v0, 0x0

    :try_start_0
    invoke-static {}, Ljavax/xml/parsers/SAXParserFactory;->newInstance()Ljavax/xml/parsers/SAXParserFactory;

    move-result-object v1

    .line 118
    .local v1, "factory":Ljavax/xml/parsers/SAXParserFactory;
    invoke-virtual {v1}, Ljavax/xml/parsers/SAXParserFactory;->newSAXParser()Ljavax/xml/parsers/SAXParser;

    move-result-object v2

    invoke-virtual {v2}, Ljavax/xml/parsers/SAXParser;->getXMLReader()Lorg/xml/sax/XMLReader;

    move-result-object v2

    .line 119
    .local v2, "xmlReader":Lorg/xml/sax/XMLReader;
    new-instance v3, Lorg/litepal/parser/LitePalContentHandler;

    invoke-direct {v3}, Lorg/litepal/parser/LitePalContentHandler;-><init>()V

    move-object v0, v3

    .line 120
    .local v0, "handler":Lorg/litepal/parser/LitePalContentHandler;
    invoke-interface {v2, v0}, Lorg/xml/sax/XMLReader;->setContentHandler(Lorg/xml/sax/ContentHandler;)V

    .line 121
    new-instance v3, Lorg/xml/sax/InputSource;

    invoke-direct {p0}, Lorg/litepal/parser/LitePalParser;->getConfigInputStream()Ljava/io/InputStream;

    move-result-object v4

    invoke-direct {v3, v4}, Lorg/xml/sax/InputSource;-><init>(Ljava/io/InputStream;)V

    invoke-interface {v2, v3}, Lorg/xml/sax/XMLReader;->parse(Lorg/xml/sax/InputSource;)V
    :try_end_0
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Lorg/xml/sax/SAXException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 133
    .end local v1    # "factory":Ljavax/xml/parsers/SAXParserFactory;
    .end local v2    # "xmlReader":Lorg/xml/sax/XMLReader;
    nop

    .line 134
    return-void

    .line 131
    .end local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    :catch_0
    move-exception v1

    .line 132
    .restart local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    .local v1, "e":Ljava/io/IOException;
    new-instance v2, Lorg/litepal/exceptions/ParseConfigurationFileException;

    const-string v3, "IO exception happened"

    invoke-direct {v2, v3}, Lorg/litepal/exceptions/ParseConfigurationFileException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 128
    .end local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    .end local v1    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 129
    .restart local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    .local v1, "e":Ljavax/xml/parsers/ParserConfigurationException;
    new-instance v2, Lorg/litepal/exceptions/ParseConfigurationFileException;

    const-string v3, "parse configuration is failed"

    invoke-direct {v2, v3}, Lorg/litepal/exceptions/ParseConfigurationFileException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 125
    .end local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    .end local v1    # "e":Ljavax/xml/parsers/ParserConfigurationException;
    :catch_2
    move-exception v1

    .line 126
    .restart local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    .local v1, "e":Lorg/xml/sax/SAXException;
    new-instance v2, Lorg/litepal/exceptions/ParseConfigurationFileException;

    const-string v3, "can not parse the litepal.xml, check if it\'s in correct format"

    invoke-direct {v2, v3}, Lorg/litepal/exceptions/ParseConfigurationFileException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 122
    .end local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    .end local v1    # "e":Lorg/xml/sax/SAXException;
    :catch_3
    move-exception v1

    .line 123
    .restart local v0    # "handler":Lorg/litepal/parser/LitePalContentHandler;
    .local v1, "e":Landroid/content/res/Resources$NotFoundException;
    new-instance v2, Lorg/litepal/exceptions/ParseConfigurationFileException;

    const-string v3, "litepal.xml file is missing. Please ensure it under assets folder."

    invoke-direct {v2, v3}, Lorg/litepal/exceptions/ParseConfigurationFileException;-><init>(Ljava/lang/String;)V

    throw v2
.end method
