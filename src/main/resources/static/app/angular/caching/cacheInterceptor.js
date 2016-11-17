'use strict';

angular.module('Congregation.Angular.Caching', ['Congregation.Config', 'Congregation.Common'])
    .factory('SmartCacheInterceptor', ['$q', 'CongregationVersion', function ($q, SampleApplicationVersion) {
        return {
            request: function (config) {
                if (config.url.indexOf(".htm") > -1) {
                    var separator = config.url.indexOf("?") === -1 ? "?" : "&";
                    config.url = config.url + separator + "v=" + SampleApplicationVersion;
                }
                return config || $q.when(config);
            }
        };
    }]);
;