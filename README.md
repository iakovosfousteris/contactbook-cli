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
1. Download `gson-2.10.1.jar` into `lib/`
2. `javac -cp "lib/*" -d out src/*.java`
3. `java -cp "out:lib/*" Main`