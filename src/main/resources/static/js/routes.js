angular.module('app.routes', [])

.config(function ($stateProvider, $urlRouterProvider) {

    // Ionic uses AngularUI Router which uses the concept of states
    // Learn more here: https://github.com/angular-ui/ui-router
    // Set up the various states which the app can be in.
    // Each state's controller can be found in controllers.js
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

    $urlRouterProvider.otherwise('/items')
});