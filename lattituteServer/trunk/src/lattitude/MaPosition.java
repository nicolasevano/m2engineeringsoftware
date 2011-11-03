package lattitude;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="MaPosition")
public class MaPosition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5910499101046618310L;

	public MaPosition() {
		
	}
	
	public MaPosition(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}	
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	public Date getDate(){
		return date;
	}
	
	@Id
	@GeneratedValue
	long id;
	
	int x;
	
	int y;
	
	int z;
	
	@Column(name="date", insertable=false, updatable=false, columnDefinition="timestamp default current_timestamp")
	@Temporal( TemporalType.TIMESTAMP )
	Date date;
	
}
