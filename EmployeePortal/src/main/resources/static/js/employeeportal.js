var app = angular.module("employee-portal", []);

app.controller("EmployeeController", function($scope, $http) {

alert(1230);
  $scope.emp = {};
    $http.get("http://localhost:8585/v1/employees")
     .then(function(response) {
       $scope.empList = response.data;
     });
});