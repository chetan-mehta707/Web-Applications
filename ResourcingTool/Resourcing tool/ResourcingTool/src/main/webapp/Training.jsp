
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="UTF-8">
<title>Envestnet | Yodlee</title>
<link rel="stylesheet" href="css/calendarview.css">
<style>
body {
	font-family: Trebuchet MS;
}

div.calendar {
	max-width: 240px;
	margin-left: auto;
	margin-right: auto;
}

div.calendar table {
	width: 100%;
}

div.dateField {
	width: 140px;
	padding: 6px;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	color: #555;
	background-color: white;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

div#popupDateField:hover {
	background-color: #cde;
	cursor: pointer;
}
</style>

<script type="text/javascript" src="js/angular.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<script src="js/prototype.js"></script>
<script src="js/calendarview.js"></script>
<script>
     /*  function setupCalendars() {
    	  console.log("here in setup calendars");
        // Embedded Calendar
        Calendar.setup(
          {
            dateField: 'embeddedDateField',
            parentElement: 'embeddedCalendar'
          }
        )

        // Popup Calendar
          Calendar.setup(
          {
            dateField: 'popupDateField',
            triggerElement: 'popupDateField'
          }
        )  
      }

      Event.observe(window, 'load', function() { setupCalendars() }) */
    </script>
</head>
<body>

	<div ng-controller="TrainingController" >
	<nav class="navbar navbar-inverse navbar-fixed-top"
				style="color: black">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">HR Management </a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="Home.jsp">Home</a></li>
							<li><a href="Training.jsp">Training Details</a></li>
							<li><a href="#">Appraisal Details</a></li>
						</ul>
						<ul
							class="navbar-text nav navbar-nav navbar-right bs-glyphicons-list">
							<!-- <li class="glyphicon glyphicon-user glyphicon-class"></li>
						<li class="glyphicon-class">{{result.userName}} </li>
						 -->
							<li><span class="glyphicon glyphicon-user"
								aria-hidden="true"></span> <span class="glyphicon-class">{{result.userName}}</span>
							</li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
				<!--/.container-fluid -->
			</nav>
	
		<div style="float: left; width: 50%">
			<div
				style="height: 400px; background-color: #efefef; padding: 10px; -webkit-border-radius: 12px; -moz-border-radius: 12px; margin-right: 10px">
				<h3
					style="text-align: center; background-color: white; -webkit-border-radius: 10px; -moz-border-radius: 10px; margin-top: 0px; margin-bottom: 20px; padding: 8px">
					Training Calendar</h3>
				<div id="embeddedExample" style="">
					<div id="embeddedCalendar"
						style="margin-left: auto; margin-right: auto"></div>
					<br />
					<div id="embeddedDateField" class="dateField">Select Date</div>
					<br />
				</div>
			</div>
		</div>
	</div>
</body>
</html>