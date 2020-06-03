package com.fakecompany.grader.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Item
{
	public enum Status
	{
		SUBMITTED,
		PENDING,
		COMPLETE
	}
	
	@Id
	private String id;
	
	private String name;
	private String notes;
	private Number grade;
	private Date completed;
	private Status status;
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getNotes()
	{
		return notes;
	}
	
	public void setNotes(String notes)
	{
		this.notes = notes;
	}
	
	public Number getGrade()
	{
		return grade;
	}
	
	public void setGrade(Number grade)
	{
		this.grade = grade;
	}
	
	public Date getCompleted()
	{
		return completed;
	}
	
	public void setCompleted(Date completed)
	{
		this.completed = completed;
	}
	
	public Status getStatus()
	{
		return status;
	}
	
	public void setStatus(Status status)
	{
		this.status = status;
	}
}
