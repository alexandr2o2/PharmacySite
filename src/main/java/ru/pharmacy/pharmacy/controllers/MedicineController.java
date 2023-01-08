package ru.pharmacy.pharmacy.controllers;


import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pharmacy.pharmacy.entiteis.CategoryEntity;
import ru.pharmacy.pharmacy.entiteis.MedicineEntity;
import ru.pharmacy.pharmacy.repositories.CategoryRepository;
import ru.pharmacy.pharmacy.repositories.MedicineRepository;

import java.util.*;

@Controller
public class MedicineController {
    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    @Qualifier("loggerBean")
    Logger logger;

    @PostMapping("/medicines")
    public Integer addMedicine(Model model, @RequestBody MedicineEntity medicine,
                               @RequestBody(required = false) Set<Long> categoriesIdShortList){
//        logger.info("Начато выполнение запроса на добавление");
        Optional<MedicineEntity> medId = medicineRepository.findById(medicine.getId());
        if (medId.isPresent()){
            return Response.SC_NOT_MODIFIED;
        }
        medicine.setId(null);
//        logger.info("Получен объект");
        logger.info(medicine.toString());
        if (medicine.getCategoryEntities().isEmpty()) {
            Set<CategoryEntity> categoryEntities = new HashSet<CategoryEntity>();
            for (Long id : categoriesIdShortList){
                Optional<CategoryEntity> category = categoryRepository.findById(id);
                if (category.isPresent()) {
                    categoryEntities.add(category.get());
                } else {
                    return Response.SC_BAD_REQUEST;
                }
            }
            medicine.setCategoryEntities(categoryEntities);
        }

        medicineRepository.save(medicine);
        Formatter f = new Formatter();
        f.format("Добалена запись в БД препаратов 'medicine', название \"%s\"", medicine.getName());
        logger.info(f.toString());

        return Response.SC_OK;
    }

    @GetMapping("/find/medicines")
    public List findMedicine(Model model, @RequestParam(value = "name") String name){
        List<MedicineEntity> m = medicineRepository.findAllByName(name);
        logger.info("Запрос на поиск в БД 'medicine' выполнен");
        return m;
    }
}
