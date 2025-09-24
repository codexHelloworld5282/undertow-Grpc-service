# 🚀 underTowJavaGrpcNodejs  

![Java](https://img.shields.io/badge/Java-11-orange?logo=java&logoColor=white)  
![Node.js](https://img.shields.io/badge/Node.js-18-green?logo=node.js&logoColor=white)  
![Express](https://img.shields.io/badge/Express.js-grey?logo=express&logoColor=white)  
![MongoDB](https://img.shields.io/badge/MongoDB-4.x-brightgreen?logo=mongodb&logoColor=white)  
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.x-ff6600?logo=rabbitmq&logoColor=white)  
![License](https://img.shields.io/badge/License-MIT-blue)  

A **full-stack integration project** demonstrating:  
✔️ gRPC communication between **Java ↔ Node.js**  
✔️ **RabbitMQ** for async messaging  
✔️ **MongoDB** for persistence  
✔️ Scalable & modular **Node.js API backend**  

---

## 📖 Overview  

This project showcases **good practices** in building distributed systems:  
- 💡 *gRPC* for high-performance inter-service communication  
- 🐇 *RabbitMQ* for event-driven architecture  
- 🗄️ *MongoDB* for data storage  
- ⚡ *Node.js clustering* for scalability  

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
