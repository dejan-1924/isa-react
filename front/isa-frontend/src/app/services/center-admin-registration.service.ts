import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';
import { map, catchError } from 'rxjs/operators';
import { BaseService } from './base.service';
import { CenterAdmin } from '../model/center-admin.model';

@Injectable({
  providedIn: 'root'
})
export class CenterAdminRegistrationService extends BaseService {

  constructor(private http: HttpClient, private router: Router) { 
    super();
  }

  private baseUrlCenterRegistration: string = 'api/centerAdmin/registration';

  register(centerAdmin: CenterAdmin) {
    return this.http
      .post<any>(BaseService.appUrl + this.baseUrlCenterRegistration, { ...centerAdmin })
      .pipe(
        map((result) => {
          return result;
        })
      );
  }
}
