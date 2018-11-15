angular.module('app', ['ionic', 'app.controllers', 'app.routes'])

.config(function($ionicConfigProvider, $sceDelegateProvider){})

.run(['$rootScope', '$state', '$stateParams', function($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }
]);