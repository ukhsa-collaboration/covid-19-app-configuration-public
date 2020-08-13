import Foundation

public extension EnvironmentConfiguration {
    
    static let production = EnvironmentConfiguration(
        identifier: "production",
        distributionRemote: Remote(
            host: "exaple.com",
            path: "",
            publicKeyPins: [],
            signatureKey: .prod
        ),
        submissionRemote: Remote(
            host: "exaple.com",
            path: "",
            headers: [
                "Authorization" : ""
            ],
            publicKeyPins: [],
            signatureKey: .prod
        )
    )
    
}

extension Remote.SignatureKey {
    
    static let prod = Remote.SignatureKey(
        id: "",
        pemRepresentation: ""
    )
    
}
