# Java Server Projects 🚀

This repository contains three different Java server implementations demonstrating various networking concepts using socket programming.

---

## 📁 Project Overview

### **1️⃣ Single Thread Server** (Simple Chat - One at a Time)

```
Client (You)                    Server (Computer)
    |                                |
    |--[Connect to port 8081]------->|
    |                                | "Someone connected!"
    |                                |
    |<--[Hello, Message from Server]-|
    |                                |
    |--[Close connection]----------->|
    ✅ Done!                         ✅ Done!
```

**What happens:**
- 1 client talks to 1 server
- Server says "Hello" and closes
- Like calling one friend at a time on the phone 📞

**Location:** `singleThreadServer/`  
**Port:** 8081

---

### **2️⃣ Multi Thread Server** (Group Chat - Many at Once)

```
Client 1, 2, 3...100 (Many people)       Server (Computer)
         |                                      |
         |----[100 people connect]------------->|
         |                                      |
         |                                   [Makes 100
         |                                    helper threads]
         |                                      |
         |<-----[Hi, message from server]------|
         |                                      |
         ✅ All 100 get messages!              ✅ Handles everyone!
```

**What happens:**
- 100 clients connect at the same time!
- Server creates a helper (thread) for each person
- Everyone gets "hi, message from server Side"
- Like a group video call with 100 friends 👥

**Location:** `MultiThreadServer/`  
**Port:** 8080

---

### **3️⃣ File Read Server** (Story Time - Reads a Book)

```
Client 1, 2, 3...100                    Server (Computer)
         |                                      |
         |----[100 people connect]------------->|
         |                                      |
         |                                   [Opens file:
         |                                    java_full_stack_notes.txt]
         |                                      |
         |<----[Line 1 from file]---------------|
         |<----[Line 2 from file]---------------|
         |<----[Line 3 from file]---------------|
         |<----[...more lines...]---------------|
         |                                      |
         ✅ Everyone gets the whole story!     ✅ Done reading!
```

**What happens:**
- 100 clients connect at once
- Server reads a text file line by line
- Sends every line to all clients
- Like a teacher reading a book to the whole class 📖

**Location:** `FileReadServer/`  
**Port:** 8080

---

## 🎯 Summary

| Project | Description | Use Case |
|---------|-------------|----------|
| **Single Thread** | Talk to one person at a time | Like texting one friend |
| **Multi Thread** | Talk to many people at once | Like a group chat |
| **File Read** | Share a story with everyone | Like reading aloud in class |

All three use **sockets** (special computer connections) to send messages back and forth!

---

## 🚀 How to Run

### **Single Thread Server**
```bash
# Terminal 1 - Start Server
cd singleThreadServer
javac Server.java
java Server

# Terminal 2 - Start Client
cd singleThreadServer
javac Client.java
java Client
```

### **Multi Thread Server**
```bash
# Terminal 1 - Start Server
cd MultiThreadServer
javac Server.java
java Server

# Terminal 2 - Start Client (runs 100 threads)
cd MultiThreadServer
javac Client.java
java Client
```

### **File Read Server**
```bash
# Terminal 1 - Start Server
cd FileReadServer
javac Server.java
java Server

# Terminal 2 - Start Client (runs 100 threads)
cd FileReadServer
javac Client.java
java Client
```

---

## 📝 Requirements

- **Java JDK** 8 or higher
- Basic understanding of:
  - Socket programming
  - Multi-threading
  - Network I/O streams

---

## 🔧 Technical Details

### **Key Concepts Used:**
- `ServerSocket` - Creates server that listens on a port
- `Socket` - Establishes connection between client and server
- `PrintWriter` - Sends data from server to client
- `BufferedReader` - Receives data from server at client
- `Thread` - Handles multiple clients simultaneously
- `Consumer<Socket>` - Functional interface for handling client connections

### **Important Notes:**
- Make sure the required ports (8080, 8081) are available before running
- For FileReadServer, ensure `java_full_stack_notes.txt` exists in the same directory as Server.java
- All servers have a timeout of 10-15 seconds (configurable via `setSoTimeout()`)
- Always flush `PrintWriter` after writing to ensure data is sent immediately

---

## 📚 Learning Objectives

By studying these projects, you will learn:
1. **Basic socket programming** - Client-server communication
2. **Single vs Multi-threaded servers** - Understanding concurrency
3. **File I/O with networking** - Reading and transmitting file contents
4. **Proper resource management** - Closing connections and streams
5. **Network programming best practices** - Flushing buffers, handling exceptions

---

## 🤝 Contributing

Feel free to fork this repository and submit pull requests with improvements!

---

## 📄 License

This project is open source and available for educational purposes.

---

## 👨‍💻 Author

Created as a learning project to demonstrate Java networking concepts.

---

**Happy Coding! 💻✨**
