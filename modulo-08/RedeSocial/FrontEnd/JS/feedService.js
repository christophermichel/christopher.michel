angular.module('app').factory('feedService', function ($http) {
    var urlBase = 'http://localhost:9090/post';

    function getPosts() {
    return $http.get(urlBase);
    };

    return {
        getPosts: getPosts
    };

});
