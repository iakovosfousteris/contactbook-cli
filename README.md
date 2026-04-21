# contactbook-cli
Java CLI contact manager with JSON persistence
# ContactBook CLI

Command-line contact manager built with Java. Implements full CRUD operations with JSON file persistence.

### **Tech Stack**
Java 17, Gson, Git, JSON

### **Features**
- Add, list, search, update, delete contacts via CLI
- Data persistence in `contacts.json`
- Input validation and error handling for file I/O

### **How to Run**
1. Download `gson-2.10.1.jar` into `lib/` from https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/
2. Compile: `javac -cp "lib/*" -d out src/*.java`
3. Run: `java -cp "out;lib/*" Main`
4. `contacts.json` will be created automatically on first run