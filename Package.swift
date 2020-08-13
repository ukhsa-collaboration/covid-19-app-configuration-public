// swift-tools-version:5.2

import PackageDescription

let package = Package(
    name: "AppConfiguration",
    platforms: [.iOS(.v13), .macOS(.v10_15)],
    products: [
        .library(
            name: "ProductionConfiguration",
            targets: ["ProductionConfiguration"]
        ),
        .library(
            name: "ScenariosConfiguration",
            targets: ["ScenariosConfiguration"]
        ),
        .executable(
            name: "config",
            targets: ["ConfigurationTester"]
        )
    ],
    dependencies: [
    ],
    targets: [
        .target(
            name: "ProductionConfiguration",
            dependencies: []
        ),
        .target(
            name: "ScenariosConfiguration",
            dependencies: ["ProductionConfiguration"]
        ),
        .target(
            name: "ConfigurationTester",
            dependencies: [
                "ProductionConfiguration",
                "ScenariosConfiguration",
            ]
        ),
    ]
)
