'use strict';

var controllers = angular.module('controllers', ['services']);

controllers.controller('ActorController', ['$scope', 'Actor', function($scope, Actor) {
    $scope.currentActor = new Actor();
    $scope.actors = Actor.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentActor = new Actor();
    };

    $scope.save = function () {
        var isNew = $scope.currentActor.id == null;
        if (isNew) {
            $scope.currentActor = Actor.save($scope.currentActor);
            $scope.authors.push($scope.currentActor);
        } else {
            $scope.currentActor = Actor.update($scope.currentActor);
        }
        $scope.cancel();
    };

    $scope.edit = function (actor) {
    	$scope.currentActor = actor;
    };

    $scope.remove = function (index, id) {
		$scope.actors.splice(index, 1);
		Actor.remove({actorId:id});
    };
}]);


controllers.controller('RegisseurController', ['$scope', 'Regisseur', function($scope, Regisseur) {
    $scope.currentRegisseur = new Regisseur();
    $scope.regisseurs = Regisseur.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentRegisseur = new Regisseur();
    };

    $scope.save = function () {
        var isNew = $scope.currentRegisseur.id == null;
        if (isNew) {
            $scope.currentRegisseur = Regisseur.save($scope.currentRegisseur);
            $scope.regisseurs.push($scope.currentRegisseur);
        } else {
            $scope.currentRegisseur = Regisseur.updateRegisseur($scope.currentRegisseur);
        }
        $scope.cancel();
    };

    $scope.edit = function (regisseur) {
    	$scope.currentRegisseur = regisseur;
    };

    $scope.remove = function (index, id) {
		$scope.regisseurs.splice(index, 1);
		Regisseur.remove({regisseurId:id});
    };
}]);