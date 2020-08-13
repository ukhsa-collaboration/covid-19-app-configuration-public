import Foundation

public struct PublicKeyPin: Codable {
    public var base64EncodedString: String
    
    public init(_ base64EncodedString: String) {
        self.base64EncodedString = base64EncodedString
    }
    
    public init(from decoder: Decoder) throws {
        self.init(try decoder.singleValueContainer().decode(String.self))
    }
    
    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        try container.encode(base64EncodedString)
    }
}
