import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Content } from './content';

@Injectable({
  providedIn: 'root'
})
export class HelloService {

  constructor(private http: HttpClient) { }

  sayHello(name: string): Observable<Content> {
    return this.http.get<Content>(environment.url + (name? "/"+name : ""));
  }
}
