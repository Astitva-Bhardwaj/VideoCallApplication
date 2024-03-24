//package com.example.VideoCall.controller;
//
//
//
//import com.example.VideoCall.entity.User;
//import com.example.VideoCall.entity.VideoCall;
//import com.example.VideoCall.service.UserService;
//import com.example.VideoCall.service.VideoCallService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.Principal;
//
//@Slf4j
//@Controller
//@RequestMapping("/video")
//public class VideoCallController {
//
//    @Autowired
//    private VideoCallService videoCallService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/create")
//    public String showCreateCallForm(Model model) {
//        model.addAttribute("videoCall", new VideoCall());
//        return "create_call"; // Return the name of the create call form HTML template
//    }
//
//    @PostMapping("/create")
//    public String createVideoCall(@ModelAttribute("videoCall")VideoCall videoCall, HttpServletRequest request) {
//        // Retrieve the logged-in user from the session
//        HttpSession session = request.getSession();
//        log.info("## VideoCallController -- createVideoCall -- >> " + session.getAttribute("loggedInUser"));
//        if (session != null && session.getAttribute("loggedInUser") != null) {
//            User loggedInUser = (User) session.getAttribute("loggedInUser");
//            videoCall.setUser(loggedInUser);
//            videoCallService.createVideoCall(videoCall);
//            return "meeting_buttons"; // Redirect to the meeting_buttons page
//        }
//
//        // Handle case where user is not found or authentication fails
//        return "redirect:/user/login"; // Redirect to login page or handle as needed
//    }
//
//
//
//
//    @GetMapping("/join")
//    public String showJoinCallForm() {
//        return "join_call"; // Return the name of the join call form HTML template
//    }
//
//    @PostMapping("/join")
//    public String joinVideoCall() {
//        // Logic to join an existing video call
//        return "redirect:/video";
//    }
//
//    // Additional controller methods for handling video call operations
//    // ...
//}
