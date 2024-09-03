package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        burgerDao.save(burger);
        return burger;
    }

    @GetMapping
    public List<Burger> findAll() {
        List<Burger> burgers = burgerDao.findAll();
        return burgers;
    }

    @GetMapping("/{id}")
    public Burger findId(@PathVariable long id) {
        Burger burger = burgerDao.findById(id);
        return burger;
    }

    @PutMapping("/{id}")
    public Burger update(@PathVariable long id) {
        Burger burger = burgerDao.findById(id);
        BurgerValidation.checkName(burger.getName());
        burgerDao.update(burger);
        return burger;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody Burger burger) {
        return burgerDao.findByPrice(burger.getPrice());
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestBody Burger burger) {
        return burgerDao.findByBreadType(burger.getBreadType());
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody Burger burger) {
        return burgerDao.findByContent(burger.getContents());
    }

}
