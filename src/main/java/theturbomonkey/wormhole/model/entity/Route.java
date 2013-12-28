package theturbomonkey.wormhole.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table ( name = "tblRoute")
public class Route 
{
	// Define each of the JPA column value mappings.
	@Id
	@GeneratedValue ( generator = "increment" )
	@GenericGenerator ( name="increment", strategy = "increment" )
	@Column ( name = "RouteID" )
	private Integer routeID;
	
	@Column ( name = "RouteName", nullable = false, length = 100)
	private String routeName;
	
	@Column ( name = "RouteDesc", nullable = false, length = 2048)
	private String routeDesc;
	
	@Column ( name = "RouteEnabled", nullable = false )
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean routeEnabled;
	
	@Column ( name = "RoutePriority", nullable = false )
	private byte routePriority;
	
	@Temporal ( TemporalType.TIMESTAMP )
	@Column ( name = "CreateDate" )
	private Date createDate;
	
	@Temporal ( TemporalType.TIMESTAMP )
	@Column ( name = "LastModifiedDate", nullable = false )
	private Date lastModifiedDate;
	
	@Column ( name = "LastModifiedUser", nullable = false, length = 16)
	private String lastModifiedUser;
	
	
	public Route ()
	{
	} // End Route Constructor

	
	// Setters and getters
	public Integer getRouteID() 
	{
		return routeID;
	}

	
	public void setRouteID(Integer routeID) 
	{
		this.routeID = routeID;
	}

	
	public String getRouteName() 
	{
		return routeName;
	}

	
	public void setRouteName(String routeName) 
	{
		this.routeName = routeName;
	}

	
	public String getRouteDesc() 
	{
		return routeDesc;
	}

	
	public void setRouteDesc(String routeDesc) 
	{
		this.routeDesc = routeDesc;
	}

	
	public boolean getRouteEnabled() 
	{
		return this.routeEnabled;
	}

	
	public void setRouteEnabled(boolean routeEnabled) 
	{
		this.routeEnabled = routeEnabled;
	}
	
	public byte getRoutePriority() 
	{
		return this.routePriority;
	}

	
	public void setRoutePriority(byte routePriority) 
	{
		this.routePriority = routePriority;
	}

	
	public Date getCreateDate() 
	{
		return createDate;
	}

	
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	
	public Date getLastModifiedDate() 
	{
		return lastModifiedDate;
	}

	
	public void setLastModifiedDate(Date lastModifiedDate) 
	{
		this.lastModifiedDate = lastModifiedDate;
	}

	
	public String getLastModifiedUser() 
	{
		return lastModifiedUser;
	}

	
	public void setLastModifiedUser(String lastModifiedUser) 
	{
		this.lastModifiedUser = lastModifiedUser;
	}
} // End Route Class
