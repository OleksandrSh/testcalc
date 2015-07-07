

if (typeof $ === 'undefined') { throw new Error('This application\'s JavaScript requires jQuery'); }


var App = angular.module('Testfront', [])
          .run(['$rootScope',  '$templateCache','$location','$document',
                function ($rootScope, $templateCache,$location,$document) {
              $rootScope.app = {
                name: 'Testfront',
                description: ' Testfront',
                              
              };
              
            }
          ]);




