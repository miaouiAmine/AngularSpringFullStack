import { TestBed, inject } from '@angular/core/testing';

import { UtilisationService } from './utilisation-service.service';

describe('UtilisationServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UtilisationService]
    });
  });

  it('should be created', inject([UtilisationService], (service: UtilisationService) => {
    expect(service).toBeTruthy();
  }));
});
