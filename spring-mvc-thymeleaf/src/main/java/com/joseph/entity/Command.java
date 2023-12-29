package com.joseph.entity;

import com.joseph.enums.State;
import com.joseph.entity.CommandArticle;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_cmd")
    private Date dateCmd;
    
    

    @Column(name = "date_mise")
    private Date dateMise;
    
    @ManyToOne
    @JoinColumn(name="client_id")
    private Customer customer;

    @OneToMany(mappedBy = "command")
    private List<CommandArticle> commandArticleList;

    @Column(name = "price_total")
    private float priceTotal;
    @Column
    private State state;
	public Command() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	public Date getDateMise() {
		return dateMise;
	}
	public void setDateMise(Date dateMise) {
		this.dateMise = dateMise;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<CommandArticle> getCommandArticleList() {
		return commandArticleList;
	}
	public void setCommandArticleList(List<CommandArticle> commandArticleList) {
		this.commandArticleList = commandArticleList;
	}
	public float getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
    

}

