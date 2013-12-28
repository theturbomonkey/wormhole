// The require.js configuration file for the wormhole application.
require.config(
{
	deps: ['main'],
	
	baseUrl: 'app/js',
	
	paths: {
		// Third Party Libraries
		backbone:   '../../resources/js/lib/backbone',
		datatables: '../../resources/js/lib/jquery.dataTables.min',
		handlebars: '../../resources/js/lib/handlebars',
		jquery:     '../../resources/js/lib/jquery',
		jqueryui:   '../../resources/js/lib/jquery-ui',
		text:       '../../resources/js/lib/text',
		underscore: '../../resources/js/lib/underscore',
		
		// Custom Modules
		datatablesExt: 'datatables-extensions',
		
		// Backbone Routers
		router:        'router',
		
		// Backbone Views
		tabRoutesView: 'view/tab-routes-view',
		tabsView:      'view/tabs-view',
			
		// Backbone Models
		routeModel:    'model/route-model'
	}, 
	
	shim: {
		jqueryui: {
			deps: ['jquery']
		},
		underscore: {
	      exports: "_"
	    },
	    backbone: {
	      deps: ['underscore', 'jquery'],
	      exports: 'Backbone'
	    },
	    handlebars: {
	      exports: 'Handlebars'
	    }
	}
});