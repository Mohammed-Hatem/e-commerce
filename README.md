# 🛒 E-Commerce System

A modular, object-oriented e-commerce system implemented in Java. This project demonstrates core design principles like encapsulation, composition, and separation of concerns — serving as a lightweight simulation of an online retail backend.

---

## 🚀 Features

- 📦 Product and Cart management with quantity support  
- 🧾 Checkout system with invoice 
- 💡 Emphasis on clean, maintainable OOP structure  
- ✅ Includes validations and error handling for edge cases  

---

## 📁 Project Structure

```plaintext
e-commerce/
├── src/             # Java source files
│   ├── Product.java
│   ├── Cart.java
│   ├── CartItem.java
│   ├── Customer.java
│   ├── Shipment.java
│   ├── Invoice.java
│   ├── test.java     # Entry point
│   └── ... 
├── out/             # Compiled class files (generated after build)
└── README.md
```
---

# 🔨 Compile
    javac -d out src/*.java

---

# ▶️ Run
    java -cp out Main

---

# 🧠 Design Considerations

Immutable Product objects

CartItem composition for quantity tracking

Separation of Invoice and Shipment logic

Main method for simulation and testing
