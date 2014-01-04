'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Actor', ['$resource', function ($resource) {
    return $resource('rest/actors/:actorId', {actorId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);


services.factory('Movie', ['$resource', function ($resource) {
    return $resource('rest/movies/:movieId', {movieId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);

services.factory('Regisseur', ['$resource', function ($resource) {
    return $resource('rest/regisseurs/:regisseurId', {id:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);

services.factory('Genre', ['$resource', function ($resource) {
    return $resource('rest/genres/:genresId', {id:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);