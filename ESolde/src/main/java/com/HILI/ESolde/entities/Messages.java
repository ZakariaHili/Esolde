package com.HILI.ESolde.entities;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Messages implements Serializable{

	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Message;

	private String Body_Message;

	private String Objet_Message;
	
	private String Attachment;
	
	@ManyToOne
	@JoinColumn(name="Id_Equipe")
	private Equipe_ESolde equipe;
	
	@ManyToOne
	@JoinColumn(name="Id_representant")
	private Representant_magasin representant_magasin;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, updatable=false)
	private Date date;
	
	
	public Messages() {
		
	
	}
	
	public Messages( String body_Message, String objet_Message,
			 Equipe_ESolde equipe,
			Representant_magasin representant_magasin) {
		
		
		Body_Message = body_Message;
		Objet_Message = objet_Message;
		
		this.equipe = equipe;
		representant_magasin = representant_magasin;
	}




	public int getId_Message() {
		return Id_Message;
	}




	public void setId_Message(int id_Message) {
		Id_Message = id_Message;
	}




	public String getBody_Message() {
		return Body_Message;
	}




	public void setBody_Message(String body_Message) {
		Body_Message = body_Message;
	}




	public String getObjet_Message() {
		return Objet_Message;
	}




	public void setObjet_Message(String objet_Message) {
		Objet_Message = objet_Message;
	}




	public String getAttachment() {
		return Attachment;
	}




	public void setAttachment(String attachment) {
		Attachment = attachment;
	}




	public Equipe_ESolde getEquipe() {
		return equipe;
	}




	public void setEquipe(Equipe_ESolde equipe) {
		this.equipe = equipe;
	}




	public Representant_magasin getRepresentant_magasin() {
		return representant_magasin;
	}




	public void setRepresentant_magasin(Representant_magasin representant_magasin) {
		this.representant_magasin = representant_magasin;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}






}
