Hostel Management System – Team 05

Hostel Management System (HMS) is a full-stack application designed to automate and streamline hostel operations.
It manages organizations, hostels, buildings, floors, rooms, beds, users, payments, and communication workflows.



 1. System Overview

This system supports multi-organization structures, allowing multiple hostels to operate under one platform.
It covers tenant onboarding, room allocation, online payments, complaints, communication, and administration.



 2. Key Features

 2.1 Organization & Hostel Structure

 Multi-organization architecture
 Hostel → Building → Floor → Room → Bed hierarchy
 Room-sharing setup (1/2/3/4 sharing)
 Real-time availability tracking

 2.2 User Roles

 Super Admin
 Organization Owner
 Hostel Admin
 Student/Tenant

Each role has different permissions defined by the system.

 2.3 Room & Bed Management

 Bed allocation and vacancy management
 Student check-in and check-out
 Document upload (Aadhaar, photo, agreement)

 2.4 Payments & Billing

 Razorpay online payment integration
 Rent + Deposit + Food + Other cost breakup
 Monthly billing lifecycle
 Payment receipts & history

 2.5 Communication & Notification

 Email notifications using JavaMailSender
 WhatsApp notifications
 Automated alerts (due payments, check-in, check-out)

 2.6 Additional Functionalities

 Complaint management
 Daily reports
 Revenue dashboards
 App version management and forced update support



 3. UI/UX Overview

This project includes a clean, modern user interface with the following screens:

 3.1 Login Page

 Simple, minimal login form
 Email + Password authentication
 Version display (optional)

 3.2 Dashboard

 Overall occupancy
 Total rooms, beds, vacant beds
 Monthly revenue summary
 Quick actions (Add Hostel, Add Room, Add User)

 3.3 Organization Module UI

 Organization list
 Create organization form
 Owner details
 Contact information display

 3.4 Hostel & Building Management UI

 Hostel list with status
 Add hostel form
 Building and floor navigation
 Room layout view
 Bed availability indicators (Vacant/Booked)

 3.5 User & Tenant Management UI

 User list with filters
 Add tenant form
 Upload documents
 Tenant profile page (Room, Payment, Documents)

 3.6 Payment UI

 Razorpay online payment popup
 Monthly invoice page
 Payment status page
 Payment history table

 3.7 Complaint Management UI

 Raise complaint form
 Complaint list for admin
 Status update panel



 4. Core Entities

 Organization
 Hostel
 Building
 Floor
 Room
 Bed
 User
 TenantProfile
 Payment
 PaymentBreakup
 Complaint
 AppVersion



 5. Tech Stack

 Backend

 Java 17
 Spring Boot
 Spring Web
 Spring Data JPA
 Spring Security
 MySQL / PostgreSQL

 Frontend

 React JS
 Tailwind CSS
 Axios

 Integrations

 Razorpay
 WhatsApp API
 JavaMailSender



 6. Setup Instructions

 Backend Setup

```
mvn clean install
mvn spring-boot:run
```

 Frontend Setup

```
npm install
npm start
```



 7. Team 05 Responsibilities

 Requirement gathering
 Database design
 Backend development
 UI/UX design and frontend development
 Integrations (Payments, Email, WhatsApp)
 Testing and deployment
 Documentation and project delivery



 8. Future Enhancements

 QR-based check-in
 Biometric attendance
 IoT-based room automation
 Dynamic pricing model
 Multi-language support
