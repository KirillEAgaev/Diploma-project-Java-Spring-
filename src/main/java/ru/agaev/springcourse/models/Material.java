package ru.agaev.springcourse.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Type of material should not be empty")
    @Size(min = 2, max = 100, message = "Type of material should be between 2 and 100 characters")
    @Column(name = "material_type")
    private String typeOfMaterial;

    @NotEmpty(message = "Shape of material should not be empty")
    @Size(min = 2, max = 100, message = "Shape of material should be between 2 and 100 characters")
    @Column(name = "material_shape")
    private String shapeOfMaterial;

    @NotEmpty(message = "Mark of material should not be empty")
    @Size(min = 2, max = 100, message = "Mark of material should be between 2 and 100 characters")
    @Column(name = "material_mark")
    private String markOfMaterial;

    @NotEmpty(message = "Price for 3 meters of material should not be empty")
    @Column(name = "price_per_3m")
    private double pricePer3m;

    @NotEmpty(message = "Density of material should not be empty")
    @Column(name = "density")
    private double densityOfMaterial;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<MaterialInOrder> materialsInOrder;

    public Material() {

    }

    public Material(String typeOfMaterial, String shapeOfMaterial, String markOfMaterial, double pricePer3m, double densityOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
        this.shapeOfMaterial = shapeOfMaterial;
        this.markOfMaterial = markOfMaterial;
        this.pricePer3m = pricePer3m;
        this.densityOfMaterial = densityOfMaterial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public String getShapeOfMaterial() {
        return shapeOfMaterial;
    }

    public void setShapeOfMaterial(String shapeOfMaterial) {
        this.shapeOfMaterial = shapeOfMaterial;
    }

    public String getMarkOfMaterial() {
        return markOfMaterial;
    }

    public void setMarkOfMaterial(String markOfMaterial) {
        this.markOfMaterial = markOfMaterial;
    }

    public double getPricePer3m() {
        return pricePer3m;
    }

    public void setPricePer3m(double pricePer3m) {
        this.pricePer3m = pricePer3m;
    }

    public double getDensityOfMaterial() {
        return densityOfMaterial;
    }

    public void setDensityOfMaterial(double densityOfMaterial) {
        this.densityOfMaterial = densityOfMaterial;
    }

    public List<MaterialInOrder> getMaterialsInOrder() {
        return materialsInOrder;
    }

    public void setMaterialsInOrder(List<MaterialInOrder> materialsInOrder) {
        this.materialsInOrder = materialsInOrder;
    }
}
