import { TestBed } from '@angular/core/testing';

import { CenterAdminRegistrationService } from './center-admin-registration.service';

describe('CenterAdminRegistrationService', () => {
  let service: CenterAdminRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CenterAdminRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
