package com.marcos.fecha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

public class DateTimeController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/date")
    public ModelAndView date() {
        Date date = new Date();
        ModelAndView modelAndView = new ModelAndView("date");
        modelAndView.addObject("date", date);
        return modelAndView;
    }

    @GetMapping("/time")
    public ModelAndView time() {
        Date time = new Date();
        ModelAndView modelAndView = new ModelAndView("time");
        modelAndView.addObject("time", time);
        return modelAndView;
    }

}
