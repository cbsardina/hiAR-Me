package com.arproject.arproject.service;

import com.arproject.arproject.config.MailConfig;
import com.arproject.arproject.model.Visitor;
import com.google.appengine.repackaged.com.google.common.io.CharStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Service
public class EmailService {

    private static final String EMAIL_TEXT_TEMPLATE_NAME = "text/email-text";
    private static final String EMAIL_SIMPLE_TEMPLATE_NAME = "html/email-simple";
    private static final String EMAIL_WITHATTACHMENT_TEMPLATE_NAME = "html/email-withattachment";
    private static final String EMAIL_INLINEIMAGE_TEMPLATE_NAME = "html/email-inlineimage";
    private static final String EMAIL_EDITABLE_TEMPLATE_CLASSPATH_RES = "classpath:mail/editablehtml/email-editable.html";

    private static final String BACKGROUND_IMAGE = "mail/editablehtml/images/background.png";
    private static final String LOGO_BACKGROUND_IMAGE = "mail/editablehtml/images/logo-background.png";
    private static final String THYMELEAF_BANNER_IMAGE = "mail/editablehtml/images/thymeleaf-banner.png";
    private static final String THYMELEAF_LOGO_IMAGE = "mail/editablehtml/images/thymeleaf-logo.png";

    private static final String PNG_MIME = "image/png";

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine stringTemplateEngine;




    /*
     * Send HTML mail with inline image
     */
    public String getEditableMailTemplate() throws IOException {
        final Resource templateResource = this.applicationContext.getResource(EMAIL_EDITABLE_TEMPLATE_CLASSPATH_RES);
        final InputStream inputStream = templateResource.getInputStream();
        return CharStreams.toString((Readable) inputStream);
    }

    /*
     * Send HTML mail with inline image
     */
    String tempHtmlContent = "RANDOM CONTENT";
    public void sendEditableEmail(
            final String visitorName, final String visitorEmail,
            final Locale locale)
            throws MessagingException {

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message
                = new MimeMessageHelper(mimeMessage, true /* multipart */, "UTF-8");
        message.setSubject("Thank You!");
        message.setFrom("Hi.AR.Me.TIY@gmail.com");
        message.setTo(visitorEmail);

        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", visitorName);

        // Create the HTML body using Thymeleaf
        final String output = stringTemplateEngine.process(tempHtmlContent, ctx);
        message.setText(output, true /* isHtml */);

        // Send mail
        this.mailSender.send(mimeMessage);
    }
}
