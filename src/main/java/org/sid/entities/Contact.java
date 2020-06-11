package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	public String name ;
    public String email; 
    public String message;
    public String subject;
}
