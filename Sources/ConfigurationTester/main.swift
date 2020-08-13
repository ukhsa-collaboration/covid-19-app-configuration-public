import Foundation
import ProductionConfiguration
import ScenariosConfiguration

let fileManager = FileManager()

let currentDirectory = URL(fileURLWithPath: fileManager.currentDirectoryPath)
let configurationsFolder = currentDirectory
    .appendingPathComponent("Configurations")

let encoder = JSONEncoder()
encoder.outputFormatting = [.sortedKeys, .prettyPrinted]

protocol Visitor {
    func visit<Configuration: Encodable>(_ configuration: Configuration, url: URL) throws
}

struct TestVisitor: Visitor {
    func visit<Configuration: Encodable>(_ configuration: Configuration, url: URL) throws {
        let data = try Data(contentsOf: url)

        if try encoder.encode(configuration) != data {
            throw CustomError("Saved configuration does not match Swift configuration")
        }
    }
}

struct SaveVisitor: Visitor {
    func visit<Configuration: Encodable>(_ configuration: Configuration, url: URL) throws {
        try encoder.encode(configuration).write(to: url)
    }
}

do {
    let arguments = ProcessInfo.processInfo.arguments
    let visitor: Visitor = arguments.contains("--test") ? TestVisitor() : SaveVisitor()
    
    try visitor.visit(FieldTestConfiguration.shared, url: configurationsFolder.appendingPathComponent("field-test.json"))
} catch {
    print(error)
    print("Run `swift run config` to update the configuration jsons from Swift file.")
    exit(1)
}

