.class final Lokhttp3/internal/tls/TrustRootIndex$BasicTrustRootIndex;
.super Lokhttp3/internal/tls/TrustRootIndex;
.source "TrustRootIndex.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lokhttp3/internal/tls/TrustRootIndex;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BasicTrustRootIndex"
.end annotation


# instance fields
.field private final subjectToCaCerts:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljavax/security/auth/x500/X500Principal;",
            "Ljava/util/List<",
            "Ljava/security/cert/X509Certificate;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public varargs constructor <init>([Ljava/security/cert/X509Certificate;)V
    .locals 7
    .param p1, "caCerts"    # [Ljava/security/cert/X509Certificate;

    .line 88
    invoke-direct {p0}, Lokhttp3/internal/tls/TrustRootIndex;-><init>()V

    .line 89
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lokhttp3/internal/tls/TrustRootIndex$BasicTrustRootIndex;->subjectToCaCerts:Ljava/util/Map;

    .line 90
    array-length v0, p1

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    aget-object v2, p1, v1

    .line 91
    .local v2, "caCert":Ljava/security/cert/X509Certificate;
    invoke-virtual {v2}, Ljava/security/cert/X509Certificate;->getSubjectX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v3

    .line 92
    .local v3, "subject":Ljavax/security/auth/x500/X500Principal;
    iget-object v4, p0, Lokhttp3/internal/tls/TrustRootIndex$BasicTrustRootIndex;->subjectToCaCerts:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 93
    .local v4, "subjectCaCerts":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/X509Certificate;>;"
    if-nez v4, :cond_0

    .line 94
    new-instance v5, Ljava/util/ArrayList;

    const/4 v6, 0x1

    invoke-direct {v5, v6}, Ljava/util/ArrayList;-><init>(I)V

    move-object v4, v5

    .line 95
    iget-object v5, p0, Lokhttp3/internal/tls/TrustRootIndex$BasicTrustRootIndex;->subjectToCaCerts:Ljava/util/Map;

    invoke-interface {v5, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 93
    :cond_0
    nop

    .line 97
    :goto_1
    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 90
    .end local v2    # "caCert":Ljava/security/cert/X509Certificate;
    .end local v3    # "subject":Ljavax/security/auth/x500/X500Principal;
    .end local v4    # "subjectCaCerts":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/X509Certificate;>;"
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 99
    :cond_1
    return-void
.end method


# virtual methods
.method public findByIssuerAndSignature(Ljava/security/cert/X509Certificate;)Ljava/security/cert/X509Certificate;
    .locals 7
    .param p1, "cert"    # Ljava/security/cert/X509Certificate;

    .line 102
    invoke-virtual {p1}, Ljava/security/cert/X509Certificate;->getIssuerX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v0

    .line 103
    .local v0, "issuer":Ljavax/security/auth/x500/X500Principal;
    iget-object v1, p0, Lokhttp3/internal/tls/TrustRootIndex$BasicTrustRootIndex;->subjectToCaCerts:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 104
    .local v1, "subjectCaCerts":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/X509Certificate;>;"
    const/4 v2, 0x0

    if-nez v1, :cond_0

    return-object v2

    .line 106
    :cond_0
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/security/cert/X509Certificate;

    .line 107
    .local v4, "caCert":Ljava/security/cert/X509Certificate;
    invoke-virtual {v4}, Ljava/security/cert/X509Certificate;->getPublicKey()Ljava/security/PublicKey;

    move-result-object v5

    .line 109
    .local v5, "publicKey":Ljava/security/PublicKey;
    :try_start_0
    invoke-virtual {p1, v5}, Ljava/security/cert/X509Certificate;->verify(Ljava/security/PublicKey;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 110
    return-object v4

    .line 111
    :catch_0
    move-exception v6

    .line 113
    .end local v4    # "caCert":Ljava/security/cert/X509Certificate;
    .end local v5    # "publicKey":Ljava/security/PublicKey;
    goto :goto_0

    .line 115
    :cond_1
    return-object v2
.end method
