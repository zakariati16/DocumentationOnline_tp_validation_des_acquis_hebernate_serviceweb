package com.poe.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER")
    private Long id;
    private String name;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public void setNotNullData(Category newCategoryData){
        if(newCategoryData.getName()!= null) {
            this.setName(newCategoryData.getName());
        }
     }
    

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + '}';
    }

}
