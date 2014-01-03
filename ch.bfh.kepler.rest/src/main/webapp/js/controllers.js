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


controllers.controller('MovieController', ['$scope', 'Movie', function($scope, Movie) {
    $scope.currentMovie = new Movie();
    $scope.movies = Movie.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentMovie = new Movie();
    };

    $scope.save = function () {
        var isNew = $scope.currentMovie.id == null;
        if (isNew) {
            $scope.currentMovie = Movie.save($scope.currentMovie);
            $scope.authors.push($scope.currentMovie);
        } else {
            $scope.currentMovie = Movie.update($scope.currentMovie);
        }
        $scope.cancel();
    };
    
            $scope.edit = function (movie) {
            	$scope.currentMovie = movie;
            };

            $scope.remove = function (index, id) {
        		$scope.movies.splice(index, 1);
        		Movie.remove({movieId:id});
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

controllers.controller('GenreController', ['$scope', 'Genre', function($scope, Genre) {
    $scope.currentGenre = new Genre();
    $scope.genres = Genre.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentGenre = new Genre();
    };

    $scope.save = function () {
        var isNew = $scope.currentGenre.id == null;
        if (isNew) {
            $scope.currentGenre = Genre.save($scope.currentGenre);
            $scope.genres.push($scope.currentGenre);
        } else {
            $scope.currentGenre = Genre.updateGenre($scope.currentGenre);
        }
        $scope.cancel();
    };

    $scope.edit = function (genre) {
    	$scope.currentGenre = genre;
    };

    $scope.remove = function (index, id) {
		$scope.genres.splice(index, 1);
		Genre.remove({genreId:id});
    };
}]);