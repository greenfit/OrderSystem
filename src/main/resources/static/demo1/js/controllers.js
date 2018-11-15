
function setCookie(name, value) {
    var exp = new Date();
    exp.setTime(exp.getTime() + 24 * 60 * 60 * 1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString() + ";path=/";
}

function getCookie(name) {
    var arr,reg = new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

angular.module('app.controllers', ["ionic"])

.controller('itemsCtrl', ['$scope', '$state', function ($scope, $state) {
    if(getCookie("userId") === null || getCookie("userId") == 0) {
        $state.go("login");
    }

    var items = getCookie("cart");
    if(items === null) {
        $scope.items = [{
            "name" : "可口可乐",
            "count" : 0,
            "index" : 1
        },{
            "name" : "零度",
            "count" : 0,
            "index" : 2
        },{
            "name" : "雪碧",
            "count" : 0,
            "index" : 3
        },{
            "name" : "芬达",
            "count" : 0,
            "index" : 4
        },{
            "name" : "醒目",
            "count" : 0,
            "index" : 5
        },{
            "name" : "酷儿",
            "count" : 0,
            "index" : 6
        },{
            "name" : "冰露",
            "count" : 0,
            "index" : 7
        }];
        $scope.text = "添加到购物车";
    } else {
        $scope.items = JSON.parse(items);
        $scope.text = "同步到购物车";
    }


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

    $scope.addCart = function() {
        setCookie("cart", JSON.stringify($scope.items));
        $state.go("cart");
    }
    // console.log( $cookies);
}])

.controller('cartCtrl', ['$scope', '$stateParams', function ($scope, $stateParams) {
    var items = getCookie("cart");
    if(items === null) {
        $scope.items = {};
        $scope.text = "您的购物车空空如也 ~ ";
    } else {
        $scope.items = JSON.parse(items);
        $scope.text = "";
    }
}])

.controller('orderCtrl', ['$scope', '$stateParams', function ($scope, $stateParams) {

}])

.controller('side-menuCtrl', ['$scope', '$state', function ($scope, $state) {
    var userId = getCookie("userId");
    if(userId === undefined) {
        userId = 0;
    }
    $scope.userImage = userId % 21;

    $scope.logout = function() {
        setCookie("userId", 0);
        $state.go("login", null, {location:'replace'});
    }
}])

.controller('loginCtrl', ['$scope', '$ionicPopup', '$http', '$state', function ($scope, $ionicPopup, $http, $state) {
    if(getCookie("userId") !== null && getCookie("userId") != 0) {
        $state.go("items", null, {location:'replace'});
    }
    $scope.userInfo = {};
    $scope.login = function() {
        if($scope.userInfo.userName === undefined || $scope.userInfo.userName.size < 1) {
            $ionicPopup.alert({ title: '参数错误', template: '请输入用户名' });
        } else {
            $http.post('/login.json', $scope.userInfo.userName).then(function(response){
                var result = response.data;
                if(result.code === 200) {
                    document.cookie['userId'] = result.data;
                    $state.go("items", null, {location:'replace'});
                } else {
                    $ionicPopup.alert({ title: '登录失败', template: result.message });
                }
            });
        }
    }
}]);
 