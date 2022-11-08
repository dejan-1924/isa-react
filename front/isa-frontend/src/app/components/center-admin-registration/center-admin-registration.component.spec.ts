import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterAdminRegistrationComponent } from './center-admin-registration.component';

describe('CenterAdminRegistrationComponent', () => {
  let component: CenterAdminRegistrationComponent;
  let fixture: ComponentFixture<CenterAdminRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterAdminRegistrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CenterAdminRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
