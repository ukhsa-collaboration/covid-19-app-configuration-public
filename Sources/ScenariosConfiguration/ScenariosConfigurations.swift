import ProductionConfiguration


public extension EnvironmentConfiguration {
    
    static let qa = EnvironmentConfiguration(
        identifier: "qa",
        distributionRemote: Remote(
            host: "exaple.com",
            path: "",
            publicKeyPins: [],
            signatureKey: .dev
        ),
        submissionRemote: Remote(
            host: "exaple.com",
            path: "",
            headers: [
                "Authorization": ""
            ],
            publicKeyPins: [],
            signatureKey: .dev
        )
    )
    
    static let assuranceFunctional = EnvironmentConfiguration(
        identifier: "assuranceFunctional",
        distributionRemote: Remote(
            host: "exaple.com",
            path: "",
            publicKeyPins: [],
            signatureKey: .dev
        ),
        submissionRemote: Remote(
            host: "exaple.com",
            path: "",
            headers: [
                "Authorization": ""
            ],
            publicKeyPins: [],
            signatureKey: .dev
        )
    )
    
    static let demo = EnvironmentConfiguration(
        identifier: "demo",
        distributionRemote: Remote(
            host: "exaple.com",
            path: "",
            publicKeyPins: [],
            signatureKey: .dev
        ),
        submissionRemote: Remote(
            host: "exaple.com",
            path: "",
            headers: [
                "Authorization": ""
            ],
            publicKeyPins: [],
            signatureKey: .dev
        )
    )
    
    static let dev = EnvironmentConfiguration(
        identifier: "dev",
        distributionRemote: Remote(
            host: "exaple.com",
            path: "",
            publicKeyPins: [],
            signatureKey: .dev
        ),
        submissionRemote: Remote(
            host: "exaple.com",
            path: "",
            headers: [
                "Authorization": ""
            ],
            publicKeyPins: [],
            signatureKey: .dev
        )
    )
    
    static let test = EnvironmentConfiguration(
        identifier: "test",
        distributionRemote: Remote(
            host: "exaple.com",
            path: "",
            publicKeyPins: [],
            signatureKey: .dev
        ),
        submissionRemote: Remote(
            host: "exaple.com",
            path: "",
            headers: [
                "Authorization": ""
            ],
            publicKeyPins: [],
            signatureKey: .dev
        )
    )
}

public extension FieldTestConfiguration {
    
    static let shared = FieldTestConfiguration(remote: .fieldTest)
    
}

private extension Remote {
    
    static let fieldTest = Remote(
        host: "",
        path: "",
        headers: [
            "x-api-key": "",
        ],
        publicKeyPins: [],
        signatureKey: .dev
    )
    
}

extension Remote.SignatureKey {
    
    static let dev = Remote.SignatureKey(
        id: "",
        pemRepresentation: ""
    )
    
}
