import { TestBed, inject } from '@angular/core/testing';

import { GestionUsersService } from './gestion-users.service';

describe('GestionUsersService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GestionUsersService]
    });
  });

  it('should be created', inject([GestionUsersService], (service: GestionUsersService) => {
    expect(service).toBeTruthy();
  }));
});
