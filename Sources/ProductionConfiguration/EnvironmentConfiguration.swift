import Foundation

public struct EnvironmentConfiguration {
    public var identifier: String
    public var distributionRemote: Remote
    public var submissionRemote: Remote
    
    public init(identifier: String, distributionRemote: Remote, submissionRemote: Remote) {
        self.identifier = identifier
        self.distributionRemote = distributionRemote
        self.submissionRemote = submissionRemote
    }
}
