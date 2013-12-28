/**
 * Function: onLoginFormLoad
 * Description: Called after the login page has loaded to handle follow-up tasks like
 *              setting the form action URL and the appropriate control focus. These 
 *              are tasks that can only be performed after the page has completely loaded.
 */
function onLoginFormLoad()
{
	setFormAction();
	setFieldFocus();
} // End onLoginFormLoad


/**
 * Function: setFocus
 * Description: Set the focus based on whether whether the text fields contain text.
 */
function setFieldFocus()
{
	var userName = $("input[name=j_username]").val();
	var password = $("input[name=j_password]").val();
	
	if ( ( userName == undefined ) || (userName.trim().length <= 0 ) )
	{
		$("input[name=j_username]").focus ();
	}
	else if ( ( password == undefined ) || (password.trim().length <= 0 ) )
	{
		$("input[name=j_password]").focus ();
	}
	else
	{
		$("#btnSubmit").focus ();
	}
} // End setFieldFocus


/**
 * Function: setFormAction
 * Description: Set the focus on the appropriate control based on whether a
 *              username or password have been specified.
 */
function setFormAction()
{
	var pathArray = window.location.href.split( '/' );
	var protocol = pathArray[0];
	var host = pathArray[2];
	var context = pathArray[3];
	
	$("#loginForm").attr("action", protocol + '://' + host + "/" + context + $("#loginForm").attr("action"));
}// End setFormAction


/**
 * Function: validateForm
 * Description: Ensure that the user entered both a username and password before allowing
 *              a form submit to proceed.
 * Returns: A boolean value to indicate whether the submit action should be allowed or aborted.
 */
function validateForm()
{
	var returnVal = false;
	var userName = $("input[name=j_username]").val();
	var password = $("input[name=j_password]").val();
	
	if ( ( userName == undefined ) || (userName.trim().length <= 0 ) )
	{
		alert ("Please enter a username." );
	}
	else if ( ( password == undefined ) || (password.trim().length <= 0 ) )
	{
		alert ("Please enter a password." );
	}
	else
	{
		returnVal = true;
	}
	
	return returnVal;
} // End validateForm