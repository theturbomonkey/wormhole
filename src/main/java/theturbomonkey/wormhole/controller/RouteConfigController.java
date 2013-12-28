package theturbomonkey.wormhole.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import theturbomonkey.wormhole.bean.DataTableData;
import theturbomonkey.wormhole.model.entity.Route;
import theturbomonkey.wormhole.model.entity.RouteSummary;
import theturbomonkey.wormhole.model.repository.RouteRepository;
import theturbomonkey.wormhole.model.repository.RouteSummaryRepository;

@Controller
@RequestMapping ( value = "/app/service/route" )
public class RouteConfigController 
{
	@Resource
	private RouteRepository routeRepo;
	
	@Resource
	private RouteSummaryRepository routeSummaryRepo;
	
	private Logger LOGGER = LoggerFactory.getLogger(RouteRepository.class);
	
	//****************************************************************************
	// Method: getRoute
	// URL Request Mapping: /app/service/route/{routeID}
	// Description:
	/**
	 * Obtain a route configuration by it's ID.
	 */
	//****************************************************************************
	@RequestMapping ( value = "/{routeID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public @ResponseBody Route getRoute ( @RequestBody String body, @PathVariable ( "routeID" ) int routeID, ModelMap model )
	{
		Route route = null;
		try
		{
			route = this.routeRepo.findOne ( routeID );
		}
		catch ( Exception dsEx )
		{
			LOGGER.error ( "An error occurred while attempting to obtain the route with ID " + routeID + ". " + dsEx.getMessage() );
			route = new Route ();
		}
		
		return route;
	} // End getAllRoutes
	
	
	//****************************************************************************
	// Method: getAllRoutes
	// URL Request Mapping: /app/service/route/all
	// Description:
	/**
	 * Obtain a list of all route configuration objects.
	 */
	//****************************************************************************
	@RequestMapping ( value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public @ResponseBody List<Route> getAllRoutes ( @RequestBody String body, ModelMap model )
	{
		List<Route> routeList = null;
		try
		{
			routeList = this.routeRepo.findAll();
		}
		catch ( Exception dsEx )
		{
			LOGGER.error ( "An error occurred while attempting to obtain the route list. " + dsEx.getMessage() );
			routeList = new ArrayList<Route> ();
		}
		
		return routeList;
	} // End getAllRoutes
	
	
	//****************************************************************************
	// Method: getAllRouteSummaries
	// URL Request Mapping: /app/service/route/summary
	// Description:
	/**
	 * Obtain a list of all route summary objects.
	 */
	//****************************************************************************
	@RequestMapping ( value = "/summary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public @ResponseBody DataTableData<RouteSummary> getAllRouteSummaries ( @RequestBody String body, ModelMap model )
	{
		List<RouteSummary> routeSummaryList = null;
		try
		{
			routeSummaryList = this.routeSummaryRepo.findAll();
		}
		catch ( Exception dsEx )
		{
			LOGGER.error ( "An error occurred while attempting to obtain the route summary list. " + dsEx.getMessage() );
			routeSummaryList = new ArrayList<RouteSummary> ();
		}
		
		return new DataTableData<RouteSummary> ( routeSummaryList );
	} // End getAllRouteSummaries
	
} // End RouteConfigController Class

