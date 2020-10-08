package uk.nhs.covid19.config

data class EnvironmentConfiguration(
    val name: String,
    val distributedRemote: Remote,
    val apiRemote: Remote
) {
    val distributedRemoteBaseUrl =
        "https://${distributedRemote.host}/" + if (distributedRemote.path != null) "${distributedRemote.path}/" else ""
    val apiRemoteBaseUrl =
        "https://${apiRemote.host}/" + if (apiRemote.path != null) "${apiRemote.path}/" else ""
}

data class Remote(
    val host: String,
    val path: String?,
    val headers: Map<String, String> = emptyMap(),
    val certificates: List<String> = emptyList(),
    val signatureKeys: List<SignatureKey> = emptyList()
)

data class SignatureKey(
    val id: String,
    val pemRepresentation: String
)

private const val AmazonRootCA1 = "++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI="
private const val AmazonRootCA2 = "f0KW/FtqTjs108NpYj42SrGvOB2PpxIVM8nWxjPqJGE="
private const val AmazonRootCA3 = "47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU="
private const val AmazonRootCA4 = "9+ze1cZgR9KO1kZrVDxA4HQ6voHRCSVNz4RdTCx4U8U="
private const val StarfieldServicesRootCA = "KwccWaCgrnaw6tsrrSO61FgLacNgG2MMLq8GE6+oP5I="
private const val DigiCert = "i7WTqTvh0OioIruIfFR4kMPnBqrS2rdiVPl/s2uC/CY="

val amazonRoots =
    listOf(AmazonRootCA1, AmazonRootCA2, AmazonRootCA3, AmazonRootCA4, StarfieldServicesRootCA)
val digiCertRoots = listOf(DigiCert)

// this is just an example public key generated with:
// openssl ecparam -genkey -name prime256v1 -noout -out key.txt
// openssl ec -in key.txt -pubout -out -
val qrCodesSignatureKey = SignatureKey(
    id = "",
    pemRepresentation = """
            -----BEGIN PUBLIC KEY-----
        MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEmRhWDuWAYBdvVQXE3H+ToC2WzKEj
        bDTBWz6tPlwS3IAaDkLoTu0fwJeRQjzpoxG8C5pYtC1D38ePa0I4NQExqA==
        -----END PUBLIC KEY-----
    """.trimIndent()
)