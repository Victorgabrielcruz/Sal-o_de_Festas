package Salao_de_festas.Salao_de_festas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Salao_de_festas.Salao_de_festas.modells.entities.Administrator;

@RestController
@RequestMapping("/api/Administrator")
public class ControllersAdministrator {

    @PostMapping
    public Administrator Create(@RequestBody Administrator administrator) {
        Administrator admin = new Administrator(administrator.getName(), administrator.getPhone(), administrator.getVenueAddress(), administrator.getCnpj());
        return admin;
    }

    @GetMapping
    public String view() {
        return "funcionando";
    }
}
