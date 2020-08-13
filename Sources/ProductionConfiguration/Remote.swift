
public struct Remote: Codable {
    
    public struct SignatureKey: Codable {
        public var id: String
        public var pemRepresentation: String
        
        public init(id: String, pemRepresentation: String) {
            self.id = id
            self.pemRepresentation = pemRepresentation
        }
    }
    
    public var host: String
    public var path: String
    public var headers: [String: String]
    public var publicKeyPins: [PublicKeyPin]
    public var signatureKey: SignatureKey
    
    public init(
        host: String,
        path: String,
        headers: [String: String] = [:],
        publicKeyPins: [PublicKeyPin],
        signatureKey: SignatureKey
    ) {
        self.host = host
        self.path = path
        self.headers = headers
        self.publicKeyPins = publicKeyPins
        self.signatureKey = signatureKey
    }
}
