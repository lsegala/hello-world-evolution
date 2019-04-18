import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo(param: string) {
    return browser.get(browser.baseUrl+(param? '?'+param : '')) as Promise<any>;
  }

  getTitleText() {
    return element(by.css('app-root h1')).getText() as Promise<string>;
  }
}
