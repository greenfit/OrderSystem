angular.module('app.routes', [])

.config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider

    .state('items', {
        url: '/items',
        templateUrl: 'templates/items.html',
        controller: 'itemsCtrl'
    })

    .state('cart', {
        url: '/cart',
        templateUrl: 'templates/cart.html',
        controller: 'cartCtrl'

    })

    .state('order', {
        url: '/order',
        templateUrl: 'templates/order.html',
        controller: 'orderCtrl'
    })

    .state('login', {
        url: '/login',
        templateUrl: 'templates/login.html',
        controller: 'loginCtrl'
    })

    $urlRouterProvider.otherwise('/login')
});