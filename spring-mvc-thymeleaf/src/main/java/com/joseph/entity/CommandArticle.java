package com.joseph.entity;

import javax.persistence.*;

@Entity
@Table(name="command_article")
public class CommandArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="command_id")
    private Command command;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;


    @Column(name="quantity")
    private int quantity;
    
    private double sousTotal;
}
