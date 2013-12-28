define ( ['jquery', 'jqueryui', 'underscore', 'backbone'], function ($, jui, _, Backbone) 
{
	var RouteModel = Backbone.Model.extend({
		
		urlRoot: "/route",
		
		/*defaults: {
			
		},*/
		
		initialize: function (){
			
		}
	});
	
	return RouteModel;
		
});