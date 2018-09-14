var vm = angular.module("demo", [ 'ngRoute', 'ngResource' ]);

vm.config(function ($routeProvider) {
    $routeProvider.when('/list-all-students', {
        templateUrl: '/template/liststudents.html',
        controller: 'listStudentController'
    }).when('/register-new-user', {
        templateUrl: '/template/userregistration.html',
        controller: 'registerUserController'
    }).when('/update-user/:id', {
        templateUrl: '/template/userupdate.html',
        controller: 'usersDetailsController'
    }).otherwise({
        redirectTo: '/home',
        templateUrl: '/template/home.html',
    });
});
