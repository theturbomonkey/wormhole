define ( ['jquery', 'jqueryui', 'underscore', 'backbone', 'handlebars', 'text!../../app/pages/template/tab-routes-template.html', 'text!../../app/pages/template/tab-routes-table-actions.html'], function ($, jui, _, Backbone, Handlebars, tabRoutesTemplate, rowActionsTemplate) 
{
	var TabRoutesView = Backbone.View.extend({
	    template: Handlebars.compile ( tabRoutesTemplate ),
	    
	    initialize: function () {
	    	console.log ('Initializing Routes Table View...');
	    },
	    
	    events: {
	    	'click #btnRoutesTableRefresh': 'onRefreshButtonClicked'
	    },
	    
	    render: function(){
	      console.log ('Rendering Routes Table View...');
	      
	      // Compile the template for the table row actions.
	      var rowActions = Handlebars.compile ( rowActionsTemplate );
	      
	      // Set the template mark-up as the content of our EL div.
	      this.$el.html ( this.template( this ) );
	      
	      // Initialize the table. We save the object returned by the init function so that we can
	      // refresh the table later as necessary. 
	      tblRoutes = this.$el.find('#tblRoutes').dataTable( 
	    			{
	    		        "bProcessing": true,
	    		        "sAjaxSource":"app/service/route/summary",
	    		        "aoColumns": [
	    					{ sTitle: "ID", mDataProp: "routeID", bSearchable: false, bVisible: false},
	    		            { sTitle: "Route Name", mDataProp: "routeName" },
	    		            { sTitle: "Priority", mDataProp: "routePriority", sClass: "center" },
	    		            { sTitle: "Faults", mDataProp: "faultCount", sClass: "center" },
	    		            { sTitle: "Status", mDataProp: "routeEnabled", sClass: "center" },
	    		            { sTitle: "Traversals", mDataProp: "traversalCount", sClass: "center" },
	    		            { sTitle: "Actions", mData: null, sClass: "center" }
	    		        ],
	    		        "fnRowCallback": function( nRow, aData, iDisplayIndex ) 
	    		        {
	    		            /* The status column value is  */
	    		        	var status = "<span class=\"txtStatusInactive\">Inactive</span>";
	    		            if ( aData["routeEnabled"] == true )
	    		            {
	    		            	status = "<span class=\"txtStatusActive\">Active</span>";
	    		            }
	    		            $('td:eq(3)', nRow).html( status );
	    		            
	    		            // Apply the actions template to the current row with the route ID.
	    		            $('td:eq(5)', nRow).html( rowActions ( { routeID: aData["routeID"] } ) );
	    		            
	    		            return nRow;
	    		        },
	    		    } );
	    			
	      this.$el.find("#tabs").tabs({
	    				   beforeActivate: function(event, ui) {
	    				        var hash = ui.newTab.children("li a").attr("href");
	    				        window.location.hash = hash;
	    				   }
	    				});
	    },
	    
	    onRefreshButtonClicked: function (){
	    	console.log ( "Refresh button clicked." );
	    	// Have the data table refreshed.
	    	tblRoutes.fnReloadAjax();
	    }
	  });
	
	  // Return the constructed view object.
	  return TabRoutesView;
});