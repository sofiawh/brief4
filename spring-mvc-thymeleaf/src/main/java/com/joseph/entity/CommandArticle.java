package com.joseph.entity;

import javax.persistence.*;

@Entity
@Table(name="command_article")
public class CommandArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="command_id")
    private Command command;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;


    @Column(name="quantity")
    private int quantity;
    
    private double sousTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSousTotal() {
		return sousTotal;
	}

	public void setSousTotal(double sousTotal) {
		this.sousTotal = sousTotal;
	}

	public CommandArticle() {
	
		// TODO Auto-generated constructor stub
	}

	/*@Override
	public String toString() {
		return "CommandArticle [id=" + id + ", command=" + command + ", article=" + article + ", quantity=" + quantity
				+ ", sousTotal=" + sousTotal + "]";
	}
    */
    
}
