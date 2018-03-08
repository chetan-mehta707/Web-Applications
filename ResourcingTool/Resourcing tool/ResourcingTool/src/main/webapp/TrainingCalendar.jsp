<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Envestnet | Yodlee</title>

<!-- <script type="text/javascript" src="js/angular.js"></script> -->

<link rel="stylesheet"
	href="bower_components/fullcalendar/dist/fullcalendar.css" />
<!-- jquery, moment, and angular have to get included before fullcalendar -->
<script type="text/javascript"
	src="bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"
	src="bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript"
	src="bower_components/angular/angular.min.js"></script>
<script type="text/javascript"
	src="bower_components/fullcalendar/dist/fullcalendar.min.js"></script>


<script type="text/javascript"
	src="bower_components/fullcalendar/dist/gcal.js"></script>


<script type="text/javascript"
	src="bower_components/angular-ui-calendar/src/calendar.js"></script>


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


</head>
<body>
	<div ng-controller="TrainingController">
		<nav class="navbar navbar-inverse"
			style="color: black">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">HR Management </a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="Home.jsp">Home</a></li>
					<li class="active"><a href="TrainingCalendar.jsp">Training Calendar</a></li>
					<li><a href="#">Appraisal Details</a></li>
				</ul>
				<ul
					class="navbar-text nav navbar-nav navbar-right bs-glyphicons-list">
					<!-- <li class="glyphicon glyphicon-user glyphicon-class"></li>
						<li class="glyphicon-class">{{result.userName}} </li>
						 -->
					<li><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						<span class="glyphicon-class">{{result.userName}}</span></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>
	</div>


	<div class="container-fluid text-center"
		ng-controller="CalendarController">
		<div class="row content">
			<div class="col-sm-2 sidenav panel">
				<p class="well">
					<a href="#">Training History</a>
				</p>
				<p class="well">
					<a href="#">Link</a>
				</p>
				<p class="well">
					<a href="#">Link</a>
				</p>
			</div>

			<div ui-calendar="uiConfig.calendar" ng-model="eventSources"
				class="col-sm-8 text-left jumbotron"></div>

			<!-- <div class="col-sm-2 sidenav container">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>