# 🧾 Java Console-Based Inventory Management System (with Admin & Staff Roles)

A **console-based** Java project that manages inventory items, handles smart search, stock analytics, and provides a **request system** where staff can propose changes and the admin can approve or deny them.

---

## 🧭 SYSTEM FLOW OVERVIEW

```
          ┌────────────────────┐
          │     LOGIN MENU     │
          └────────┬───────────┘
                   │
          ┌────────┴────────┐
          │                 │
     [ADMIN LOGIN]      [STAFF LOGIN]
          │                 │
          ▼                 ▼
 ┌────────────────┐   ┌────────────────┐
 │  ADMIN MENU    │   │   STAFF MENU   │
 └────────────────┘   └────────────────┘
          │                 │
          │                 │
          ▼                 ▼
   ┌────────────────┐   ┌────────────────────────┐
   │ Manage Items   │   │  View Inventory        │
   │  (Add/Edit/Del)│   │  Submit Change Request │
   └────────────────┘   └────────────────────────┘
          │                 │
          ▼                 │
   ┌────────────────────────┘
   │   View Staff Requests
   │   Approve or Deny
   │   Update Inventory
   └───────────┬────────────
               ▼
         ┌───────────────┐
         │  Analytics    │
         │  (Totals +    │
         │   Bar Graph)  │
         └───────────────┘
               │
               ▼
         ┌───────────────┐
         │ File Handling │
         │ Save & Load   │
         │ inventory.txt │
         └───────────────┘
```

---

## ⚙️ FEATURES

### 👑 Admin Capabilities
- Add, edit, or delete inventory items  
- View inventory analytics (total stock, total value)  
- View and manage staff change requests  
- Approve, deny, or modify requests  
- Save and load inventory data (Java I/O)  

### 👷 Staff Capabilities
- Log in with staff account  
- View all items in inventory  
- Submit a change request (e.g., restock, price change)  
- Track request status  

### 📊 Analytics
- Displays total stock, total inventory value  
- Monthly stock visualization using a **text-based bar graph**  

---

## 🗂 FILE STRUCTURE (Suggested)
```
InventorySystem/
│
├── Main.java
├── Item.java
├── InventoryManager.java
├── User.java
├── LoginSystem.java
├── Request.java
├── RequestManager.java
│
├── data/
│   ├── inventory.txt
│   ├── users.txt
│   └── requests.txt
│
└── README.md
```

---

## 📘 SYSTEM WORKFLOW

| Step | Role | Action | Result |
|------|------|--------|---------|
| 1 | Both | Login | Access menus |
| 2 | Admin | Add/Edit/Delete items | Update inventory |
| 3 | Staff | Submit request | Request added to list |
| 4 | Admin | Review requests | Approve or reject |
| 5 | Both | View analytics | See totals and graphs |
| 6 | Admin | Save changes | Data stored to file |

---

## 💾 FILE HANDLING
- **inventory.txt** → stores all item data  
- **users.txt** → stores user credentials and roles  
- **requests.txt** → stores pending staff requests  

All data is reloaded when the program starts using Java I/O (`BufferedReader`, `BufferedWriter`, or `ObjectInputStream` / `ObjectOutputStream`).

---

## 🧠 SHORT DESCRIPTION
This project simulates a **real-world inventory management flow**:
- Admins oversee stock and approve requests.  
- Staff can view items and suggest updates.  
- Analytics provide quick stock and value insights.  
- Data is persistent using file handling.  

💡 *Perfect for learning OOP, file I/O, and role-based systems in Java!*
