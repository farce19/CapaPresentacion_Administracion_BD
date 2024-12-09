package com.administracion.bd.category;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY") 
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID") 
    private Long categoryId;

    @Column(name = "CATEGORY_NAME") 
    private String categoryName;

    
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
