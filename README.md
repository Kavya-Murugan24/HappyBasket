# 🛒 HappyBasket

HappyBasket is a **mini e-commerce web application** that allows users to explore products, add them to a cart, and manage their shopping experience.  
This project demonstrates skills in **frontend design, database schema design, and backend integration using Java**.

---

## 🚀 Features
- 🏠 **Home Page** – Attractive landing page with product listing
- ℹ️ **About Page** – Information about the application
- 🔑 **Login System (Planned)** – Users must log in before checkout
- 🛍️ **Add to Cart** – Add/remove items to cart
- 🗄️ **Database Schema** – Designed tables for Users, Products, Orders
- ⚙️ **Java Backend (Planned)** – Servlets + JDBC for real database connection

---

## 🛠️ Tech Stack
- **Frontend**: HTML, CSS  
- **Backend**: Java (Servlets, JDBC)  
- **Database**: MySQL  
- **Server**: Apache Tomcat  
- **Tools**: VS Code, Git, GitHub  

---

## 📂 Project Structure
HappyBasket/
│── Home.html              # Homepage
│── Login.html             # Login page
│── Registration.html      # User registration page
│── cartkkkk.html          # Cart test page (old version)
│── style.css              # Stylesheet
│── jsfile.js              # JavaScript logic
│
│── ConnectDB.java         # Java backend DB connection
│── ConnectDB.class        # Compiled Java class
│
│── HappyBasket DB.session.sql  # Database schema
│
│── Screenshots/           # Project screenshots
│ ├─ Home.png
│ ├─ Aboutus.png
│ ├─ Login.png
│ ├─ Registration.png
│ └─ Contactus.png
│── images/ (currently in root, can move to folder later)
│    ├── daisy.jpg
│    ├── gerbera new.webp
│    ├── orchid ele new.jpg
│    ├── rose and lily.webp
│    └── ... (flower images)
│
│── mysql-connector-j-9.4.0/   # MySQL JDBC connector
│── lib/                       # Libraries (if needed)
│── connectingjava/            # Extra Java files (if any)
│
│── README.md                  # Project documentation
## How to Run
1. Import project in VS Code / IDE
2. Set up MySQL database using `HappyBasket DB.session.sql`
3. Update `ConnectDB.java` with your DB credentials
4. Deploy on Apache Tomcat
5. Open Home.html in browser
