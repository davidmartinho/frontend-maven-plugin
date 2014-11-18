# Frontend Maven Plugin
===

A maven plugin to run tomcat in a embedded server, while automatically
watching for browserify bundle file changes.

## Installation
* Clone this repo
```
git clone 
```

* Run maven install
```
mvn install
```

## Usage
* Include the plugin on the pom file of your webapp
```
<plugin>
    <groupId>org.fenixedu</groupId>
    <artifactId>frontend-maven-plugin</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <configuration>
        <path>CONTEXT_PATH</path>
        <port>PORT</port>
        <warSourceDirectory>
            STATIC_FILES_DIRECTORY
        </warSourceDirectory>
        <sourceFile>
            BROWSERIFY_ENTRY_FILE.js
        </sourceFile>
        <outputFile>
            BROWSERIFY_BUNDLE_FILE.js 
        </outputFile>
    </configuration>
</plugin>
```

* Replace CONTEXT_PATH, PORT, STATIC_FILES_DIRECTORY, BROWSERIFY_ENTRY_FILE.js
and BROWSERIFY_BUNDLE_FILE.js according to your webapp settings

* On your webapp root directory run the following command:
```
mvn frontend:server
```

* Open your browser on <a href="http://localhost:PORT/CONTEXT_PATH">http://localhost:PORT/CONTEXT_PATH</a> and enjoy
