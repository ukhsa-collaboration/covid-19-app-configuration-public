package uk.nhs.covid19.config

val production = EnvironmentConfiguration(
    name = "Production",
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
