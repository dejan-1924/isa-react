import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { CenterRegistrationService } from 'src/app/services/center-registration.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Center } from 'src/app/model/center.model';

@Component({
  selector: 'app-center-registration',
  templateUrl: './center-registration.component.html',
  styleUrls: ['./center-registration.component.css']
})
export class CenterRegistrationComponent implements OnInit {
  insertForm: FormGroup;
  name: FormControl;
  address: FormControl;
  city: FormControl;
  country: FormControl;
  description: FormControl;
  opening: FormControl;
  closing: FormControl;
  grade: FormControl;

  constructor(
    private crs: CenterRegistrationService,
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  onSubmit() {
    let center: Center = this.insertForm.value;
    console.log("Ime centra je " + center.name);
    this.crs.register(center).subscribe(
      (result) => {
        console.log("Registrovan");
      },
      (error) => {
        console.log("Greska");
      }
    );
  }

  ngOnInit(): void {
    this.name = new FormControl('', [Validators.required]);
    this.address = new FormControl('', [Validators.required]);
    this.city = new FormControl('', [Validators.required]);
    this.country = new FormControl('', [Validators.required]);
    this.description = new FormControl('', [Validators.required]);
    this.opening = new FormControl('', [Validators.required]);
    this.closing = new FormControl('', [Validators.required]);
    this.grade = new FormControl('', [Validators.required]);

    this.insertForm = this.fb.group({
      name: this.name,
      address: this.address,
      city: this.city,
      country: this.country,
      description: this.description,
      opening: this.opening,
      closing: this.closing,
      grade: this.grade
    });
  }

}
