package home_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;

public class home_servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res); 
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    	String uname = "Guest";
    	PrintWriter out = res.getWriter();
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = null;
            HttpSession session = req.getSession();
            int uid = (int) (session.getAttribute("UserID"));
            

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsys", "root", "vivek");

            String sql = "SELECT Name FROM users WHERE UserID=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, uid);
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            uname = rs.getString("Name");

            
            
            
            con.close(); 
        } catch (Exception e) {
            out.println(e);
        }
        
        out.print("<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>\r\n"
        		+ "    \r\n"
        		+ "    <title>Bookmytrek</title>\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\" integrity=\"sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n"
        		+ "    <link rel=\"icon\" type=\"x-icon\" href=\"web-logo.png\">\r\n"
        		+ "    <link rel=\"Stylesheet\" href=\"home_res/homestyle.css\">\r\n"
        		+ "\r\n"
        		+ "</head>\r\n"
        		+ "\r\n"
        		+ "    <header>\r\n"
        		+ "        <div class=\"navbar\">\r\n"
        		+ "            <div class=\"nav-logo border\">\r\n"
        		+ "                <div class=\"logo\" >\r\n"
        		+ "                    <h1>ThrillTrek</h1>\r\n"
        		+ "                </div>\r\n"
        		+ "            </div>\r\n"
        		+ "\r\n"
        		+ "            <div class=\"nav-address border \">\r\n"
        		+ "                <!-- <p class=\"add-first\">My Location</p> -->\r\n"
        		+ "                <div class=\"add-icon\">\r\n"
        		+ "                    <i class=\"fa-solid fa-location-dot\"></i>\r\n"
        		+ "                    <p class=\"add-second\">India</p>\r\n"
        		+ "                </div>\r\n"
        		+ "            </div>\r\n"
        		+ "\r\n"
        		+ "            <div class=\"nav-search\">\r\n"
        		+ "                \r\n"
        		+ "                </select>\r\n"
        		+ "                <input placeholder=\"   search Trek locations\" class=\"search-input \">\r\n"
        		+ "                <div class=\"search-icon\" >\r\n"
        		+ "                    <i class=\"fa-solid fa-magnifying-glass-location\"></i>\r\n"
        		+ "                </div>\r\n"
        		+ "            </div>\r\n"
        		+ "\r\n"
        		+ "            <div class=\"nav-signin border\">\r\n"
        		+ "                <p><span>Hello,"+uname+"</span></p>\r\n"
        		+ "                <p class=\"nav-second\">Your profile</p>\r\n"
        		+ "            </div>\r\n"
        		+ "\r\n"
        		+ "            <div class=\"nav-return border\">\r\n"
        		+ "                <p><span>Cancellation &</span></p>\r\n"
        		+ "                <p class=\"nav-second\">Booking policy</p>\r\n"
        		+ "            </div>\r\n"
        		+ "\r\n"
        		+ "            <div class=\"nav-cart border\">\r\n"
        		+ "                <i class=\"fa-solid fa-person-hiking\"></i>\r\n"
        		+ "                <p>Cart</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "\r\n"
        		+ "        <div class=\"panel\">\r\n"
        		+ "            <div class=\"panel1 border\">\r\n"
        		+ "                <!-- <i class=\"fa-solid fa-bars\"></i>\r\n"
        		+ "                All -->\r\n"
        		+ "            </div>\r\n"
        		+ "            <div class=\"panel-ops\">\r\n"
        		+ "                <div class=\"panel1 deals border\">Trending Destinations</div>\r\n"
        		+ "                <div class=\"panel1 camp border\">Camping</div>\r\n"
        		+ "                <div class=\"panel1 trek border\">Treking </div>\r\n"
        		+ "                <div class=\"panel1 trek border\">Scuba Diving</div>\r\n"
        		+ "                <div class=\"panel1 trek border\">Rappelling</div>\r\n"
        		+ "                \r\n"
        		+ "                <!-- <div class=\"panel1 sale border\">Sale</p> -->\r\n"
        		+ "            </div>\r\n"
        		+ "            <!-- <div class=\"panel-customer border\">\r\n"
        		+ "                <i class=\"fa-solid fa-user-tie\"></i>\r\n"
        		+ "                <p>Customer Service</p>\r\n"
        		+ "\r\n"
        		+ "            </div> -->\r\n"
        		+ "        </div>\r\n"
        		+ "    </header>\r\n"
        		+ "\r\n"
        		+ "    <!-- <div class=\"hero-section\">\r\n"
        		+ "\r\n"
        		+ "    </div> -->\r\n"
        		+ "\r\n"
        		+ "    <div class=\"container\">\r\n"
        		+ "        <div class=\"wrapper\">\r\n"
        		+ "            <img src=\"home_res/image4.jpeg\" >\r\n"
        		+ "            <img src=\"home_res/image2.jpeg\" >\r\n"
        		+ "            <img src=\"home_res/image5.jpeg\" >\r\n"
        		+ "            <img src=\"home_res/img6.jpeg\"   >\r\n"
        		+ "            <img src=\"home_res/img7.jpeg\"   >\r\n"
        		+ "            <img src=\"home_res/img8.jpg\"    >\r\n"
        		+ "            <img src=\"home_res/image5.jpeg\" >\r\n"
        		+ "            <img src=\"home_res/img6.jpeg\"   >\r\n"
        		+ "            <img src=\"home_res/img7.jpeg\"   >\r\n"
        		+ "            <img src=\"home_res/img8.jpg\"    >\r\n"
        		+ "            <img src=\"home_res/img7.jpeg\"   >\r\n"
        		+ "            <img src=\"home_res/img8.jpg\"    >\r\n"
        		+ "            <img src=\"home_res/image4.jpeg\" >\r\n"
        		+ "            <img src=\"img7.jpeg\"   >\r\n"
        		+ "        </div>\r\n"
        		+ "           \r\n"
        		+ "    </div>\r\n"
        		+ "<body>\r\n"
        		+ "    <div class=\"agencyhead\">\r\n"
        		+ "        <p>----- Recommended Activities -----</p>\r\n"
        		+ "    </div> \r\n"
        		
        		+ "    <main class=\"obj-width\" id=\"blog-container\" >\r\n"
        		+ "        <div class=\"blog-card\">\r\n"
        		+ "            <img src=\"trek/naliii.jpg\" alt=\"\">\r\n"
        		+ "            <h2>This is a title</h2>\r\n"
        		+ "            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugit tempora dolorum odio nam non eos quas perspiciatis laborum quaerat asperiores!</p>\r\n"
        		+ "        </div>\r\n"
        		+ "    </main>\r\n"
        		+ "</body>\r\n"
        		+ "    \r\n"
        		+ "     <!-- <div class=\"foot-panel2\">\r\n"
        		+ "        <div class=\"foot-head1 border\">\r\n"
        		+ "            <h3>Get to know us</h3>\r\n"
        		+ "            <p>About us</p>\r\n"
        		+ "            <p>careers</p>\r\n"
        		+ "            <p>opportunities</p>\r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"foot-head2 border\">\r\n"
        		+ "            <h3>conntect with us</h3>\r\n"
        		+ "            <p>Instagram</p>\r\n"
        		+ "            <p>Facebook</p>\r\n"
        		+ "            <p>Twitter</p>\r\n"
        		+ "            <a href=\"#\"></a> <h3>Let us help you</h3>\r\n"
        		+ "            <p>Guidelines for the trek</p>\r\n"
        		+ "            <p>your bookings</p>\r\n"
        		+ "            <p>Cancel bookings</p>\r\n"
        		+ "            <p>Cancellation policy</p> \r\n"
        		+ "            <ul>\r\n"
        		+ "                <li> <a href=\"#\"></a>Let us help you</li>\r\n"
        		+ "                <li> <a href=\"#\"></a>Guidelines for the Trek</li>\r\n"
        		+ "                <li> <a href=\"#\"></a>Your bookings</li>\r\n"
        		+ "                <li> <a href=\"#\"></a>Cancel bookings</li>\r\n"
        		+ "                <li> <a href=\"#\"></a>Cancellation policy</li>\r\n"
        		+ "              </ul>\r\n"
        		+ "           \r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"panel-customer border\">\r\n"
        		+ "            <i class=\"fa-solid fa-user-tie\"></i>\r\n"
        		+ "            <p>Customer Service</p> -->\r\n"
        		+ "\r\n"
        		+ "        <!-- </div> \r\n"
        		+ "    </div> --> \r\n"
        		+ "\r\n"
        		+ "    <footer>\r\n"
        		+ "        <div class=\"foot-panel1\">\r\n"
        		+ "         Back to Top\r\n"
        		+ "        </div> \r\n"
        		+ "        <div class=\"foot-panel2\">\r\n"
        		+ "         <ul>\r\n"
        		+ "            <a href=\"#\"> <p>About Us</p></a>\r\n"
        		+ "             \r\n"
        		+ "         </ul>\r\n"
        		+ "     \r\n"
        		+ "         <ul>\r\n"
        		+ "            <a href=\"#\"> <p>Connect us</p></a>\r\n"
        		+ "     \r\n"
        		+ "         </ul>\r\n"
        		+ "     \r\n"
        		+ "         <ul>\r\n"
        		+ "            <a href=\"#\">  <p>Cancellation Policy</p></a>\r\n"
        		+ "     \r\n"
        		+ "         </ul>\r\n"
        		+ "     \r\n"
        		+ "         <ul>\r\n"
        		+ "            <a href=\"#\">  <p>Privacy Policy</p></a>\r\n"
        		+ "             \r\n"
        		+ "         </ul>\r\n"
        		+ "         \r\n"
        		+ "        </div>\r\n"
        		+ "        \r\n"
        		+ "     \r\n"
        		+ "        <!-- <div class=\"foot-panel3\">\r\n"
        		+ "         \r\n"
        		+ "            <h2 class=\"logo\">ThrillTrek</h2>\r\n"
        		+ "         \r\n"
        		+ "        </div> -->\r\n"
        		+ "        <div class=\"foot-panel4\">\r\n"
        		+ "         <div class=\"pages\">\r\n"
        		+ "             <a>Conditions of Use</a>\r\n"
        		+ "             <a>Privacy Notice</a>\r\n"
        		+ "             <a>Your Ads Privacy Choices</a>\r\n"
        		+ "         </div>\r\n"
        		+ "         <div class=\"copyright\">\r\n"
        		+ "             © 1996-2024, Thrilltrek.com, Inc. or its affiliates\r\n"
        		+ "         </div>\r\n"
        		+ "        </div>\r\n"
        		+ "     </footer>\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "</html>\r\n"
        		+ "\r\n"

        		+ "    <!-- <div class=\"agency\">\r\n"
        		+ "        <div class=\"box1 box\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"box2 box\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"box3 box\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"box4 box\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "        <!-- 2ndline -->\r\n"
        		+ "        <!-- <div class=\"box4 box01\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"box4 box01\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                 <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"box4 box01\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "        <div class=\"box4 box01\">\r\n"
        		+ "            <div class=\"box-content\">\r\n"
        		+ "                <h2>Agency name</h2>\r\n"
        		+ "                <div class=\"box-img\" style=\"background-image:url('info.jpg');\"></div>\r\n"
        		+ "                <p>See more</p>\r\n"
        		+ "            </div>\r\n"
        		+ "        </div>\r\n"
        		+ "    </div> --> \r\n"
        		+ "\r\n"
        		+ "       <!-- footer -->\r\n"
        		+ "\r\n"
        		+ "        <!-- <div class=\"foot-panel1\">\r\n"
        		+ "            <p>Go back to top</p>\r\n"
        		+ "        </div> -->\r\n"
        		+ "\r\n"
        		+ "        ");
        
    }
}