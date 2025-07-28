package com.hostel.User;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.hostel.Controller.userController;
import com.hostel.Entity.User_Login_Entity;
import com.hostel.Entity.hostel_room_database;
import com.itextpdf.text.log.SysoCounter;

public class User_Interface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int verify = 0;

		String name = null;
		String email = null;

		System.out.println(
				"         Welcome to My College Hostel Facilities \n    Providing best hostel services for student welfare\n"
						+ "\n1] New User\n2] Existing User\nChoose one from the following to continue:");

		User_Login_Entity uobj = new User_Login_Entity();
		userController cobj = new userController();
		hostel_room_database obj = new hostel_room_database();
		int user_type = Integer.parseInt(sc.nextLine());

		if (user_type == 1) {
			System.out.println("\n\n");
			System.out.println("************************************************************\n");

			System.out.println("*         🌟 WELCOME TO OUR PREMIUM HOSTEL 🌟\n");
			System.out.println("*     ✅ BOLD FEATURES THAT MAKE US THE BEST! ✅\n");
			System.out.println("*  🛏️  Spacious & Fully Furnished Rooms");
			System.out.println("*  📶 High-Speed Wi-Fi in Every Corner");
			System.out.println("*  🍽️  Hygienic Mess with Tasty Meals");
			System.out.println("*  🧼 Daily Housekeeping & Laundry Facilities");
			System.out.println("*  🔐 24x7 Security with CCTV Surveillance");
			System.out.println("*  🏋️ Modern Gym & Fitness Center");
			System.out.println("*  🧘 Meditation & Common Relaxation Zones");
			System.out.println("*  📚 Study Lounge with Peaceful Ambience");
			System.out.println("*  🚿 Hot Water Supply – 24 Hours");
			System.out.println("*  🧰 Quick Maintenance Support");
			System.out.println("*  🧊 Water Coolers & RO Purified Drinking Water");
			System.out.println("*  🏀 Outdoor/Indoor Game Areas ");
			System.out.println("*  🚗 Parking Facility Available ");
			System.out.println("*  🚫 Strict Anti-Ragging Policy\n");
			System.out.println("     🌈 Join us for a Safe, Comfortable & Thriving");
			System.out.println("             Hostel Experience! 🌈\n");
			System.out.println("************************************************************");
			System.out.println("\n\n");

			System.out.println("\nNew Registration\nEnter Name:");
			String User_name = sc.nextLine();

			System.out.println("Create Password:");
			String User_password = sc.nextLine();

			System.out.println("Enter your registered email:");
			String User_email = sc.nextLine();

			String otp = OtpEmailService.generateOtp();
			OtpEmailService.sendOtpEmail(User_email, otp);

			System.out.println("\nEnter the OTP sent to your email:");
			String enteredOtp = sc.nextLine();

			if (otp.equals(enteredOtp)) {
				System.out.println("\n✅ OTP Verified! Registration successful for: " + User_name);

				uobj.setUsername(User_name);
				uobj.setPassword(User_password);
				uobj.setEmail(User_email);
				uobj.setCreateDate(LocalDateTime.now());
				uobj.setModifyDate(LocalDateTime.now());

				cobj.insertNewUser(uobj);
				System.out.println("🎉 Congrats! You are registered into the Hostel Database.");

				
				name = User_name;
				email = User_email;

				verify = 1;
			} else {
				System.out.println("\n❌ Incorrect OTP. Registration failed. Exiting...");
				verify = 0;
			}
		} else if (user_type == 2) {
			System.out.println("\nVerify User\nEnter Name:");
			String User_name = sc.nextLine();

			System.out.println("Enter Password:");
			String User_password = sc.nextLine();
			String login_check = cobj.check_login(User_name, User_password);
			System.out.println(login_check);
			if (login_check.contains("Welcome back " + User_name)) {
				verify += 2;

		
				email = cobj.getEmailByUsername(User_name);
				name = User_name;
			}
		} else {
			System.out.println("Wrong inputs try again !");
		}

		if (verify == 1) {
		    System.out.println("Continuing");
		    System.out.println("\n");

		    while (true) {
		        System.out.println("**************************************************************");
		        System.out.println("*            🏠 Welcome to Your Hostel Dashboard 🏠 ");
		        System.out.println("*------------------------------------------------------------*");
		        System.out.println("*   📋 MENU OPTIONS\n");
		        System.out.println("*   1️]  Search Available Hostel Rooms");
		        System.out.println("*   2]  Book/Reserve a Room");
		        System.out.println("*   3]  View Mess Menu");
		        System.out.println("*   4]  View Hostel Rules & Regulations");
		        System.out.println("*   5]  Pay Hostel Fees or check balance");
		        System.out.println("*   6]  Chat with Hostel Warden / Support");
		   	    System.out.println("*   7]  View Hostel Rules & Code of Conduct");
		        System.out.println("*   8]  Logout");
		        System.out.println("**************************************************************");
		        System.out.println("\nPlease enter your choice:");
		        int choice = sc.nextInt();

		        switch (choice) {
		            case 1:
		                System.out.println("Enter your branch or department of studies:");
		                sc.nextLine(); // Consume newline
		                String branch_name = sc.nextLine();
		                String ans = cobj.getroom(branch_name);
		                System.out.println(ans);
		                break;

		            case 2:
		             
		                obj.setUser(uobj);
		                sc.nextLine(); // Consume newline
		                System.out.println("Enter room name you want to reserve:");
		                String room_name = sc.nextLine();
		                obj.setRoom_allocated(room_name);
		                obj.setService_request("not now");
		                obj.setRoommate_no(1);
		                obj.setLeave_application("not now");
		                obj.setFees_payment(100000);
		                String otp = cobj.insertinto_hostelDB(obj);
		                System.out.println(otp);
		                System.out.println("\n✅ Proceed to fee payments.");
		                break;

		            case 3:
		                System.out.println("**************************************************************");
		                System.out.println("*            🍽️ Hostel Mess Menu 🍽️");
		                System.out.println("*------------------------------------------------------------*");
		                System.out.println("*   🕖 Breakfast (7:30 AM - 9:00 AM):");
		                System.out.println("*     - Poha / Upma / Sheera (Alternating)");
		                System.out.println("*     - Idli-Sambar (Weekly 2 days)");
		                System.out.println("*     - Tea / Coffee / Banana");
		                System.out.println("*------------------------------------------------------------*");
		                System.out.println("*   🍛 Lunch (12:30 PM - 2:00 PM):");
		                System.out.println("*     - Chapati / Bhakri");
		                System.out.println("*     - Matki Usal / Batata Bhaji / Mix Veg");
		                System.out.println("*     - Varan-Bhaat / Pithla-Bhaat");
		                System.out.println("*     - Salad / Pickle / Papad");
		                System.out.println("*------------------------------------------------------------*");
		                System.out.println("*   ☕ Evening Snacks (5:00 PM - 6:00 PM):");
		                System.out.println("*     - Sabudana Khichdi / Bhel / Samosa (Rotational)");
		                System.out.println("*     - Tea / Coffee");
		                System.out.println("*------------------------------------------------------------*");
		                System.out.println("*   🍽️ Dinner (7:30 PM - 9:00 PM):");
		                System.out.println("*     - Chapati / Bhakri");
		                System.out.println("*     - Methi Bhaji / Baingan Bharta / Aluchi Patal Bhaji");
		                System.out.println("*     - Dal-Khichdi / Pulav / Jeera Rice");
		                System.out.println("*     - Buttermilk / Gulab Jamun (Weekly special)");
		                System.out.println("**************************************************************");
		                System.out.println("*   ✅ Hygienic, Tasty & Balanced Meals Prepared Daily");
		                System.out.println("*   ✅ Weekly Menu Chart Displayed on Hostel Notice Board");
		                System.out.println("**************************************************************");
		                System.out.println("📞 Contact +91-7499527448 for Mess related queries");
		                break;

		            case 4:
		                sc.nextLine();
		                System.out.println("Enter your room number:");
		                String roomNo = sc.nextLine();
		                System.out.println("Enter your class/department (e.g., FY BTech CSE):");
		                String studentClass = sc.nextLine();
		                String pdfPath = HostelRulesPDFGenerator.generateRulesPDF(name, roomNo, studentClass);
		                if (pdfPath != null) {
		                    OtpEmailService.sendRulesPdfEmail(email, name, pdfPath);
		                } else {
		                    System.out.println("❌ Failed to generate PDF.");
		                }
		                break;

		            case 5:
		                System.out.println("💰 Payments are handled at the college office or official website.");
		                System.out.println("Total hostel fee is ₹100000/-.");
		                System.out.println("Your pending fees has been added to the database.");
		                break;

		            case 6:
		                sc.nextLine();
		                System.out.println("💬 Add your query:");
		                String query = sc.nextLine();
		                System.out.println("Enter your room name:");
		                String room_namee = sc.nextLine();
		                String otp2 = cobj.addQuery(query, room_namee);
		                System.out.println(otp2);
		                break;
		            case 7:  sc.nextLine();
			         System.out.println("Enter your room number:");
			         String roomNoo = sc.nextLine();

			         System.out.println("Enter your class/department (e.g., FY BTech CSE):");
			         String studentClasss = sc.nextLine();

			         String pdfPathh = HostelRulesPDFGenerator.generateRulesPDF(name, roomNoo, studentClasss);
			         if (pdfPathh != null) {
			             OtpEmailService.sendRulesPdfEmail(email, name, pdfPathh);
			         } else {
			             System.out.println("❌ Failed to generate PDF.");
			         }
			         break;
		            case 8:
		                System.out.println("👋 Logged out of your account. Thank you!");
		                return; // OR use break inside while + wrap while in outer `if`

		            default:
		                System.out.println("❌ Invalid choice. Please try again.");
		        }
		    }
		}
 else if (verify == 2) {
	 while (true) {
		    System.out.println("**************************************************************");
		    System.out.println("*          🙋‍♂️ Welcome Back to the Hostel Portal 🙋‍♀️");
		    System.out.println("*------------------------------------------------------------*");
		    System.out.println("*   📋 MENU OPTIONS\n");
		    System.out.println("*   1️⃣  Enter My Room Details");
		    System.out.println("*   2️⃣  View Mess Menu");
		    System.out.println("*   3️⃣  Pay Monthly Fees / Check Payment Status");
		    System.out.println("*   4️⃣  View Hostel Rules & Code of Conduct");
		    System.out.println("*   5️⃣  Request Room Change");
		    System.out.println("*   6️⃣  Apply for Leave");
		    System.out.println("*   7️⃣  Submit Service Request (Repairs, Cleaning, Security etc.)");
		    System.out.println("*   8️⃣  Logout");
		    System.out.println("**************************************************************");
		    System.out.println("\nPlease enter your choice:");
		    int choice = sc.nextInt();

		    switch (choice) {

		        case 1:
		            sc.nextLine(); // consume newline
		            obj.setUser(uobj);

		            System.out.print("Enter number of roommates in your room: ");
		            int roommates = sc.nextInt();
		            obj.setRoommate_no(roommates);

		            sc.nextLine(); // consume newline
		            System.out.print("Enter your room name: ");
		            String roomName = sc.nextLine();
		            obj.setRoom_allocated(roomName);

		            System.out.print("Any leave application (if not, type 'not now'): ");
		            String leaveApp = sc.nextLine();
		            obj.setLeave_application(leaveApp);

		            System.out.print("Enter initial fee payment (₹): ");
		            int fees = sc.nextInt();
		            obj.setFees_payment(fees);

		            String otp = cobj.insertinto_hostelDB(obj);
		            System.out.println("✅ OTP: " + otp);
		            break;

		        case 2:
		            // Mess menu
		            System.out.println("**************************************************************");
		            System.out.println("*            🍽️ Hostel Mess Menu 🍽️");
		            System.out.println("*------------------------------------------------------------*");
	                System.out.println("*   🕖 Breakfast (7:30 AM - 9:00 AM):");
	                System.out.println("*     - Poha / Upma / Sheera (Alternating)");
	                System.out.println("*     - Idli-Sambar (Weekly 2 days)");
	                System.out.println("*     - Tea / Coffee / Banana");
	                System.out.println("*------------------------------------------------------------*");
	                System.out.println("*   🍛 Lunch (12:30 PM - 2:00 PM):");
	                System.out.println("*     - Chapati / Bhakri");
	                System.out.println("*     - Matki Usal / Batata Bhaji / Mix Veg");
	                System.out.println("*     - Varan-Bhaat / Pithla-Bhaat");
	                System.out.println("*     - Salad / Pickle / Papad");
	                System.out.println("*------------------------------------------------------------*");
	                System.out.println("*   ☕ Evening Snacks (5:00 PM - 6:00 PM):");
	                System.out.println("*     - Sabudana Khichdi / Bhel / Samosa (Rotational)");
	                System.out.println("*     - Tea / Coffee");
	                System.out.println("*------------------------------------------------------------*");
	                System.out.println("*   🍽️ Dinner (7:30 PM - 9:00 PM):");
	                System.out.println("*     - Chapati / Bhakri");
	                System.out.println("*     - Methi Bhaji / Baingan Bharta / Aluchi Patal Bhaji");
	                System.out.println("*     - Dal-Khichdi / Pulav / Jeera Rice");
	                System.out.println("*     - Buttermilk / Gulab Jamun (Weekly special)");
	                System.out.println("**************************************************************");
	                System.out.println("*   ✅ Hygienic, Tasty & Balanced Meals Prepared Daily");
	                System.out.println("*   ✅ Weekly Menu Chart Displayed on Hostel Notice Board");
	                System.out.println("**************************************************************");
		            System.out.println("📞 Contact +91-7499527448 for Mess related queries ");
		            break;

		        case 3:
		            sc.nextLine(); // consume newline
		            String otp1 = cobj.pay_fees(uobj.getUsername());
		            System.out.println("📌 Payment Info: " + otp1);
		            break;

		        case 4:
		            sc.nextLine();
		            System.out.println("Enter your room number:");
		            String roomNo = sc.nextLine();

		            System.out.println("Enter your class/department (e.g., FY BTech CSE):");
		            String studentClass = sc.nextLine();

		            String pdfPath = HostelRulesPDFGenerator.generateRulesPDF(name, roomNo, studentClass);
		            if (pdfPath != null) {
		                OtpEmailService.sendRulesPdfEmail(email, name, pdfPath);
		            } else {
		                System.out.println("❌ Failed to generate PDF.");
		            }
		            break;

		        case 5:
		            sc.nextLine();
		            System.out.println("Enter your current room name:");
		            String current_room = sc.nextLine();

		            System.out.println("Why do you want to change the room?");
		            String queryRoom = sc.nextLine();

		            obj.setRoom_change_application(queryRoom);
		            obj.setRoom_allocated(current_room);
		        String optt=    cobj.change_room(obj);
		        System.out.println(optt);
		            break;

		        case 6:
		            sc.nextLine();
		            System.out.println("Enter your current room name:");
		            String now_room = sc.nextLine();

		            System.out.println("Why do you want leave?");
		            String leave = sc.nextLine();

		            obj.setLeave_application(leave);
		            obj.setRoom_allocated(now_room);
		         String otp2=   cobj.leave(obj);
		         System.out.println(otp2);
		            break;

		        case 7:
		            sc.nextLine();
		            System.out.println("Add your service query:");
		            String query = sc.nextLine();

		            System.out.println("Enter your room name:");
		            String room_namee = sc.nextLine();

		            String otp3 = cobj.addQuery(query, room_namee);
		            System.out.println("✅ Request submitted: " + otp3);
		            break;

		        case 8:
		            System.out.println("✅ Logged out successfully. See you again!");
		            break;

		        default:
		            System.out.println("⚠️ Invalid option selected. Please try again.");
		            break;
		    }

		   
		    if (choice == 8) {
		        break;
		    }
		}
 }else {
			System.out.println("⚠️ Access Denied. Please try again.");
		}
		sc.close();
	}
}
