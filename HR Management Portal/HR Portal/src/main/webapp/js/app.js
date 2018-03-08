var module = angular.module("myApp",["ui.calendar"]);
module.controller("Controller",initController);
module.controller("ResultController",resultController);
module.controller("TrainingController",trainingController);
module.controller("CalendarController",calendarCtrl);
//module.factory("AppFactory",)

function initController($scope,$http,$window,sharedProperties){
	console.log("inside initController");
	$scope.authenticate = function() {
		//console.log($scope.employee);
		$http({
			method : 'POST',
			url : 'Home',
			contentType: 'application/json',
			data : JSON.stringify($scope.employee),
		}).then(function(data) {
			console.log("here then ");
			//console.log(JSON.stringify(data));

			$scope.person = JSON.parse(JSON.stringify(data.data));
			//console.log("vale::"+JSON.stringify($scope.person.userName));
			sharedProperties.setData(data.data);
			console.log("data here::"+$scope.person);
			sessionStorage.redirection=true;
			$window.location.href = 'Home.jsp';
		}).catch(function (data) {
			console.log("inside catch::"+JSON.stringify(data))
			$scope.error=true;
		});

	};

};


module.service("sharedProperties",function() {
	console.log("inside 1");
	return {
		getData: function() {
			console.log("inside 2");
			return angular.fromJson(sessionStorage.sharedProperties);
		},
		setData: function(value) {
			console.log("inside 3");
			sessionStorage.sharedProperties = angular.toJson(value);
		},
	}
});


module.service("trainingDetails",function(){
	console.log("inside training service");
	return{
		getTrainingDetails: function() {
			console.log("inside getTrainingDetails");
			return angular.fromJson(sessionStorage.trainingDetails);
		},
		setTrainingDetails: function(value) {
			console.log("inside setTrainingDetails");
			sessionStorage.trainingDetails = angular.toJson(value);
		},
	}
});


function resultController($scope,sharedProperties,$window,$http,trainingDetails){
	console.log("inside result controller"+sessionStorage.redirection);	
	$scope.showData=sessionStorage.redirection;
	console.log("redirection:"+JSON.stringify(sessionStorage.redirection));
	if(!sessionStorage.redirection){
		console.log("re direction false");
		$window.location.href = 'index.html';
	}else{
		console.log("here in else initialize");
		$scope.result=JSON.parse(JSON.stringify(sharedProperties.getData()));
		console.log("2^^result::"+$scope.result.userName);
	}	

	$scope.showTrainings = function(){
		console.log("inside show trainigs");
		$http({
			method : 'GET',
			url : 'TrainingCalendar',
			contentType: 'application/json',
			data : ''
		}).then(function(data) {
			console.log("here then for training::"+JSON.stringify(data));
			trainingDetails.setTrainingDetails(data.data);
			$window.location.href = 'TrainingCalendar.jsp';
			//console.log(JSON.stringify(data));
		}).catch(function (data) {
			console.log("inside catch for show training::"+JSON.stringify(data));
			$scope.error=true;
		});
	}	
}

function trainingController($scope,sharedProperties,$window){
	console.log("inside trainingController"+sessionStorage.redirection);
	$scope.showData=sessionStorage.redirection;
	console.log("redirection training:"+JSON.stringify(sessionStorage.redirection));
	if(!sessionStorage.redirection){
		console.log("re training false");
		$window.location.href = 'index.html';
	}else{
		console.log("here in else training");
		$scope.result=JSON.parse(JSON.stringify(sharedProperties.getData()));
		console.log("2^^result training::"+$scope.result.userName);
	}
}


/*function calendarCtrl($scope) {
     config object 
	console.log("inside calendarCtrl");
    $scope.uiConfig = {
      calendar:{
        height: 450,
        editable: true,
        header:{
          left: 'month basicWeek basicDay agendaWeek agendaDay',
          center: 'title',
          right: 'today prev,next'
        },
        eventClick: $scope.alertEventOnClick,
        eventDrop: $scope.alertOnDrop,
        eventResize: $scope.alertOnResize
      }
    };
}*/




