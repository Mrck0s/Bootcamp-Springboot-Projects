package com.marcos.license.controllers;

import com.marcos.license.models.License;
import com.marcos.license.services.LicenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping("/new")
    public String showLicenseForm(Model model) {
        model.addAttribute("license", new License());
        return "licenseForm";
    }

    @PostMapping("/new")
    public String createLicense(@ModelAttribute License license) {
        licenseService.createLicense(license.getState(), license.getExpirationDate());
        return "redirect:/list";
    }
}

