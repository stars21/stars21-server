package cn.stars21.util;

import java.nio.charset.Charset;

public class Constant {

    public static final String DefultCharsetName = "utf-8";
    public static final Charset DefultCharset = Charset.forName(DefultCharsetName);
    public static final String LineSeparator = System.getProperty("line.separator");
    public static final String HTTPSERVICE_RESULT = "resultStatus";
    public static final String HTTPSERVICE_DESCRIPTION = "errorMessage";
    public static final String HTTPSERVICE_DATA = "data";
    public static final Integer RESULT_SUCCESS = Integer.valueOf(0);
    public static final Integer RESULT_FAILURE = Integer.valueOf(1);
    public static final String HTTPSERVICE_UNKNOWN = "Unknown error.";
    public static final String PAGE_REQUEST_SIZE = "size";
    public static final String PAGE_REQUEST_PAGE = "page";
    public static final int DEFAULT_PAGE_SIZE = 20;

}