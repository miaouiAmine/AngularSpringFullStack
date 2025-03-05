import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreeCodeComponent } from './CreeCode.component';

describe('CodepageComponent', () => {
  let component: CreeCodeComponent;
  let fixture: ComponentFixture<CreeCodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreeCodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreeCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
