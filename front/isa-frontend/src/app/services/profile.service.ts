import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseService } from './base.service';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';
import { Donor } from '../model/donor.model';
import { AccountService } from './account.service';

@Injectable({
  providedIn: 'root',
})
export class ProfileService extends BaseService {
  showDialog = false;
  constructor(private http: HttpClient, acct: AccountService) {
    super();
  }

  public getData(email: string): Observable<Donor> {
    console.log(email);
    return this.http.post<Donor>(BaseService.appUrl + `api/profile`, {
      email,
    });
  }

  public update(user: Donor) {
    return this.http.put<Donor>(BaseService.appUrl + `api/profile/update`, {
      ...user,
    });
  }
}
