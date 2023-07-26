package com.marcos.fecha;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    private Date date;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/date")
    public String date(Model model) {
        this.date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d 'de' MMMM, yyyy");
        String formattedDate = dateFormat.format(date);
        model.addAttribute("formattedDate", formattedDate);
        return "date";
    }
    @RequestMapping("/time")
    public String time(Model model) {
        this.date = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(date);
        model.addAttribute("formattedTime", formattedTime);
        return "time";
    }
}
