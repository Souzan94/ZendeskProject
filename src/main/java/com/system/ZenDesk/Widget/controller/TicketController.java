package com.system.ZenDesk.Widget.controller;


import com.system.ZenDesk.Widget.model.User;
import com.system.ZenDesk.Widget.repo.UserRepo;
import com.system.ZenDesk.Widget.service.IvrService;
import com.system.ZenDesk.Widget.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class TicketController {

    @Autowired
    public UserRepo userRepo;
    @Autowired
    public TicketService ticketService;
    @Autowired
    public IvrService  ivrService;

    @RequestMapping(value="/createTicket",method = RequestMethod.POST)

    public ModelAndView  createTicket(ModelAndView mv,  @ModelAttribute User user, @RequestParam(value = "checkbox1",defaultValue = "false") boolean checkbox1,
                                      @RequestParam(value = "checkbox2",defaultValue = "false") boolean checkbox2,
                                      @RequestParam(value = "categorySelect",defaultValue = "") String categorySelect
            ,@RequestParam(value = "subcategorySelect",defaultValue = "") String subcategory) throws IOException {
        User user1= new User();
        user1=userRepo.findByEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setSurName(user.getSurName());
        user1=userRepo.save(user1);
        String message = ticketService.generateTicket(user1,checkbox1,checkbox2,categorySelect,subcategory);
        ivrService.CreateCampaign();
        mv.addObject("finalMessage",message);
        mv.setViewName("dashboard");

        return  mv;


    }
}
