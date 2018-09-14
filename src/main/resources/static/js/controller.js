vm.
    controller('listStudentController', function ($scope, $http, $location, $route) {

    $http({
        method: 'GET',
        url: 'http://localhost:8080/api/students/all'
    }).then(function (response) {
        $scope.users = response.data;
    });

    $scope.editUser = function (userId) {
        $location.path("/update-user/" + userId);
    }

    $scope.deleteUser = function (userId) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/api/students/all/' + userId
        })
            .then(
                function (response) {
                    $location.path("/list-all-students");
                    $route.reload();
                });
    }
});


vm.
    controller('registerUserController', function ($scope, $http, $location,
                                                   $route) {
        $scope.submitUserForm = function () {
        $http({
            method: 'POST',
            url: 'http://192.168.1.108:8080/api/students/',
            data: $scope.user,
        }).then(function (response) {
            $location.path("/list-all-students");
            $route.reload();
        }, function (errResponse) {
            $scope.errorMessage = errResponse.data.errorMessage;
        });
    }

    $scope.resetForm = function () {
        $scope.user = null;
    };
});

vm
    .controller(
        'usersDetailsController',
        function ($scope, $http, $location, $routeParams, $route) {

            $scope.userId = $routeParams.id;

            $http({
                method: 'GET',
                url: 'http://192.168.1.108:8080/api/students/' + $scope.userId
            }).then(function (response) {
                $scope.user = response.data;
            });

            $scope.submitUserForm = function () {
                $http({
                    method: 'POST',
                    url: 'http://192.168.1.108:8080/api/students/',
                    data: $scope.user,
                })
                    .then(
                        function (response) {
                            $location.path("/list-all-students");
                            $route.reload();
                        },
                        function (errResponse) {
                            $scope.errorMessage = "Error while updating User - Error Message: '"
                                + errResponse.data.errorMessage;
                        });
            }
        });


