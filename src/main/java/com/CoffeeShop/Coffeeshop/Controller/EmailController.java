package com.CoffeeShop.Coffeeshop.Controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.service.AddressService;
import com.CoffeeShop.Coffeeshop.service.ProductService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@RestController
public class EmailController {
	@Autowired ProductService ps;
	
	@Autowired AddressService As;
	
   @RequestMapping(value = "/sendemail/{to}/{product_Id}")
   public String sendEmail(@PathVariable("to") int addressid,@PathVariable("product_Id") int productId) throws AddressException, MessagingException, IOException {
	  Product product= ps.getProduct(productId);
	  
	   sendmail(product,As.getByAddressId(addressid));
	   return "Email sent successfully";   
   }   


private void sendmail(Product product,Address address) throws AddressException, MessagingException, IOException {
	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.port", "587");
	   
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("iampsjain@gmail.com", "Pushpak@1997");
	      }
	   });
	   Message msg = new MimeMessage(session);
	   msg.setFrom(new InternetAddress("iampsjain@gmail.com", false));

	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address.getEmail_id()));
	   msg.setSubject("Order Confirmation");
	   msg.setContent(""
	   		+ ""
	   		+ "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>\r\n" + 
	   		"    <!--[if gte mso 9]><xml>\r\n" + 
	   		"     <o:OfficeDocumentSettings>\r\n" + 
	   		"      <o:AllowPNG/>\r\n" + 
	   		"      <o:PixelsPerInch>96</o:PixelsPerInch>\r\n" + 
	   		"     </o:OfficeDocumentSettings>\r\n" + 
	   		"    </xml><![endif]-->\r\n" + 
	   		"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
	   		"    <meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
	   		"    <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\r\n" + 
	   		"    <title></title>\r\n" + 
	   		"    \r\n" + 
	   		"    \r\n" + 
	   		"    <style type=\"text/css\" id=\"media-query\">\r\n" + 
	   		"      body {\r\n" + 
	   		"  margin: 0;\r\n" + 
	   		"  padding: 0; }\r\n" + 
	   		"\r\n" + 
	   		"table, tr, td {\r\n" + 
	   		"  vertical-align: top;\r\n" + 
	   		"  border-collapse: collapse; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser table, .mso-container table {\r\n" + 
	   		"  table-layout: fixed; }\r\n" + 
	   		"\r\n" + 
	   		"* {\r\n" + 
	   		"  line-height: inherit; }\r\n" + 
	   		"\r\n" + 
	   		"a[x-apple-data-detectors=true] {\r\n" + 
	   		"  color: inherit !important;\r\n" + 
	   		"  text-decoration: none !important; }\r\n" + 
	   		"\r\n" + 
	   		"[owa] .img-container div, [owa] .img-container button {\r\n" + 
	   		"  display: block !important; }\r\n" + 
	   		"\r\n" + 
	   		"[owa] .fullwidth button {\r\n" + 
	   		"  width: 100% !important; }\r\n" + 
	   		"\r\n" + 
	   		"[owa] .block-grid .col {\r\n" + 
	   		"  display: table-cell;\r\n" + 
	   		"  float: none !important;\r\n" + 
	   		"  vertical-align: top; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .num12, .ie-browser .block-grid, [owa] .num12, [owa] .block-grid {\r\n" + 
	   		"  width: 600px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {\r\n" + 
	   		"  line-height: 100%; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .mixed-two-up .num4, [owa] .mixed-two-up .num4 {\r\n" + 
	   		"  width: 200px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .mixed-two-up .num8, [owa] .mixed-two-up .num8 {\r\n" + 
	   		"  width: 400px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.two-up .col, [owa] .block-grid.two-up .col {\r\n" + 
	   		"  width: 300px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.three-up .col, [owa] .block-grid.three-up .col {\r\n" + 
	   		"  width: 200px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.four-up .col, [owa] .block-grid.four-up .col {\r\n" + 
	   		"  width: 150px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.five-up .col, [owa] .block-grid.five-up .col {\r\n" + 
	   		"  width: 120px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.six-up .col, [owa] .block-grid.six-up .col {\r\n" + 
	   		"  width: 100px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.seven-up .col, [owa] .block-grid.seven-up .col {\r\n" + 
	   		"  width: 85px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.eight-up .col, [owa] .block-grid.eight-up .col {\r\n" + 
	   		"  width: 75px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.nine-up .col, [owa] .block-grid.nine-up .col {\r\n" + 
	   		"  width: 66px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.ten-up .col, [owa] .block-grid.ten-up .col {\r\n" + 
	   		"  width: 60px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.eleven-up .col, [owa] .block-grid.eleven-up .col {\r\n" + 
	   		"  width: 54px !important; }\r\n" + 
	   		"\r\n" + 
	   		".ie-browser .block-grid.twelve-up .col, [owa] .block-grid.twelve-up .col {\r\n" + 
	   		"  width: 50px !important; }\r\n" + 
	   		"\r\n" + 
	   		"@media only screen and (min-width: 620px) {\r\n" + 
	   		"  .block-grid {\r\n" + 
	   		"    width: 600px !important; }\r\n" + 
	   		"  .block-grid .col {\r\n" + 
	   		"    vertical-align: top; }\r\n" + 
	   		"    .block-grid .col.num12 {\r\n" + 
	   		"      width: 600px !important; }\r\n" + 
	   		"  .block-grid.mixed-two-up .col.num4 {\r\n" + 
	   		"    width: 200px !important; }\r\n" + 
	   		"  .block-grid.mixed-two-up .col.num8 {\r\n" + 
	   		"    width: 400px !important; }\r\n" + 
	   		"  .block-grid.two-up .col {\r\n" + 
	   		"    width: 300px !important; }\r\n" + 
	   		"  .block-grid.three-up .col {\r\n" + 
	   		"    width: 200px !important; }\r\n" + 
	   		"  .block-grid.four-up .col {\r\n" + 
	   		"    width: 150px !important; }\r\n" + 
	   		"  .block-grid.five-up .col {\r\n" + 
	   		"    width: 120px !important; }\r\n" + 
	   		"  .block-grid.six-up .col {\r\n" + 
	   		"    width: 100px !important; }\r\n" + 
	   		"  .block-grid.seven-up .col {\r\n" + 
	   		"    width: 85px !important; }\r\n" + 
	   		"  .block-grid.eight-up .col {\r\n" + 
	   		"    width: 75px !important; }\r\n" + 
	   		"  .block-grid.nine-up .col {\r\n" + 
	   		"    width: 66px !important; }\r\n" + 
	   		"  .block-grid.ten-up .col {\r\n" + 
	   		"    width: 60px !important; }\r\n" + 
	   		"  .block-grid.eleven-up .col {\r\n" + 
	   		"    width: 54px !important; }\r\n" + 
	   		"  .block-grid.twelve-up .col {\r\n" + 
	   		"    width: 50px !important; } }\r\n" + 
	   		"\r\n" + 
	   		"@media (max-width: 620px) {\r\n" + 
	   		"  .block-grid, .col {\r\n" + 
	   		"    min-width: 320px !important;\r\n" + 
	   		"    max-width: 100% !important;\r\n" + 
	   		"    display: block !important; }\r\n" + 
	   		"  .block-grid {\r\n" + 
	   		"    width: calc(100% - 40px) !important; }\r\n" + 
	   		"  .col {\r\n" + 
	   		"    width: 100% !important; }\r\n" + 
	   		"    .col > div {\r\n" + 
	   		"      margin: 0 auto; }\r\n" + 
	   		"  img.fullwidth, img.fullwidthOnMobile {\r\n" + 
	   		"    max-width: 100% !important; }\r\n" + 
	   		"  .no-stack .col {\r\n" + 
	   		"    min-width: 0 !important;\r\n" + 
	   		"    display: table-cell !important; }\r\n" + 
	   		"  .no-stack.two-up .col {\r\n" + 
	   		"    width: 50% !important; }\r\n" + 
	   		"  .no-stack.mixed-two-up .col.num4 {\r\n" + 
	   		"    width: 33% !important; }\r\n" + 
	   		"  .no-stack.mixed-two-up .col.num8 {\r\n" + 
	   		"    width: 66% !important; }\r\n" + 
	   		"  .no-stack.three-up .col.num4 {\r\n" + 
	   		"    width: 33% !important; }\r\n" + 
	   		"  .no-stack.four-up .col.num3 {\r\n" + 
	   		"    width: 25% !important; }\r\n" + 
	   		"  .mobile_hide {\r\n" + 
	   		"    min-height: 0px;\r\n" + 
	   		"    max-height: 0px;\r\n" + 
	   		"    max-width: 0px;\r\n" + 
	   		"    display: none;\r\n" + 
	   		"    overflow: hidden;\r\n" + 
	   		"    font-size: 0px; } }\r\n" + 
	   		"\r\n" + 
	   		"    </style>\r\n" + 
	   		"</head>\r\n" + 
	   		"<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #EAE3DD\">\r\n" + 
	   		"  <style type=\"text/css\" id=\"media-query-bodytag\">\r\n" + 
	   		"    @media (max-width: 520px) {\r\n" + 
	   		"      .block-grid {\r\n" + 
	   		"        min-width: 320px!important;\r\n" + 
	   		"        max-width: 100%!important;\r\n" + 
	   		"        width: 100%!important;\r\n" + 
	   		"        display: block!important;\r\n" + 
	   		"      }\r\n" + 
	   		"\r\n" + 
	   		"      .col {\r\n" + 
	   		"        min-width: 320px!important;\r\n" + 
	   		"        max-width: 100%!important;\r\n" + 
	   		"        width: 100%!important;\r\n" + 
	   		"        display: block!important;\r\n" + 
	   		"      }\r\n" + 
	   		"\r\n" + 
	   		"        .col > div {\r\n" + 
	   		"          margin: 0 auto;\r\n" + 
	   		"        }\r\n" + 
	   		"\r\n" + 
	   		"      img.fullwidth {\r\n" + 
	   		"        max-width: 100%!important;\r\n" + 
	   		"      }\r\n" + 
	   		"			img.fullwidthOnMobile {\r\n" + 
	   		"        max-width: 100%!important;\r\n" + 
	   		"      }\r\n" + 
	   		"      .no-stack .col {\r\n" + 
	   		"				min-width: 0!important;\r\n" + 
	   		"				display: table-cell!important;\r\n" + 
	   		"			}\r\n" + 
	   		"			.no-stack.two-up .col {\r\n" + 
	   		"				width: 50%!important;\r\n" + 
	   		"			}\r\n" + 
	   		"			.no-stack.mixed-two-up .col.num4 {\r\n" + 
	   		"				width: 33%!important;\r\n" + 
	   		"			}\r\n" + 
	   		"			.no-stack.mixed-two-up .col.num8 {\r\n" + 
	   		"				width: 66%!important;\r\n" + 
	   		"			}\r\n" + 
	   		"			.no-stack.three-up .col.num4 {\r\n" + 
	   		"				width: 33%!important;\r\n" + 
	   		"			}\r\n" + 
	   		"			.no-stack.four-up .col.num3 {\r\n" + 
	   		"				width: 25%!important;\r\n" + 
	   		"			}\r\n" + 
	   		"      .mobile_hide {\r\n" + 
	   		"        min-height: 0px!important;\r\n" + 
	   		"        max-height: 0px!important;\r\n" + 
	   		"        max-width: 0px!important;\r\n" + 
	   		"        display: none!important;\r\n" + 
	   		"        overflow: hidden!important;\r\n" + 
	   		"        font-size: 0px!important;\r\n" + 
	   		"      }\r\n" + 
	   		"    }\r\n" + 
	   		"  </style>\r\n" + 
	   		"  <!--[if IE]><div class=\"ie-browser\"><![endif]-->\r\n" + 
	   		"  <!--[if mso]><div class=\"mso-container\"><![endif]-->\r\n" + 
	   		"  <table class=\"nl-container\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #EAE3DD;width: 100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
	   		"	<tbody>\r\n" + 
	   		"	<tr style=\"vertical-align: top\">\r\n" + 
	   		"		<td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n" + 
	   		"    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #EAE3DD;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"    <div style=\"background-color:#EAE3DD;\">\r\n" + 
	   		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #4F4F4F;\" class=\"block-grid \">\r\n" + 
	   		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#4F4F4F;\">\r\n" + 
	   		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#EAE3DD;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:#4F4F4F;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:15px; padding-bottom:15px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:15px; padding-bottom:15px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div align=\"center\" class=\"img-container center fixedwidth \" style=\"padding-right: 0px;  padding-left: 0px;\">\r\n" + 
	   		"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px;line-height:0px;\"><td style=\"padding-right: 0px; padding-left: 0px;\" align=\"center\"><![endif]-->\r\n" + 
	   		"  <img class=\"center fixedwidth\" align=\"center\" border=\"0\" src=\"https://d15k2d11r6t6rl.cloudfront.net/public/users/BeeFree/beefree-l8fpa42smj/header-logo-1.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: 0;height: auto;float: none;width: 100%;max-width: 240px\" width=\"240\">\r\n" + 
	   		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
	   		"        </div>\r\n" + 
	   		"      </div>\r\n" + 
	   		"    </div>\r\n" + 
	   		"    <div style=\"background-color:#EAE3DD;\">\r\n" + 
	   		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #FFFFFF;\" class=\"block-grid \">\r\n" + 
	   		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
	   		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#EAE3DD;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 10px; padding-bottom: 10px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#892C63;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:120%; padding-right: 20px; padding-left: 20px; padding-top: 10px; padding-bottom: 10px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:14px;color:#892C63;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 18px;line-height: 22px\"><strong><span style=\"font-size: 14px; line-height: 16px;\">Hi "+address.getName()+" , Your order details are here.</span></strong></p></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
	   		"        </div>\r\n" + 
	   		"      </div>\r\n" + 
	   		"    </div>\r\n" + 
	   		"    <div style=\"background-color:#EAE3DD;\">\r\n" + 
	   		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #EDEDED;\" class=\"block-grid mixed-two-up \">\r\n" + 
	   		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#EDEDED;\">\r\n" + 
	   		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#EAE3DD;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:#EDEDED;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\" width:200px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num4\" style=\"display: table-cell;vertical-align: top;max-width: 320px;min-width: 200px;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div align=\"center\" class=\"img-container center  autowidth  fullwidth \" style=\"padding-right: 0px;  padding-left: 0px;\">\r\n" + 
	   		"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px;line-height:0px;\"><td style=\"padding-right: 0px; padding-left: 0px;\" align=\"center\"><![endif]-->\r\n" + 
	   		"  <div style=\"line-height:15px;font-size:1px\">&#160;</div>  <img class=\"center  autowidth  fullwidth\" align=\"center\" border=\"0\" src=\""+product.getImgurl()+"\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: 0;height: auto;float: none;width: 100%;max-width: 170px\" width=\"170\">\r\n" + 
	   		"<div style=\"line-height:15px;font-size:1px\">&#160;</div><!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"              <!--[if (mso)|(IE)]></td><td align=\"center\" width=\"400\" style=\" width:400px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num8\" style=\"display: table-cell;vertical-align: top;min-width: 320px;max-width: 400px;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#555555;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:180%; padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:22px;color:#555555;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 18px;line-height: 32px\"><strong><span style=\"font-size: 16px; line-height: 28px;\">"+product.getTitle()+"</span></strong></p><ul>\r\n" + 
	   		"<li style=\"font-size: 18px; line-height: 32px;\"><span style=\"font-size: 16px; line-height: 28px;\">Item price: "+product.getPrice()+"</span></li>\r\n" + 
	   		"<li style=\"font-size: 18px; line-height: 32px;\"><span style=\"font-size: 16px; line-height: 28px;\">Quantity: 1</span></li>\r\n" + 
	   		"<li style=\"font-size: 18px; line-height: 32px;\"><span style=\"font-size: 16px; line-height: 28px;\">Subtotal: $ "+product.getPrice()+"</span></li>\r\n" + 
	   		"</ul></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
	   		"        </div>\r\n" + 
	   		"      </div>\r\n" + 
	   		"    </div>\r\n" + 
	   		"    <div style=\"background-color:#EAE3DD;\">\r\n" + 
	   		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #5C5C5C;\" class=\"block-grid \">\r\n" + 
	   		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#5C5C5C;\">\r\n" + 
	   		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#EAE3DD;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:#5C5C5C;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#FFFFFF;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:120%; padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:14px;color:#FFFFFF;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><div style=\"line-height:14px; font-size:12px; text-align: center;\"><span style=\"font-size: 28px; line-height: 33px;\"><span style=\"line-height: 33px; font-size: 28px;\">Order confirmation</span></span></div></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 0px; padding-bottom: 25px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#FFFFFF;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:180%; padding-right: 20px; padding-left: 20px; padding-top: 0px; padding-bottom: 25px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:22px;color:#FFFFFF;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 25px;text-align: center\">Your order has been confirmed. Thank you for ordering from coffee shop&#160;<br>Enjoy your food...</p></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"                  \r\n" + 
	   		"                    \r\n" + 
	   		"<div align=\"center\" class=\"button-container center \" style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:30px;\">\r\n" + 
	   		"  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:30px;\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:38pt; v-text-anchor:middle; width:176pt;\" arcsize=\"0%\" strokecolor=\"#FFFFFF\" fillcolor=\"#FFFFFF\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#892C63; font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size:16px;\"><![endif]-->\r\n" + 
	   		"    <div style=\"color: #892C63; background-color: #FFFFFF; border-radius: 0px; -webkit-border-radius: 0px; -moz-border-radius: 0px; max-width: 235px; width: 185px;width: auto; border-top: 0px solid transparent; border-right: 0px solid transparent; border-bottom: 0px solid transparent; border-left: 0px solid transparent; padding-top: 10px; padding-right: 25px; padding-bottom: 10px; padding-left: 25px; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; text-align: center; mso-border-alt: none;\">\r\n" + 
	   		"      <span style=\"font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;font-size:16px;line-height:32px;\"><span style=\"font-family: 'lucida sans unicode', 'lucida grande', sans-serif; font-size: 16px; line-height: 32px;\" data-mce-style=\"font-family: 'lucida sans unicode', 'lucida grande', sans-serif; font-size: 16px; line-height: 28px;\" mce-data-marked=\"1\">TRACK YOUR ORDER</span></span>\r\n" + 
	   		"    </div>\r\n" + 
	   		"  <!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
	   		"        </div>\r\n" + 
	   		"      </div>\r\n" + 
	   		"    </div>\r\n" + 
	   		"    <div style=\"background-color:#EAE3DD;\">\r\n" + 
	   		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\" class=\"block-grid two-up \">\r\n" + 
	   		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\r\n" + 
	   		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#EAE3DD;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\" width:300px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num6\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#555555;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:150%; padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:18px;color:#555555;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 12px;line-height: 18px\"><span style=\"font-size: 14px; line-height: 21px;\"><strong><span style=\"line-height: 21px; font-size: 14px;\">Billing "
	   		+ "</span></strong></span></p><p style=\"margin: 0;font-size: 12px;line-height: 18px\"><span style=\"font-size: 12px; line-height: 18px;\">1170 Northeast Industrial Park Road</span></p><p style=\"margin: 0;font-size: 12px;line-height: 18px\"><span style=\"font-size: 12px; line-height: 18px;\">Meridian, MS 39301</span></p><p style=\"margin: 0;font-size: 12px;line-height: 18px\"><span style=\"font-size: 12px; line-height: 18px;\">(601) 482-7420 </span></p></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"              <!--[if (mso)|(IE)]></td><td align=\"center\" width=\"300\" style=\"background-color:#892C63; width:300px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num6\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\r\n" + 
	   		"              <div style=\"background-color: #892C63; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#FFFFFF;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:150%; padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:18px;color:#FFFFFF;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 12px;line-height: 18px\"><strong><span style=\"font-size: 14px; line-height: 21px;\">Shipping Address</span></strong></p><p style=\"margin: 0;font-size: 12px;line-height: 18px\">"+address.getAddress()+"</p></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
	   		"        </div>\r\n" + 
	   		"      </div>\r\n" + 
	   		"    </div>\r\n" + 
	   		"    <div style=\"background-color:#EAE3DD;\">\r\n" + 
	   		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #FFFFFF;\" class=\"block-grid \">\r\n" + 
	   		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
	   		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#EAE3DD;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 10px; padding-bottom: 10px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#892C63;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:120%; padding-right: 20px; padding-left: 20px; padding-top: 10px; padding-bottom: 10px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:14px;color:#892C63;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 18px;line-height: 22px\"><strong><span style=\"font-family: 'lucida sans unicode', 'lucida grande', sans-serif; font-size: 14px; line-height: 16px;\" mce-data-marked=\"1\">Shipping info</span></strong></p></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
	   		"        </div>\r\n" + 
	   		"      </div>\r\n" + 
	   		"    </div>\r\n" + 
	   		"    <div style=\"background-color:#EAE3DD;\">\r\n" + 
	   		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #EDEDED;\" class=\"block-grid \">\r\n" + 
	   		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#EDEDED;\">\r\n" + 
	   		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:#EAE3DD;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 600px;\"><tr class=\"layout-full-width\" style=\"background-color:#EDEDED;\"><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\" width:600px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
	   		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 600px;display: table-cell;vertical-align: top;\">\r\n" + 
	   		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"                  \r\n" + 
	   		"                    <div class=\"\">\r\n" + 
	   		"	<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\"><![endif]-->\r\n" + 
	   		"	<div style=\"color:#555555;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:150%; padding-right: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;\">	\r\n" + 
	   		"		<div style=\"font-size:12px;line-height:18px;color:#555555;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 12px;line-height: 18px\"><span style=\"font-size: 14px; line-height: 21px;\">Your items will be shipped within 30 mins to your address by your chosen delivery method.</span></p><p style=\"margin: 0;font-size: 12px;line-height: 18px\">&#160;</p></div>	\r\n" + 
	   		"	</div>\r\n" + 
	   		"	<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
	   		"</div>\r\n" + 
	   		"                  \r\n" + 
	   		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
	   		"              </div>\r\n" + 
	   		"            </div>\r\n" + 
	   		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
	   		"        </div>\r\n" + 
	   		"      </div>\r\n" + 
	   		"    </div>\r\n" + 
	   		"   <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
	   		"		</td>\r\n" + 
	   		"  </tr>\r\n" + 
	   		"  </tbody>\r\n" + 
	   		"  </table>\r\n" + 
	   		"  <!--[if (mso)|(IE)]></div><![endif]-->\r\n" + 
	   		"\r\n" + 
	   		"\r\n" + 
	   		"</body></html>"
	   		+ ""
	   		+ "", "text/html");
	   msg.setSentDate(new Date());

	   MimeBodyPart messageBodyPart = new MimeBodyPart();
	   messageBodyPart.setContent("Hi Thank you ordering food", "text/html");

//	   Multipart multipart = new MimeMultipart();
//	   multipart.addBodyPart(messageBodyPart);
//	   MimeBodyPart attachPart = new MimeBodyPart();
//
//	   attachPart.attachFile("/var/tmp/image19.png");
//	   multipart.addBodyPart(attachPart);
//	   msg.setContent(multipart); 
	   Transport.send(msg);  
	   String message="Hi "+address.getName()+" Team online coffee shop thanking you for ordering food from our website";
	  
	   
	   String mobile=address.getMobile_number();
	  String authtoken="155210AtYL1fumEBt5936e0cb";
	   Client client = Client.create();
		WebResource webResource = client.resource("http://api.msg91.com/api/sendhttp.php?country=91&sender=OCSHOP&route=4&mobiles="+address.getMobile_number()+"&authkey=155210AtYL1fumEBt5936e0cb&message="+message.replaceAll("\\s","%20")+"");
		ClientResponse response = webResource.get(ClientResponse.class);
			System.out.println(response.getEntity(String.class));
		System.out.println(response);
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}


	}

}