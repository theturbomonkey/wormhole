package theturbomonkey.wormhole.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Type;

@Entity
@Immutable
@Subselect ( "SELECT r.RouteID AS RouteID, r.RouteName AS RouteName, r.RouteEnabled AS RouteEnabled, r.RoutePriority AS RoutePriority, COUNT(e.EventID) AS FaultCount, SUM(CASE WHEN j.TraversalCount IS NOT NULL THEN j.TraversalCount ELSE 0 END) AS TraversalCount FROM tblRoute r LEFT JOIN tblEvent e ON r.RouteID = e.RouteID AND e.EventTypeID IN (2,3) LEFT JOIN tblRouteJob j ON r.RouteID = j.RouteID GROUP BY r.RouteID" )
public class RouteSummary
{
	@Id
	@Column ( name = "RouteID" )
	private int routeID;
	
	@Column ( name = "RouteName" )
	private String routeName;
	
	@Column ( name = "RouteEnabled", nullable = false )
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean routeEnabled;
	
	@Column ( name = "RoutePriority", nullable = false )
	private byte routePriority;
	
	@Column ( name = "FaultCount" )
	private int faultCount;
	
	@Column ( name = "TraversalCount" )
	private int traversalCount;
	
	public int getRouteID() {
		return routeID;
	}
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public boolean getRouteEnabled() {
		return routeEnabled;
	}
	public void setRouteEnabled(boolean routeEnabled) {
		this.routeEnabled = routeEnabled;
	}
	public byte getRoutePriority() {
		return routePriority;
	}
	public void setRoutePriority(byte routePriority) {
		this.routePriority = routePriority;
	}
	public int getFaultCount() {
		return faultCount;
	}
	public void setFaultCount(int faultCount) {
		this.faultCount = faultCount;
	}
	public int getTraversalCount() {
		return traversalCount;
	}
	public void setTraversalCount(int traversalCount) {
		this.traversalCount = traversalCount;
	}
} // End RouteSummaryBean Class

