import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreePortMComponent } from './cree-port-m.component';

describe('CreePortMComponent', () => {
  let component: CreePortMComponent;
  let fixture: ComponentFixture<CreePortMComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreePortMComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreePortMComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
