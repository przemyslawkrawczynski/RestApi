//package com.crud.tasks.service;
//
//import com.crud.tasks.domain.Mail;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class SimpleMailServiceTest {
//
//    @InjectMocks
//    private SimpleMailService simpleMailService;
//
//    @Mock
//    private JavaMailSender javaMailSender;
//
////    @Test
////    public void shouldSendMail() {
////
////       //Given
////        Mail mail = new Mail("test@test.com", "cc@test.co","test", "Test Message");
////        Mail mail1 = new Mail("tes1@test1.com", "test", "Test Message");
////
////        // 1 mail
////        SimpleMailMessage mailMessage = new SimpleMailMessage();
////
////        if (mail.getToCC() != null) {
////            mailMessage.setCc(mail.getToCC());
////        }
////
////        mailMessage.setTo(mail.getReceiverEail());
////        mailMessage.setSubject(mail.getSubject());
////        mailMessage.setText(mail.getMessage());
////
////        //2 mail
////        SimpleMailMessage mailMessage1 = new SimpleMailMessage();
////
////        if (mail.getToCC() != null) {
////            mailMessage1.setCc(mail.getToCC());
////        }
////
////        mailMessage1.setSubject(mail.getSubject());
////        mailMessage1.setText(mail.getMessage());
////
////        //When
////        simpleMailService.send(mail);
////        simpleMailService.send(mail1);
////
////        //Then
////        verify(javaMailSender, times(1)).send(mailMessage);
////        verify(javaMailSender, times(1)).send(mailMessage1);
////
////    }
//
//}