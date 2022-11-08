import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class TestService extends BaseService {

  constructor(private http: HttpClient) { 
    super()
  }

  

  test() {
    console.log(BaseService.appUrl + `api/donor/test`)
    return this.http.get( BaseService.appUrl + `api/donor/test`, { responseType: 'text'}).pipe(map((data: any) => {
      return data;
    }));
  }
}
