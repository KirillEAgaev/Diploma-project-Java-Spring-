package ru.agaev.springcourse.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agaev.springcourse.models.Material;
import ru.agaev.springcourse.repositories.MaterialRepository;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Material findOne(int id) {
        return materialRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Material material) {
        materialRepository.save(material);
    }

    @Transactional
    public void update(int id, Material updatedMaterial) {
        updatedMaterial.setId(id);
        materialRepository.save(updatedMaterial);
    }

    @Transactional
    public void delete(int id) {
        materialRepository.deleteById(id);
    }

    public List<Material> searchByType(String type) {
        return materialRepository.findByTypeOfMaterialContaining(type);
    }

    public List<Material> searchByMark(String mark) {
        return materialRepository.findByMarkOfMaterialContaining(mark);
    }

    public double calculateVolume(String materialMark, double quantity) {
        Material material = materialRepository.findByMarkOfMaterial(materialMark);
        if (material == null) {
            throw new IllegalArgumentException("Material not found for the given mark");
        }
        double density = material.getDensityOfMaterial();
        return quantity / density;
    }

    public double calculateSectionArea(double diameter) {
        return Math.PI * Math.pow(diameter / 2, 2);
    }

    public double calculateSectionArea(double width, double height) {
        return width * height;
    }

    public int calculateNumberOfBars(double volume, double sectionArea) {
        double standardBarLength = 3.0;
        double length = volume / sectionArea;
        return (int) Math.ceil(length / standardBarLength);
    }
}
