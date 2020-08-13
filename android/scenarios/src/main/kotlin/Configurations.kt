package uk.nhs.covid19.config

object Configurations {

    val qa = EnvironmentConfiguration(
        name = "QA",
        distributedRemote = Remote(
            host = "exaple.com",
            path = null,
            certificates = amazonRoots
        ),
        apiRemote = Remote(
            host = "exaple.com",
            path = null,
            headers = mapOf("Authorization" to ""),
            certificates = amazonRoots
        )
    )

    val assuranceFunctional = EnvironmentConfiguration(
        "Assurance Functional",
        Remote(
            host = "exaple.com",
            path = null,
            certificates = amazonRoots
        ),
        apiRemote = Remote(
            host = "exaple.com",
            path = null,
            headers = mapOf("Authorization" to ""),
            certificates = amazonRoots
        )
    )

    val demo = EnvironmentConfiguration(
        name = "Demo",
        distributedRemote = Remote(
            host = "exaple.com",
            path = null,
            certificates = amazonRoots
        ),
        apiRemote = Remote(
            host = "exaple.com",
            path = null,
            headers = mapOf("Authorization" to ""),
            certificates = amazonRoots
        )
    )

    val ci = EnvironmentConfiguration(
        name = "CI",
        distributedRemote = Remote(
            host = "exaple.com",
            path = null,
            certificates = amazonRoots
        ),
        apiRemote = Remote(
            host = "exaple.com",
            path = null,
            headers = mapOf("Authorization" to ""),
            certificates = amazonRoots
        )
    )

    val test = EnvironmentConfiguration(
        name = "Test",
        distributedRemote = Remote(
            host = "exaple.com",
            path = null,
            certificates = amazonRoots
        ),
        apiRemote = Remote(
            host = "exaple.com",
            path = null,
            headers = mapOf("Authorization" to ""),
            certificates = amazonRoots
        )
    )

    val allConfigs = listOf(qa, assuranceFunctional, demo, ci, test)
}
