define(['jquery', 'jqueryui', 'underscore', 'backbone', 'datatablesExt', 'routeModel'], function($, jui, _, Backbone, dtExt, routeModel)
{
  var AppRouter = Backbone.Router.extend({
    routes: {
      '':              'index',
      'routeEdit/:id': 'routeEdit',
      'tabRoutes':     'index',
      'tabConfig':     'tabConfig',
      'tabPlugins':    'tabPlugins'
    },
    
    index: function () {
    	// Make sure that the route tab is actually selected. It's at index 0 in the tab
    	// list.
    	if ( $("ul li.ui-state-active").index() != 0 )
    	{
    		// The tab isn't active, which means that someone is navigating to the tab using
    		// the URL, which JQuery Tabs doesn't really appreciate. Manually activate 
    		// the routes tab.
    		tabsViewInstance.$el.tabs("option", "active", 0);
    	}
    	
    	// Scroll to the top of the page. It's possible for the window to not
    	// be scrolled to the top when a tab is selected, and the window
    	// scrolls down to the anchor for the tab.
    	window.scrollTo(0,0);
    	
    	// This index route will be invoked after the tabs are initialized the first time, so 
    	// it doesn't always signify that a tab has been clicked. Refresh the routes data table
    	// only if the tab has been clicked.
    	if ( typeof firstCallToIndexOccurred == "undefined" )
    	{
    		// This is the first call to index and all we do is set the first call variable.
    		firstCallToIndexOccurred = true;
    	}
    	else
    	{
    		// Refresh the routes datatable.
    		console.log ( "Refreshing the routes table." );
    		tblRoutes.fnReloadAjax();
    	}
    },
    
    routeEdit: function(id) {
    	// Display the route edit dialog.
    	var route
    	
    	alert ( "Edit the route with ID " + id );
    },
    
    tabConfig: function () {
    	// Make sure that the configuration tab is actually selected. It's at index 1 in the tab
    	// list.
    	if ( $("ul li.ui-state-active").index() != 1 )
    	{
    		// The tab isn't active, which means that someone is navigating to the tab using
    		// the URL, which JQuery Tabs doesn't really appreciate. Manually activate 
    		// the configuration tab.
    		tabsViewInstance.$el.tabs("option", "active", 1);
    	}
    	
    	// Scroll to the top of the page. It's possible for the window to not
    	// be scrolled to the top when a tab is selected, and the window
    	// scrolls down to the anchor for the tab.
    	window.scrollTo(0,0);
    },
    
    tabPlugins: function () {
    	// Make sure that the plug-ins tab is actually selected. It's at index 2 in the tab
    	// list.
    	if ( $("ul li.ui-state-active").index() != 2 )
    	{
    		// The tab isn't active, which means that someone is navigating to the tab using
    		// the URL, which JQuery Tabs doesn't really appreciate. Manually activate 
    		// the plug-ins tab.
    		tabsViewInstance.$el.tabs("option", "active", 2);
    	}
    	
    	// Scroll to the top of the page. It's possible for the window to not
    	// be scrolled to the top when a tab is selected, and the window
    	// scrolls down to the anchor for the tab.
    	window.scrollTo(0,0);
    },
  });

  var initialize = function () {
	  // Create an instance of our router.
      appRouter = new AppRouter;

      // Start backbone history tracking so that routing actually works.
      Backbone.history.start();
  };
  
  return { initialize: initialize };
});