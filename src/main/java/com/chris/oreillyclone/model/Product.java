package com.chris.oreillyclone.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "product_line")
    private String productLine;
    @Column(name = "product_family")
    private String productFamily;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratingList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();

    @Column(name = "num_ratings")
    private int numRatings;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category cateogry;

//    @ManyToOne()
//    @JoinColumn(name="subcategory_id")
//    private Subcategory subcateogry;

    private LocalDateTime createdAt;

    public Product() {}

    public Product(Long id, String title, String description, double price, String productLine,
                   String productFamily, String imageUrl, List<Rating> ratingList, int numRatings,
                   Category cateogry, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.productLine = productLine;
        this.productFamily = productFamily;
        this.imageUrl = imageUrl;
        this.ratingList = ratingList;
        this.numRatings = numRatings;
        this.cateogry = cateogry;
        this.createdAt = createdAt;
    }
}
