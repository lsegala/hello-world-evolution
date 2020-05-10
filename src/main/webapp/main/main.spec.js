'use strict';

describe('hello.main module', function() {

  var scope;
  var rootScope;
  var controller;
  var httpBackend;

  beforeEach(module('hello.main'));

  beforeEach(inject(function($injector){
    rootScope = $injector.get('$rootScope');
    scope = rootScope.$new();
    httpBackend = $injector.get('$httpBackend');
    controller = $injector.get('$controller');
    controller('MainCtrl', {$scope: scope})
  }));

  it("Should call and return Hello, Sou Java!", function(){
    httpBackend.expectGET('/rest/hello').respond(200,{message: 'Hello!'});
    scope.init()
    httpBackend.flush();
    expect(scope.message).toEqual("Hello!");
  });
});