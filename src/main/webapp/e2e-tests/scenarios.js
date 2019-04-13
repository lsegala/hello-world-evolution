'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('hello', function() {
  var httpBackend;

  it('should automatically redirect to /main when location hash/fragment is empty', function() {
    browser.get('index.html');
    expect(browser.getLocationAbsUrl()).toMatch("/main");
  });


  describe('main', function() {

    beforeEach(inject(function($injector) {
      httpBackend = $injector.get('$httpBackend');
    }));

    it('should render view1 when user navigates to /main', function() {
      //httpBackend.expectGET('rest/hello/').respond(200,{message: "Hello World!"});
      browser.get('index.html#!/main');
      //httpBackend.flush();
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/Hello Word!/);
    });

  });
});
