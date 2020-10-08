package uk.nhs.covid19.config

// this is just an example public key generated with:
// openssl ecparam -genkey -name prime256v1 -noout -out key.txt
// openssl ec -in key.txt -pubout -out -
internal val stagingSignatureKey = SignatureKey(
    id = "",
    pemRepresentation = """
        -----BEGIN PUBLIC KEY-----
        MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEmRhWDuWAYBdvVQXE3H+ToC2WzKEj
        bDTBWz6tPlwS3IAaDkLoTu0fwJeRQjzpoxG8C5pYtC1D38ePa0I4NQExqA==
        -----END PUBLIC KEY-----
        """.trimIndent()
)

object Configurations {

    val staging = EnvironmentConfiguration(
        name = "Staging",
        distributedRemote = Remote(
            host = "example.com",
            path = null,
            certificates = amazonRoots,
            signatureKeys = listOf(stagingSignatureKey)
        ),
        apiRemote = Remote(
            host = "example.com",
            path = null,
            headers = mapOf("Authorization" to ""),
            certificates = amazonRoots,
            signatureKeys = listOf(stagingSignatureKey)
        )
    )

    val allConfigs = listOf(staging)
}
