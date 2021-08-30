package com.saleka.application.notification;

import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.notification.message.Message;
import com.saleka.application.notification.message.MessageService;
import com.saleka.application.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NotificationController {
    @Autowired
    private MessageService messageService;

    @GetMapping("admin/mailbox")
    public String getMessages(Model model,@RequestParam(required = false , defaultValue = "1") int page){
        int size = 10;
        UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Message> allMessages = messageService.listMessages();
        Page<Message> pageMessages = messageService.listMessages(page,size);
        List<Message> messages = pageMessages.getContent();

        model.addAttribute("user", connectedUser);
        model.addAttribute("messages",messages);
        model.addAttribute("currentPage",page);
        model.addAttribute("allmessages",allMessages.size());
        model.addAttribute("totalPages",pageMessages.getTotalPages());
        model.addAttribute("totalElements",pageMessages.getTotalElements());
        return "admin/notification/mailbox";
    }
    @GetMapping("admin/compose")
    public String writeMessage(Model model,@RequestParam(required = false , defaultValue = "1") int page){
        int size = 10;
        UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Message> allMessages = messageService.listMessages();
        Page<Message> pageMessages = messageService.listMessages(page,size);
        List<Message> messages = pageMessages.getContent();

        model.addAttribute("user", connectedUser);
        model.addAttribute("messages",messages);
        model.addAttribute("currentPage",page);
        model.addAttribute("allmessages",allMessages.size());
        model.addAttribute("totalPages",pageMessages.getTotalPages());
        model.addAttribute("totalElements",pageMessages.getTotalElements());
        return "admin/notification/compose";
    }
}
