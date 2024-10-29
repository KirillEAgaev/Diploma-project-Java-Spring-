package ru.agaev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.agaev.springcourse.models.Material;
import ru.agaev.springcourse.services.MaterialService;

import javax.validation.Valid;

@Controller
@RequestMapping("/materials")
public class MaterialsController {
    private final MaterialService materialService;

    @Autowired
    public MaterialsController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("materials", materialService.findAll());
        return "materials/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("material", materialService.findOne(id));
        return "materials/show";
    }

    @GetMapping("/new")
    public String newMaterial(@ModelAttribute("material") Material material) {
        return "materials/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("material") @Valid Material material,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "materials/new";

        materialService.save(material);
        return "redirect:/materials";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("material", materialService.findOne(id));
        return "materials/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("material") @Valid Material material, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "materials/edit";

        materialService.update(id, material);
        return "redirect:/materials";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        materialService.delete(id);
        return "redirect:/materials";
    }

    @GetMapping("/search/type")
    public String searchByType(@RequestParam("type") String type, Model model) {
        model.addAttribute("materials", materialService.searchByType(type));
        return "materials/index";
    }

    @GetMapping("/search/mark")
    public String searchByMark(@RequestParam("mark") String mark, Model model) {
        model.addAttribute("materials", materialService.searchByMark(mark));
        return "materials/index";
    }

    @GetMapping("/calculate")
    public String showCalculationForm(Model model) {
        model.addAttribute("materials", materialService.findAll());
        return "materials/calculate/index";
    }

    @PostMapping("/calculate")
    public String calculateMaterial(@RequestParam int materialId,
                                    @RequestParam double quantity,
                                    @RequestParam(required = false) Double diameter,
                                    @RequestParam(required = false) Double width,
                                    @RequestParam(required = false) Double height,
                                    Model model) {
        Material material = materialService.findOne(materialId);
        double volume = materialService.calculateVolume(String.valueOf(material.getDensityOfMaterial()), quantity);
        double sectionArea;

        if (diameter != null) {
            sectionArea = materialService.calculateSectionArea(diameter);
        } else {
            sectionArea = materialService.calculateSectionArea(width, height);
        }

        int numberOfBars = materialService.calculateNumberOfBars(volume, sectionArea);

        model.addAttribute("material", material);
        model.addAttribute("quantity", quantity);
        model.addAttribute("volume", volume);
        model.addAttribute("sectionArea", sectionArea);
        model.addAttribute("numberOfBars", numberOfBars);

        return "materials/calculate/calculate";
    }
}
