import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {User} from "./user";

@Injectable()
export class UsersService {

  public serviceUrl: string = 'api/v1/user';

  constructor(private http: Http) { }

  public getList(): Observable<User[]> {
    return this.http.get(this.serviceUrl)
      .map(this.extractData)
      .catch(this.extractError);
  }

  public getOne(id: number): Observable<User> {
    return this.http.get(this.serviceUrl + '/' + id)
      .map(this.extractData)
      .catch(this.extractError);
  }

  public createOne(user: User): Observable<User> {
    return this.http.post(this.serviceUrl,user)
      .map(this.extractData)
      .catch(this.extractError);
  }

  public updateOne(user: User): Observable<User> {
    return this.http.put(this.serviceUrl + '/' + user.id, user)
      .map(this.extractData)
      .catch(this.extractError);
  }

  public deleteOne(id: number): Observable<User> {
    return this.http.delete(this.serviceUrl + '/' + id)
      .map(this.extractData)
      .catch(this.extractError);
  }

  private extractData(res: Response) {
    let resp: any;
    if (res.text() === '') {
      resp = '';
    } else {
      try {
        resp = res.json();
      } catch (error) {
        resp = '';
      }
    }
    return resp;
  }

  private extractError(error: Response) {
    return Observable.throw(this.extractData(error));
  }

}
