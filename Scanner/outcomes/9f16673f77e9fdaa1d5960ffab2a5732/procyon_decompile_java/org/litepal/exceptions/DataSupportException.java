// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.exceptions;

public class DataSupportException extends RuntimeException
{
    public static final String ID_TYPE_INVALID_EXCEPTION = "id type is not supported. Only int or long is acceptable for id";
    public static final String INSTANTIATION_EXCEPTION = " needs a default constructor.";
    public static final String MODEL_IS_NOT_AN_INSTANCE_OF_DATA_SUPPORT = " should be inherited from DataSupport";
    public static final String SAVE_FAILED = "Save current model failed.";
    public static final String UPDATE_CONDITIONS_EXCEPTION = "The parameters in conditions are incorrect.";
    public static final String WRONG_FIELD_TYPE_FOR_ASSOCIATIONS = "The field to declare many2one or many2many associations should be List or Set.";
    private static final long serialVersionUID = 1L;
    
    public DataSupportException(final String s) {
        super(s);
    }
    
    public DataSupportException(final String s, final Throwable t) {
        super(s, t);
    }
    
    public static String noSuchFieldExceptioin(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("The ");
        sb.append(s2);
        sb.append(" field in ");
        sb.append(s);
        sb.append(" class is necessary which does not exist.");
        return sb.toString();
    }
    
    public static String noSuchMethodException(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("The ");
        sb.append(s2);
        sb.append(" method in ");
        sb.append(s);
        sb.append(" class is necessary which does not exist.");
        return sb.toString();
    }
}
