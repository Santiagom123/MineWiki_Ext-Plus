
# MineWiki_Ext Plus

## Run Released JAR

Execute inside the folder where the JAR file is located:

```

java -jar MineWikiExtPlus-{Version}.jar {modid}:{id}:{metadata}

```

If `id` or `metadata` are not required, replace them with `0`.

Example:

```

java -jar MineWikiExtPlus-1.0.0.jar examplemod:0:0

```

---

# Build and Compile

## Requirements

- JDK 8
- Gradle 8.5 (use a standalone installation instead of relying on the wrapper if versions differ)

---

# IntelliJ IDEA

## Setup

Open project as Gradle project.

Set project configuration:

```

File → Project Structure → Project

```

- Project SDK → JDK 8  
- Language Level → 8  

### Configure Gradle

```

Settings → Build, Execution, Deployment → Build Tools → Gradle

```

Set:

- Gradle JVM → JDK 8  
- Gradle Distribution → Gradle 8.5 installation

## Build

Use the Gradle tool window:

```

Tasks → build → build

```

Or via terminal:

```

gradle clean build

```

## Output

```

build/libs/

```

The generated JAR is the release artifact.

---

# VS Code

## Recommended Extensions

- Java Extension Pack
- Gradle for Java

## Setup

Open project folder.

Verify:

```

java -version

```

Must be JDK 8.

Verify Gradle:

```

gradle -v

```

Ensure version 8.5 is used.

## Build

```

gradle clean build

```

Output:

```

build/libs/

```

---

# Eclipse

## Setup

Install Eclipse IDE for Java Developers.

Configure JDK:

```

Window → Preferences → Java → Installed JREs

```

Set JDK 8 as default.

## Import Project

```

File → Import → Gradle → Existing Gradle Project

```

Select project folder.

## Build

Right click project:

```

Gradle → Tasks → build → build

```

Or:

```

gradle clean build

```

---

## Output

```

build/libs/

```

Use the generated JAR for distribution.

---

Always ensure:

- Java 8 compatibility  
- Gradle 8.5 execution  
- Clean build before release  
```

