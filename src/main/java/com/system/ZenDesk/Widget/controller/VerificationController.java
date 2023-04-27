package com.system.ZenDesk.Widget.controller;


import com.system.ZenDesk.Widget.Utils.EmailTemplate;
import com.system.ZenDesk.Widget.model.User;
import com.system.ZenDesk.Widget.repo.UserRepo;
import com.system.ZenDesk.Widget.service.EmailService;
import com.system.ZenDesk.Widget.service.VerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VerificationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public VerificationService verificationService;

    @Autowired
    public UserRepo userRepo;


    @Autowired
    EmailService emailService;

    @GetMapping("/generateCode")

    public ModelAndView generateCode( ModelAndView mv){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
           String email=auth.getName();
           int code=verificationService.generateCode(email);

            logger.info("Code : "+code);
            EmailTemplate emailTemplate= new EmailTemplate("your code is");
            Map<String,String> replacements= new HashMap<String,String>();
            replacements.put("user",email);
            replacements.put("codenum",String.valueOf(code));
            String message=emailTemplate.getTemplate(replacements);
            User user= userRepo.findByEmail(email);
            emailService.SendMessage(user.getEmail(),"Zendesk System",message+" "+code);
            mv.setViewName("codepage");

        return mv;
    }

    @RequestMapping(value = "/validateCode",method = RequestMethod.GET)
    public ModelAndView validateCode(ModelAndView mv, @RequestParam("codenum") int codenum){

      final  String  SUCCESS= "Entered Code Is Valid";
        String   FAIL="Code Has Been Expired  In 1 Minute .Please Resend Again";
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      String email=auth.getName();
      logger.info("Code Number : "+codenum);
      if(codenum>=0){

       int ServerCode= verificationService.getCode(email);
       if (ServerCode>0)
       {
        if (codenum==ServerCode){


            verificationService.clearCode(email);
            mv.addObject("codeMessage",SUCCESS);
            User user=userRepo.findByEmail(email);
            user.setEnabled(true);
            userRepo.save(user);
            List<GrantedAuthority> authorities= new ArrayList<>();
            Authentication newAuth= new UsernamePasswordAuthenticationToken(auth.getPrincipal(),auth.getCredentials(),authorities);
            SecurityContextHolder.getContext().setAuthentication(newAuth);

            mv.setViewName("userinfos");
            //mv.addObject("remoteUser",user.getEmail());
            mv.addObject("user", user);


            return  mv;
        }
        else{ FAIL="Code Is Invalid Please Check From Your Code ";}


       }


      }


      mv.addObject("codeMessage",FAIL);
      mv.setViewName("codepage");
      return  mv;


    }
}
