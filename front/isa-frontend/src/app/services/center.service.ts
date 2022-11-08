import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Center } from '../model/center.model';

@Injectable({
  providedIn: 'root',
})
export class CenterService extends BaseService {
  constructor(private http: HttpClient) {
    super();
  }

  public getCenters(): Observable<Center[]> {
    return this.http.get<Center[]>(BaseService.appUrl + `api/center/centers`);
  }
}
