import { Component, OnInit } from '@angular/core';
import { HelloService } from './hello.service';
import { Content } from './content';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  constructor(
    private helloService: HelloService,
    private route: ActivatedRoute){}

  title: string;

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.helloService.sayHello(params['name'])
        .subscribe(content => this.title = content.message);
    });
  }
}
