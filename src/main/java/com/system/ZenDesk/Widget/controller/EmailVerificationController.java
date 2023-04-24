package com.system.ZenDesk.Widget.controller;



import com.system.ZenDesk.Widget.model.User;
import com.system.ZenDesk.Widget.repo.UserRepo;
import com.system.ZenDesk.Widget.service.VerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class EmailVerificationController {
 private final Logger logger = LoggerFactory.getLogger(this.getClass());

@Value("${app.spring.name}")
String appName;
 @Autowired
 private UserRepo userRepo;

 @Autowired
 private VerificationService verificationService;

 @Autowired
 private VerificationController verificationController;


 @GetMapping("/")
  public ModelAndView homePage(ModelAndView mv , HttpServletRequest request, HttpServletResponse response){

  String message ="Welcome to Zendesk ";
  mv.addObject("appName",appName);
  mv.addObject("message",message);

  Authentication  auth = SecurityContextHolder.getContext().getAuthentication();
  if (auth !=null){

      String email=auth.getName();
   verificationService.clearCode(email);

   new SecurityContextLogoutHandler().logout(request,response,auth);
      mv.setViewName("infos");

  }

  return mv;

 }


 @RequestMapping(value="/Checkinfos",method = RequestMethod.GET)
 public ModelAndView check(HttpServletRequest request, ModelAndView mv, @RequestParam("email") String email){

  double val=Math.random();
  String error =null;
   if (val<0.1){

    mv.addObject("infosMessage","Try again after some time");
    mv.setViewName("infos");
    return mv;
   }
   else if (userRepo.findByEmail(email)!=null){


     mv.addObject("infosMessage","Email Is Already Existed");
     mv.setViewName("infos");
     return mv;


   }
   else{


  mv.addObject("infosMessage","Good informations");
    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    User user= new User(0,passwordEncoder.encode(email),email,false,"","","");

    user=userRepo.save(user);
    try{

     request.login(user.getEmail(),email);
     mv.addObject("remoteUser",request.getRemoteUser());
     return verificationController.generateCode(mv);

    } catch (ServletException e) {
       error=e.getMessage();
       logger.error(error);

    }

   }

   mv.addObject("infosMessage",error);
   mv.setViewName("infos");
   return mv;

 }

 @RequestMapping(value = "/logout",method = RequestMethod.GET)

 public @ResponseBody String logout(HttpServletRequest request,HttpServletResponse response){
  Authentication  auth = SecurityContextHolder.getContext().getAuthentication();

  if (auth !=null){

   String email=auth.getName();
   verificationService.clearCode(email);
   new SecurityContextLogoutHandler().logout(request,response,auth);
  }

 return   "redirect:/infos?logout";



 }



}

