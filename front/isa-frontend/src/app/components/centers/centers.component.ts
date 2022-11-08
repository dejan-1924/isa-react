import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Center } from 'src/app/model/center.model';
import { CenterService } from 'src/app/services/center.service';

@Component({
  selector: 'app-centers',
  templateUrl: './centers.component.html',
  styleUrls: ['./centers.component.css'],
})
export class CentersComponent implements OnInit {
  searchText: any;
  public centers: Center[];
  constructor(private centerService: CenterService) {}

  ngOnInit(): void {
    this.getCenters();
  }

  public getCenters(): void {
    this.centerService.getCenters().subscribe(
      (response: Center[]) => {
        this.centers = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
