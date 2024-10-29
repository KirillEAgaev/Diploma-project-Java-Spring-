package ru.agaev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agaev.springcourse.models.Material;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
    List<Material> findByTypeOfMaterialContaining(String type);
    List<Material> findByMarkOfMaterialContaining(String mark);
    Material findByMarkOfMaterial(String mark);
}
