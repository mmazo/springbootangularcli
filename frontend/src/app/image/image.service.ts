import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {Image} from "./image";

@Injectable()
export class ImageService {

  public serviceUrl: string = 'api/v1/image';

  constructor(private http: Http) { }

  public deleteOne(id: number): Observable<Image> {
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
