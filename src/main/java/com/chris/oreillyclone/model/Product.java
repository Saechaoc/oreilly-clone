package com.chris.oreillyclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "Quantity")
    private int quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratingList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();

    @Column(name = "num_ratings")
    private int numRatings;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;

    private String stock;

//    @ManyToOne()
//    @JoinColumn(name="subcategory_id")
//    private Subcategory subcateogry;

    private LocalDateTime createdAt;
}
