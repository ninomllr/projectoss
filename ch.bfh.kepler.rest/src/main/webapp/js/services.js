'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Actor', ['$resource', function ($resource) {
    return $resource('rest/actors/:actorId', {actorId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);