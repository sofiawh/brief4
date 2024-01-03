package com.joseph.entity;

import com.joseph.enums.State;
import com.joseph.entity.CommandArticle;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Transactional
@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "date_cmd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCmd;
    
    

   // @Column(name = "date_mise")
   // private Date dateMise;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Customer customer;

    
	@OneToMany(mappedBy = "command", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CommandArticle> commandArticleList;

    @Column(name = "price_total")
    private float priceTotal;
   // @Column
   // private State state;
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
	/*public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}*/
	@Override
	public String toString() {
		return "Command [id=" + id + ", dateCmd=" + dateCmd + ", customer=" + customer + ", commandArticleList="
				+ commandArticleList + ", priceTotal=" + priceTotal + "]";
	}
    

}

