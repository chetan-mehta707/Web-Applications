<html ng-app="myApp">
<head>
<title>Envestnet Yodlee</title>
<!-- <script type="text/javascript" src="js/angular.js"></script> -->

<link rel="stylesheet" href="bower_components/fullcalendar/dist/fullcalendar.css"/>
<!-- jquery, moment, and angular have to get included before fullcalendar -->
<script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript" src="bower_components/angular/angular.min.js"></script>

<script type="text/javascript" src="bower_components/fullcalendar/dist/fullcalendar.min.js"></script>
<script type="text/javascript" src="bower_components/fullcalendar/dist/gcal.js"></script>


<script type="text/javascript" src="bower_components/angular-ui-calendar/src/calendar.js"></script>


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
	<div ng-controller="ResultController" ng-show="showData"
		class="ng-hide">
		<div class="container" >
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
						<a class="navbar-brand" href="#">HR Management</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="Home.jsp">Home</a></li>
							<li><a href="#" ng-click="showTrainings()">Training Calendar</a></li>
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


			<div class="container bootstrap snippet jumbotron">
				<div class="row">
					<div class="col-sm-10">
						<h2>{{result.userName}}</h2>
					</div>

				</div>
				<div class="row">
					<div class="col-sm-4">
						<!--left col-->

						<ul class="list-group">
							<li class="list-group-item text-muted"><h3>Profile
									Information</h3></li>
							<li class="list-group-item text-right"><span
								class="pull-left"><strong>Designation</strong></span>
								{{result.designation}}</li>
							<li class="list-group-item text-right"><span
								class="pull-left"><strong>Department</strong></span>
								{{result.department}}</li>
							<li class="list-group-item text-right"
								ng-show="{{result.employeeID}}" class="ng-hide"><span
								class="pull-left"><strong>Employee ID</strong></span>
								{{result.employeeID}}</li>
							<li class="list-group-item text-right"><span
								class="pull-left"><strong>Email ID</strong></span>
								{{result.mailId}}</li>
							<li class="list-group-item text-right"><span
								class="pull-left"><strong>Reporting Manager</strong></span>
								{{result.manager}}</li>
							<li class="list-group-item text-right" ng-show="{{result.phone}}"
								class="ng-hide"><span class="pull-left"><strong>Phone</strong></span>
								{{result.phone}}</li>
							<li class="list-group-item text-right"><span
								class="pull-left"><strong>UserName</strong></span>
								{{result.nickName}}</li>
						</ul>

					</div>
				</div>
			</div>

			<!-- <div class="jumbotron">
				<div>
					<h2>
						Welcome, <span>{{result.userName}}</span>
						</h1>
						<p>
							Department::<span>{{result.department}}</span>
						</p>
						<p>
							Employee ID::<span>{{result.employeeID}}</span>
						</p>
						<p>
							Designation::<span>{{result.designation}}</span>
						</p>
						<p>
							Nick Name::<span>{{result.nickName}}</span>
						</p>
						<p>
							Manager::<span>{{result.manager}}</span>
						</p>
				</div>
			</div> -->
		</div>
	</div>

</body>
</html>