package uk.nhs.covid19.config

val FieldTestConfiguration = EnvironmentConfiguration(
    name = "Field test",
    distributedRemote = Remote(
        host = "example.com",
        path = "Test/v1",
        headers = mapOf("x-api-key" to "key")
    ),
    apiRemote = Remote(
        host = "example.com",
        path = "Test/v1",
        headers = mapOf("x-api-key" to "key")
    )
)
