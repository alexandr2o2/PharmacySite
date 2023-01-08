package ru.pharmacy.pharmacy.controllers;



import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pharmacy.pharmacy.entiteis.ManufacturerEntity;
import ru.pharmacy.pharmacy.repositories.ManufacturerRepository;

import java.util.Formatter;
import java.util.List;

@RestController
public class ManufacturerController {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    @Qualifier("loggerBean")
    Logger logger;

    @PostMapping("/manufacturer")
    public String addManufacturer(Model model, @RequestBody ManufacturerEntity manufacturer){

        manufacturer.setId(null);
        manufacturerRepository.save(manufacturer);
        Formatter f = new Formatter();
        f.format("Добалена запись в БД произвлдителей, название \"%s\"", manufacturer.getName());
        logger.info(f.toString());

        return "Запрос выполнен";
    }

    @GetMapping("/find/manufacturers")
    public List fingManufacturer(Model model, @RequestParam(value = "name") String name){
        List<ManufacturerEntity> m = manufacturerRepository.findAllByName(name);
        logger.info("Запрос на поиск производителей выполнен");
        return m;
    }
}
