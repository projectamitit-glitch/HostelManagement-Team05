package com.avsoft.hostelmanagement.util;

public class MessageConstant {

   // User
   public static final String USER_REGISTER_SUCCESS = "User registered successfully.";

   // Organization
   public static final String ORG_CREATED_SUCCESS = "Organization created successfully.";
   public static final String ORG_FETCH_SUCCESS = "Organization fetched successfully.";
   public static final String ORG_LIST_FETCH_SUCCESS = "Organization list fetched successfully.";
   public static final String ORG_DELETE_SUCCESS = "Organization deleted successfully.";

   // Hostel
   public static final String HOSTEL_CREATED_SUCCESS = "Hostel created successfully.";
   public static final String HOSTEL_FETCH_SUCCESS = "Hostel fetched successfully.";
   public static final String HOSTEL_LIST_FETCH_SUCCESS = "Hostel list fetched successfully.";
   public static final String HOSTEL_DELETE_SUCCESS = "Hostel deleted successfully.";
   public static final String HOSTEL_DELETE_ALL_SUCCESS = "All hostels deleted successfully.";

   // Building
   public static final String BUILDING_CREATED_SUCCESS = "Building created successfully.";
   public static final String BUILDING_FETCH_SUCCESS = "Building fetched successfully.";
   public static final String BUILDING_LIST_FETCH_SUCCESS = "Building list fetched successfully.";
   public static final String BUILDING_DELETE_SUCCESS = "Building deleted successfully.";
   public static final String BUILDING_DELETE_ALL_SUCCESS = "All buildings deleted successfully";

   // Floor
   public static final String FLOOR_CREATED_SUCCESS = "Floor created successfully.";
   public static final String FLOOR_FETCH_SUCCESS = "Floor fetched successfully.";
   public static final String FLOOR_LIST_FETCH_SUCCESS = "Floor list fetched successfully.";
   public static final String FLOOR_BY_BUILDING_FETCH_SUCCESS = "Floor list by building fetched successfully.";
   public static final String FLOOR_DELETE_SUCCESS = "Floor deleted successfully.";

   // Room
   public static final String ROOM_CREATED_SUCCESS = "Room created successfully.";
   public static final String ROOM_FETCH_SUCCESS = "Room fetched successfully.";
   public static final String ROOM_LIST_FETCH_SUCCESS = "Room list fetched successfully.";
   public static final String ROOM_UPDATE_SUCCESS = "Room updated successfully.";
   public static final String ROOM_DELETE_SUCCESS = "Room deleted successfully.";

   // Bed
   public static final String BED_CREATED_SUCCESS = "Bed created successfully.";
   public static final String BED_FETCH_SUCCESS = "Bed fetched successfully.";
   public static final String BED_LIST_FETCH_SUCCESS = "Bed list fetched successfully.";
   public static final String BED_DELETE_SUCCESS = "Bed deleted successfully.";
   public static final String BED_DELETE_ALL_SUCCESS = "All beds deleted successfully.";

   // Email - admin content
   public static final String MASSEGE_SENDER = "email send succesfully";
   public static final String ADMIN_MESSAGE_BODY = "Dear Admin,\n\n" +
         "A new user has successfully completed the registration and payment process in the Hostel Management System.\n\n"
         +
         "🔹 USER DETAILS:\n" +
         "• Name: {USER_NAME}\n" +
         "• Email: {USER_EMAIL}\n" +
         "• Mobile No: {USER_MOBILE}\n" +
         "• Room Type: {ROOM_TYPE}\n" +
         "• Room Number: {ROOM_NUMBER}\n" +
         "• Check-in Date: {CHECKIN_DATE}\n\n" +

         "🔹 PAYMENT DETAILS:\n" +
         "• Transaction ID: {TRANSACTION_ID}\n" +
         "• Amount Paid: {AMOUNT}\n" +
         "• Payment Date: {PAYMENT_DATE}\n" +
         "• Payment Status: SUCCESS\n\n" +

         "The user account has been successfully created, and the payment has been confirmed.\n\n" +
         "Please review the details and proceed with the necessary administrative actions.\n\n" +
         "Regards,\n" +
         "AVSoft Hostel Management System\n";
   public static final String ADMIN_MESSAGE_SUBJECT = "Welcome to AVSoft Hostel Management – "
         + "Registration & Payment Confirmation\r\n";

   // Email - User Content
   public static final String USER_MESSAGE_SUBJECT = "Your Hostel Registration & Payment Confirmation – Receipt Attached";
   public static final String USER_MESSAGE_BODY = "Dear {USER_NAME},\n\n" +
         "Thank you for registering with AVSoft Hostel Management.\n" +
         "Your registration, room allocation, and payment have been successfully completed.\n\n" +

         "We have attached your official **Payment Receipt (PDF)** for your reference.\n\n" +

         "🔹 YOUR DETAILS:\n" +
         "• Name: {USER_NAME}\n" +
         "• Email: {USER_EMAIL}\n" +
         "• Mobile No: {USER_MOBILE}\n" +
         "• Room Type: {ROOM_TYPE}\n" +
         "• Room Number: {ROOM_NUMBER}\n" +
         "• Check-in Date: {CHECKIN_DATE}\n\n" +

         "🔹 PAYMENT DETAILS:\n" +
         "• Transaction ID: {TRANSACTION_ID}\n" +
         "• Amount Paid: {AMOUNT}\n" +
         "• Payment Date: {PAYMENT_DATE}\n" +
         "• Payment Status: SUCCESS\n\n" +

         "Your room has been successfully allocated, and the payment has been confirmed.\n" +
         "You can use the attached PDF receipt for future verification or any hostel documentation needs.\n\n" +

         "If you have any questions, feel free to contact our support team.\n\n" +

         "Thank you for choosing AVSoft Hostel Management.\n" +
         "Wishing you a comfortable stay!\n\n" +
         "Regards,\n" +
         "AVSoft Hostel Management System\n";

}
