var app = angular.module("employee-portal", []);

app.controller("EmployeeController", function($scope, $http) {

     $scope.showAllEmployees = function () {
                $http.get("/v1/employees")
                     .then(function(response) {
                        console.log(response);
                       $scope.employees = response.data;
                     });
            };

});