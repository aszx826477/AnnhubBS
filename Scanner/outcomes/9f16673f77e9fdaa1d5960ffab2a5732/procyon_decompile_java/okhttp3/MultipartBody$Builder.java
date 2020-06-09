// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import okio.ByteString;

public final class MultipartBody$Builder
{
    private final ByteString boundary;
    private final List parts;
    private MediaType type;
    
    public MultipartBody$Builder() {
        this(UUID.randomUUID().toString());
    }
    
    public MultipartBody$Builder(final String s) {
        this.type = MultipartBody.MIXED;
        this.parts = new ArrayList();
        this.boundary = ByteString.encodeUtf8(s);
    }
    
    public MultipartBody$Builder addFormDataPart(final String s, final String s2) {
        return this.addPart(MultipartBody$Part.createFormData(s, s2));
    }
    
    public MultipartBody$Builder addFormDataPart(final String s, final String s2, final RequestBody requestBody) {
        return this.addPart(MultipartBody$Part.createFormData(s, s2, requestBody));
    }
    
    public MultipartBody$Builder addPart(final Headers headers, final RequestBody requestBody) {
        return this.addPart(MultipartBody$Part.create(headers, requestBody));
    }
    
    public MultipartBody$Builder addPart(final MultipartBody$Part multipartBody$Part) {
        if (multipartBody$Part != null) {
            this.parts.add(multipartBody$Part);
            return this;
        }
        throw new NullPointerException("part == null");
    }
    
    public MultipartBody$Builder addPart(final RequestBody requestBody) {
        return this.addPart(MultipartBody$Part.create(requestBody));
    }
    
    public MultipartBody build() {
        if (!this.parts.isEmpty()) {
            return new MultipartBody(this.boundary, this.type, this.parts);
        }
        throw new IllegalStateException("Multipart body must have at least one part.");
    }
    
    public MultipartBody$Builder setType(final MediaType type) {
        if (type == null) {
            throw new NullPointerException("type == null");
        }
        if (type.type().equals("multipart")) {
            this.type = type;
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("multipart != ");
        sb.append(type);
        throw new IllegalArgumentException(sb.toString());
    }
}
