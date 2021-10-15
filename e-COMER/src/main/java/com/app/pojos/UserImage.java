package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="image_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserImage extends BaseEntity{
	
	@Column(length = 100)
	private String name;
	@Column(length = 50)
	private String type;
	
	@Lob
	private byte[] data;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private User owner;

	public UserImage(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}
	

}
