angular.module('app.routes', [])

.config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider

    .state('items', {
        url: '/items',
        templateUrl: 'templates/items.html',
        controller: 'itemsCtrl',
        cache: false
    })

    .state('cart', {
        url: '/cart',
        templateUrl: 'templates/cart.html',
        controller: 'cartCtrl',
        cache: false
    })

    .state('order', {
        url: '/order',
        templateUrl: 'templates/order.html',
        controller: 'orderCtrl',
        cache: false
    })

    .state('login', {
        url: '/login',
        templateUrl: 'templates/login.html',
        controller: 'loginCtrl'
    })

    $urlRouterProvider.otherwise('/login')
});