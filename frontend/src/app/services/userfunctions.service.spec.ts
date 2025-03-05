import { TestBed, inject } from '@angular/core/testing';

import { UserfunctionsService } from './userfunctions.service';

describe('UserfunctionsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserfunctionsService]
    });
  });

  it('should be created', inject([UserfunctionsService], (service: UserfunctionsService) => {
    expect(service).toBeTruthy();
  }));
});
