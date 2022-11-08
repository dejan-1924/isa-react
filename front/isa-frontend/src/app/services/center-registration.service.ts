import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';
import { map, catchError } from 'rxjs/operators';
import { BaseService } from './base.service';
import { Time } from '@angular/common';
import { Center } from '../model/center.model';

@Injectable({
  providedIn: 'root'
})
export class CenterRegistrationService extends BaseService{

  constructor(private http: HttpClient, private router: Router) { 
    super();
  }

  private baseUrlCenterRegistration: string = 'api/center/registration';

  register(center: Center) {
    return this.http
      .post<any>(BaseService.appUrl + this.baseUrlCenterRegistration, { ...center })
      .pipe(
        map((result) => {
          return result;
        })
      );
  }
}
