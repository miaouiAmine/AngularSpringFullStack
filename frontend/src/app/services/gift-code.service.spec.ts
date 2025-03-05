import { TestBed, inject } from '@angular/core/testing';

import { GiftCodeService } from './gift-code.service';

describe('GiftCodeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GiftCodeService]
    });
  });

  it('should be created', inject([GiftCodeService], (service: GiftCodeService) => {
    expect(service).toBeTruthy();
  }));
});
