package com.example.VideoCall.controller;


import com.example.VideoCall.entity.User;
import com.example.VideoCall.entity.VideoCall;
import com.example.VideoCall.service.UserService;
import com.example.VideoCall.service.impl.UserServiceImpl;
import com.example.VideoCall.service.impl.VideoCallServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    VideoCallServiceImpl videoCallService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Return the name of the registration form HTML template
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.registerUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Return the name of the login form HTML template
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        User user = userService.loginUser(username, password);
        log.info("UserController -- login -->> " + user.toString());
        if (user != null) {
            // Successful login
            model.addAttribute("user", user);
            session.setAttribute("loggedInUser", user);
            return "meeting"; // Redirect to dashboard or home page after login
        } else {
            // Failed login
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "redirect:/user/login"; // Return to the login form with an error message
        }
    }

    @PostMapping("/video/create")
    public String createVideoCall(@ModelAttribute("videoCall") VideoCall videoCall, HttpServletRequest request) {
        log.info("UserController -- /video/create");
        // Retrieve the logged-in user from the session
        HttpSession session = request.getSession();

        log.info("## UserController -- createVideoCall -- >> " + session.getAttribute("loggedInUser"));
        if (session != null && session.getAttribute("loggedInUser") != null) {
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            videoCall.setUser(loggedInUser);
            videoCallService.createVideoCall(videoCall);
            return "meeting_buttons"; // Redirect to the meeting_buttons page
        }

        // Handle case where user is not found or authentication fails
        return "redirect:/user/login"; // Redirect to login page or handle as needed
    }


}
