package project.dajver.com.cartviewwithbadge.cart.helper.entity.models;

import java.io.Serializable;
import java.math.BigDecimal;

import project.dajver.com.cartviewwithbadge.cart.helper.i.Saleable;

public class ProductEntityModel implements Saleable, Serializable {

    private static final long serialVersionUID = -4073256626483275668L;

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String image;

    public ProductEntityModel() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof ProductEntityModel)) return false;

        return (this.id == ((ProductEntityModel) o).getId());
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = (int) (hash * prime + id);
        hash = hash * prime + (name == null ? 0 : name.hashCode());
        hash = hash * prime + (price == null ? 0 : price.hashCode());
        hash = hash * prime + (description == null ? 0 : description.hashCode());

        return hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String pDescription) {
        this.description = pDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageName) {
        this.image = imageName;
    }
}