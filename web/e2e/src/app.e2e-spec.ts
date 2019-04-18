import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display Hello', () => {
    page.navigateTo(null);
    expect(page.getTitleText()).toEqual('Hello!');
  });

  it('should display Hello, Leonardo', () => {
    page.navigateTo('name=Leonardo');
    expect(page.getTitleText()).toEqual('Hello, Leonardo!');
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
