package com.hostel.User;

import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class HostelRulesPDFGenerator {

    public static String generateRulesPDF(String username, String roomNo, String studentClass) {
        String filePath = "Hostel_Rules_" + username + ".pdf";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("🏠 Hostel Rules & Regulations 🏠", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            // User Details
            Font userFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            document.add(new Paragraph("👤 Name: " + username, userFont));
            document.add(new Paragraph("🏠 Room No: " + roomNo, userFont));
            document.add(new Paragraph("🎓 Class: " + studentClass, userFont));
            document.add(Chunk.NEWLINE);

            // Rules
            Font ruleFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            document.add(new Paragraph("📌 General Hostel Rules & Code of Conduct:", ruleFont));
            document.add(Chunk.NEWLINE);

            String[] rules = {
                "1. Maintain absolute silence from 9:00 PM to 6:00 AM. Violators will face disciplinary action.",
                "2. Strictly no entry or exit after 10:00 PM without a written permission from the Warden.",
                "3. Lights must be turned off by 11:00 PM unless prior permission is granted for study purposes.",
                "4. Ragging is strictly prohibited and punishable under the law (as per UGC regulations).",
                "5. All hostel residents must attend roll call and regular meetings without fail.",
                "6. Damage to hostel property must be reported immediately and will be charged to the resident.",
                "7. Cooking, smoking, drinking alcohol, or drug use is strictly prohibited within the hostel premises.",
                "8. Unauthorized electrical appliances (heaters, immersion rods, etc.) are not allowed.",
                "9. Cleanliness must be maintained in individual rooms, bathrooms, and common areas.",
                "10. No guest or outsider is allowed in the rooms without prior approval.",
                "11. Any kind of physical or verbal abuse will lead to immediate eviction and police action.",
                "12. Playing loud music or causing disturbances is not permitted at any time.",
                "13. Students must return directly to the hostel after college hours unless informed otherwise.",
                "14. Any misuse of hostel facilities (Wi-Fi, water, food) will lead to suspension of privileges.",
                "15. Involvement in any illegal or unethical activities inside or outside the hostel is prohibited.",
                "16. Only authorized hostel staff are allowed to enter the rooms for inspection or cleaning.",
                "17. Tampering with CCTV or fire safety equipment is a serious offense.",
                "18. Students must deposit their room keys before leaving for vacation.",
                "19. Entry into opposite-gender hostels is strictly forbidden under any circumstance.",
                "20. Repeated violations of rules may lead to permanent expulsion from the hostel."
            };

            for (String rule : rules) {
                document.add(new Paragraph(rule, ruleFont));
            }

            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("⚠️ NOTE: Violation of any of the above rules will attract strict disciplinary action including fines, suspension, or expulsion from the hostel.", ruleFont));
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("✅ Thank you for cooperating and helping us maintain a safe and respectful environment.", ruleFont));

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return filePath;
    }
}
