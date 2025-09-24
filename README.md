# 🚀 underTowJavaGrpcNodejs  

![Java](https://img.shields.io/badge/Java-11-orange?logo=java&logoColor=white)  
![Node.js](https://img.shields.io/badge/Node.js-18-green?logo=node.js&logoColor=white)  
![Express](https://img.shields.io/badge/Express.js-grey?logo=express&logoColor=white)  
![MongoDB](https://img.shields.io/badge/MongoDB-4.x-brightgreen?logo=mongodb&logoColor=white)  
![License](https://img.shields.io/badge/License-MIT-blue)  

A **full-stack integration project** demonstrating:  
✔️ gRPC communication between **Java ↔ Node.js**  
✔️ **MongoDB** for persistence  
✔️ Scalable & modular **Node.js API backend**  

---
## 📂 Project Structure  


underTowJavaGrpcNodejs/
├── java/                         
│   ├── src/main/java/org/example/
│   │   ├── handlers/             # gRPC handlers
│   │   ├── utils/                # Helper classes
│   │   └── proto/                # Protobuf definitions
│
├── nodejs/
│   ├── src/
│   │   ├── constants/            # Centralized path constants
│   │   ├── controllers/          # Express controllers
│   │   ├── models/               # MongoDB models
│   │   ├── routes/               # Express routes
│   │   ├── services/
│   │   │   └── rabbitMq/         # Publisher, Consumer, Connection
│   │   ├── app.js                # Express app config
│   │   └── server.js             # Entry point


## 📖 Overview  

This project showcases **good practices** in building distributed systems:  
- 💡 *gRPC* for high-performance inter-service communication  
- 🐇 *RabbitMQ* for event-driven architecture  
- 🗄️ *MongoDB* for data storage  
- ⚡ *Node.js clustering* for scalability

##⚙️ Setup & Installation
🔹 Java (gRPC Server)
cd java
mvn clean install
mvn exec:java

🔹 Node.js (API & RabbitMQ Consumer)
cd nodejs
npm install
npm start

🗄️ MongoDB Setup
docker run -d -p 27017:27017 --name mongodb mongo:latest

##📬 Example API Request
POST http://localhost:3000/api/v1/orders
Content-Type: application/json

{
  "orderId": "12345",
  "item": "Laptop",
  "quantity": 2
}


✔️ Stored in MongoDB
✔️ Sent to RabbitMQ queue
✔️ Processed by Consumer

## ✅ Good Practices Followed

🧩 Separation of Concerns → Modular routes, services, and controllers

📌 Centralized Constants → All API paths in one file

📡 Async Handling → Decoupled producer/consumer using RabbitMQ

⚡ Scalability → Node.js clustering enabled

📝 Clean Git Workflow → Clear commits & PR process

## 🤝 Contributing

Fork the repo

Create a feature branch → git checkout -b feature/my-feature

Commit → git commit -m "Add my feature"

Push → git push origin feature/my-feature

Open a Pull Request 🎉

##📜 License

This project is licensed under the MIT License.