function calendarCtrl($scope,$compile,uiCalendarConfig,trainingDetails) {var date = new Date();
console.log("calenadr ctrk");
var d = date.getDate();
var m = date.getMonth();
var y = date.getFullYear();

$scope.trainingEvents=JSON.parse(JSON.stringify(trainingDetails.getTrainingDetails()));
console.log("here calendar::"+JSON.stringify($scope.trainingEvents));

$scope.changeTo = 'India';
/* event source that pulls from google.com */
$scope.eventSource = {
		url: "http://www.google.com/calendar/feeds/usa__en%40holiday.calendar.google.com/public/basic",
		className: 'gcal-event',           // an option!
		currentTimezone: 'America/Chicago' // an option!
};
/* event source that contains custom events on the scope */
$scope.events = [
                 {title: 'All Day Event 11',start: new Date(y, m, 1)},
                 {title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2)},
                 {id: 999,title: 'Repeating Event1',start: new Date(y, m, d - 3, 16, 0),allDay: false},
                 {id: 999,title: 'Repeating Event2',start: new Date(y, m, d + 4, 16, 0),allDay: false},
                 {title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false},
                 {title: 'Click for Google 22',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}
                 ];


/*console.log("before loop");
for(var i=0;i<JSON.stringify($scope.trainingEvents).length;i++){
	console.log("inside loop json");
	$scope.newEvents[i].title=$scope.trainingEvents[i];
	$scope.newEvents[i].start=$scope.trainingEvents[i];
	console.log("title::"+$scope.newEvents[i].title);
	console.log("date::"+$scope.newEvents[i].start);
}*/

/* event source that calls a function on every view switch */
$scope.eventsF = function (start, end, timezone, callback) {
	var s = new Date(start).getTime() / 1000;
	var e = new Date(end).getTime() / 1000;
	var m = new Date(start).getMonth();
	var events = [{title: 'Feed Me ' + m,start: s + (50000),end: s + (100000),allDay: false, className: ['customFeed']}];
	callback(events);
};

$scope.calEventsExt = {
		color: '#f00',
		textColor: 'yellow',
		events: [ 
		         {type:'party',title: 'Lunch',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
		         {type:'party',title: 'Lunch 2',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
		         {type:'party',title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}
		         ]
};
/* alert on eventClick */
$scope.alertOnEventClick = function( date, jsEvent, view){
	$scope.alertMessage = (date.title + ' was clicked ');
};
/* alert on Drop */
$scope.alertOnDrop = function(event, delta, revertFunc, jsEvent, ui, view){
	$scope.alertMessage = ('Event Droped to make dayDelta ' + delta);
};
/* alert on Resize */
$scope.alertOnResize = function(event, delta, revertFunc, jsEvent, ui, view ){
	$scope.alertMessage = ('Event Resized to make dayDelta ' + delta);
};
/* add and removes an event source of choice */
$scope.addRemoveEventSource = function(sources,source) {
	var canAdd = 0;
	angular.forEach(sources,function(value, key){
		if(sources[key] === source){
			sources.splice(key,1);
			canAdd = 1;
		}
	});
	if(canAdd === 0){
		sources.push(source);
	}
};
/* add custom event*/
$scope.addEvent = function() {
	$scope.events.push({
		title: 'Open Sesame',
		start: new Date(y, m, 28),
		end: new Date(y, m, 29),
		className: ['openSesame']
	});
};
/* remove event */
$scope.remove = function(index) {
	$scope.events.splice(index,1);
};
/* Change View */
$scope.changeView = function(view,calendar) {
	uiCalendarConfig.calendars[calendar].fullCalendar('changeView',view);
};
/* Change View */
$scope.renderCalender = function(calendar) {
	if(uiCalendarConfig.calendars[calendar]){
		uiCalendarConfig.calendars[calendar].fullCalendar('render');
	}
};
/* Render Tooltip */
$scope.eventRender = function( event, element, view ) { 
	element.attr({'tooltip': event.title,
		'tooltip-append-to-body': true});
	$compile(element)($scope);
};
/* config object */
$scope.uiConfig = {
		calendar:{
			height: 450,
			editable: true,
			header:{
				left: 'month basicDay agendaDay',
				center: 'title',
				right: 'today prev,next'
			},
			eventClick: $scope.alertEventOnClick,
			eventDrop: $scope.alertOnDrop,
			eventResize: $scope.alertOnResize
		}
};

$scope.changeLang = function() {
	if($scope.changeTo === 'Hungarian'){
		$scope.uiConfig.calendar.dayNames = ["Vasárnap", "Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat"];
		$scope.uiConfig.calendar.dayNamesShort = ["Vas", "Hét", "Kedd", "Sze", "Csüt", "Pén", "Szo"];
		$scope.changeTo= 'English';
	} else {
		$scope.uiConfig.calendar.dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
		$scope.uiConfig.calendar.dayNamesShort = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
		$scope.changeTo = 'Hungarian';
	}
};
/* event sources array*/
$scope.eventSources = [$scope.events, $scope.eventSource, $scope.eventsF];
$scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];
}


