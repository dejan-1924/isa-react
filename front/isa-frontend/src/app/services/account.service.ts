import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';
import { map, catchError } from 'rxjs/operators';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root',
})
export class AccountService extends BaseService {
  constructor(private http: HttpClient, private router: Router) {
    super();
  }

  private baseUrlLogin: string = 'api/login';

  private loginStatus = new BehaviorSubject<boolean>(this.checkLoginStatus());
  private UserEmail = new BehaviorSubject<any>(localStorage.getItem('email'));
  private UserRole = new BehaviorSubject<any>(localStorage.getItem('role'));

  login(email: string, password: string) {
    return this.http
      .post<any>(BaseService.appUrl + `api/login`, { email, password })
      .pipe(
        map((result) => {
          if (result) {
            if (result.role != 'unauthorized') {
              this.loginStatus.next(true);
              localStorage.setItem('loginStatus', '1');
              localStorage.setItem('email', result.email);
              localStorage.setItem('role', result.role);
            }
          }
          return result;
        })
      );
  }

  logout() {
    this.loginStatus.next(false);
    localStorage.removeItem('email');
    localStorage.removeItem('role');
    localStorage.setItem('loginStatus', '0');
    this.router.navigate(['/login']);
  }

  checkLoginStatus(): boolean {
    return false;
  }

  get isLoggedIn() {
    return this.loginStatus.asObservable();
  }
  get currentUserName() {
    return this.UserEmail.asObservable();
  }
  get currentUserRole() {
    return this.UserRole.asObservable();
  }
}
