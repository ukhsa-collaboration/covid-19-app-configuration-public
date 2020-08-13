import Foundation

struct CustomError: Error, CustomStringConvertible {
    var description: String
    
    init(_ description: String) {
        self.description = description
    }
    
    init(_ description: String, underlyingError: Error) {
        self.description = "\(description): \(underlyingError)"
    }
    
}
