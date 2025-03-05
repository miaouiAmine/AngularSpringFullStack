import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AchteCouponComponent } from './achte-coupon.component';

describe('AchteCouponComponent', () => {
  let component: AchteCouponComponent;
  let fixture: ComponentFixture<AchteCouponComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AchteCouponComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AchteCouponComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
