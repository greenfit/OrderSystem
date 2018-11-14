angular.module('app.controllers', ["ionic"])

.controller('itemsCtrl', ['$scope', '$stateParams', '$state', function ($scope, $state) {
    $scope.items = [{
        "name" : "可口可乐",
        "count" : 0
    },{
        "name" : "零度",
        "count" : 0
    },{
        "name" : "雪碧",
        "count" : 0
    },{
        "name" : "芬达",
        "count" : 0
    },{
        "name" : "醒目",
        "count" : 0
    },{
        "name" : "酷儿",
        "count" : 0
    },{
        "name" : "冰露",
        "count" : 0
    }];

    $scope.changeCount = function (item, change){
        if(change < 0) {
            if(item.count >= 1) {
                item.count = item.count - 1;
            }
        } else {
            if(item.count < 99) {
                item.count = item.count + 1;
            }
        }
    };

    // console.log( $cookies);


}])

.controller('cartCtrl', ['$scope', '$stateParams', function ($scope, $stateParams) {

}])

.controller('orderCtrl', ['$scope', '$stateParams', function ($scope, $stateParams) {

}])

.controller('side-menuCtrl', ['$scope', '$stateParams', function ($scope, $stateParams) {

}])

.controller('loginCtrl', ['$scope', '$ionicPopup', '$http', function ($scope, $ionicPopup, $http) {
    $scope.userInfo = {};
    $scope.login = function() {
        if($scope.userInfo.userName === undefined || $scope.userInfo.userName.size < 1) {
            $ionicPopup.alert({ title: '参数错误', template: '请输入用户名' });
        } else {
            $http.post('/login.json', $scope.userInfo.userName).then(function(response){
                var result = response.data;
                if(result.code === 200) {
                    document.cookie['userId'] = result.data;
                    console.log(result);
                } else {
                    $ionicPopup.alert({ title: '登录失败', template: result.message });
                }
            });
        }
    }
}]);
 