import org.junit.jupiter.api.Test
import uk.nhs.covid19.config.Configurations
import uk.nhs.covid19.config.EnvironmentConfiguration
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.util.*

class ParsingPemRepresentationTest {

    private val keyFactory = KeyFactory.getInstance("EC")
    private val decoder = Base64.getDecoder()

    @Test
    fun `parsing pem representation`() {
        Configurations.allConfigs.forEach {
            loadsPemRepresentation(it)
        }
    }

    private fun loadsPemRepresentation(environmentConfiguration: EnvironmentConfiguration) {
        (environmentConfiguration.apiRemote.signatureKeys + environmentConfiguration.distributedRemote.signatureKeys).map { key ->
            decoder.decode(key.pemRepresentation
                .split("\n")
                .filter { !(it.isEmpty() || it.startsWith("-----")) }
                .joinToString(""))
        }.forEach {
            keyFactory.generatePublic(X509EncodedKeySpec(it))
        }
    }
}