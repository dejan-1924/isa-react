import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';
import { map, catchError } from 'rxjs/operators';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient, private router: Router) { }

  register(email: string, password: string, name: string, surname: string, address: string, city: string, country: string, phoneNumber: string, ssn: string, isMale: boolean) {
    return this.http
      .post<any>(BaseService.appUrl + `api/registration/donor`, { email, password, name, surname, address, city, country, phoneNumber, ssn, isMale })
      .pipe(
        map((result) => {
          return result;
        })
      );
  }
}
